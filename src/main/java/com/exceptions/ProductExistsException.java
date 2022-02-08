package com.exceptions;

public class ProductExistsException extends Exception{
	
	static final String MESSAGE="This Product Already Exists";
	
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
