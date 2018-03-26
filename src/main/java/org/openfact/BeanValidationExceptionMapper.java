package org.openfact;

import org.openfact.representations.idm.ConstraintErrorRepresentation;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.Map;
import java.util.stream.Collectors;

@Provider
public class BeanValidationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException exception) {
        final Map<String, String> errorResponse = exception.getConstraintViolations()
                .stream()
                .collect(Collectors.toMap(o -> o.getPropertyPath().toString(), ConstraintViolation::getMessage));
        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(new ConstraintErrorRepresentation("Invalid Request", errorResponse))
                .build();
    }

}
