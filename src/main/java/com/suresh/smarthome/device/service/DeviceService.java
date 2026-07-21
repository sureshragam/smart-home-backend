package com.suresh.smarthome.device.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.suresh.smarthome.common.exception.ResourceAlreadyExistsException;
import com.suresh.smarthome.common.exception.ResourceNotFoundException;
import com.suresh.smarthome.common.util.DateTimeUtil;
import com.suresh.smarthome.device.dto.request.AddDeviceRequest;
import com.suresh.smarthome.device.dto.request.DeviceHeartbeatRequest;
import com.suresh.smarthome.device.dto.request.RegisterDeviceRequest;
import com.suresh.smarthome.device.dto.response.DeviceResponse;
import com.suresh.smarthome.device.entity.Device;
import com.suresh.smarthome.device.enums.DeviceStatus;
import com.suresh.smarthome.device.mapper.DeviceMapper;
import com.suresh.smarthome.device.repository.DeviceRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeviceService {

    private final DeviceRepository deviceRepository;

    public List<DeviceResponse> getAllDevices() {

        return deviceRepository.findAll(Sort.by(Sort.Direction.ASC, "name"))
                .stream()
                .map(DeviceMapper::toResponse)
                .toList();
    }

    public void processHeartbeat(DeviceHeartbeatRequest request) {

        Device device = deviceRepository.findByDeviceCode(request.getDeviceCode())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                        		String.format("Device with code '%s' not found.", request.getDeviceCode())));

        device.setIpAddress(request.getIpAddress());
        device.setWifiStrength(request.getWifiStrength());
        device.setFirmwareVersion(request.getFirmwareVersion());
        device.setStatus(DeviceStatus.ONLINE);
        device.setLastSeen(DateTimeUtil.now());

        deviceRepository.save(device);
    }
    
    public DeviceResponse addDevice(AddDeviceRequest request) {
    	String deviceCode = generateDeviceCode(request);
    	Optional<Device> existingDevice = deviceRepository.findByDeviceCode(deviceCode);
    	if(existingDevice.isPresent()) {
    		throw new ResourceAlreadyExistsException(
    		        String.format("Device with code '%s' already exists.", deviceCode));
    	}
    	Device newDevice  = DeviceMapper.toDevice(request);
    	newDevice.setDeviceCode(deviceCode);
    	Device savedDevice = deviceRepository.save(newDevice);
    	return DeviceMapper.toResponse(savedDevice);
    	
    }
    
    public void registerDevice(RegisterDeviceRequest request) {

        Device device = deviceRepository
                .findByDeviceCode(request.getDeviceCode())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                String.format(
                                        "Device with code '%s' not found.",
                                        request.getDeviceCode()
                                )));

        device.setIpAddress(request.getIpAddress());
        device.setFirmwareVersion(request.getFirmwareVersion());
        device.setStatus(DeviceStatus.ONLINE);
        device.setLastSeen(DateTimeUtil.now());

        deviceRepository.save(device);
    }
    public DeviceResponse getDevice(String deviceCode) {

        Device device = deviceRepository
                .findByDeviceCode(deviceCode)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                String.format(
                                        "Device with code '%s' not found.",
                                        deviceCode)));

        return DeviceMapper.toResponse(device);
    }
    
    private String generateDeviceCode(AddDeviceRequest request) {

        Optional<Device> lastDevice =
                deviceRepository.findTopByTypeAndLocationOrderByIdDesc(
                        request.getType(),
                        request.getLocation());

        int nextSequence = 1;

        if (lastDevice.isPresent()) {

            String code = lastDevice.get().getDeviceCode();

            String[] parts = code.split("-");

            nextSequence = Integer.parseInt(parts[2]) + 1;
        }

        return String.format("%s-%s-%03d",
                request.getType().name(),
                request.getLocation().name(),
                nextSequence);
    }
}