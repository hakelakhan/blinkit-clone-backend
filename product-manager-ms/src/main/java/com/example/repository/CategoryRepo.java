package com.example.repository;

import com.example.entity.Category;
import com.example.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepo extends MongoRepository<Category, String> {
}
