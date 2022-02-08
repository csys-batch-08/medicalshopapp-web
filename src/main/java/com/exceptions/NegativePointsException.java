package com.exceptions;

public class NegativePointsException extends Exception{

	static final String MESSAGE="Points in negative, You Can't Convert";
	
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
