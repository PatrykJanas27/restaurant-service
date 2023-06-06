package com.example.restaurantservice.repository;

import com.example.restaurantservice.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface OrdersRepository extends JpaRepository<OrderProduct, Integer> {
    List<OrderProduct> findAll();

    List<OrderProduct> findAllByOrderDateAfterAndOrderDateBefore(LocalDateTime fromDate, LocalDateTime toDate);
}
