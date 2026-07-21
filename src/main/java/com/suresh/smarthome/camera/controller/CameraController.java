package com.suresh.smarthome.camera.controller;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.suresh.smarthome.camera.dto.CameraCaptureResponse;
import com.suresh.smarthome.camera.dto.CameraStatusResponse;
import com.suresh.smarthome.camera.service.CameraService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/camera")
@RequiredArgsConstructor
@Tag(name = "Camera", description = "Camera control APIs")
public class CameraController {

    private final CameraService cameraService;

    @GetMapping("/{deviceCode}/status")
    public ResponseEntity<CameraStatusResponse> getStatus(
            @PathVariable String deviceCode) {

        return ResponseEntity.ok(
                cameraService.getStatus(deviceCode)
        );
    }

    @PostMapping("/{deviceCode}/switch")
    public ResponseEntity<String> switchCamera(
            @PathVariable String deviceCode) {

        return ResponseEntity.ok(
                cameraService.switchCamera(deviceCode)
        );
    }

    @PostMapping("/{deviceCode}/capture")
    public ResponseEntity<CameraCaptureResponse> capture(
            @PathVariable String deviceCode) {

        return ResponseEntity.ok(
                cameraService.capture(deviceCode)
        );
    }

    @GetMapping("/{deviceCode}/snapshot")
    public ResponseEntity<ByteArrayResource> snapshot(
            @PathVariable String deviceCode) {

        ByteArrayResource image =
                cameraService.getSnapshot(deviceCode);

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .header(HttpHeaders.CACHE_CONTROL, "no-cache")
                .body(image);
    }
}