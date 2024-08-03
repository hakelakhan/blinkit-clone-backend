package com.example.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ProductCategoryMapping {

    @Id
    private String category;
    private List<String> productIds;

    public ProductCategoryMapping(String category) {
        this.category = category;
        this.productIds = new ArrayList<>();
    }
}
