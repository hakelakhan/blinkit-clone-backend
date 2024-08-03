package com.example.model;

public class SMSNotification extends Notification {
    private String text;

    public String[] getDynamicParams() {
        return dynamicParams;
    }

    private String[] dynamicParams;

    public SMSNotification(String text, String[] dynamicParams) {
        super(NotificationChannel.SMS);
        this.text = text;
        this.dynamicParams = dynamicParams;
    }

    public String getText() {
        return text;
    }
}
