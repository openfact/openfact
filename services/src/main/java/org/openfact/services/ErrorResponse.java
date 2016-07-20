package org.openfact.services;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.openfact.representations.idm.ErrorRepresentation;

public class ErrorResponse {

	public static Response exists(String message) {
		return ErrorResponse.error(message, Response.Status.CONFLICT);
	}

	public static Response error(String message, Response.Status status) {
		ErrorRepresentation error = new ErrorRepresentation();
		error.setErrorMessage(message);
		return Response.status(status).entity(error).type(MediaType.APPLICATION_JSON).build();
	}

}
