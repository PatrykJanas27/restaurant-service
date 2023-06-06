package com.example.restaurantservice.controller;

import com.example.restaurantservice.dto.CustomerDto;
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
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.Order;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

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

        Customer customer = new Customer();
        customer.setCustomerLocation(customerDto.getCustomerLocation());
        customer.setCustomerName(customerDto.getCustomerName());
        customer.setCustomerType(customerDto.getCustomerType());
        customerRepository.saveAndFlush(customer);
        OrderProduct order = new OrderProduct();
        order.setCustomer(customer);
        ordersRepository.saveAndFlush(order);
        return "showPageToMakeAnOrder2";
    }

    @PostMapping("/submitAnOrder")
    public String submitAnOrder(@ModelAttribute("customerDto") CustomerDto customerDto,
                                @RequestParam(name = "selectedFood", required = false) List<String> selectedFood,
                                Model model
    ) {
        System.out.println(customerDto.getCustomerName());
        selectedFood.forEach(System.out::println);
        OrderProduct lastOrder = ordersRepository.findAll().get(ordersRepository.findAll().size() - 1);
        List<Food> foods = lastOrder.getFoods();
        Double totalPrice = 0.0;
        for (String foodDto : selectedFood) {
            Food byName = foodRepository.findByName(foodDto);
            foods.add(byName);
            totalPrice += byName.getPrice();
        }
        lastOrder.setOrderTotalPrice(totalPrice);
        lastOrder.setOrderDate(LocalDateTime.now());
        ordersRepository.saveAndFlush(lastOrder);
        model.addAttribute("order", ordersRepository.findAll().get(ordersRepository.findAll().size() - 1));
        return "showOrder";
    }

    @GetMapping("/orderRaport")
    public String orderRaport(Model model) {
        model.addAttribute("orders", ordersRepository.findAll());
        return "orderRaport";
    }

    @GetMapping("/editFood/{foodId}")
    public String editFood(@PathVariable("foodId") Integer foodId, Model model) {
        // Retrieve the food item by its ID from your data source (e.g., database)
        Optional<Food> food = foodRepository.findById(foodId);
        if(food.isEmpty()){
            throw new RuntimeException("there is no food with this id");
        }

        model.addAttribute("food", food);
        return "editFood"; // Return the name of the HTML template for editing food
    }

    @PostMapping("/saveFood")
    @Transactional
    public String saveFood(@ModelAttribute("food") Food food) {
        // Update the food item in your data source (e.g., database)
        Optional<Food> byId = foodRepository.findById(food.getId());
        Food food1 = byId.get();
        food1.setPrice(food.getPrice());
        food1.setName(food.getName());
        food1.setDescription(food.getDescription());
        return "index"; // Redirect to the food listing page after saving the changes
    }

    @GetMapping("/generateReportWithDate")
    public String generateReportWithDate(Model model){
        model.addAttribute("orderReportInput", new OrderReportInput());
        return "generateRaport";
    }

    @PostMapping("/generateReport")
    public String generateReport(@ModelAttribute("orderReportInput") OrderReportInput orderReportInput, Model model) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime fromDate = LocalDateTime.parse(orderReportInput.getFromDate() + "T00:00:00", formatter);
        LocalDateTime toDate = LocalDateTime.parse(orderReportInput.getToDate()+ "T23:59:59", formatter);
        System.out.println(fromDate);
        System.out.println(toDate);


        // Retrieve the orders within the specified date range from your data source (e.g., database)
        List<OrderProduct> orders = ordersRepository.findAllByOrderDateAfterAndOrderDateBefore(fromDate, toDate);

        model.addAttribute("orders", orders);
        return "order-report"; // Return the name of the HTML template to display the order report
    }





}
