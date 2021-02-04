package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Booking;
import com.app.service.IBookingService;

@RestController 
@RequestMapping("/booking")
@CrossOrigin
public class BookingController 
{
	@Autowired
	private IBookingService booking_Serv;
	
	@Autowired
	private PgController pgCont;
	
	@PostMapping("/add/{pg_id}/{cust_id}")
	public void MakeBooking(@RequestBody Booking b, @PathVariable Integer pg_id, @PathVariable Integer cust_id)
	{
		b.setConfirmationStatus("Confirm");
		System.out.println("Booking data received is " + b.getNoOfBookings());
		booking_Serv.CreateBooking(b, pg_id, cust_id);
	}
	
}
