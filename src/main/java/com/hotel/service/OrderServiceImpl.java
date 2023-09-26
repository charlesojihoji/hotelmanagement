package com.hotel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.entity.Customer;
import com.hotel.entity.Order;
import com.hotel.repository.CustomerRepository;
import com.hotel.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public String addOrder(Order order) {

		try {
			orderRepository.save(order);
			return "Order Added";
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public String updateOrder(Order order) {

		try {
			orderRepository.save(order);
			return "Order Updated";
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Order> getAllOrders() {

		try {
			List<Order> orders = orderRepository.findAll();
			return orders;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Order getOrder(int id) {

		try {
			Optional<Order> order = orderRepository.findById(id);
			
			return order.get();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Order> getCustomerOrders(int id) {

		try {
			Customer customer = customerRepository.findById(id).get();
			List<Order> orders = orderRepository.findByCustomerId(customer);
			return orders;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
