package com.exceptions;

public class CartNotEnoughQtyException extends Exception{
	
	static final String MESSAGE="Currently The Available Quantity Is Lesser Than You Choosed ! Try After Sometime";
	
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
