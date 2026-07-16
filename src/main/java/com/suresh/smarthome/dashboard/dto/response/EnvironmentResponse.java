package com.suresh.smarthome.dashboard.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EnvironmentResponse {

    private Double temperature;

    private Double humidity;

    private Double pressure;
    
    private Boolean DoorStatus;

    private LocalDateTime lastUpdated;

}