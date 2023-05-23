package com.example.restaurantservice.dtoMapper;

import com.example.restaurantservice.dto.CustomerDto;
import com.example.restaurantservice.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerDetailsDtoMapper {
    public CustomerDto map(Customer customerDetails) {
        CustomerDto customerDto = new CustomerDto();

        return customerDto;
    }

    public Customer map(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setId(customerDto.getId());
        return customer;
    }
}