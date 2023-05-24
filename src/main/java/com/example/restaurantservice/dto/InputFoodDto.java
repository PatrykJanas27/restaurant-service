package com.example.restaurantservice.dto;

import lombok.Data;

@Data
public class InputFoodDto {
    private String name;
    private String description;
    private Double price;
}
