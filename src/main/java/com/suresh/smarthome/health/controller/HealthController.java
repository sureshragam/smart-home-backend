package com.suresh.smarthome.health.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suresh.smarthome.health.dto.response.HealthResponse;
import com.suresh.smarthome.health.service.HealthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/health")
@RequiredArgsConstructor
public class HealthController {

    private final HealthService healthService;

    @GetMapping
    public List<HealthResponse> getHealthMetrics() {
        return healthService.getHealthMetrics();
    }

}