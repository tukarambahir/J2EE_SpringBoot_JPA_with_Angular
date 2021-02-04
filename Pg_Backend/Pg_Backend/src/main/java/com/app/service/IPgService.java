package com.app.service;


import java.util.List;
import java.util.Set;

import com.app.pojos.Pg;

public interface IPgService 
{
	void AddPg(Pg p, String OEmail);
	
	void RemovePg(int pgId);
	
	Pg GetPg(int id);
	
	void UpdatePg(Pg p);
	
	Pg SearchByName(String name);
	
	public List<Pg> GetAllPg();
	
	public Set<String> FindDistinctCity(); 
	
	public List<Pg> FindPgByCity(String cityName); 
}
