package com.example.restaurantservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Food implements Printable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String description;
    private Double price; // TODO: change to BigDecimal

    @ManyToOne
    @JoinColumn(name = "order_product_id")
    private OrderProduct orderProduct;

    @Override
    public void print() {
        System.out.println("Food: " + name);
        System.out.println("Price: " + price);
    }

    public Double getPrice() {
        return price;
    }
}
