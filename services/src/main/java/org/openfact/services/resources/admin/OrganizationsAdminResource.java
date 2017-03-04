package org.openfact.services.resources.admin;

import org.jboss.logging.Logger;
import org.openfact.models.AdminRoles;
import org.openfact.models.ModelDuplicateException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.representations.idm.OrganizationRepresentation;
import org.openfact.services.ErrorResponse;
import org.openfact.services.ForbiddenException;
import org.openfact.services.managers.OrganizationManager;
import org.openfact.services.resource.security.ClientUser;
import org.openfact.services.resource.security.SecurityContextProvider;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Path("/admin/organizations")
public class OrganizationsAdminResource {

    protected static final Logger logger = Logger.getLogger(OrganizationsAdminResource.class);

    @Context
    private UriInfo uriInfo;

    @Context
    private OpenfactSession session;

    @Inject
    private OrganizationManager organizationManager;

    @Inject
    private SecurityContextProvider secureContextProvider;

    /**
     * Create a new organization.
     *
     * @param rep The representation of the organization that will be created
     * @return The organization created on Response format
     * @summary Create a new organization
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response importOrganization(@Context final UriInfo uriInfo, @Valid final OrganizationRepresentation rep) {
        if (!secureContextProvider.getPermitedOrganizations(session).contains(organizationManager.getOpenfactAdminstrationOrganization())) {
            throw new ForbiddenException();
        }
        if (!secureContextProvider.getClientUser(session).hasAppRole(AdminRoles.CREATE_ORGANIZATION)) {
            throw new ForbiddenException();
        }

        logger.debugv("importOrganization: {0}", rep.getOrganization());

        try {
            OrganizationModel organization = organizationManager.importOrganization(rep);

            URI location = uriInfo.getBaseUriBuilder().path(organization.getName()).build();
            logger.debugv("imported organization success, sending back: {0}", location.toString());

            return Response.created(location).build();
        } catch (ModelDuplicateException e) {
            return ErrorResponse.exists("Organization with same name exists");
        }
    }

    /**
     * Get all organizations.
     *
     * @return All organizations
     * @summary Get all organizations
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<OrganizationRepresentation> getOrganizations() {
        List<OrganizationRepresentation> reps = new ArrayList<>();

        List<OrganizationModel> permitedOrganizations = secureContextProvider.getPermitedOrganizations(session);
        if (permitedOrganizations != null && !permitedOrganizations.isEmpty() && permitedOrganizations.contains(organizationManager.getOpenfactAdminstrationOrganization())) {
            List<OrganizationModel> organizations = organizationManager.getOrganizations();
            addOrganizationRep(reps, organizations);
        } else if (permitedOrganizations != null && !permitedOrganizations.isEmpty()) {
            addOrganizationRep(reps, permitedOrganizations);
        }

        if (reps.isEmpty()) {
            throw new ForbiddenException();
        }

        logger.debug(("getOrganizations()"));
        return reps;
    }

    protected void addOrganizationRep(List<OrganizationRepresentation> reps, List<OrganizationModel> organizations) {
        ClientUser contextUser = secureContextProvider.getClientUser(session);
        if (contextUser.hasAppRole(AdminRoles.VIEW_ORGANIZATION)) {
            organizations.stream().forEach(organization -> {
                reps.add(ModelToRepresentation.toRepresentation(organization, false));
            });
        } else if (contextUser.hasOneOfAppRole(AdminRoles.ALL_ORGANIZATION_ROLES)) {
            organizations.stream().forEach(organization -> {
                OrganizationRepresentation rep = new OrganizationRepresentation();
                rep.setOrganization(organization.getName());
                reps.add(rep);
            });
        }
    }

}
