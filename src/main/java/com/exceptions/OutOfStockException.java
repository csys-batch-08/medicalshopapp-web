package com.exceptions;

public class OutOfStockException extends Exception{
	
	static final String MESSAGE="Currently the product is out of stock !";
	
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
