package org.pensions.md.exceptions.mappers;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.pensions.md.exceptions.UnAuthorizedException;
import org.pensions.md.model.dto.Message;

@Provider
public class UnAuthorizedExceptionMapper implements ExceptionMapper<UnAuthorizedException>{

	@Override
	public Response toResponse(UnAuthorizedException exception) {
		return Response
				.status(Status.UNAUTHORIZED)
				.entity(new Message(Status.UNAUTHORIZED.getStatusCode(), exception.getMessage()))
				.type(MediaType.APPLICATION_JSON)
				.build();
	}

}
