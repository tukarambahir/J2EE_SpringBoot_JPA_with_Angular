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

import com.app.pojos.Owner;
import com.app.pojos.Pg;
import com.app.service.IOwnerService;


@RestController 
@CrossOrigin
@RequestMapping("/owner")

public class OwnerController 
{
	@Autowired
	private IOwnerService ownerService;
	
	public OwnerController() 
	{
		System.out.println("In Constr Of Owner Controller");
	}
	
	@PostMapping("/register")
	public int OwnerRegistration(@RequestBody Owner o)
	{
		ownerService.AddOwner(o);
		return 1;
	}
	
	@PostMapping("/login")
	public Owner Login(@RequestBody Owner loginObj)
	{
		//Functionality nt completed
		Owner o = ownerService.login(loginObj.getEmail(), loginObj.getPassword());
		return o;
	}
//	
//	@PostMapping("/login") 
//	public ResponseEntity<?> Login(@RequestBody Owner loginObj) 
//	{ 
//		Owner owner = ownerService.login(loginObj.getEmail(), loginObj.getPassword()); 
//		System.out.println(owner); 
//		return new ResponseEntity<>(owner, HttpStatus.OK); } 
	
	@PostMapping("/searchByName")
	public Pg searchByName(@RequestBody String name)
	{
		System.out.println("Searched Name Is : " + name + " In OwnerController");
		return ownerService.searchPgByName(name);
	}
	
	@GetMapping("/show/pglist/{Oid}")
	public List<Pg> ShowPgList(@PathVariable Integer Oid)
	{
		return ownerService.GetPgList(Oid);
	}
	
	
	//Search pg according to name

	//View all bookings in his pg
	// see the revenue collected from particular pg
}
