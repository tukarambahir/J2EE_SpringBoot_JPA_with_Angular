package com.app.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Booking;
import com.app.pojos.Customer;
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
		c.setGender("Male");
		c.setDob(LocalDate.of(1997,06,07));
		custService.AddCustomer(c);																																																								
		System.out.println("Customer Registered Successfully");
	}
																															
	@GetMapping("/get/{pid}")
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
	
	@PostMapping("/login")
	public Customer CustomerLogin(@RequestBody Customer c)
	{
		Customer loggedCust = custService.CustomerLogin(c.getEmail(), c.getPassword());
		return loggedCust;
	}
	
	@GetMapping("/getAllBokings/{custId}")
	public List<Booking> GetAllBookings(@PathVariable Integer custId)
	{
		return custService.GetAllBookings(custId);
	}
	
	@DeleteMapping("/delete/booking/{delete_id}")
	public void DeleteBooking(@PathVariable Integer delete_id)
	{
		custService.CancelBooking(delete_id);
	}
}
