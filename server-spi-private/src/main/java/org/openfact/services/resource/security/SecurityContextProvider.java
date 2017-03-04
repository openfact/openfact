package org.openfact.services.resource.security;

import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;

import java.util.List;

public interface SecurityContextProvider {

    UserContextModel getCurrentUser(OpenfactSession session);

    List<OrganizationModel> getPermitedOrganizations(OpenfactSession session);

}
