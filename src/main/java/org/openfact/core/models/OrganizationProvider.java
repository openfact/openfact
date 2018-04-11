package org.openfact.core.models;

import java.util.List;
import java.util.Optional;

public interface OrganizationProvider {

    /**
     * Used for create admin organization
     */
    OrganizationModel addOrganization(String id, String name);

    OrganizationModel addOrganization(String name, UserModel owner);

    Optional<OrganizationModel> getOrganization(String id);

}
