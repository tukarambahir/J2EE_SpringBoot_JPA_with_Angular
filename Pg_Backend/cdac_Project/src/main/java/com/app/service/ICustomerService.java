package com.app.service;

import java.util.Optional;

import com.app.pojos.Customer;
import com.app.pojos.Owner;

public interface ICustomerService 
{
	public void AddCustomer(Customer c);
	
	public Optional<Customer> findCustomer(Integer id);

	public void UpdateCustomer(Customer c);
	
	public void DeleteCustomer(Integer id);
	
	public Customer login(String ownerEmail, String password);

}
