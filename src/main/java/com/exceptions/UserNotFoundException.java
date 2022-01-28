package com.exceptions;

 	public class UserNotFoundException extends Exception{
		
	static final String message="Invalid Mail Id or Password";
	
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
