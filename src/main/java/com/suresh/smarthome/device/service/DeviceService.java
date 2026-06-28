package com.suresh.smarthome.device.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.suresh.smarthome.common.exception.ResourceNotFoundException;
import com.suresh.smarthome.common.util.DateTimeUtil;
import com.suresh.smarthome.device.dto.request.DeviceHeartbeatRequest;
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

        return deviceRepository.findAll()
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
}