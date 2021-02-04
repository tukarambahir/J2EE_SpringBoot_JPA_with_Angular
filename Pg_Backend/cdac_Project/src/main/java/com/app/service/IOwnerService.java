package com.app.service;

import java.util.Optional;

import com.app.pojos.Owner;

public interface IOwnerService 
{
	public void AddOwner(Owner o);
	
	public Owner findbyEmail(String ownerEmail);
	
	public Owner findOwner(int ownerId);

	
	public Owner login(String ownerEmail, String password);
}
