package com.suresh.smarthome.dashboard.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.suresh.smarthome.common.util.DateTimeUtil;
import com.suresh.smarthome.common.util.UptimeUtil;
import com.suresh.smarthome.dashboard.dto.response.DashboardResponse;
import com.suresh.smarthome.dashboard.dto.response.EnvironmentResponse;
import com.suresh.smarthome.device.repository.DeviceRepository;
import com.suresh.smarthome.sensor.enums.SensorStatus;
import com.suresh.smarthome.sensor.enums.SensorType;
import com.suresh.smarthome.sensor.repository.SensorReadingRepository;
import com.suresh.smarthome.sensor.repository.SensorRepository;

import lombok.RequiredArgsConstructor;
import com.suresh.smarthome.sensor.entity.SensorReading;
import com.suresh.smarthome.sensor.enums.ReadingType;


@Service
@RequiredArgsConstructor
public class DashboardService {

	private final DeviceRepository deviceRepository;
	private final SensorRepository sensorRepository;
	private final SensorReadingRepository sensorReadingRepository;

	public DashboardResponse getDashboardSummary() {

		long totalDevices = deviceRepository.count();

		LocalDateTime threshold = DateTimeUtil.now().minusMinutes(1);

		long onlineDevices = deviceRepository.countByLastSeenAfter(threshold);

		long activeMotionSensors = sensorRepository.countByTypeAndStatus(SensorType.PIR,SensorStatus.ACTIVE);


		    return DashboardResponse.builder()
		            .totalDevices(totalDevices)
		            .onlineDevices(onlineDevices)
		            .activeMotionDevices(activeMotionSensors)
		            .alerts(0)
		            .uptime(UptimeUtil.getApplicationUptime())
		            .build();
	}
	
	public EnvironmentResponse getEnvironmentSummary() {
		 Double temperature =
		            sensorReadingRepository
		                    .findTopByReadingTypeOrderByReadingTimeDesc(
		                            ReadingType.TEMPERATURE)
		                    .map(SensorReading::getValue)
		                    .orElse(null);

		    Double humidity =
		            sensorReadingRepository
		                    .findTopByReadingTypeOrderByReadingTimeDesc(
		                            ReadingType.HUMIDITY)
		                    .map(SensorReading::getValue)
		                    .orElse(null);

		    Double pressure =
		            sensorReadingRepository
		                    .findTopByReadingTypeOrderByReadingTimeDesc(
		                            ReadingType.PRESSURE)
		                    .map(SensorReading::getValue)
		                    .orElse(null);
		    Boolean door_status = sensorReadingRepository
                    .findTopByReadingTypeOrderByReadingTimeDesc(
                            ReadingType.DOOR_STATE)
                    .map(r -> Double.compare(r.getValue(), 1.0) == 0)
                    .orElse(null);
		    
		return EnvironmentResponse.builder()
				.temperature(temperature)
				.humidity(humidity)
				.pressure(pressure)
				.DoorStatus(door_status)
				.build();
		
	}
	
	

}