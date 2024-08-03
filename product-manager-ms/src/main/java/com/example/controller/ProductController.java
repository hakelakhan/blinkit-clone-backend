package com.example.controller;

import com.example.dto.AddProductRequest;
import com.example.service.ProductService;
import com.example.service.ProductTestDataLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductTestDataLoadService productTestDataLoadService;

    @PostMapping("/product")
    ResponseEntity<String> addProduct(@RequestBody AddProductRequest addProductRequest) {
        productService.addProduct(addProductRequest);
        return ResponseEntity.ok("Success");
    }
    @PostMapping("/product/add-all")
    ResponseEntity<String> addProduct() {
        try {
            productTestDataLoadService.loadTestData();
            return ResponseEntity.ok("Success");
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body("Failed with error " + e.getMessage());
        }
    }
}
