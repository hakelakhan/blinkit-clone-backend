package com.example.service;

import com.example.model.Notification;
import com.example.model.NotificationChannel;
import com.example.model.NotificationRecipient;
import com.example.model.SMSNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service

public class NotificationBusinessService {
    @Autowired
    private NotificationChannelFactory notificationChannelFactory;
    public boolean sendOTP(String customerMobileNumber) {
        String newOTP = "12434";
        Notification notification =

                new SMSNotification("Dear customer, please find OTP $ ", new String[] {newOTP});

        NotificationChannelClient client  =
                notificationChannelFactory.getNotificationChannelClient( notification.getNotificationChannel());
        boolean retValue = client.sendNotification(notification, new NotificationRecipient() {
            @Override
            public String getRecipientIdentifier() {
                return "919834349699";
            }

            @Override
            public NotificationChannel getNotificationChannel() {
                return NotificationChannel.SMS;
            }
        });

        return retValue;

    }

    public void setNotificationChannelFactory(NotificationChannelFactory notificationChannelFactory) {
        this.notificationChannelFactory = notificationChannelFactory;
    }
}
