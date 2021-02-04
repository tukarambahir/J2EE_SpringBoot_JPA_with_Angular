package com.app.service;

import java.util.List;

import com.app.pojos.Owner;
import com.app.pojos.Pg;

public interface IOwnerService 
{
	public void AddOwner(Owner o);
	
	public Owner findbyEmail(String ownerEmail);
	
	public Owner login(String ownerEmail, String password);
	
	public Pg searchPgByName(String name);
	
	public List<Pg> GetPgList(Integer id);
	
}
