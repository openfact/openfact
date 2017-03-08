package org.openfact.services;

import org.openfact.models.OpenfactContext;
import org.openfact.models.OpenfactSession;

import java.util.HashMap;
import java.util.Map;

public class DefaultOpenfactSession implements OpenfactSession {

    private final Map<String, Object> attributes = new HashMap<>();
    private OpenfactContext context;

    public DefaultOpenfactSession() {
        context = new DefaultOpenfactContext();
    }

    @Override
    public OpenfactContext getContext() {
        return context;
    }

    @Override
    public Object getAttribute(String attribute) {
        return attributes.get(attribute);
    }

    @Override
    public Object removeAttribute(String attribute) {
        return attributes.remove(attribute);
    }

    @Override
    public void setAttribute(String name, Object value) {
        attributes.put(name, value);
    }

}
