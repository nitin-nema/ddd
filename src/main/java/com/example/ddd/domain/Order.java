//Aggreagte root class

package com.example.ddd.domain;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


//JPA enitity
@Entity
public class Order {

    @Id
    private String id;
    private String customerId;
    private LocalDateTime createdAt;


    //maps the status field to the database columns
    @Enumerated(EnumType.STRING)
    private OrderStatus status;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderLine> orderLines = new ArrayList<>();

    public Order() {}

    public Order(String id, String customerId) {
        this.id = id;
        this.customerId = customerId;
        this.createdAt = LocalDateTime.now();
        this.status = OrderStatus.NEW;
    }

    public String getId() {
        return id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public OrderStatus getStatus() {
        return status;
    }


//business logic for adding an order line
    public void addOrderLine(OrderLine orderLine) {
        this.orderLines.add(orderLine);
    }

    //Business logiv dfor processing payment
    public void processPayment() {
        this.status = OrderStatus.PAID;
    }

    // Other domain logic methods like cancelOrder, shipOrder, etc.

    //add Item
    public void addtem(Orderline orderLine){

        if(status != OrderStatus.NEW){

            throw new IllegalArgumentException("cannot modify order in current state items.");

        }
        this.orderLine.add(orderLine);
    }


    //processpayment

    public void processPayment(PaymentDetails paymentDetails){
        if(status != OrderStatus.NEW){
            throw new IllegalStateException("Payment can obnly be processed for new orders");
        }
        this.paymentDetails = paymentDetails;
        this.status = OrderStatus.PAID;
    }
}
