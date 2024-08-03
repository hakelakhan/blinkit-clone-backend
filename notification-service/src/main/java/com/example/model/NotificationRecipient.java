package com.example.model;

public interface NotificationRecipient {
    //get mobile number or email id or any other id
    String getRecipientIdentifier();
    NotificationChannel getNotificationChannel();
}
