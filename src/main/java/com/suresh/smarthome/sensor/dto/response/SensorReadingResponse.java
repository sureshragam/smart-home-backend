package com.suresh.smarthome.sensor.dto.response;

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

    private String deviceName;

    private Double temperature;

    private Double humidity;

    private Integer battery;

    private Integer signalStrength;

    private String readingTime;

}