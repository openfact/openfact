package org.openfact.models;

import java.util.List;

import org.openfact.migration.MigrationModel;
import org.openfact.provider.Provider;

public interface OrganizationProvider extends Provider {

	MigrationModel getMigrationModel();

	OrganizationModel createOrganization(String name);

	OrganizationModel createOrganization(String id, String name);

	OrganizationModel getOrganization(String id);
	
	OrganizationModel getOrganizationByName(String name);
	
	
	List<OrganizationModel> getOrganizations();

	boolean removeOrganization(String id);

	void close();

}
