package com.app.exceptions;

@SuppressWarnings("serial")
public class EmptyPgListException extends RuntimeException 
{
	public EmptyPgListException(String msg) 
	{
		super(msg);
	}
}
