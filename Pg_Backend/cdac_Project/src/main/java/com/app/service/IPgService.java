package com.app.service;


import com.app.pojos.Pg;

public interface IPgService 
{
	void AddPg(Pg p, String OEmail);
	
	void RemovePg(int pgId);
	
	Pg GetPg(int id);
	
	void UpdatePg(Pg p);
	
	
}
