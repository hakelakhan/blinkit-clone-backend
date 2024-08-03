package com.example.service;

import com.example.model.NotificationChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationChannelFactory {
    private NotificationChannelClient smsClient;

    @Autowired
    public NotificationChannelFactory(NotificationChannelClient smsClient) {
        this.smsClient = smsClient;
    }

    public NotificationChannelClient getNotificationChannelClient(NotificationChannel notificationChannel) {
        return switch(notificationChannel) {
            case SMS -> smsClient;
            case EMAIL -> throw new RuntimeException("Not yet implemented");

        };
    }
}
