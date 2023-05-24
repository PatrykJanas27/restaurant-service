package com.example.restaurantservice.dto;

import lombok.Data;

@Data
public class CustomerDto {
    private Integer id;
    private String customerName;
    private String customerLocation;
    private String customerType;
}
