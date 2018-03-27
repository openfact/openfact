package org.openfact.services.resolvers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

@Provider
public class ObjectMapperResolver implements ContextResolver<ObjectMapper> {

    protected ObjectMapper mapper = new ObjectMapper();

    public ObjectMapperResolver() {
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public ObjectMapperResolver(boolean indent) {
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        if (indent) {
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
        }
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        return mapper;
    }

}
