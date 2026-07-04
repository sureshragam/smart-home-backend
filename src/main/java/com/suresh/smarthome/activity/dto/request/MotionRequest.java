package com.suresh.smarthome.activity.dto.request;

import com.suresh.smarthome.device.enums.MotionStatus;

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
@Schema(description = "Motion event request sent by a PIR sensor.")
public class MotionRequest {

    @Schema(
            description = "Unique sensor code",
            example = "PIR-HALL-01"
    )
    @NotBlank(message = "Sensor code is required.")
    private String sensorCode;

    @Schema(
            description = "Current motion status",
            example = "ACTIVE",
            allowableValues = { "ACTIVE", "IDLE" }
    )
    @NotNull(message = "Motion status is required.")
    private MotionStatus motionStatus;
}