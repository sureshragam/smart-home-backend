package com.suresh.smarthome.notification.entity;

import java.time.LocalDateTime;

import com.suresh.smarthome.common.entity.BaseEntity;
import com.suresh.smarthome.notification.enums.NotificationPriority;
import com.suresh.smarthome.notification.enums.NotificationStatus;
import com.suresh.smarthome.notification.enums.NotificationType;
import com.suresh.smarthome.sensor.enums.UnitType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "notifications")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Notification extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NotificationType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NotificationPriority priority;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NotificationStatus status;

    @Column(nullable = false, length = 150)
    private String title;

    @Column(nullable = false, length = 500)
    private String message;

    @Column(nullable = false, length = 100)
    private String deviceCode;

    @Column(length = 100)
    private String sensorCode;

    @Column(length = 100)
    private String source;

    @Column
    private Double value;
    
    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private UnitType unit;

    @Column(nullable = false)
    private LocalDateTime notificationTime;

}