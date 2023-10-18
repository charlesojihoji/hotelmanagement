package com.hotel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hotel.entity.Customer;


public interface CustomerService {

	public String addCustomer(Customer customer);

	public Customer getCustomer(int id);

	public void updateCustomer(Customer customer);

	public List<Customer> getAllCustomers();

	public String deleteCustomer(int id);
}
