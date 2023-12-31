package com.hotel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.entity.Customer;
import com.hotel.repository.CustomerRepository;
import com.hotel.repository.OrderRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository hotelRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public String addCustomer(Customer customer) {

		try {
			hotelRepository.save(customer);
			return "Record Added";
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Test");
		return null;
	}

	@Override
	public Customer getCustomer(int id) {
		
		try {
			Optional<Customer> customer = hotelRepository.findById(id);
			return customer.get();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void updateCustomer(Customer customer) {

		try {
			hotelRepository.save(customer);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Customer> getAllCustomers() {

		try {
			return hotelRepository.findAll();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public String deleteCustomer(int id) {

		try {
			
			Customer customer = hotelRepository.findById(id).get();
			orderRepository.deleteAllByCustomerId(customer);
			hotelRepository.deleteById(id);
			
			return "Customer Deleted";
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
