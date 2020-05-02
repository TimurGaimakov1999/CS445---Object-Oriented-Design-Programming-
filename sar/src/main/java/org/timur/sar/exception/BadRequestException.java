package org.timur.sar.exception;

public class BadRequestException extends RuntimeException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5484478818777627631L;
	
	
	public BadRequestException(String detail)
	{
		super(detail);
	}
}
