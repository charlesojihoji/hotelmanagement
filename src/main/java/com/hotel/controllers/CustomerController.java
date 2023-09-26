package com.hotel.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.entity.Customer;
import com.hotel.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	private static Logger log=Logger.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerService hotelService;
	
	@PostMapping
	public String addCustomer(@RequestBody Customer customer) {
		
		hotelService.addCustomer(customer);
		log.info("Customer added successfully");
		log.error("Some error message");
		log.warn("Some warning message");
		log.debug("Some debug message");
		
		System.out.println("Another test");
		return "Customer Added";
	}
	
	@GetMapping("/{id}")
	public Customer getCustomer(@PathVariable int id) {
		
		Customer customer = hotelService.getCustomer(id);
		
		return customer;
	}
	
	@GetMapping
	public List<Customer> getAllCustomers(){
		
		List<Customer> customers = hotelService.getAllCustomers();
		
		return customers;
	}
	
	@PutMapping
	public String updateCustomer(@RequestBody Customer customer) {
		
		hotelService.updateCustomer(customer);
		
		return "Customer Updated";
	}
	
}
