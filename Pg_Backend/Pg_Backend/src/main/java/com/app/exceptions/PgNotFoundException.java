package com.app.exceptions;

@SuppressWarnings("serial")
public class PgNotFoundException extends RuntimeException
{
	public PgNotFoundException(String msg)
	{
		super(msg);
	}
}
