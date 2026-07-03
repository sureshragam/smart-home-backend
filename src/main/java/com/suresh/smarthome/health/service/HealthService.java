package com.suresh.smarthome.health.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.suresh.smarthome.common.util.UptimeUtil;
import com.suresh.smarthome.health.dto.response.HealthResponse;
import com.suresh.smarthome.health.enums.HealthStatus;

@Service
public class HealthService {

    public List<HealthResponse> getHealthMetrics() {

        List<HealthResponse> metrics = new ArrayList<>();

        // Backend
        metrics.add(
                HealthResponse.builder()
                        .label("Backend")
                        .value("Running")
                        .status(HealthStatus.HEALTHY)
                        .build());

        // Database
        metrics.add(
                HealthResponse.builder()
                        .label("Database")
                        .value("Connected")
                        .status(HealthStatus.HEALTHY)
                        .build());

        // Memory
        Runtime runtime = Runtime.getRuntime();

        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long usedMemory = totalMemory - freeMemory;

        long usedMb = usedMemory / (1024 * 1024);
        long totalMb = totalMemory / (1024 * 1024);

        double memoryUsage = (double) usedMb / totalMb * 100;

        HealthStatus memoryStatus;

        if (memoryUsage >= 90) {
            memoryStatus = HealthStatus.CRITICAL;
        } else if (memoryUsage >= 75) {
            memoryStatus = HealthStatus.WARNING;
        } else {
            memoryStatus = HealthStatus.HEALTHY;
        }

        metrics.add(
                HealthResponse.builder()
                        .label("Memory")
                        .value(usedMb + " MB / " + totalMb + " MB")
                        .status(memoryStatus)
                        .build());

        // Uptime
        metrics.add(
                HealthResponse.builder()
                        .label("Uptime")
                        .value(UptimeUtil.getApplicationUptime())
                        .status(HealthStatus.HEALTHY)
                        .build());

        return metrics;
    }


}