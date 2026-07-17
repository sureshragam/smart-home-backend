package com.suresh.smarthome.device.dto.response;

import com.suresh.smarthome.device.enums.DeviceLocation;
import com.suresh.smarthome.sensor.enums.SensorStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeviceSummaryResponse {
    private Long id;
    private String name;
    private String deviceCode;
    private DeviceLocation location;
    private SensorStatus status;
}