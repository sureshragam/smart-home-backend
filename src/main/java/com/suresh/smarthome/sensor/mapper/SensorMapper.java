package com.suresh.smarthome.sensor.mapper;

import com.suresh.smarthome.common.util.DateTimeUtil;
import com.suresh.smarthome.sensor.dto.response.SensorReadingResponse;
import com.suresh.smarthome.sensor.entity.SensorReading;

public final class SensorMapper {

    private SensorMapper() {
    }

    public static SensorReadingResponse toResponse(SensorReading sensorReading) {

        return SensorReadingResponse.builder()
                .id(sensorReading.getId())
                .deviceName(sensorReading.getDevice().getName())
                .temperature(sensorReading.getTemperature())
                .humidity(sensorReading.getHumidity())
                .battery(sensorReading.getBattery())
                .signalStrength(sensorReading.getSignalStrength())
                .readingTime(DateTimeUtil.format(sensorReading.getReadingTime()))
                .build();
    }

}