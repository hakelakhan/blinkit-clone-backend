package com.example.service;

import com.example.model.Notification;

public interface NotificationService {
    boolean sendNotification(NotificationChannel channel, Notification notification);
}
