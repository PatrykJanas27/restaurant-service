package com.example.restaurantservice.dtoMapper;

import com.example.restaurantservice.dto.OrdersDto;
import com.example.restaurantservice.entity.Orders;
import org.springframework.stereotype.Service;

@Service
public class OrdersDtoMapper {
    public OrdersDto map(Orders orders){
        OrdersDto ordersDto = new OrdersDto();
        ordersDto.setId(ordersDto.getId());
        return ordersDto;
    }
    public Orders map(OrdersDto ordersDto){
        Orders orders = new Orders();
        orders.setId(ordersDto.getId());
        return orders;
    }
}
