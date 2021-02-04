package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Customer;
import com.app.pojos.Owner;

public interface CustomerRepository extends JpaRepository<Customer, Integer> 
{
	Optional<Customer> findByCustomerId(Integer id);

	public Customer findByEmailAndPassword(String ownerEmail, String pass);
	
}
