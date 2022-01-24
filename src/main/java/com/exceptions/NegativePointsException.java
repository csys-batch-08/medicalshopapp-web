package com.exceptions;

public class NegativePointsException extends Exception{

	String message="Points in negative, You Can't Convert";
	
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
