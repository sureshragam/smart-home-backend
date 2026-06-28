package com.suresh.smarthome.device.mapper;

import com.suresh.smarthome.device.dto.response.DeviceResponse;
import com.suresh.smarthome.device.entity.Device;
import com.suresh.smarthome.common.util.DateTimeUtil;

public final class DeviceMapper {

    private DeviceMapper() {
    }

    public static DeviceResponse toResponse(Device device) {

        return DeviceResponse.builder()
                .id(device.getId())
                .name(device.getName())
                .status(device.getStatus())
                .motion(device.getMotionStatus())
                .wifi(device.getWifiStrength())
                .ipAddress(device.getIpAddress())
                .lastSeen(DateTimeUtil.format(device.getLastSeen()))
                .build();
    }

}