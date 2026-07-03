package com.suresh.smarthome.dashboard.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.suresh.smarthome.common.util.DateTimeUtil;
import com.suresh.smarthome.common.util.UptimeUtil;
import com.suresh.smarthome.dashboard.dto.response.DashboardResponse;
import com.suresh.smarthome.device.enums.MotionStatus;
import com.suresh.smarthome.device.repository.DeviceRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class DashboardService {

    private final DeviceRepository deviceRepository;

    public DashboardResponse getDashboardSummary() {

        long totalDevices = deviceRepository.count();

        LocalDateTime threshold = DateTimeUtil.now().minusMinutes(1);

        long onlineDevices = deviceRepository.countByLastSeenAfter(threshold);

        long activeMotionDevices =
                deviceRepository.countByMotionStatus(MotionStatus.ACTIVE);

        return DashboardResponse.builder()
                .totalDevices(totalDevices)
                .onlineDevices(onlineDevices)
                .activeMotionDevices(activeMotionDevices)
                .alerts(0)
                .uptime(UptimeUtil.getApplicationUptime())
                .build();
    }
    
}