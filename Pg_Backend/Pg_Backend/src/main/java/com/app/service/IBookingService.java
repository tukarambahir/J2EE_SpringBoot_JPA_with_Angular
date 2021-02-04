package com.app.service;

import java.util.List;

import com.app.pojos.Booking;

public interface IBookingService 
{
	public void CreateBooking(Booking b, Integer pgId, Integer custId);

}
