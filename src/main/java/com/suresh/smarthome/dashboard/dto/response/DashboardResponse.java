package com.suresh.smarthome.dashboard.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DashboardResponse {

    private long totalDevices;

    private long onlineDevices;

    private long activeMotionDevices;

    private long alerts;

    private String uptime;

}