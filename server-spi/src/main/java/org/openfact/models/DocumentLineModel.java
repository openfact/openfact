package org.openfact.models;

import java.util.Map;

public interface DocumentLineModel {

    String getId();

    void setAttribute(String name, String value);

    void setAttribute(String name, Boolean value);

    void setAttribute(String name, Integer value);

    void setAttribute(String name, Long value);

    void removeAttribute(String name);

    String getAttribute(String name);

    Integer getAttribute(String name, Integer defaultValue);

    Long getAttribute(String name, Long defaultValue);

    Boolean getAttribute(String name, Boolean defaultValue);

    Map<String, String> getAttributes();

}
