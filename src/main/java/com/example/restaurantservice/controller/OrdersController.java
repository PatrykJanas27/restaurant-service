package com.example.restaurantservice.controller;

import com.example.restaurantservice.dto.CustomerDto;
import com.example.restaurantservice.dto.InputFoodDto;
import com.example.restaurantservice.entity.Food;
import com.example.restaurantservice.repository.FoodRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class OrdersController {
    private final FoodRepository foodRepository;

    @GetMapping("/index")
    public String home(Model model) {
        return "index";
    }

    @GetMapping("/showPageToAddFood")
    public String showPageToAddFood(Model model) {
        model.addAttribute("inputFoodDto", new InputFoodDto());
        return "showPageToAddFood";
    }

    @PostMapping("/addFood")
    public String addFood(@ModelAttribute InputFoodDto inputFoodDto) {
        Food food = new Food();
        food.setName(inputFoodDto.getName());
        System.out.println(inputFoodDto.getName());
        food.setDescription(inputFoodDto.getDescription());
        food.setPrice(inputFoodDto.getPrice());
        foodRepository.saveAndFlush(food);
        return "index";
    }

    @GetMapping("/showFood")
    public String showFood(Model model) {
        model.addAttribute("foods", foodRepository.findAll());
        return "showFood";
    }
}
