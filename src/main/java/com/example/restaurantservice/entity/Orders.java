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
public class Orders implements Printable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private CustomerDetails customerDetails;

    @OneToMany
    private List<Product> products;
    private double totalPrice;


    private Long customerId;
    private Long deliveryManId;

    @OneToOne
    private Orders orders;
    private LocalDateTime dateTime;
    private String paymentMethod;
    @OneToOne
    private PaymentDetails paymentDetails;

    public Orders(CustomerDetails customerDetails, List<Product> products) {
        this.customerDetails = customerDetails;
        this.products = products;
        this.totalPrice = calculateTotalPrice(products);
    }

    private double calculateTotalPrice(List<Product> products) {
        return products.stream().map(Product::getPrice).reduce(0.0, Double::sum);
    }

    @Override
    public void print() {
        System.out.println("Customer details: " + customerDetails.toString());
        System.out.println("Products: ");
        products.forEach(Printable::print);
    }
}
