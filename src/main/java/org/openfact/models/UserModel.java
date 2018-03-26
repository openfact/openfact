package org.openfact.models;

import java.util.List;

public interface UserModel extends Model {

    String getUsername();

    String getIdentityId();

    String getIdentityProvider();

    String getEmail();

    void setEmail(String email);

    String getFullName();

    void setFullName(String fullName);

    List<CompanyModel> getOwnedCompanies();

    List<CompanyModel> getCollaboratedCompanies();

}
