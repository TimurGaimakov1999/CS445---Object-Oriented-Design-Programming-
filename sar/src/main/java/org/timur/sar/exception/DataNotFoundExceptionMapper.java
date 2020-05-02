package org.timur.sar.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.timur.sar.model.ErrorAccount;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>
{

	@Override
	public Response toResponse(DataNotFoundException exception) 
	{
		ErrorAccount errorAccount = new ErrorAccount(exception.getMessage(), 404, "");
		return Response.status(Status.NOT_FOUND).entity(errorAccount).build();
	}
}
