package org.timur.sar.exception;

public class DataNotFoundException extends RuntimeException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9016030877875404865L;
	
	
	public DataNotFoundException(String detail)
	{
		super(detail);
	}
}
