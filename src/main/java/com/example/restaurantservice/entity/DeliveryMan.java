package com.example.restaurantservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryMan implements Printable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String phoneNumber;

    @OneToMany
    List<Orders> orders;

    public void print() {
        System.out.println("DeliveryMan: " + firstName + " " + lastName);
        System.out.println("Phone Number: " + phoneNumber);
        orders.forEach(Printable::print);
    }


}
