package com.suresh.smarthome.health.dto.response;

import com.suresh.smarthome.health.enums.HealthStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HealthResponse {

    private Long id;

    private String label;

    private String value;

    private HealthStatus status;

}