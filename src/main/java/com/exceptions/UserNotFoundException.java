package com.exceptions;

 	public class UserNotFoundException extends Exception{
		
	static final String MESSAGE="Invalid Mail Id or Password";
	
	@Override
	public String getMessage()
	{
		
		return MESSAGE;
	}

	@Override
	public String toString() {
		return MESSAGE;
	}
	
	

}
