package com.example.restaurantservice.dto;

import lombok.Data;

@Data
public class CustomerDto {
    private Integer id;
    private String lastName;
    private String firstName;
    private String phoneNumber;

}
