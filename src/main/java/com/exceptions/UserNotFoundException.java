package com.exceptions;

public class UserNotFoundException extends Exception{
	
	static final String message="Invalid User Name or Password";
	
	@Override
	public String getMessage()
	{
		
		return message;
	}

	@Override
	public String toString() {
		return message;
	}
	
	

}
