package com.example.restaurantservice.repository;

import com.example.restaurantservice.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<OrderProduct, Integer> {
    List<OrderProduct> findAll();
}
