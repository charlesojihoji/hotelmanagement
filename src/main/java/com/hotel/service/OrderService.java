package com.hotel.service;

import java.util.List;

import com.hotel.entity.Order;

public interface OrderService {

	public String addOrder(Order order);

	public String updateOrder(Order order);

	public List<Order> getAllOrders();

	public Order getOrder(int id);

	public List<Order> getCustomerOrders(int id);

	public String deleteOrder(int id);

}
