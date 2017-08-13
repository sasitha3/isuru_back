package org.pensions.md.exceptions.mappers;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.pensions.md.exceptions.UserNotFoundException;
import org.pensions.md.model.dto.Message;

@Provider
public class UserNotFoundExceptionMapper implements ExceptionMapper<UserNotFoundException>{

	@Override
	public Response toResponse(UserNotFoundException exception) {
		return Response
				.status(Status.NOT_FOUND)
				.entity(new Message(Status.NOT_FOUND.getStatusCode(), exception.getMessage()))
				.type(MediaType.APPLICATION_JSON)
				.build();
	}

}
