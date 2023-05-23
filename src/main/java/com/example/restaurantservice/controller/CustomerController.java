package com.example.restaurantservice.controller;

import com.example.restaurantservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
@RequiredArgsConstructor
@RequestMapping("/customerDetails")
public class CustomerController {
    private final CustomerService customerService;

    /*@GetMapping("{/id}")
    ResponseEntity<CustomerDto> getCustomerDetailsById(@PathVariable Long id){

    }*/
}
