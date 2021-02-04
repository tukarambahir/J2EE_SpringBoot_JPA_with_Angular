package com.app.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.PgRepository;
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
		p.setOwner(o);
		pgRepo.save(p);
	}

	@Override
	public void RemovePg(int pgId) 
	{
		Pg pgToRemove = pgRepo.getOne(pgId);
		System.out.println(pgToRemove.toString());
		pgRepo.delete(pgToRemove);
	}

	@Override
	public Pg GetPg(int id) 
	{
		Optional<Pg> optionalPg = pgRepo.findById(id);
		if (optionalPg.isPresent())
			return optionalPg.get();
		
		else
			System.out.println("Pg Not found");
			return null;
		
	}

	@Override
	public void UpdatePg(Pg p) 
	{
		pgRepo.save(p);
	}
	
}
