package com.suresh.smarthome.notification.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suresh.smarthome.notification.entity.Notification;
import com.suresh.smarthome.notification.enums.NotificationStatus;
import com.suresh.smarthome.notification.enums.NotificationType;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findAllByOrderByNotificationTimeDesc();

    List<Notification> findByStatusOrderByNotificationTimeDesc(
            NotificationStatus status);

    long countByStatus(NotificationStatus status);
    
    Optional<Notification> findFirstByTypeAndSensorCodeOrderByNotificationTimeDesc(
            NotificationType type,
            String sensorCode);

}