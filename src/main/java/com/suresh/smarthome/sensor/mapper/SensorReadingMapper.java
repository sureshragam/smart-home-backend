package com.suresh.smarthome.sensor.mapper;

import com.suresh.smarthome.common.util.DateTimeUtil;
import com.suresh.smarthome.sensor.dto.response.SensorReadingResponse;
import com.suresh.smarthome.sensor.entity.SensorReading;

public final class SensorReadingMapper {

    private SensorReadingMapper() {
    }

    public static SensorReadingResponse toResponse(SensorReading sensorReading) {

        return SensorReadingResponse.builder()
                .id(sensorReading.getId())
                .sensorName(sensorReading.getSensor().getName())
                .sensorCode(sensorReading.getSensor().getSensorCode())
                .deviceName(sensorReading.getSensor().getDevice().getName())
                .readingType(sensorReading.getReadingType())
                .value(sensorReading.getValue())
                .unit(sensorReading.getUnit())
                .readingTime(DateTimeUtil.format(sensorReading.getReadingTime()))
                .build();
    }

}