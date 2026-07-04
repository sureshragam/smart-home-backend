package com.suresh.smarthome.device.mapper;

import com.suresh.smarthome.device.dto.request.AddDeviceRequest;
import com.suresh.smarthome.device.dto.response.DeviceResponse;
import com.suresh.smarthome.device.entity.Device;
import com.suresh.smarthome.device.enums.DeviceStatus;
import com.suresh.smarthome.common.util.DateTimeUtil;

public final class DeviceMapper {

    private DeviceMapper() {
    }

    public static DeviceResponse toResponse(Device device) {

    	return DeviceResponse.builder()
    	        .id(device.getId())
    	        .name(device.getName())
    	        .deviceCode(device.getDeviceCode())
    	        .type(device.getType())
    	        .status(device.getStatus())
    	        .wifiStrength(device.getWifiStrength())
    	        .firmwareVersion(device.getFirmwareVersion())
    	        .ipAddress(device.getIpAddress())
    	        .lastSeen(DateTimeUtil.format(device.getLastSeen()))
    	        .build();

    }
    
    public static Device toDevice(AddDeviceRequest request) {
    	return Device.builder()
    			.location(request.getLocation())
    			.name(request.getName())
    			.status(DeviceStatus.OFFLINE)
    			.type(request.getType())
    			
    			.build();
    }
}