package com.exceptions;

public class AddressNotFoundException extends Exception{
	
	
	String message="Address Not Found,Please update your Delivery Address";
	
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
