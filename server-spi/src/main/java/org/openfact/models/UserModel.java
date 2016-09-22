package org.openfact.models;

import java.util.List;
import java.util.Map;

public interface UserModel {

    String getUsername();

    String getFullName();

    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);

    String getEmail();

    Map<String, List<String>> getAttributes();

}
