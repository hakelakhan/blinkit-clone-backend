package com.example.model;

public abstract class Notification {
    private final NotificationChannel notificationChannel;

    protected Notification(NotificationChannel notificationChannel) {
        this.notificationChannel = notificationChannel;
    }

    public NotificationChannel getNotificationChannel() {
        return notificationChannel;
    }
}
