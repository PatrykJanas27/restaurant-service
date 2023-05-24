package com.example.restaurantservice.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderProductDto {
    private Integer id;
    private String customerDetails;
    private LocalDateTime orderDate;
    private String orderMethod;
    private Double orderTotalPrice;
}
