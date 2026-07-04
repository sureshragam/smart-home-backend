package com.suresh.smarthome.sensor.controller;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suresh.smarthome.sensor.dto.request.AddSensorRequest;

import com.suresh.smarthome.sensor.dto.response.AddSensorResponse;

import com.suresh.smarthome.sensor.service.SensorService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/sensors")
@RequiredArgsConstructor
@Tag(
    name = "Sensors",
    description = "APIs for CRUD operations for sensors"
)
public class SensorController {

    private final SensorService sensorService;
    
    @PostMapping
    public ResponseEntity<AddSensorResponse> addSensor(@Valid @RequestBody AddSensorRequest request) {
    	AddSensorResponse response = sensorService.addSensor(request);
    	return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);

    }

}