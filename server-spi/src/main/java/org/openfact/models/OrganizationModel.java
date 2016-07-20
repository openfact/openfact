package org.openfact.models;

import org.openfact.provider.ProviderEvent;

public interface OrganizationModel {

	interface OrganizationCreationEvent extends ProviderEvent {
        OrganizationModel getCreatedOrganization();
    }    
    
	String getId();

	String getName();

	void setName(String name);

	boolean isEnabled();

	void setEnabled(boolean enabled);	
	
}
