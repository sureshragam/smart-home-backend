package com.suresh.smarthome.device.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
@Schema(description = "Heartbeat request sent periodically by an IoT device.")
public class DeviceHeartbeatRequest {

    @Schema(
            description = "Unique device code",
            example = "ESP32-LIVINGROOM-01"
    )
    @NotBlank(message = "Device code is required.")
    private String deviceCode;

    @Schema(
            description = "Current IP address of the device",
            example = "192.168.1.101"
    )
    @NotBlank(message = "IP Address is required.")
    private String ipAddress;

    @Schema(
            description = "Current Wi-Fi signal strength",
            example = "-52 dBm"
    )
    @NotNull(message = "Wi-Fi strength is required.")
    private Integer wifiStrength;

    @Schema(
            description = "Current firmware version",
            example = "v1.0.0"
    )
    @NotBlank(message = "Firmware version is required.")
    private String firmwareVersion;

}