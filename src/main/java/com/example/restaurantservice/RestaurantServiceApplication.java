package com.example.restaurantservice;

import com.example.restaurantservice.entity.Food;
import com.example.restaurantservice.repository.FoodRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RestaurantServiceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(RestaurantServiceApplication.class, args);
		FoodRepository foodRepository = run.getBean(FoodRepository.class);
		foodRepository.save(new Food(1, "hot-dog", "z ketchupem", 30.0));



	}

}
