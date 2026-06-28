package com.suresh.smarthome.device.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeviceHeartbeatRequest {

    @NotBlank(message = "Device code is required.")
    private String deviceCode;

    @NotBlank(message = "IP Address is required.")
    private String ipAddress;

    @NotBlank(message = "Wi-Fi strength is required.")
    private String wifiStrength;

    @NotBlank(message = "Firmware version is required.")
    private String firmwareVersion;

}