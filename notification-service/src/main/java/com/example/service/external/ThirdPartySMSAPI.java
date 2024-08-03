package com.example.service.external;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "exampleClient", url = "https://api.textlocal.in" )
public interface ThirdPartySMSAPI  {

    @RequestMapping(value = "/send/", method = RequestMethod.POST)

    String  sendSMS(
            @RequestParam("apiKey") String apiKey,
            @RequestParam("message") String message,
            @RequestParam("sender") String sender,
            @RequestParam("numbers") String numbers
    );
//    String sender = "&sender=" + "TXTLCL";
}
