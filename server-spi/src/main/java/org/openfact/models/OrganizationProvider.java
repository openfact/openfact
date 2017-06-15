package org.openfact.models;

import java.util.List;

public interface OrganizationProvider {

    OrganizationModel createOrganization(String name);

    OrganizationModel createOrganization(String id, String name);

    OrganizationModel getOrganization(String id);

    OrganizationModel getOrganizationByName(String name);

    List<OrganizationModel> getOrganizations();

    List<OrganizationModel> getOrganizations(int firstResult, int maxResults);

    int getOrganizationsCount();

    boolean removeOrganization(String id);

    boolean removeOrganization(OrganizationModel organization);

}
