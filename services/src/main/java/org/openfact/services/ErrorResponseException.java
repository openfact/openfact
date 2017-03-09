package org.openfact.services;

import org.openfact.representations.idm.OAuth2ErrorRepresentation;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ErrorResponseException extends WebApplicationException {

    private static final long serialVersionUID = 1L;

    private final String error;
    private final String errorDescription;
    private final Response.Status status;

    public ErrorResponseException(String error, String errorDescription, Response.Status status) {
        this.error = error;
        this.errorDescription = errorDescription;
        this.status = status;
    }

    @Override
    public Response getResponse() {
        OAuth2ErrorRepresentation errorRep = new OAuth2ErrorRepresentation(error, errorDescription);
        return Response.status(status).entity(errorRep).type(MediaType.APPLICATION_JSON_TYPE).build();
    }

}
