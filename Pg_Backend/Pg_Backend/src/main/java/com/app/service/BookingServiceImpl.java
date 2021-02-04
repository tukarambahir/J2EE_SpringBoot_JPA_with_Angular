package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.BookingRepository;
import com.app.dao.CustomerRepository;
import com.app.pojos.Booking;
import com.app.pojos.Customer;
import com.app.pojos.Pg;

@Service 
@Transactional
public class BookingServiceImpl implements IBookingService 
{	
	@Autowired
	private BookingRepository booking_repo;
	
	@Autowired
	private ICustomerService cust_serv;
	
	@Autowired
	private IPgService pg_serv;
	
	@Autowired
	private CustomerRepository cust_repo;
	

	public BookingServiceImpl() 
	{
		System.out.println("In Constr Of BookingServiceImpl");
	}

	@Override
	public void CreateBooking(Booking b, Integer pgId, Integer custId) 
	{
		Pg pgForBooking = pg_serv.GetPg(pgId);
		if(b.getRoomType().equals("AC"))
		{
			pgForBooking.setAcAvail(pgForBooking.getAcAvail() - b.getNoOfBookings());
			int rooms = (int)Math.ceil(pgForBooking.getAcAvail()/pgForBooking.getRoomCapacity());
			pgForBooking.setAcRooms(rooms);
		}
		
		if(b.getRoomType().equals("NON-AC"))
		{
			pgForBooking.setNacAvail(pgForBooking.getNacAvail() - b.getNoOfBookings());
			int nacrooms = (int)Math.ceil(pgForBooking.getNacAvail()/pgForBooking.getRoomCapacity());
			pgForBooking.setAcRooms(nacrooms);
		}
		pg_serv.UpdatePg(pgForBooking);
		b.setBookedPg(pgForBooking);
		
		//---------------
		
		booking_repo.save(b);
		
		//---------------
		
		Optional<Customer> c = cust_repo.findById(custId);
		Customer c1 = c.get();
		c1.addBooking(b);
		cust_serv.UpdateCustomer(c1);
		
	}


	
	
}
