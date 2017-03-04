package org.openfact.models;

public interface OpenfactSession {

    OpenfactContext getContext();

    Object getAttribute(String attribute);
    Object removeAttribute(String attribute);
    void setAttribute(String name, Object value);

}
