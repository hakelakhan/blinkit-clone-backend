package com.example.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.parameters.P;

import java.util.List;

@Document(collection = "productIdsByCategory")
@Getter
@Setter
public class ProductIdsByCategory {
    @Id
    private String category;
    private List<String> productIds;

}
