package com.example.restaurantservice.dtoMapper;

import com.example.restaurantservice.dto.FoodDto;
import com.example.restaurantservice.entity.Food;
import org.springframework.stereotype.Service;

@Service
public class FoodDtoMapper {
    public FoodDto map(Food food){
        FoodDto foodDto = new FoodDto();
        foodDto.setId(food.getId());
        foodDto.setName(food.getName());
        foodDto.setPrice(food.getPrice());
        return foodDto;
    }
    public Food map(FoodDto foodDto){
        Food food = new Food();
        food.setId(foodDto.getId());
        food.setName(foodDto.getName());
        food.setPrice(foodDto.getPrice());
        return food;
    }
}
