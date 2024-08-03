package com.example.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Product {
    @Id
    private String id;
    private String name;
    private String category;

    private String price;
    private String unit;
    private Map<String, String > highlights;
    private String details;
    private List<String> images;
    public Product() {
        highlights = new HashMap<>();
        images = new ArrayList<>();
    }
    public Product(String name, String category) {
        this();
        this.name = name;
        this.category = category;
    }
    public double getPriceAsDouble() {
        return Double.parseDouble(this.price);
    }
}
