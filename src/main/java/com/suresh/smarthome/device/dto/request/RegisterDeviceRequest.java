package com.suresh.smarthome.device.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDeviceRequest {

    @NotBlank
    private String deviceCode;

    @NotBlank
    private String ipAddress;

    @NotBlank
    private String firmwareVersion;
}