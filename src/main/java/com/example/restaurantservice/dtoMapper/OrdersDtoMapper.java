package com.example.restaurantservice.dtoMapper;

import com.example.restaurantservice.dto.OrderProductDto;
import com.example.restaurantservice.entity.OrderProduct;
import org.springframework.stereotype.Service;

@Service
public class OrdersDtoMapper {
    public OrderProductDto map(OrderProduct orders) {
        OrderProductDto orderProductDto = new OrderProductDto();
        orderProductDto.setId(orders.getId());
        orderProductDto.setOrderDate(orders.getOrderDate());
        orderProductDto.setOrderMethod(orders.getOrderMethod());
        orderProductDto.setOrderTotalPrice(orders.getOrderTotalPrice());
        orderProductDto.setCustomerDetails(orders.getCustomerDetails());
        return orderProductDto;
    }

    public OrderProduct map(OrderProductDto orderProductDto) {
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setId(orderProductDto.getId());
        orderProduct.setOrderDate(orderProductDto.getOrderDate());
        orderProduct.setOrderTotalPrice(orderProductDto.getOrderTotalPrice());
        orderProduct.setCustomerDetails(orderProductDto.getCustomerDetails());
        orderProduct.setOrderMethod(orderProductDto.getOrderMethod());
        return orderProduct;
    }
}
