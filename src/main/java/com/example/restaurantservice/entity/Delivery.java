package com.example.restaurantservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Delivery implements Printable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String deliveryName;
    private String areaCode;

//    @OneToMany(mappedBy = "delivery")
//    private List<OrderProduct> orderProducts;

    @Override
    public void print() {
        System.out.println("Delivery: " + deliveryName);
        System.out.println("Area code: " + areaCode);
    }
}
