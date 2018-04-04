package org.openfact.core.models;

import java.util.Optional;

public interface OrganizationProvider {

    OrganizationModel addCompany(String name, UserModel owner);

    Optional<OrganizationModel> getCompany(String id);

}
