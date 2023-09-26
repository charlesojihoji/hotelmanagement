package com.hotel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.entity.Order;
import com.hotel.repository.OrderRepository;
import com.hotel.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping
	public String addOrder(@RequestBody Order order) {
		
		orderService.addOrder(order);
		
		return "Order Added";
	}
	
	@PutMapping
	public String updateOrder(@RequestBody Order order) {
		
		orderService.updateOrder(order);
		
		return "Order Updated";
	}
	
	@GetMapping
	public List<Order> getAllOrders() {
		
		List<Order> orders = orderService.getAllOrders();
		
		return orders;
	}
	
	@GetMapping("/{id}")
	public Order getOrder(@PathVariable int id) {
		
		Order order = orderService.getOrder(id);
		
		return order;
		
	}
	
	@GetMapping("/customer-orders/{id}")
	public List<Order> getCustomerOrders(@PathVariable int id){
		
		List<Order> orders = orderService.getCustomerOrders(id);
		
		return orders;
	}
}
