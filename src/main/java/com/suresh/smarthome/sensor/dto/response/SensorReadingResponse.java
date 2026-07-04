package com.suresh.smarthome.sensor.dto.response;

import com.suresh.smarthome.sensor.enums.ReadingType;
import com.suresh.smarthome.sensor.enums.UnitType;

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
public class SensorReadingResponse {

    private Long id;

    private String sensorName;

    private String sensorCode;

    private String deviceName;

    private ReadingType readingType;

    private Double value;

    private UnitType unit;

    private String readingTime;

}