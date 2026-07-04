package com.suresh.smarthome.sensor.dto.response;

import com.suresh.smarthome.sensor.enums.SensorType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddSensorResponse {

    private String sensorCode;

    private String name;

    private SensorType type;

    private String manufacturer;

    private String model;

    private Integer pinNumber;

    private String deviceCode;

    private String message;

}