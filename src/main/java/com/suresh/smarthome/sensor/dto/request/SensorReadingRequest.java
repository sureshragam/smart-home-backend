package com.suresh.smarthome.sensor.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
@Schema(description = "Sensor reading submitted by an IoT device.")
public class SensorReadingRequest {

    @Schema(
            description = "Unique device code",
            example = "ESP32-LIVINGROOM-01"
    )
    @NotBlank(message = "Device code is required.")
    private String deviceCode;

    @Schema(
            description = "Temperature in degrees Celsius",
            example = "28.5"
    )
    @NotNull(message = "Temperature is required.")
    private Double temperature;

    @Schema(
            description = "Relative humidity in percentage",
            example = "62.3"
    )
    @NotNull(message = "Humidity is required.")
    private Double humidity;

    @Schema(
            description = "Battery level in percentage",
            example = "91",
            minimum = "0",
            maximum = "100"
    )
    @NotNull(message = "Battery level is required.")
    @Min(value = 0, message = "Battery cannot be less than 0.")
    @Max(value = 100, message = "Battery cannot be greater than 100.")
    private Integer battery;

    @Schema(
            description = "Wi-Fi signal strength (RSSI)",
            example = "-48"
    )
    @NotNull(message = "Signal strength is required.")
    private Integer signalStrength;

}