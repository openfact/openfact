package org.openfact.core.models;

import java.util.Optional;

public interface OrganizationProvider {

    OrganizationModel addOrganization(String name, UserModel owner);

    Optional<OrganizationModel> getOrganization(String id);

}
