package com.example.restaurantservice.dtoMapper;

import com.example.restaurantservice.dto.FoodDto;
import com.example.restaurantservice.dto.OrderProductDto;
import com.example.restaurantservice.entity.Customer;
import com.example.restaurantservice.entity.Delivery;
import com.example.restaurantservice.entity.Food;
import com.example.restaurantservice.entity.OrderProduct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class OrdersDtoMapper {
    private final FoodDtoMapper foodDtoMapper;
    private final CustomerDtoMapper customerDtoMapper;
    private final DeliveryDtoMapper deliveryDtoMapper;
    public OrderProductDto map(OrderProduct orders) {
        FoodDtoMapper foodDtoMapper = new FoodDtoMapper();
        OrderProductDto orderProductDto = new OrderProductDto();
        orderProductDto.setId(orders.getId());
        orderProductDto.setOrderDate(orders.getOrderDate());
        orderProductDto.setOrderMethod(orders.getOrderMethod());
        orderProductDto.setOrderTotalPrice(orders.getOrderTotalPrice());
        orderProductDto.setCustomerDetails(orders.getCustomerDetails());
        orderProductDto.setCustomerDto(customerDtoMapper.map(orders.getCustomer()));
        orderProductDto.setDeliveryDto(deliveryDtoMapper.map(orders.getDelivery()));
        orderProductDto.setFoodDtosList(orders.getFoods().stream().map(foodDtoMapper::map).toList());
        return orderProductDto;
    }

    public OrderProduct map(OrderProductDto orderProductDto) {
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setId(orderProductDto.getId());
        orderProduct.setOrderDate(orderProductDto.getOrderDate());
        orderProduct.setOrderTotalPrice(orderProductDto.getOrderTotalPrice());
        orderProduct.setCustomerDetails(orderProductDto.getCustomerDetails());
        orderProduct.setOrderMethod(orderProductDto.getOrderMethod());
        orderProduct.setCustomer(customerDtoMapper.map(orderProductDto.getCustomerDto()));
        orderProduct.setDelivery(deliveryDtoMapper.map(orderProductDto.getDeliveryDto()));
        orderProduct.setFoods(orderProductDto.getFoodDtosList().stream().map(foodDtoMapper::map).toList());
        return orderProduct;
    }
}
