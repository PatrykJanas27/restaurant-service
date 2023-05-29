package com.example.restaurantservice.controller;

import com.example.restaurantservice.dto.CustomerDto;
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

    @GetMapping("/makeAnOrder")
    public String showData(Model model) {
        model.addAttribute("foods", foodRepository.findAll());
        return "makeAnOrder";
    }

    @PostMapping("/submitOrder")
    public String submitOrder(@RequestParam("selectedFoods") List<Integer> selectedFoods, HttpServletRequest request, Model model) {
        OrderProduct order = new OrderProduct();
        List<Food> foods = new ArrayList<>();
        for (Integer id : selectedFoods) {
            String quantityStr = request.getParameter("quantity" + id);
            int quantity = Integer.parseInt(quantityStr);
            Food food = foodRepository.findById(id).orElse(null);
            if (food != null) {
                foods.add(food);
            }
        }
        order.setFoods(foods);
        order.setOrderTotalPrice(order.calculateTotalPrice(foods));
        // Set other fields of the order...
        // Save the order to the database
        ordersRepository.save(order);
        model.addAttribute("order", order);
        return "orderConfirmation";
    }

    @PostMapping("/appointment/save")
    public String saveAppointment(@ModelAttribute CustomerDto customerDto) {
        // Save the customerDto...
        return "redirect:/makeAnOrder";
    }
}
