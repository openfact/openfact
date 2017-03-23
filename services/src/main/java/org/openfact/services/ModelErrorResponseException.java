package org.openfact.services;

import javax.ejb.ApplicationException;
import javax.ws.rs.core.Response;

@ApplicationException(rollback = true)
public class ModelErrorResponseException extends Exception {

    private Response.Status status;

    public ModelErrorResponseException(String message) {
        super(message);
        this.status = Response.Status.INTERNAL_SERVER_ERROR;
    }

    public ModelErrorResponseException(String message, Response.Status status) {
        super(message);
        this.status = status;
    }

    public Response.Status getStatus() {
        return status;
    }
}
