package com.suresh.smarthome.activity.dto.response;

import com.suresh.smarthome.activity.enums.ActivityType;

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
public class ActivityResponse {

    private Long id;

    private ActivityType type;

    private String title;

    private String deviceName;

    private String sensorName;

    private String timestamp;

}