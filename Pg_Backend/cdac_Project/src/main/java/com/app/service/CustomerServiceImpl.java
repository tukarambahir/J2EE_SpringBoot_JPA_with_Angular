package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CustomerRepository;
import com.app.dao.ICustomerDao;
import com.app.pojos.Customer;
import com.app.pojos.Owner;

@Service 
@Transactional
public class CustomerServiceImpl implements ICustomerService
{
	
	
	@Autowired
	private CustomerRepository cust_repo;
	

	
	@Override
	public void AddCustomer(Customer c) 
	{
		cust_repo.save(c);
	}

	@Override
	public Optional<Customer> findCustomer(Integer id) 
	{
		return cust_repo.findByCustomerId(id);
	}

	@Override
	public void UpdateCustomer(Customer c) 
	{
		cust_repo.save(c);
	}

	@Override
	public void DeleteCustomer(Integer id) 
	{
		Customer custToDelete = cust_repo.getOne(id);
		cust_repo.delete(custToDelete);
	}

	@Override
	public Customer login(String ownerEmail, String password) {
		System.out.println("In OwnerService -- Email : " + ownerEmail + "Password " + password);
		Customer o = cust_repo.findByEmailAndPassword(ownerEmail, password);
		if(o != null)
			return o;
		else
		{
			System.out.println("Owner login failed");
			return null;
		}
	}
	
}
