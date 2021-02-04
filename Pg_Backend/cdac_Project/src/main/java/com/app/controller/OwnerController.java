package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Owner;
import com.app.service.IOwnerService;

@RestController
@RequestMapping("/owner")
@CrossOrigin
public class OwnerController 
{
	@Autowired
	private IOwnerService ownerService;
	
	public OwnerController() 
	{
		System.out.println("In Constr Of Owner Controller");
	}
	
	@PostMapping("/register")
	public String OwnerRegistration(@RequestBody Owner o)
	{
		ownerService.AddOwner(o);
		return "Owner Registered Successfully";
	}

	/*
	 * @PostMapping("/login") public Owner Login(@RequestBody Owner loginObj) {
	 * //Functionality nt completed Owner o =
	 * ownerService.login(loginObj.getEmail(), loginObj.getPassword()); if(o ==
	 * null) { return null; }
	 * 
	 * else return o; }
	 */
	@PostMapping("/login")
	public ResponseEntity<?> Login(@RequestBody Owner loginObj)
	{
		Owner owner = ownerService.login(loginObj.getEmail(), loginObj.getPassword());
		System.out.println(owner);
		return new ResponseEntity<>(owner, HttpStatus.OK);

	}
	
}
