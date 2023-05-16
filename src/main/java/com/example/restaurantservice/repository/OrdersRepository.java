package com.example.restaurantservice.repository;

import com.example.restaurantservice.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders,Long> {
}
