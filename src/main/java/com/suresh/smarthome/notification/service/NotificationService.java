package com.suresh.smarthome.notification.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suresh.smarthome.common.exception.ResourceNotFoundException;
import com.suresh.smarthome.notification.entity.Notification;
import com.suresh.smarthome.notification.enums.NotificationPriority;
import com.suresh.smarthome.notification.enums.NotificationStatus;
import com.suresh.smarthome.notification.enums.NotificationType;
import com.suresh.smarthome.notification.repository.NotificationRepository;
import com.suresh.smarthome.sensor.enums.UnitType;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public Notification createNotification(
            NotificationType type,
            NotificationPriority priority,
            String title,
            String message,
            String deviceCode,
            String sensorCode,
            String source,
            Double value,
            UnitType unit)
    {
    	
    	Optional<Notification> existingNotification =
    	        notificationRepository
    	                .findFirstByStatusAndTypeAndSensorCodeOrderByNotificationTimeDesc(
    	                        NotificationStatus.UNREAD,
    	                        type,
    	                        sensorCode);

    	if (existingNotification.isPresent()) {
    	    return existingNotification.get();
    	}
    	
        Notification notification = Notification.builder()
                .type(type)
                .priority(priority)
                .status(NotificationStatus.UNREAD)
                .title(title)
                .message(message)
                .deviceCode(deviceCode)
                .sensorCode(sensorCode)
                .source(source)
                .value(value)
                .unit(unit)
                .notificationTime(LocalDateTime.now())
                .build();

        return notificationRepository.save(notification);
    }

    public List<Notification> getNotifications()
    {
        return notificationRepository.findAllByOrderByNotificationTimeDesc();
    }

    public List<Notification> getUnreadNotifications()
    {
        return notificationRepository
                .findByStatusOrderByNotificationTimeDesc(
                        NotificationStatus.UNREAD);
    }

    public long getUnreadCount()
    {
        return notificationRepository.countByStatus(
                NotificationStatus.UNREAD);
    }
    
    @Transactional
    public void markAsRead(Long notificationId)
    {
        Notification notification =
                notificationRepository.findById(notificationId).orElseThrow(() ->
                new ResourceNotFoundException(
                        String.format(
                                "Notification with id '%d' not found.",
                                notificationId)));

        notification.setStatus(NotificationStatus.READ);

        notificationRepository.save(notification);
    }
    @Transactional
    public void markAllAsRead() {

        List<Notification> notifications =
                notificationRepository.findByStatusOrderByNotificationTimeDesc(
                        NotificationStatus.UNREAD);

        notifications.forEach(notification ->
                notification.setStatus(NotificationStatus.READ));
    }

}