package com.suresh.smarthome.sensor.dto.request;

import com.suresh.smarthome.sensor.enums.SensorType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class AddSensorRequest {

    @NotBlank(message = "Sensor name is required")
    @Size(min = 3, max = 50,
          message = "Sensor name must be between 3 and 50 characters")
    private String name;

    @NotNull(message = "Sensor type is required")
    private SensorType type;

    @NotBlank(message = "Manufacturer is required")
    private String manufacturer;

    @NotBlank(message = "Model is required")
    private String model;

    @NotBlank(message = "Device code is required")
    private String deviceCode;

    @NotNull(message = "pinNumber is required")
    private Integer pinNumber;
}