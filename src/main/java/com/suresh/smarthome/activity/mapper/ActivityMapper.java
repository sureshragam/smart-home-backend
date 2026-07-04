package com.suresh.smarthome.activity.mapper;

import com.suresh.smarthome.activity.dto.response.ActivityResponse;
import com.suresh.smarthome.activity.entity.Activity;
import com.suresh.smarthome.common.util.DateTimeUtil;

public final class ActivityMapper {

    private ActivityMapper() {
    }

    public static ActivityResponse toResponse(Activity activity) {

        return ActivityResponse.builder()
                .id(activity.getId())
                .type(activity.getType())
                .title(activity.getTitle())
                .deviceName(activity.getSensor().getDevice().getName())
                .sensorName(activity.getSensor().getName())
                .timestamp(DateTimeUtil.format(activity.getActivityTime()))
                .build();
    }

}