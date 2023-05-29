package com.example.restaurantservice.controller;

import com.example.restaurantservice.dto.CustomerDto;
import com.example.restaurantservice.dto.FoodDto;
import com.example.restaurantservice.dto.InputFoodDto;
import com.example.restaurantservice.entity.Customer;
import com.example.restaurantservice.entity.Food;
import com.example.restaurantservice.entity.OrderProduct;
import com.example.restaurantservice.repository.CustomerRepository;
import com.example.restaurantservice.repository.FoodRepository;
import com.example.restaurantservice.repository.OrdersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
public class OrdersController {
    private final FoodRepository foodRepository;
    private final OrdersRepository ordersRepository;
    private final CustomerRepository customerRepository;

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

    @GetMapping("/showPageToMakeAnOrder1")
    public String showPageToMakeAnOrder1(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        return "showPageToMakeAnOrder1";
    }



    @PostMapping("/showPageToMakeAnOrder2")
    public String showPageToMakeAnOrder2(@ModelAttribute CustomerDto customerDto, Model model) {
        model.addAttribute("customerDto", customerDto);
        System.out.println(customerDto.getCustomerName());
        System.out.println(customerDto.getCustomerLocation());
        model.addAttribute("allFoodFromRepository", foodRepository.findAll());
        return "showPageToMakeAnOrder2";
    }

    @PostMapping("/submitAnOrder")
    public String submitAnOrder(@ModelAttribute("customerDto") CustomerDto customerDto,
                                @RequestParam(name = "selectedFood", required = false) List<String> selectedFood
    ) {
        System.out.println(customerDto.getCustomerName());
        System.out.println(selectedFood.get(0));
        return "redirect:/index";
    }

}
