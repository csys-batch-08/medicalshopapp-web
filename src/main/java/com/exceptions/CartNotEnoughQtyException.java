package com.exceptions;

public class CartNotEnoughQtyException extends Exception{
	
	static final String message="Currently The Available Quantity Is Lesser Than You Choosed ! Try After Sometime";
	
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
