package org.openfact.models;

import java.util.List;

public interface OrganizationProvider {

    OrganizationModel createOrganization(String name) throws ModelException;

    OrganizationModel createOrganization(String id, String name) throws ModelException;

    OrganizationModel getOrganization(String id);

    OrganizationModel getOrganizationByName(String name);

    List<OrganizationModel> getOrganizations();

    List<OrganizationModel> getOrganizations(int firstResult, int maxResults);

    boolean removeOrganization(String organizationId);

    boolean removeOrganization(OrganizationModel organization);

    int getOrganizationsCount();

}
