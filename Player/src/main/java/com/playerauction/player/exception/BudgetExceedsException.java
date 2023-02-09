package com.playerauction.player.exception;

public class BudgetExceedsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BudgetExceedsException(String msg)
	{
		super(msg);
	}

}
