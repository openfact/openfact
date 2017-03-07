package org.openfact.services;

import org.openfact.models.ModelRollbackException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class OpenfactExceptionMapper implements ExceptionMapper<ModelRollbackException> {

    @Override
    public Response toResponse(ModelRollbackException exception) {
        return ErrorResponse.error(exception.getMessage(), exception.getStatus());
    }

}
