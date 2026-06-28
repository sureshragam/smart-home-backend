package com.suresh.smarthome.health.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.suresh.smarthome.health.dto.response.HealthResponse;
import com.suresh.smarthome.health.mapper.HealthMapper;
import com.suresh.smarthome.health.repository.HealthRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HealthService {

    private final HealthRepository healthRepository;

    public List<HealthResponse> getHealthMetrics() {

        return healthRepository.findAll()
                .stream()
                .map(HealthMapper::toResponse)
                .toList();
    }

}