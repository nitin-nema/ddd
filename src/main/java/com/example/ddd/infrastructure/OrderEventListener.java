package com.example.ddd.infrastructure;

import com.example.ddd.domain.OrderPlacedEvent;
import org.apache.logging.log4j.message.SimpleMessage;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class OrderEventListener {

    @EventListener
    public void handleOrderPlaced(OrderPlacedEvent event) {
        // Handle the event, e.g., send email, notify shipping service, etc.
        System.out.println("Order placed with ID: " + event.getOrderId() + ", for customer: " + event.getCustomerId());
    }

    // sending the confirmation email

    private void sendConfirmationEamil(String customerId, String orderId){
        SimpleMailMessage message = new SimpleMaiMessage();
        message.setTo("customer@example.com");
        message.setSubject("Order Confitmation");
        message.setText("Your order has been placed eithb " + orderId);

        mailSender.send(message);
        System.out.println("Order Confirmation with ID: " + orderId);

    }
}
