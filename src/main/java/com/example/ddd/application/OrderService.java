package com.example.ddd.application;

import com.example.ddd.domain.Order;
import com.example.ddd.domain.OrderPlacedEvent;
import com.example.ddd.domain.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
// Spring comonent used to publish events within the applciation context
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Transactional
    public Order placeOrder(Order order) {
        // Save order to repository (aggregate)
        Order savedOrder = orderRepository.save(order);

        // Publish domain event
        eventPublisher.publishEvent(new OrderPlacedEvent(savedOrder.getId(), savedOrder.getCustomerId()));

        return savedOrder;
    }

    // Other business logic like processing payment, canceling, etc.
}
