package com.suresh.smarthome.device.dto.response;

import com.suresh.smarthome.device.enums.DeviceStatus;
import com.suresh.smarthome.device.enums.MotionStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeviceResponse {

    private Long id;

    private String name;

    private DeviceStatus status;

    private MotionStatus motion;

    private Integer wifi;

    private String ipAddress;

    private String lastSeen;

}