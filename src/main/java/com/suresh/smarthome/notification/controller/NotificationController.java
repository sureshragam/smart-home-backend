package com.suresh.smarthome.notification.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.suresh.smarthome.notification.dto.response.NotificationResponse;
import com.suresh.smarthome.notification.mapper.NotificationMapper;
import com.suresh.smarthome.notification.service.NotificationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping
    public List<NotificationResponse> getNotifications() {

        return notificationService.getNotifications()
                .stream()
                .map(NotificationMapper::toResponse)
                .toList();
    }

    @GetMapping("/unread")
    public List<NotificationResponse> getUnreadNotifications() {

        return notificationService.getUnreadNotifications()
                .stream()
                .map(NotificationMapper::toResponse)
                .toList();
    }

    @GetMapping("/unread/count")
    public long getUnreadCount() {

        return notificationService.getUnreadCount();
    }

    @PutMapping("/{id}/read")
    public void markAsRead(@PathVariable Long id) {

        notificationService.markAsRead(id);
    }

    @PutMapping("/read-all")
    public void markAllAsRead() {

        notificationService.markAllAsRead();
    }
}