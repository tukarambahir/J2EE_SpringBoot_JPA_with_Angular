package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.Booking;
import com.app.pojos.Customer;

public interface ICustomerService 
{
	public void AddCustomer(Customer c);
	
	public Optional<Customer> findCustomer(Integer id);

	public void UpdateCustomer(Customer c);
	
	public void DeleteCustomer(Integer id);

	public Customer CustomerLogin(String email, String password);
	
	public Customer getCustomer(Integer id);
	
	public List<Booking> GetAllBookings(Integer cId);
	
	public void CancelBooking(Integer book_id);
}
