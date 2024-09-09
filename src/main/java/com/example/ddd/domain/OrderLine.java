package com.example.ddd.domain;
//OrderStatus

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class OrderLine {

    @Id
    @GeneratedValue
    private Long id;
    private String productId;
    private int quantity;

    public OrderLine() {}

    public OrderLine(String productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }
}

