package com.example.service;

import com.example.dto.AddProductRequest;
import com.example.entity.Category;
import com.example.entity.Product;
import com.example.repository.CategoryRepo;
import com.example.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private CategoryRepo categoryRepo;

    public boolean addProduct(AddProductRequest addProductRequest) {
        Product product = new Product(addProductRequest.name(), addProductRequest.category());
        productRepo.save(product);
//        Category category = new Category(product.getCategory());
        return true;
    }
}
