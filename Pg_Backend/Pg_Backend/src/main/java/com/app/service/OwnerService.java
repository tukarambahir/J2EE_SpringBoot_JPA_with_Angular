package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.OwnerRepository;
import com.app.exceptions.OwnerByEmailNotFoundException;
import com.app.exceptions.OwnerLoginFailed;
import com.app.pojos.Owner;
import com.app.pojos.Pg;

@Service 
@Transactional
public class OwnerService implements IOwnerService
{
	public OwnerService() 
	{
		System.out.println("In Constr Of OwnerService");
	}
	
	@Autowired
	private OwnerRepository ownerRepo;
	
	@Autowired
	private PgService pgServ;
	
	public void AddOwner(Owner o)
	{
		ownerRepo.save(o);
	}

	@Override
	public Owner findbyEmail(String ownerEmail) 
	{
		Owner o = ownerRepo.findDistinctByEmail(ownerEmail);
		if(o != null)
			return o;
		else
		{
			throw new OwnerByEmailNotFoundException("Owner By email not found");
		}
	}

	@Override
	public Owner login(String ownerEmail, String password) 
	{
		System.out.println("In OwnerService -- Email : " + ownerEmail + "Password " + password);
		Owner o = ownerRepo.findByEmailAndPassword(ownerEmail, password);
		if(o == null)
		{
			throw new OwnerLoginFailed("invalid Login Credentials");
		}
			
		else
		{
			return o;
		}	
	}

	@Override
	public Pg searchPgByName(String name) 
	{
		Pg p = pgServ.SearchByName(name);
		if(p != null)
			return p;
		else
		{
			System.out.println("Pg search by name failed in OwnerService");
			System.out.println("Searched Name Is : " + name + " In OwnerService");
			return null;
		}
	}

	@Override
	public List<Pg> GetPgList(Integer id) 
	{
		Optional<Owner> o = ownerRepo.findById(id);
		Owner o1 = o.get();
		return o1.getPglist();
	}
	

	
	
}
