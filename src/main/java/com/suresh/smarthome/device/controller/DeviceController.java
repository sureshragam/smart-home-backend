package com.suresh.smarthome.device.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.suresh.smarthome.device.dto.request.AddDeviceRequest;
import com.suresh.smarthome.device.dto.request.DeviceHeartbeatRequest;
import com.suresh.smarthome.device.dto.request.RegisterDeviceRequest;
import com.suresh.smarthome.device.dto.response.DeviceResponse;
import com.suresh.smarthome.device.service.DeviceService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/devices")
@RequiredArgsConstructor
@Tag(
    name = "Devices",
    description = "APIs for managing smart home devices and receiving device heartbeats."
)
public class DeviceController {

    private final DeviceService deviceService;

    @Operation(summary = "Get all registered devices")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Devices retrieved successfully")
    })
    @GetMapping
    public List<DeviceResponse> getAllDevices() {
        return deviceService.getAllDevices();
    }

    @Operation(
        summary = "Receive device heartbeat",
        description = "Receives heartbeat information from an IoT device and updates its latest status, IP address, firmware version, Wi-Fi strength, and last seen timestamp."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Heartbeat processed successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid heartbeat request"),
        @ApiResponse(responseCode = "404", description = "Device not found")
    })
    @PostMapping("/heartbeat")
    public ResponseEntity<Void> heartbeat(
            @Valid @RequestBody DeviceHeartbeatRequest request) {

        deviceService.processHeartbeat(request);

        return ResponseEntity.ok().build();
    }
    
    @PostMapping
    public ResponseEntity<DeviceResponse> addDevice(@Valid @RequestBody AddDeviceRequest device){
    	DeviceResponse response = deviceService.addDevice(device);
    	
    	return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void registerDevice(
            @Valid @RequestBody RegisterDeviceRequest request) {

        deviceService.registerDevice(request);
    }
    

}