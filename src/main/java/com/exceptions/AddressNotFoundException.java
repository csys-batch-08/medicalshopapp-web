package com.exceptions;

public class AddressNotFoundException extends Exception{
	
	
	static final String MESSAGE="Delivery Address Not Found,Please update your Address";
	
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
