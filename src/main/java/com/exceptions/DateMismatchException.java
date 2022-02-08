package com.exceptions;

public class DateMismatchException extends Exception{

	static final String MESSAGE="From Date Not Earlier Than To date";
	
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
