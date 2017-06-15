package org.openfact.models;

public interface OrganizationProvider {

    OrganizationModel createOrganization(String name);

    OrganizationModel createOrganization(String id, String name);

}
