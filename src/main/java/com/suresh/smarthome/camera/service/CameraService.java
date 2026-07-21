package com.suresh.smarthome.camera.service;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;

import com.suresh.smarthome.camera.client.TabletCameraClient;
import com.suresh.smarthome.camera.dto.CameraCaptureResponse;
import com.suresh.smarthome.camera.dto.CameraStatusResponse;
import com.suresh.smarthome.common.exception.ResourceNotFoundException;
import com.suresh.smarthome.device.entity.Device;
import com.suresh.smarthome.device.repository.DeviceRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CameraService {

    private final DeviceRepository deviceRepository;
    private final TabletCameraClient tabletCameraClient;

    public CameraStatusResponse getStatus(String deviceCode) {

        Device device = getDevice(deviceCode);

        return tabletCameraClient.getStatus(device.getIpAddress());
    }

    public String switchCamera(String deviceCode) {

        Device device = getDevice(deviceCode);

        return tabletCameraClient.switchCamera(device.getIpAddress());
    }

    public CameraCaptureResponse capture(String deviceCode) {

        Device device = getDevice(deviceCode);

        return tabletCameraClient.capture(device.getIpAddress());
    }

    public ByteArrayResource getSnapshot(String deviceCode) {

        Device device = getDevice(deviceCode);

        return tabletCameraClient.getSnapshot(device.getIpAddress());
    }

    private Device getDevice(String deviceCode) {

        return deviceRepository.findByDeviceCode(deviceCode)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                String.format(
                                        "Device with code '%s' not found.",
                                        deviceCode
                                )));
    }
}