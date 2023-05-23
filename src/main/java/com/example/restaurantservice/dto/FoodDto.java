package com.example.restaurantservice.dto;

import lombok.Data;

@Data
public class FoodDto {
    private Long id;
    private String name;
    private double price;
}
