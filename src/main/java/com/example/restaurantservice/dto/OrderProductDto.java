package com.example.restaurantservice.dto;

import com.example.restaurantservice.entity.Customer;
import com.example.restaurantservice.entity.Delivery;
import com.example.restaurantservice.entity.Food;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderProductDto {
    private Integer id;
    private String customerDetails;
    private LocalDateTime orderDate;
    private String orderMethod;
    private Double orderTotalPrice;
    private CustomerDto customerDto;
    private DeliveryDto deliveryDto;
    private List<FoodDto> foodDtosList;
}
