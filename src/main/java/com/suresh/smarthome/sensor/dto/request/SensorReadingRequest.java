package com.suresh.smarthome.sensor.dto.request;

import com.suresh.smarthome.sensor.enums.ReadingType;
import com.suresh.smarthome.sensor.enums.UnitType;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class SensorReadingRequest {

    @NotBlank
    private String sensorCode;

    @NotNull
    private ReadingType readingType;

    @NotNull
    private Double value;

    @NotNull
    private UnitType unit;

}