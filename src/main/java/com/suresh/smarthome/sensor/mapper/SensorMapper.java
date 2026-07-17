package com.suresh.smarthome.sensor.mapper;

import com.suresh.smarthome.sensor.dto.response.SensorResponse;
import com.suresh.smarthome.sensor.entity.Sensor;

public class SensorMapper {
	public static SensorResponse toSensorResponse(Sensor request) {
		return SensorResponse.builder()
				.name(request.getName())
				.sensorCode(request.getSensorCode())
				.type(request.getType())
				.status(request.getStatus())
				.pinNumber(request.getPinNumber())
				.lastSeen(request.getLastSeen())
				.manufacturer(request.getManufacturer())
				.model(request.getModel())
				.device(request.getDevice())
				.build();
	}

}
