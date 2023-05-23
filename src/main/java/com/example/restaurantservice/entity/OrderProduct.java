package com.example.restaurantservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderProduct implements Printable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String customerDetails;
    private LocalDateTime orderDate;
    private String orderMethod;
    private Double orderTotalPrice; // TODO: change to BigDecimal

    // Foregin key should be on the manyside
//    @OneToMany(mappedBy = "orderProduct") // TODO: it should be at the food side
//    private List<Food> foods;

    @ManyToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;


    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private double calculateTotalPrice(List<Food> foods) {
        return foods.stream().map(Food::getPrice).reduce(0.0, Double::sum);
    }

    @Override
    public void print() {
        System.out.println("Customer details: " + customer.toString());
        System.out.println("Products: ");
//        foods.forEach(Printable::print);
    }
}
