package com.app.exceptions;

@SuppressWarnings("serial")
public class OwnerLoginFailed extends RuntimeException 
{
	public OwnerLoginFailed(String msg) 
	{
		super(msg);
	}
}
