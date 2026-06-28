package com.suresh.smarthome.health.mapper;

import com.suresh.smarthome.health.dto.response.HealthResponse;
import com.suresh.smarthome.health.entity.HealthMetric;

public final class HealthMapper {

    private HealthMapper() {
    }

    public static HealthResponse toResponse(HealthMetric metric) {

        return HealthResponse.builder()
                .id(metric.getId())
                .label(metric.getLabel())
                .value(metric.getValue())
                .status(metric.getStatus())
                .build();
    }

}