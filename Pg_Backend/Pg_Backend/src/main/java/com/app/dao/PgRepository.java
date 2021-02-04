package com.app.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.app.pojos.Pg;

public interface PgRepository extends JpaRepository<Pg, Integer> 
{
	@CrossOrigin
	public Pg findByPgName(String name);
	
}
