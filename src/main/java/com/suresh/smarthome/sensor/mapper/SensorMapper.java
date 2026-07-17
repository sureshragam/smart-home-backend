package com.suresh.smarthome.sensor.mapper;

import com.suresh.smarthome.device.dto.response.DeviceSummaryResponse;
import com.suresh.smarthome.sensor.dto.response.SensorResponse;
import com.suresh.smarthome.sensor.entity.Sensor;

public class SensorMapper {
	public static SensorResponse toSensorResponse(Sensor request) {
		return SensorResponse.builder()
				.id(request.getId())
				.name(request.getName())
				.sensorCode(request.getSensorCode())
				.type(request.getType())
				.status(request.getStatus())
				.pinNumber(request.getPinNumber())
				.lastSeen(request.getLastSeen())
				.manufacturer(request.getManufacturer())
				.model(request.getModel())
				.device(DeviceSummaryResponse.builder()
						.id(request.getDevice().getId())
						.name(request.getDevice().getName())
						.deviceCode(request.getDevice().getDeviceCode())
						.location(request.getDevice().getLocation())
						.status(request.getStatus())
						.build())
				.build();
	}

}
