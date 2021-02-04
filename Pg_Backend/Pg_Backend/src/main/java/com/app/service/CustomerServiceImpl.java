package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.BookingRepository;
import com.app.dao.CustomerRepository;
import com.app.exceptions.CustomerNotFoundException;
import com.app.pojos.Booking;
import com.app.pojos.Customer;
import com.app.pojos.Pg;

@Service 
@Transactional
public class CustomerServiceImpl implements ICustomerService
{
	
	
	@Autowired
	private CustomerRepository cust_repo;
	
	@Autowired
	private BookingRepository book_repo;
	
	@Autowired
	private PgService pg_Serv;
	
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
	public Customer CustomerLogin(String email, String password) 
	{
		Customer c = cust_repo.findByEmailAndPassword(email, password);
		if(c == null)
			throw new CustomerNotFoundException("Customer Not Found");
		else
		return c;
	}

	@Override
	public Customer getCustomer(Integer id)
	{
		return cust_repo.getOne(id);
	}

	@Override
	public List<Booking> GetAllBookings(Integer cId) 
	{
		Optional<Customer> c_hist = cust_repo.findByCustomerId(cId);
		Customer c = c_hist.get();
		return c.getBookings();
	}

	@Override
	public void CancelBooking(Integer book_id) 
	{
		Optional<Booking> b = book_repo.findById(book_id);
		Booking bookingToDelete = b.get();
		
		Customer c = bookingToDelete.getCust();
		c.removeBooking(bookingToDelete);
		
		Pg p = pg_Serv.GetPg(bookingToDelete.getBookedPg().getPgId());
		int NoOfBookings = bookingToDelete.getNoOfBookings();
		
		if(bookingToDelete.getRoomType().equals("AC"))
		{
			p.setAcAvail(p.getAcAvail() + NoOfBookings);
			p.setAcRooms(p.getAcAvail()/p.getRoomCapacity());
		}
		
		if(bookingToDelete.getRoomType().equals("NON-AC"))
		{
			p.setNacAvail(p.getNacAvail() + NoOfBookings);
			p.setNacRooms(p.getNacAvail()/p.getRoomCapacity());
		}
		book_repo.delete(bookingToDelete);
	}
	
}
