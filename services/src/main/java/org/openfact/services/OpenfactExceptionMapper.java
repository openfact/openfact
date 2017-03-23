package org.openfact.services;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class OpenfactExceptionMapper implements ExceptionMapper<ModelErrorResponseException> {

    @Override
    public Response toResponse(ModelErrorResponseException exception) {
        return ErrorResponse.error(exception.getMessage(), exception.getStatus());
    }

}
