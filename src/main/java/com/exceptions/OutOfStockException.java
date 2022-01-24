package com.exceptions;

public class OutOfStockException extends Exception{
	
String message="Currently the product is out of stock !";
	
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
