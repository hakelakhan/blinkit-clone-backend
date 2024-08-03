package com.example.service;

import com.example.model.Notification;
import com.example.model.NotificationRecipient;

public interface NotificationChannelClient {

    boolean sendNotification(Notification notification, NotificationRecipient notificationRecipient);
}
