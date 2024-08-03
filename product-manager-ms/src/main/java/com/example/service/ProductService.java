package com.example.service;

import com.example.dto.AddProductRequest;
import com.example.entity.Product;
import com.example.entity.ProductCategoryMapping;
import com.example.repository.ProductCategoryMappingRepository;
import com.example.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ProductCategoryMappingRepository productCategoryMappingRepository;
    @Autowired
    private ResourceLoader resourceLoader;

    public boolean addProduct(AddProductRequest addProductRequest) {
        Product product = new Product(addProductRequest.name(), addProductRequest.category());
        saveProduct(product);
        return true;
    }
    void saveProduct(Product product) {
        product = productRepo.save(product);
        String category = product.getCategory();
        var byCategory = productCategoryMappingRepository.findById(category).orElseGet(() -> new ProductCategoryMapping(category));
        byCategory.getProductIds().add(product.getId());
        productCategoryMappingRepository.save(byCategory);
        
    }

    public void deleteProductById(String id) {
        productRepo.deleteById(id);
    }

    
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product getProductById(String id) {
        Optional<Product> product = productRepo.findById(id);
        return product.orElse(null);
    }

    
    public List<Product> getProductsByCategory(String category) {
        // Implement this method if custom query is needed
        List<String> ids = getProductIdssByCategory(category);
        if(ids.isEmpty()) {
            return Collections.emptyList();
        }
        return productRepo.findAllById(ids); // Placeholder implementation
    }

    private List<String> getProductIdssByCategory(String category) {
        return productCategoryMappingRepository.findById(category)
                .map(ProductCategoryMapping::getProductIds)
                .orElse(Collections.emptyList());
    }


    public List<Product> getProductsByPriceRange(String category, double minPrice, double maxPrice) {
        // Implement this method if custom query is needed
        List<Product> productsByCategory = getProductsByCategory(category);
        return productsByCategory.stream()
                .filter(product -> product.getPriceAsDouble() >= minPrice && product.getPriceAsDouble() <= maxPrice)
                .collect(Collectors.toList());
    }
}
