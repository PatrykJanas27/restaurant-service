package com.example.restaurantservice.repository;

import com.example.restaurantservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDetailsRepository extends JpaRepository<Customer, Integer> {
}
