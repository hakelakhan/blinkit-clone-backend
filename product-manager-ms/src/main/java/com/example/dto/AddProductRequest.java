package com.example.dto;

public record AddProductRequest (
        String name,
        String description,
        String category
){
}
