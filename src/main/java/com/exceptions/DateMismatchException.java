package com.exceptions;

public class DateMismatchException extends Exception{

	static final String message="From Date Not Earlier Than To date";
	
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
