package com.example.entity;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductGroup {
    @Id
    private String id;
    private String group;
    private List<String> productIds;
}
