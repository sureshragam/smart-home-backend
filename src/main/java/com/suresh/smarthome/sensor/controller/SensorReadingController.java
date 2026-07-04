package com.suresh.smarthome.sensor.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suresh.smarthome.sensor.dto.request.SensorReadingRequest;
import com.suresh.smarthome.sensor.dto.response.SensorReadingResponse;
import com.suresh.smarthome.sensor.service.SensorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/sensor-readings")
@RequiredArgsConstructor
public class SensorReadingController {
	private final SensorService sensorService;

    @Operation(
        summary = "Get all sensor readings",
        description = "Returns all recorded sensor readings ordered by the latest reading first."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Sensor readings retrieved successfully")
    })
    @GetMapping
    public List<SensorReadingResponse> getAllReadings() {

        return sensorService.getAllSensorReadings();
    }

    @Operation(
        summary = "Save a sensor reading",
        description = "Receives temperature, humidity, battery level and Wi-Fi signal strength from an IoT device and stores the reading."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Sensor reading saved successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid sensor reading request"),
        @ApiResponse(responseCode = "404", description = "Device not found")
    })
    @PostMapping
    public SensorReadingResponse saveReading(
            @Valid @RequestBody SensorReadingRequest request) {

        return sensorService.saveReading(request);
    }
}
