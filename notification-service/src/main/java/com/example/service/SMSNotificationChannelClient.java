package com.example.service;

import com.example.model.Notification;
import com.example.model.NotificationRecipient;
import com.example.model.SMSNotification;
import com.example.service.external.ThirdPartySMSAPI;
import lombok.extern.slf4j.Slf4j;
import org.example.constant.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SMSNotificationChannelClient implements NotificationChannelClient {

    private static final Logger log = LoggerFactory.getLogger(SMSNotificationChannelClient.class);
    @Autowired
    private ThirdPartySMSAPI thirdPartySMSAPI;

    @Override
    public boolean sendNotification(Notification notification, NotificationRecipient notificationRecipient) {
        SMSNotification smsNotification = (SMSNotification) notification;

        try {
            log.info("Sending sms for user {}", notificationRecipient.getRecipientIdentifier());
            var response = thirdPartySMSAPI.sendSMS(Constants.TEXT_LOCAL_SMS_API_KEY, smsNotification.getText(), Constants.TEXT_LOCAL_DEFAULT_SENDER, notificationRecipient.getRecipientIdentifier());
            log.info("Sent sms for user {} Response from API is {} ", notificationRecipient.getRecipientIdentifier(), response);
            return true;
        }
        catch(Exception ex) {
            log.error("Error while sending sms to user {}, Error is {}", notificationRecipient.getRecipientIdentifier(), ex);
        }
        return false;
    }
}
