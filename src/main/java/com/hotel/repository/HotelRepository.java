package com.hotel.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hotel.entity.Customer;

@Repository
public interface HotelRepository extends CrudRepository<Customer, Integer> {

	public List<Customer> findAll();
}
