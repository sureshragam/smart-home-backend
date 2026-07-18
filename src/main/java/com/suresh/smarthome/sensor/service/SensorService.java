package com.suresh.smarthome.sensor.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suresh.smarthome.common.exception.ResourceAlreadyExistsException;
import com.suresh.smarthome.common.exception.ResourceNotFoundException;
import com.suresh.smarthome.common.util.DateTimeUtil;
import com.suresh.smarthome.device.entity.Device;
import com.suresh.smarthome.device.repository.DeviceRepository;
import com.suresh.smarthome.notification.constant.NotificationConstants;
import com.suresh.smarthome.notification.enums.NotificationPriority;
import com.suresh.smarthome.notification.enums.NotificationType;
import com.suresh.smarthome.notification.service.NotificationService;
import com.suresh.smarthome.sensor.dto.request.AddSensorRequest;
import com.suresh.smarthome.sensor.dto.request.SensorReadingRequest;
import com.suresh.smarthome.sensor.dto.response.AddSensorResponse;
import com.suresh.smarthome.sensor.dto.response.SensorReadingResponse;
import com.suresh.smarthome.sensor.dto.response.SensorResponse;
import com.suresh.smarthome.sensor.entity.Sensor;
import com.suresh.smarthome.sensor.entity.SensorReading;
import com.suresh.smarthome.sensor.enums.SensorStatus;
import com.suresh.smarthome.sensor.mapper.SensorMapper;
import com.suresh.smarthome.sensor.mapper.SensorReadingMapper;
import com.suresh.smarthome.sensor.repository.SensorReadingRepository;
import com.suresh.smarthome.sensor.repository.SensorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SensorService {

    private final SensorRepository sensorRepository;
    private final SensorReadingRepository sensorReadingRepository;
    private final DeviceRepository deviceRepository;
    private final NotificationService notificationService;

    public List<SensorReadingResponse> getAllSensorReadings() {

        return sensorReadingRepository.findAll(
                Sort.by(Sort.Direction.DESC, "readingTime"))
                .stream()
                .map(SensorReadingMapper::toResponse)
                .toList();
    }

    @Transactional
    public SensorReadingResponse saveReading(SensorReadingRequest request) {

        Sensor sensor = sensorRepository.findBySensorCode(request.getSensorCode())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                String.format(
                                        "Sensor with code '%s' not found.",
                                        request.getSensorCode())));

        LocalDateTime now = DateTimeUtil.now();

        sensor.setLastSeen(now);
        sensor.setStatus(SensorStatus.ACTIVE);

        Device device = sensor.getDevice();
        device.setLastSeen(now);

        SensorReading reading = SensorReading.builder()
                .sensor(sensor)
                .readingType(request.getReadingType())
                .value(request.getValue())
                .unit(request.getUnit())
                .readingTime(now)
                .build();

        SensorReading savedReading = sensorReadingRepository.save(reading);

        checkNotificationRules(savedReading);

        return SensorReadingMapper.toResponse(savedReading);
    }

    @Transactional
    public AddSensorResponse addSensor(AddSensorRequest request) {

        Device device = deviceRepository.findByDeviceCode(request.getDeviceCode())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                String.format(
                                        "Device with code '%s' not found.",
                                        request.getDeviceCode())));

        String sensorCode = generateSensorCode(device, request);

        if (sensorRepository.existsBySensorCode(sensorCode)) {
            throw new ResourceAlreadyExistsException(
                    String.format(
                            "Sensor with code '%s' already exists.",
                            sensorCode));
        }

        Sensor sensor = Sensor.builder()
                .name(request.getName())
                .sensorCode(sensorCode)
                .type(request.getType())
                .status(SensorStatus.ACTIVE)
                .pinNumber(request.getPinNumber())
                .manufacturer(request.getManufacturer())
                .model(request.getModel())
                .device(device)
                .build();

        Sensor savedSensor = sensorRepository.save(sensor);

        return AddSensorResponse.builder()
                .sensorCode(savedSensor.getSensorCode())
                .name(savedSensor.getName())
                .type(savedSensor.getType())
                .manufacturer(savedSensor.getManufacturer())
                .model(savedSensor.getModel())
                .pinNumber(savedSensor.getPinNumber())
                .deviceCode(savedSensor.getDevice().getDeviceCode())
                .message("Sensor registered successfully.")
                .build();
    }

    private String generateSensorCode(
            Device device,
            AddSensorRequest request) {

        Optional<Sensor> lastSensor =
                sensorRepository.findTopByDeviceAndTypeOrderByIdDesc(
                        device,
                        request.getType());

        int nextSequence = 1;

        if (lastSensor.isPresent()) {

            String code = lastSensor.get().getSensorCode();

            String[] parts = code.split("-");

            nextSequence = Integer.parseInt(parts[2]) + 1;
        }

        return String.format(
                "%s-%s-%03d",
                request.getType().name(),
                device.getLocation().name(),
                nextSequence);
    }

    private void checkNotificationRules(SensorReading reading) {

        switch (reading.getReadingType()) {

            case TEMPERATURE ->
                checkTemperature(reading);

            case HUMIDITY ->
                checkHumidity(reading);

            case PRESSURE ->
                checkPressure(reading);

            default -> {
            }
        }
    }

    private void checkTemperature(SensorReading reading) {

        if (reading.getValue() <= NotificationConstants.HIGH_TEMPERATURE_THRESHOLD) {
            return;
        }

        Sensor sensor = reading.getSensor();

        Device device = sensor.getDevice();

        notificationService.createNotification(
                NotificationType.TEMPERATURE,
                NotificationPriority.HIGH,
                "High Temperature",
                String.format(
                        "Temperature in %s reached %.1f°C.",
                        device.getLocation(),
                        reading.getValue()),
                device.getDeviceCode(),
                sensor.getSensorCode(),
                device.getName(),
                reading.getValue(),
                reading.getUnit());
    }

    private void checkHumidity(SensorReading reading) {


        if (reading.getValue() <= NotificationConstants.HIGH_HUMIDITY_THRESHOLD) {
            return;
        }
        Sensor sensor = reading.getSensor();

        Device device = sensor.getDevice();
        
        notificationService.createNotification(
                NotificationType.HUMIDITY,
                NotificationPriority.HIGH,
                "High Humidity",
                String.format(
                		"Humidity in %s reached %.1f%%.",
                        device.getLocation(),
                        reading.getValue()),
                device.getDeviceCode(),
                sensor.getSensorCode(),
                device.getName(),
                reading.getValue(),
                reading.getUnit());

    }

    private void checkPressure(SensorReading reading) {

        // Future implementation

    }

	public List<SensorResponse> getSensors() {
		List<SensorResponse> sensors = sensorRepository.findAll()
		        .stream()
		        .map(SensorMapper::toSensorResponse)
		        .toList();
		return sensors;
	}
}