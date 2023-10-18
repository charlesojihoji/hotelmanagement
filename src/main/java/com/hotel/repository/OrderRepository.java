package com.hotel.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.hotel.entity.Customer;
import com.hotel.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Integer>{

	public List<Order> findAll();

	public List<Order> findByCustomerId(Customer customer);
	
	@Transactional
	public void deleteAllByCustomerId(Customer customer);
}
