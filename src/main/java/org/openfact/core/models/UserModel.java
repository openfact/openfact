package org.openfact.core.models;

import java.util.List;

public interface UserModel extends Model {

    String getUsername();

    String getIdentityId();

    String getIdentityProvider();

    String getEmail();

    void setEmail(String email);

    String getFullName();

    void setFullName(String fullName);

    List<OrganizationModel> getOwnedCompanies();

    List<OrganizationModel> getCollaboratedCompanies();

}
