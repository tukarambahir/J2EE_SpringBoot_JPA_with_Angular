package com.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/dummy")
public class DummyController 
{
	public DummyController() 
	{
		System.out.println("in ctor of dummy controller");
	}

	
	@GetMapping("/nums")
	public List<Integer> testMe() 
	{
		System.out.println("in test me");
		return Arrays.asList(1, 2, 3, 4, 5, 6);
	}

}