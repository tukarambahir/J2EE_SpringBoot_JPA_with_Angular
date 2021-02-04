package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.OwnerRepository;
import com.app.pojos.Customer;
import com.app.pojos.Owner;

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
			System.out.println("Owner By email not found");
			return null;
		}
	}

	@Override
	public Owner login(String ownerEmail, String password) 
	{
		System.out.println("In OwnerService -- Email : " + ownerEmail + "Password " + password);
		Owner o = ownerRepo.findByEmailAndPassword(ownerEmail, password);
		if(o != null)
			return o;
		else
		{
			System.out.println("Owner login failed");
			return null;
		}	}

	@Override
	public Owner findOwner(int ownerId) {
		return ownerRepo.findByOwnerId(ownerId);
	
		
	}
	
	
}
