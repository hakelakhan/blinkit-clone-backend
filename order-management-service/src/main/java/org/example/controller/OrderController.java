package org.example.controller;

import org.example.dto.CreateNewOrderRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    @PostMapping("/order")
    ResponseEntity<String> placeNewOrder(CreateNewOrderRequestDTO createNewOrderRequestDTO) {
        return ResponseEntity.ok("Success");
    }
    @GetMapping("/")
    ResponseEntity<String> getOrderDetails(@RequestParam("order-id") String orderId) {
        return ResponseEntity.ok("Success");
    }
    @PutMapping("/update-status")
    ResponseEntity<String> updateStatus(@RequestHeader("order-id") String orderId) {
        return ResponseEntity.ok("Success");
    }

    //determine delivery charges
    // get bill details
    /*
            Delivery Boy notification
            Shop owner notification
            Customer notification order placed
     */



}
