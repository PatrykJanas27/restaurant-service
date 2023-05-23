package com.example.restaurantservice.dtoMapper;

import com.example.restaurantservice.dto.CustomerDetailsDto;
import com.example.restaurantservice.entity.CustomerDetails;
import org.springframework.stereotype.Service;

@Service
public class CustomerDetailsDtoMapper {
    public CustomerDetailsDto map(CustomerDetails customerDetails){
        CustomerDetailsDto customerDetailsDto = new CustomerDetailsDto();
        customerDetailsDto.setFirstName(customerDetails.getFirstName());
        customerDetailsDto.setLastName(customerDetails.getLastName());
        customerDetailsDto.setPhoneNumber(customerDetails.getPhoneNumber());
        return customerDetailsDto;
    }
    public CustomerDetails map(CustomerDetailsDto customerDetailsDto){
        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setId(customerDetailsDto.getId());
        customerDetails.setLastName(customerDetailsDto.getLastName());
        customerDetails.setFirstName(customerDetailsDto.getFirstName());
        customerDetails.setPhoneNumber(customerDetailsDto.getPhoneNumber());
        return customerDetails;
    }
}