package org.openfact.core.models;

public interface UserModel extends Model {

    String getUsername();

    String getIdentityId();

    String getIdentityProvider();

    String getEmail();

    void setEmail(String email);

    String getFullName();

    void setFullName(String fullName);

}
