package com.app.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Customer;

@Repository
public class CustomerDaoImpl implements ICustomerDao 
{

	@Autowired
	private EntityManager manager;
	
	@Autowired
	private CustomerRepository custRepo;
	
	public CustomerDaoImpl() {
	System.out.println("In Constr Of CustomerDaoImpl");
	}
	
	@Override
	public void RegisterCustomer(Customer c) 
	{
		System.out.println("In RegisterCustomer");
		manager.persist(c);
	}


	@Override
	public String UpdateCustomer(Customer C) 
	{
		System.out.println("In UpdateCustomer");
		manager.persist(C);
		return "Customer Updated Successfully";
	}

	@Override
	public String DeleteCustomer(int id) 
	{
		// TODO Auto-generated method stub
		return null;
	}

}
