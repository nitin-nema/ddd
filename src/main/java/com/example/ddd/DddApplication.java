
package com.example.ddd;

import com.example.ddd.application.OrderService;
import com.example.ddd.domain.Order;
import com.example.ddd.domain.OrderLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DddApplication implements CommandLineRunner {

	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(DddApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Create new order and place it
		Order order = new Order("1", "customer1");
		order.addOrderLine(new OrderLine("product1", 2));
		order.addOrderLine(new OrderLine("product2", 1));

		// Place order
		orderService.placeOrder(order);
	}
}

