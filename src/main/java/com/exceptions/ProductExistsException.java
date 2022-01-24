package com.exceptions;

public class ProductExistsException extends Exception{
	
	String message="Product Already exists";
	
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
