package com.example.repository;

import com.example.entity.ProductCategoryMapping;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductCategoryMappingRepository extends MongoRepository<ProductCategoryMapping, String> {
}
