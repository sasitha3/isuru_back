package org.pensions.md.exceptions.mappers;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.pensions.md.exceptions.MysqlException;
import org.pensions.md.model.dto.Message;

@Provider
public class MysqlExceptionMapper implements ExceptionMapper<MysqlException>{

	@Override
	public Response toResponse(MysqlException exception) {
		return Response
				.status(Status.INTERNAL_SERVER_ERROR)
				.entity(new Message(Status.INTERNAL_SERVER_ERROR.getStatusCode(),
						"An error occured in the database. please contact the administrator"
						))
				.build();
	}
		
}
