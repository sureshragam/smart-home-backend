package com.suresh.smarthome.dashboard.service;

import org.springframework.stereotype.Service;

import com.suresh.smarthome.dashboard.dto.response.DashboardResponse;
import com.suresh.smarthome.device.enums.DeviceStatus;
import com.suresh.smarthome.device.enums.MotionStatus;
import com.suresh.smarthome.device.repository.DeviceRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final DeviceRepository deviceRepository;

    public DashboardResponse getDashboardSummary() {

        long totalDevices = deviceRepository.count();

        long onlineDevices = deviceRepository.countByStatus(DeviceStatus.ONLINE);

        long activeMotionDevices =
                deviceRepository.countByMotionStatus(MotionStatus.ACTIVE);

        return DashboardResponse.builder()
                .totalDevices(totalDevices)
                .onlineDevices(onlineDevices)
                .activeMotionDevices(activeMotionDevices)
                .alerts(0)
                .uptime("12h 30m")
                .build();
    }
}