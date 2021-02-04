package com.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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

import com.app.dao.OwnerRepository;
import com.app.pojos.Booking;
import com.app.pojos.Owner;
import com.app.pojos.Pg;
import com.app.service.PgService;

@RestController
@RequestMapping("/pg")
@CrossOrigin
public class PgController 
{
	@Autowired
	private PgService pgServ;
	
	@Autowired
	private OwnerRepository oRepo;
	
	@PostMapping("/add/{O_email}")
	public int AddnewPg(@RequestBody Pg p, @PathVariable String O_email)
	{
		System.out.println("In Add Pg Controller" + p.toString());
		
		p.setAcAvail(p.getRoomCapacity() * p.getAcRooms());
		p.setNacAvail(p.getRoomCapacity() * p.getNacRooms()); 
		pgServ.AddPg(p, O_email);
		return 1;
	}
	
	@GetMapping("/getall")
	public List<Pg> GetAllPg()
	{
		List<Pg> allPg = pgServ.GetAllPg();
		List<Pg> realPg = new ArrayList<>();
		for(Pg p : allPg)
		{
			if(p.getOwner() != null && p.getAcAvail() > 0 && p.getNacAvail() > 0)
				realPg.add(p);
		}
		return realPg;
	}
	
	@GetMapping("/getcities")
	public Set<String> getCities()
	{
		return pgServ.FindDistinctCity();
	}
	
	@DeleteMapping("/delete/{PgId}")
	public int DeletePg(@PathVariable int PgId)
	{
		pgServ.RemovePg(PgId);
		return 1;	// Changed
	}
	
	
	@GetMapping("/get/{gid}")		// Updated Code
	public Pg getPgDetails(@PathVariable int gid) 
	{
		System.out.println("in get product dtls " + gid);
		Pg p = pgServ.GetPg(gid);
		if(p !=null)
			return p;
		else
		{
			System.out.println("Pg Is NULL");
			return null;
		}
			
	}
	
	
	// THIS IS USED FOR SEARCHING PG WIH CITY NAME
	@GetMapping("/findByName/{cityName}")
	public List<Pg> GetPgByCity(@PathVariable String cityName)
	{
		return pgServ.FindPgByCity(cityName);
	}
	
	//THIS IS USED FOR CALCULATING TOTAL BUSINESS OF OWNER
	
	@GetMapping("/getOwnerBusiness/{OwnerId}")
	public List<Pg> CalculateBusiness(@PathVariable Integer OwnerId)
	{
		Optional<Owner> o = oRepo.findById(OwnerId);
		int sum = 0;
		int custNo = 0;
		Owner oo = o.get();
		int owner = oo.getOwnerId();
		List<Pg> allPgOfOwner = oo.getPglist();
		for(Pg p : allPgOfOwner)
		{
			sum = 0;
			custNo = 0;
			//System.out.println("No of bookings in PgId " + p.getPgId() +" are " +  p.getAllbookings().size() + "whose Owner Id Is " + oo.getOwnerId());
			for(Booking b : p.getAllbookings())
			{
				sum = sum + (b.getNoOfBookings() * p.getPgRent());
				custNo = custNo + b.getNoOfBookings();
			}
			System.out.println("Total Business Of PG with PgId " + p.getPgId() + " is " + sum);
			p.setNoOfCustomers(custNo);
			p.setTotalBusiness(sum);
			pgServ.UpdatePg(p);
		}
		
		return allPgOfOwner;
	}
	
	
	@PutMapping("/update")
	public int UpdatePg(@RequestBody Pg p)
	{
		Pg oldPg = pgServ.GetPg(p.getPgId());
		p.setAcAvail(oldPg.getAcAvail());
		p.setNacAvail(oldPg.getNacAvail());
		System.out.println("In Update Pg Controller" + p.toString());
		pgServ.UpdatePg(p);
		return 1;
	}
	
	// This method is Used in ANGULAR To Update PG
	@PutMapping("/updateAll/{oid}")
	public int UpdateFullPg(@RequestBody Pg p, @PathVariable Integer oid )
	{
		Optional<Owner> o = oRepo.findById(oid);
		Owner o1 = o.get();
		p.setAcAvail(p.getAcRooms() * p.getRoomCapacity());
		p.setNacAvail(p.getNacRooms() * p.getRoomCapacity());
		p.setCountry("India");
		p.setOwner(o1);
		pgServ.UpdatePg(p);
		return 1;
	}
	
	//Method for only updating Rooms
	
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
