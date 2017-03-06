package org.openfact.services.resources.admin;

import org.openfact.common.OpenfactClientConnection;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.services.ForbiddenException;
import org.openfact.services.managers.OrganizationManager;
import org.openfact.services.resource.security.ClientUser;
import org.openfact.services.resource.security.OrganizationAuth;
import org.openfact.services.resource.security.Resource;
import org.openfact.services.resource.security.SecurityContextProvider;

import javax.ws.rs.NotFoundException;
import java.util.List;

public class AdminUtil {

    public static OrganizationModel initOrganization(String organizationName, OrganizationManager organizationManager) {
        OrganizationModel organization = organizationManager.getOrganizationByName(organizationName);
        if (organization == null) {
            throw new NotFoundException("Organization " + organizationName + " not found.");
        }
        return organization;
    }

    public static AdminEventBuilder initAdminEvent(AdminEventBuilder adminEvent, OrganizationModel organization, ClientUser clientUser, OpenfactClientConnection clientConnection) {
        return adminEvent.organization(organization)
                .clientUser(clientUser)
                .clientConnection(clientConnection);
    }

    public static OrganizationAuth initAuth(OpenfactSession session, SecurityContextProvider securityContext, OrganizationManager organizationManager, OrganizationModel organization) {
        List<OrganizationModel> permittedOrganizations = securityContext.getPermittedOrganizations(session);
        if (!permittedOrganizations.contains(organizationManager.getOpenfactAdminstrationOrganization()) && !permittedOrganizations.contains(organization)) {
            throw new ForbiddenException();
        }

        return securityContext
                .getClientUser(session)
                .organizationAuth(Resource.ORGANIZATION);
    }

}
