package com.app.exceptions;

@SuppressWarnings("serial")
public class OwnerByEmailNotFoundException extends RuntimeException 
{
	public OwnerByEmailNotFoundException(String msg) 
	{
		super(msg);
	}
}
