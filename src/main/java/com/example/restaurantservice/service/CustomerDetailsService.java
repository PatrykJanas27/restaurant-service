package com.example.restaurantservice.service;

import com.example.restaurantservice.dto.CustomerDetailsDto;
import com.example.restaurantservice.dtoMapper.CustomerDetailsDtoMapper;
import com.example.restaurantservice.entity.CustomerDetails;
import com.example.restaurantservice.repository.CustomerDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerDetailsService {
    private final CustomerDetailsRepository customerDetailsRepository;
    private final CustomerDetailsDtoMapper customerDetailsDtoMapper;
    Optional<CustomerDetailsDto> getCustomerDetailsById(Long id) {
        return customerDetailsRepository.findById(id)
                .map(customerDetailsDtoMapper::map);
    }
    CustomerDetailsDto saveCustomerDetails(CustomerDetailsDto customerDetailsDto){
        CustomerDetails customerDetails = customerDetailsDtoMapper.map(customerDetailsDto);
        CustomerDetails savedCustomerDetails = customerDetailsRepository.save(customerDetails);
        return customerDetailsDtoMapper.map(savedCustomerDetails);
    }
}
