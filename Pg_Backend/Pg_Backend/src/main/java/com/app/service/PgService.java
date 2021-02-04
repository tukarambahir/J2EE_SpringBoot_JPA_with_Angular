package com.app.service;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.PgRepository;
import com.app.exceptions.PgNotFoundException;
import com.app.pojos.Owner;
import com.app.pojos.Pg;

@Service 
@Transactional
public class PgService implements IPgService 
{
	@Autowired
	private PgRepository pgRepo;
	
	@Autowired
	private OwnerService Oservice;
	
	public PgService() 
	{
		System.out.println("In Constr Of PgService Class");
	}
	
	public void AddPg(Pg p, String OEmail)
	{
		Owner o = Oservice.findbyEmail(OEmail);
		p.setOwner(o);	// This method is also called in 	o.addPg(p)
		o.addPg(p);
		pgRepo.save(p);
	}

	@Override
	public void RemovePg(int pgId) 
	{
		Pg pgToRemove = pgRepo.getOne(pgId);
		System.out.println(pgToRemove.toString());
		pgToRemove.setOwner(null);
		pgRepo.delete(pgToRemove);
	}

	
	@Override
	public Pg GetPg(int id) 
	{
		Optional<Pg> optionalPg = pgRepo.findById(id);
		if (optionalPg.isPresent())
		{
			System.out.println(optionalPg.get());
			Pg p = optionalPg.get();
			return p;
		}
			
		else
		{
			throw new PgNotFoundException("Pg Not found");
		}
			
	}
	@Override
	public void UpdatePg(Pg p) 
	{
		pgRepo.save(p);
	}

	@Override
	public Pg SearchByName(String name) 
	{
		Pg p = pgRepo.findByPgName(name);
		if(p == null)
		{
			System.out.println("PG Search by name Failed in PgService");
			System.out.println("Searched Name Is : " + name + " In PgService");
			return null;
		}
		else 
			return p;
		
	}

	@Override
	public List<Pg> GetAllPg() 
	{
		return pgRepo.findAll();
	}

	@Override
	public Set<String> FindDistinctCity() 
	{
		int count = 0;
		List<Pg> p = this.GetAllPg();
		Set<String> s = new HashSet<>();
		for(Pg pg : p)
		{
			if(s.contains(pg.getCity()) || pg.getCity().equals(""))
				count++;
			else
				s.add(pg.getCity());
		}
//		for(String str : s)
//		{
//			System.out.println("City : " + str);
//		}
		return s;
	}

	@Override
	public List<Pg> FindPgByCity(String cityName) 
	{
		int count = 0;
		List<Pg> p = this.GetAllPg();
		List<Pg> PCity = new ArrayList<>();
		for(Pg pg : p)
		{
			if(pg.getCity().equals(cityName))
				PCity.add(pg);
			else
				count++;
		}
		
		for(Pg pp : PCity)
		{
			System.out.println("Pg By City: " + pp.getPgId());
		}
		
		return PCity;
	}


	
}
