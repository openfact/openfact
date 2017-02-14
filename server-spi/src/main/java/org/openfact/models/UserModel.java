package org.openfact.models;

import java.util.Map;

public interface UserModel {

    String getUsername();

    String getFirstName();

    String getLastName();

    String getFullName();

    String getEmail();

    Map<String, Object> getAttributes();

    boolean hasRole(String role);

}
