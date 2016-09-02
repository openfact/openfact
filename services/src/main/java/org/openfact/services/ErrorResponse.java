package org.openfact.services;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.openfact.representations.idm.ErrorRepresentation;
import org.openfact.representations.idm.OAuth2ErrorRepresentation;

public class ErrorResponse extends WebApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String error;
	private final String errorDescription;
	private final Response.Status status;

	public ErrorResponse(String error, String errorDescription, Response.Status status) {
		this.error = error;
		this.errorDescription = errorDescription;
		this.status = status;
	}

	@Override
	public Response getResponse() {
		OAuth2ErrorRepresentation errorRep = new OAuth2ErrorRepresentation(error, errorDescription);
		return Response.status(status).entity(errorRep).type(MediaType.APPLICATION_JSON_TYPE).build();
	}

	public static Response exists(String message) {
		return ErrorResponse.error(message, Response.Status.CONFLICT);
	}

	public static Response error(String message, Response.Status status) {
		ErrorRepresentation error = new ErrorRepresentation();
		error.setErrorMessage(message);
		return Response.status(status).entity(error).type(MediaType.APPLICATION_JSON).build();
	}

}
