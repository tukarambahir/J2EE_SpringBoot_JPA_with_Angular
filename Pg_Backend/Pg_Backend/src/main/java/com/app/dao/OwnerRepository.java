package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Owner;;

public interface OwnerRepository extends JpaRepository<Owner, Integer> 
{
	public Owner findDistinctByEmail(String ownerEmail);
	
	public Owner findByEmailAndPassword(String ownerEmail, String pass);
	
	
}
