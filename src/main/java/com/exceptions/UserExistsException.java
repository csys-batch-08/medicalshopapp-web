package com.exceptions;

public class UserExistsException extends Exception{
	
	static final String message="This User Already Registered";
	
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
