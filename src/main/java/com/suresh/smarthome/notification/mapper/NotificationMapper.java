package com.suresh.smarthome.notification.mapper;

import com.suresh.smarthome.notification.dto.response.NotificationResponse;
import com.suresh.smarthome.notification.entity.Notification;

public final class NotificationMapper {

    private NotificationMapper() {
    }

    public static NotificationResponse toResponse(Notification notification) {

        return NotificationResponse.builder()
                .id(notification.getId())
                .type(notification.getType())
                .priority(notification.getPriority())
                .status(notification.getStatus())
                .title(notification.getTitle())
                .message(notification.getMessage())
                .deviceCode(notification.getDeviceCode())
                .sensorCode(notification.getSensorCode())
                .source(notification.getSource())
                .value(notification.getValue())
                .unit(notification.getUnit())
                .notificationTime(notification.getNotificationTime())
                .build();
    }
}