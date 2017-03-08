package org.openfact.models;

import javax.ejb.ApplicationException;
import javax.ws.rs.core.Response;

@ApplicationException(rollback = true)
public class ModelRollbackException extends Exception {

    private Response.Status status;

    public ModelRollbackException(String message) {
        super(message);
        this.status = Response.Status.INTERNAL_SERVER_ERROR;
    }

    public ModelRollbackException(String message, Response.Status status) {
        super(message);
        this.status = status;
    }

    public Response.Status getStatus() {
        return status;
    }
}
