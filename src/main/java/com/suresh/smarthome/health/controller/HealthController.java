package com.suresh.smarthome.health.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suresh.smarthome.health.dto.response.HealthResponse;
import com.suresh.smarthome.health.service.HealthService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/health")
@RequiredArgsConstructor
@Tag(
    name = "Health",
    description = "APIs for retrieving the health status and metrics of the smart home system."
)
public class HealthController {

    private final HealthService healthService;

    @Operation(
        summary = "Get system health metrics",
        description = "Returns the current health metrics of the smart home system such as CPU, memory, temperature, disk usage, and network status."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Health metrics retrieved successfully")
    })
    @GetMapping
    public List<HealthResponse> getHealthMetrics() {
        return healthService.getHealthMetrics();
    }

}