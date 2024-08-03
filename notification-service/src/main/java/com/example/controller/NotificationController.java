package com.example.controller;

import com.example.service.NotificationBusinessService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.example.constant.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notification")
public class NotificationController {

    private final NotificationBusinessService notificationBusinessService;

    @Autowired
    public NotificationController(NotificationBusinessService notificationBusinessService) {
        this.notificationBusinessService = notificationBusinessService;
    }

    @PostMapping("/send-otp")
    ResponseEntity<String> sendOTP(@Valid @Pattern(regexp = Constants.Regex.MOBILE_NUMBER_PATTERN) @RequestHeader("customerMobileNumber") String customerMobileNumber) {

        var result = notificationBusinessService.sendOTP(customerMobileNumber);
        return ResponseEntity.ok(result ? "Success" : "Failed");

    }
//    ResponseEntity<String> verifyOTP(VerifyOTPRequest verifyOTPRequest) {

}
