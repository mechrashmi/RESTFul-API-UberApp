package org.rashmi.Hive.UberApp.exceptions.mappers;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.rashmi.Hive.UberApp.exceptions.CabNotFoundException;
import org.rashmi.Hive.UberApp.models.impl.ErrorModel;


@Provider
public class CabNotFoundExceptionMapper implements ExceptionMapper<CabNotFoundException> {

	@Override
	public Response toResponse(CabNotFoundException exception) {
		ErrorModel err = new ErrorModel(exception.getMessage(), Status.NOT_FOUND.getStatusCode(), "Please try again!!");
		return Response.status(Status.NOT_FOUND).entity(err).build();
	}

}
