package com.suresh.smarthome.sensor.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suresh.smarthome.common.exception.ResourceNotFoundException;
import com.suresh.smarthome.common.util.DateTimeUtil;
import com.suresh.smarthome.device.entity.Device;
import com.suresh.smarthome.device.repository.DeviceRepository;
import com.suresh.smarthome.sensor.dto.request.SensorReadingRequest;
import com.suresh.smarthome.sensor.dto.response.SensorReadingResponse;
import com.suresh.smarthome.sensor.entity.SensorReading;
import com.suresh.smarthome.sensor.mapper.SensorMapper;
import com.suresh.smarthome.sensor.repository.SensorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SensorService {

    private final SensorRepository sensorRepository;
    private final DeviceRepository deviceRepository;

    public List<SensorReadingResponse> getAllReadings() {

        return sensorRepository.findAll(
                Sort.by(Sort.Direction.DESC, "readingTime"))
                .stream()
                .map(SensorMapper::toResponse)
                .toList();
    }

    @Transactional
    public SensorReadingResponse saveReading(
            SensorReadingRequest request) {

        Device device = deviceRepository.findByDeviceCode(request.getDeviceCode())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                String.format(
                                        "Device with code '%s' not found.",
                                        request.getDeviceCode())));
        
        LocalDateTime now = DateTimeUtil.now();
        device.setLastSeen(now);

        SensorReading reading = SensorReading.builder()
                .device(device)
                .temperature(request.getTemperature())
                .humidity(request.getHumidity())
                .battery(request.getBattery())
                .signalStrength(request.getSignalStrength())
                .readingTime(now)
                .build();

        SensorReading savedReading =
                sensorRepository.save(reading);

        return SensorMapper.toResponse(savedReading);
    }

}