package org.openfact.core;

import org.openfact.core.representations.idm.ErrorRepresentation;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ErrorResponse {

    public static Response exists(String message) {
        return ErrorResponse.error(message, Response.Status.CONFLICT);
    }

    public static Response error(String message, Response.Status status) {
        ErrorRepresentation error = new ErrorRepresentation();
        error.setMessage(message);
        return Response.status(status).entity(error).type(MediaType.APPLICATION_JSON).build();
    }

}