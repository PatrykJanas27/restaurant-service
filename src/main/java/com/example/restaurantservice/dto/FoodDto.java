package com.example.restaurantservice.dto;

import lombok.Data;

@Data
public class FoodDto {
    private Integer id;
    private String name;
    private String description;
    private Double price;
}
