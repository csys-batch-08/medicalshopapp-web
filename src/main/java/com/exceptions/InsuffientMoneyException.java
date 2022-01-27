package com.exceptions;

public class InsuffientMoneyException extends Exception{
	
	static final String message="Not enough Money In Wallet";
	
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
