package com.exceptions;

 	final class UserNotFoundException extends Exception{
	
	/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
	static final String message="Invalid User Name or Password";
	
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
