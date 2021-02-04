package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Pg;

public interface PgRepository extends JpaRepository<Pg, Integer> 
{
	
}
