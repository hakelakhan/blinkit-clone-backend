package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableFeignClients
@ImportAutoConfiguration(FeignAutoConfiguration.class)
public class NotificationServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApp.class, args);
    }

}
