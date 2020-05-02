package org.timur.sar.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.timur.sar.model.ErrorAccount;

@Provider
public class BadRequestExceptionMapper implements ExceptionMapper<BadRequestException>
{

	@Override
	public Response toResponse(BadRequestException exception) 
	{
		ErrorAccount errorAccount = new ErrorAccount(exception.getMessage(), 400, "");
		return Response.status(Status.BAD_REQUEST).entity(errorAccount).build();
	}

}
