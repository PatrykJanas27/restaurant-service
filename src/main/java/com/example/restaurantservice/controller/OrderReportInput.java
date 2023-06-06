package com.example.restaurantservice.controller;

import lombok.Data;

import java.time.LocalDate;

@Data
public class OrderReportInput {
    private String fromDate;
    private String toDate;
}
