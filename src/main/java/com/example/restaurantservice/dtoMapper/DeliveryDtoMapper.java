package com.example.restaurantservice.dtoMapper;

import com.example.restaurantservice.dto.DeliveryDto;
import com.example.restaurantservice.entity.Delivery;
import org.springframework.stereotype.Service;

@Service
public class DeliveryDtoMapper {
    public DeliveryDto map(Delivery delivery){
        DeliveryDto deliveryDto = new DeliveryDto();
        deliveryDto.setId(delivery.getId());
        deliveryDto.setDeliveryName(delivery.getDeliveryName());
        deliveryDto.setAreaCode(delivery.getAreaCode());
        return deliveryDto;
    }
    public Delivery map(DeliveryDto deliveryDto){
        Delivery delivery = new Delivery();
        delivery.setId(deliveryDto.getId());
        delivery.setDeliveryName(deliveryDto.getDeliveryName());
        delivery.setAreaCode(deliveryDto.getAreaCode());
        return delivery;
    }
}
