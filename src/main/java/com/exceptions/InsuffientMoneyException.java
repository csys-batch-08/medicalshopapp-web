package com.exceptions;

public class InsuffientMoneyException extends Exception{
	
	static final String MESSAGE="Not enough Money In Wallet";
	
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
