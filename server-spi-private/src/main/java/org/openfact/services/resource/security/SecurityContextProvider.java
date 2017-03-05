package org.openfact.services.resource.security;

import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;

import java.util.List;

public interface SecurityContextProvider {

    ClientUser getClientUser(OpenfactSession session);

    List<OrganizationModel> getPermittedOrganizations(OpenfactSession session);

}
