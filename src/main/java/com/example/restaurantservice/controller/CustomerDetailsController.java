package com.example.restaurantservice.controller;

import com.example.restaurantservice.dto.CustomerDetailsDto;
import com.example.restaurantservice.entity.CustomerDetails;
import com.example.restaurantservice.service.CustomerDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
@RequiredArgsConstructor
@RequestMapping("/customerDetails")
public class CustomerDetailsController {
    private final CustomerDetailsService customerDetailsService;

    /*@GetMapping("{/id}")
    ResponseEntity<CustomerDetailsDto> getCustomerDetailsById(@PathVariable Long id){

    }*/
}
