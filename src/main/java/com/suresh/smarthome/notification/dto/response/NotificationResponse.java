package com.suresh.smarthome.notification.dto.response;

import java.time.LocalDateTime;

import com.suresh.smarthome.notification.enums.NotificationPriority;
import com.suresh.smarthome.notification.enums.NotificationStatus;
import com.suresh.smarthome.notification.enums.NotificationType;
import com.suresh.smarthome.sensor.enums.UnitType;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NotificationResponse {

    private Long id;

    private NotificationType type;

    private NotificationPriority priority;

    private NotificationStatus status;

    private String title;

    private String message;

    private String deviceCode;

    private String sensorCode;

    private String source;

    private Double value;

    private UnitType unit;

    private LocalDateTime notificationTime;

}