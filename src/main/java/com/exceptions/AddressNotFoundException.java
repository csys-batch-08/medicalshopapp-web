package com.exceptions;

public class AddressNotFoundException extends Exception{
	
	
	static final String message="Delivery Address Not Found,Please update your Address";
	
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
