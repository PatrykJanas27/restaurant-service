package com.example.restaurantservice.service;

import com.example.restaurantservice.dto.CustomerDto;
import com.example.restaurantservice.dtoMapper.CustomerDetailsDtoMapper;
import com.example.restaurantservice.entity.Customer;
import com.example.restaurantservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerDetailsDtoMapper customerDetailsDtoMapper;

    Optional<CustomerDto> getCustomerDetailsById(Integer id) {
        return customerRepository.findById(id)
                .map(customerDetailsDtoMapper::map);
    }

    CustomerDto saveCustomerDetails(CustomerDto customerDto) {
        Customer customer = customerDetailsDtoMapper.map(customerDto);
        Customer savedCustomer = customerRepository.save(customer);
        return customerDetailsDtoMapper.map(savedCustomer);
    }
}
