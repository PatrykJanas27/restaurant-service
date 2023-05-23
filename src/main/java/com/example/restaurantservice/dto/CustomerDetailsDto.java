package com.example.restaurantservice.dto;

import lombok.Data;

@Data
public class CustomerDetailsDto {
    private Long id;
    private String lastName;
    private String firstName;
    private String phoneNumber;

}
