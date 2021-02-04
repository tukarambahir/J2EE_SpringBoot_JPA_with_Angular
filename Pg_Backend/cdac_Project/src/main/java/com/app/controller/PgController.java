package com.app.controller;

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
import org.springframework.web.bind.annotation.CrossOrigin;

import com.app.pojos.Owner;
import com.app.pojos.Pg;
import com.app.service.OwnerService;
import com.app.service.PgService;

@RestController
@RequestMapping("/pg")
@CrossOrigin
public class PgController 
{
	@Autowired
	private PgService pgServ;
	@Autowired
	private OwnerService oServ;
	
	
	@PostMapping("/add/{O_email}")
	public String AddnewPg(@RequestBody Pg p, @PathVariable String O_email)
	{
		System.out.println("In Add Pg Controller" + p.toString());
		
		p.setAcAvail(p.getRoomCapacity() * p.getAcRooms());
		p.setNacAvail(p.getRoomCapacity() * p.getNacRooms()); 
		pgServ.AddPg(p, O_email);
		
		return "success";
	}
	
	@DeleteMapping("/delete/{PgId}")
	public void DeletePg(@PathVariable int PgId)
	{
		pgServ.RemovePg(PgId);
	}
	
	@GetMapping("/get/{gid}")
	public ResponseEntity<?> getPgDetails(@PathVariable int gid) {
		System.out.println("in get product dtls " + gid);
		try  
		{
			return ResponseEntity.ok(pgServ.GetPg(gid));
		} 
		catch (RuntimeException e)
		{
			System.out.println("err in controller " + e);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/gett/{pgId}")
	public ResponseEntity<?> getPgDetails1(@PathVariable int pgId) {
		System.out.println("in get product dtls " + pgId);
		try  
		{
			return ResponseEntity.ok(pgServ.GetPg(pgId));
		} 
		catch (RuntimeException e)
		{
			System.out.println("err in controller " + e);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	

	@GetMapping("/{O_id}")
	public ResponseEntity<?> getallpg(@PathVariable int O_id) {
		System.out.println("in get product dtls " + O_id);
		try 
		{
			Owner o=(oServ.findOwner(O_id));
			return ResponseEntity.ok(o.getPglist());
		} 
		catch (RuntimeException e)
		{
			System.out.println("err in controller " + e);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	
	@PutMapping("/update")
	public void UpdatePg(@RequestBody Pg p)
	{
		Pg oldPg = pgServ.GetPg(p.getPgId());
		p.setAcAvail(oldPg.getAcAvail());
		p.setNacAvail(oldPg.getNacAvail());
		System.out.println("In Update Pg Controller" + p.toString());
		pgServ.UpdatePg(p);
	}
	
	//Method for olny updating Rooms
	
	@PutMapping("/updateRooms/{pgid}/{acroom}/{nacroom}")
	public void UpdateRooms(@PathVariable int pgid, @PathVariable int acroom, @PathVariable int nacroom)
	{
		Pg currentPg = pgServ.GetPg(pgid);
		currentPg.setAcRooms(acroom);
		currentPg.setNacRooms(nacroom);
		currentPg.setAcAvail(currentPg.getRoomCapacity() * acroom);
		currentPg.setNacAvail(currentPg.getRoomCapacity() * nacroom);
		pgServ.UpdatePg(currentPg);
	}
}
