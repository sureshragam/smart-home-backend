package com.suresh.smarthome.activity.dto.request;

import com.suresh.smarthome.device.enums.MotionStatus;

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
public class MotionRequest {

    @NotBlank(message = "Device code is required.")
    private String deviceCode;

    @NotNull(message = "Motion status is required.")
    private MotionStatus motionStatus;

}