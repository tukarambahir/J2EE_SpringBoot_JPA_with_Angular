package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.BookingRepository;
import com.app.dao.OwnerRepository;
import com.app.pojos.Booking;
import com.app.pojos.Owner;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController 
{
	@Autowired
	private OwnerRepository ORepo;
	
	@Autowired
	private BookingRepository BRepo;
	
	@GetMapping("/allOwners")
	public List<Owner> getAllowners()
	{
		return ORepo.findAll();
	}
	
	@GetMapping("/getallBookings")
	public List<Booking> getAllBookings()
	{
		return BRepo.findAll();
	}
}
