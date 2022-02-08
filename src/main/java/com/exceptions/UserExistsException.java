package com.exceptions;

public class UserExistsException extends Exception{
	
	static final String MESSAGE="This User Already Registered";
	
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
