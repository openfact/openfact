package org.openfact.models;

import org.openfact.migration.MigrationModel;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;
import org.openfact.provider.Provider;

import java.util.List;
import java.util.Map;

public interface OrganizationProvider extends Provider {

    MigrationModel getMigrationModel();

    OrganizationModel createOrganization(String name);

    OrganizationModel createOrganization(String id, String name);

    OrganizationModel getOrganization(String id);

    OrganizationModel getOrganizationByName(String name);

    List<OrganizationModel> getOrganizations();

    List<OrganizationModel> getOrganizations(int firstResult, int maxResults);

    boolean removeOrganization(String organizationId);

    boolean removeOrganization(OrganizationModel organization);

    int getOrganizationsCount();

    //List<OrganizationModel> searchForOrganization(String filterText, int firstResult, int maxResults);
    //List<OrganizationModel> searchForOrganization(Map<String, String> attributes, int firstResult, int maxResults);

}
