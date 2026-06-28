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
                .device(activity.getDeviceName())
                .timestamp(DateTimeUtil.format(activity.getActivityTime()))
                .build();
    }

}