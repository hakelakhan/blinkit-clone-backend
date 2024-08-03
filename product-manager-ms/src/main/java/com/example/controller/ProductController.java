package com.example.controller;

import com.example.dto.AddProductRequest;
import com.example.entity.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    ResponseEntity<String> addProduct(@RequestBody AddProductRequest addProductRequest) {
        productService.addProduct(addProductRequest);

        return ResponseEntity.ok("Success");
    }
}
