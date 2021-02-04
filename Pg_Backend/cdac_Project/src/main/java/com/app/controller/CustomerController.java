package com.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Customer;
import com.app.pojos.Owner;
import com.app.service.ICustomerService;

@RestController 
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController 
{
	@Autowired
	private ICustomerService custService;
	
	public CustomerController() 
	{
		
		System.out.println("In Default Constructor Of CustomerController");
		
	}
	
	@PostMapping("/register")
	public void registerNewCustomer(@RequestBody Customer c)
	{
		System.out.println("in Register new Customer " + c);
		custService.AddCustomer(c);
		System.out.println("Customer Registered Successfully");
	}
	@RequestMapping("/login")
	public ResponseEntity<?> Login(@RequestBody Customer loginObj)
	{
		Customer customer = custService.login(loginObj.getEmail(), loginObj.getPassword());
		System.out.println(customer);
		return new ResponseEntity<>(customer, HttpStatus.OK);

	}
	
	
	@GetMapping("/{pid}")
	public Optional<Customer> getCustomerDetails(@PathVariable Integer pid) 
	{
		System.out.println("in getCustomerDetails " + pid);
		
		if(custService.findCustomer(pid).isPresent())	
			return custService.findCustomer(pid);
		else
		return null;
	}
	
	@PutMapping("/update")
	public void UpdateOldCustomer(@RequestBody Customer c) 
	{
		System.out.println("in Update old Customer " + c);
		custService.UpdateCustomer(c);
		System.out.println("Customer Updated Successfully");
	}
	
	@DeleteMapping("/delete/{did}")
	public void DeleteCustomer(@PathVariable Integer did)
	{
		custService.DeleteCustomer(did);
	}
}
