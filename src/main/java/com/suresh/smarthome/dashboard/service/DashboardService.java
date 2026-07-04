package com.suresh.smarthome.dashboard.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.suresh.smarthome.common.util.DateTimeUtil;
import com.suresh.smarthome.common.util.UptimeUtil;
import com.suresh.smarthome.dashboard.dto.response.DashboardResponse;

import com.suresh.smarthome.device.repository.DeviceRepository;
import com.suresh.smarthome.sensor.enums.SensorStatus;
import com.suresh.smarthome.sensor.enums.SensorType;
import com.suresh.smarthome.sensor.repository.SensorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DashboardService {

	private final DeviceRepository deviceRepository;
	private final SensorRepository sensorRepository;

	public DashboardResponse getDashboardSummary() {

		long totalDevices = deviceRepository.count();

		LocalDateTime threshold = DateTimeUtil.now().minusMinutes(1);

		long onlineDevices = deviceRepository.countByLastSeenAfter(threshold);

		long activeMotionSensors = sensorRepository.countByTypeAndStatus(SensorType.PIR,SensorStatus.ACTIVE);

		return DashboardResponse.builder().totalDevices(totalDevices).onlineDevices(onlineDevices)
				.activeMotionDevices(activeMotionSensors).alerts(0).uptime(UptimeUtil.getApplicationUptime()).build();
	}

}