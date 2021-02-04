package com.app.dao;


import com.app.pojos.Customer;

public interface ICustomerDao 
{	
	public void RegisterCustomer(Customer c);
	
	public String UpdateCustomer(Customer C);
	
	public String DeleteCustomer (int id);
}
