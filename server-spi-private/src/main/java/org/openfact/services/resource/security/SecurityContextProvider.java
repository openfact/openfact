package org.openfact.services.resource.security;

import org.openfact.models.OrganizationModel;

public interface SecurityContextProvider {

    OrganizationModel getCurrentOrganization();

    UserContextModel getCurrentUser();
    
}
