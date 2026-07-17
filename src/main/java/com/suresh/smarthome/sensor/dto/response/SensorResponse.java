package com.suresh.smarthome.sensor.dto.response;

import java.time.LocalDateTime;

import com.suresh.smarthome.device.entity.Device;
import com.suresh.smarthome.sensor.enums.SensorStatus;
import com.suresh.smarthome.sensor.enums.SensorType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SensorResponse {
	private String name;
	private String sensorCode;
	private SensorType type;
	private SensorStatus status;
	private Integer pinNumber;
	private Device device;
	private LocalDateTime lastSeen;
    private String manufacturer;
    private String model;
}
