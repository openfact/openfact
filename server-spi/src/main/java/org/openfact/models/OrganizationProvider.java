package org.openfact.models;

import java.util.List;
import java.util.Map;

import org.openfact.migration.MigrationModel;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;
import org.openfact.provider.Provider;

public interface OrganizationProvider extends Provider {

    MigrationModel getMigrationModel();

    OrganizationModel createOrganization(String name);

    OrganizationModel createOrganization(String id, String name);

    OrganizationModel getOrganization(String id);

    OrganizationModel getOrganizationByName(String name);

    List<OrganizationModel> getOrganizations();

    List<OrganizationModel> getOrganizations(Integer firstResult, Integer maxResults);

    boolean removeOrganization(String organizationId);

    boolean removeOrganization(OrganizationModel organization);

    int getOrganizationsCount();

    List<OrganizationModel> searchForOrganization(String filterText, Integer firstResult, Integer maxResults);

    List<OrganizationModel> searchForOrganization(Map<String, String> attributes, Integer firstResult, Integer maxResults);

    SearchResultsModel<OrganizationModel> searchForOrganization(SearchCriteriaModel criteria);

    SearchResultsModel<OrganizationModel> searchForOrganization(SearchCriteriaModel criteria, String filterText);

    void close();

}
