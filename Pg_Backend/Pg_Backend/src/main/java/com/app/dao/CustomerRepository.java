package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> 
{
	public Optional<Customer> findByCustomerId(Integer id);
	
	public Customer findByEmailAndPassword(String custEmail, String custPass);
}
