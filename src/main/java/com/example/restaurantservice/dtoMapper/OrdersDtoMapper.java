package com.example.restaurantservice.dtoMapper;

import com.example.restaurantservice.dto.OrderProductDto;
import com.example.restaurantservice.entity.OrderProduct;
import org.springframework.stereotype.Service;

@Service
public class OrdersDtoMapper {
    public OrderProductDto map(OrderProduct orders) {
        OrderProductDto orderProductDto = new OrderProductDto();
        orderProductDto.setId(orderProductDto.getId());
        return orderProductDto;
    }

    public OrderProduct map(OrderProductDto orderProductDto) {
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setId(orderProductDto.getId());
        return orderProduct;
    }
}
