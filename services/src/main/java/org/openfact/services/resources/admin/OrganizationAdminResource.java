package org.openfact.services.resources.admin;

import org.jboss.logging.Logger;
import org.keycloak.KeyPairVerifier;
import org.keycloak.common.VerificationException;
import org.keycloak.common.util.PemUtils;
import org.openfact.Config;
import org.openfact.common.OpenfactClientConnection;
import org.openfact.events.admin.OperationType;
import org.openfact.models.*;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.models.utils.RepresentationToModel;
import org.openfact.representations.idm.OrganizationRepresentation;
import org.openfact.services.ErrorResponse;
import org.openfact.services.ForbiddenException;
import org.openfact.services.managers.OrganizationManager;
import org.openfact.services.resource.security.OrganizationAuth;
import org.openfact.services.resource.security.SecurityContextProvider;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;
import java.security.cert.X509Certificate;
import java.util.List;

@Stateless
@Path("/admin/organizations")
public class OrganizationAdminResource {

    protected static final Logger logger = Logger.getLogger(OrganizationAdminResource.class);

    @Context
    private UriInfo uriInfo;

    @Context
    private OpenfactSession session;

    @Context
    private OpenfactClientConnection clientConnection;

    @Inject
    private AdminEventBuilder adminEvent;

    @Inject
    private SecurityContextProvider securityContext;

    @Inject
    private OrganizationManager organizationManager;

    private void requireDelete() {
        List<OrganizationModel> permittedOrganizations = securityContext.getPermittedOrganizations(session);
        if (!permittedOrganizations.contains(organizationManager.getOpenfactAdminstrationOrganization()) && !securityContext.getClientUser(session).hasAppRole(AdminRoles.ADMIN)) {
            throw new ForbiddenException();
        }
    }

    /**
     * Get the organization with the specified organization name.
     *
     * @return The organization with the specified name
     * @summary Get the organization with the specified name
     */
    @GET
    @Path("/{organization}")
    @Produces(MediaType.APPLICATION_JSON)
    public OrganizationRepresentation getOrganization(@PathParam("organization") String organizationName) {
        OrganizationModel organization = AdminUtil.initOrganization(organizationName, organizationManager);
        OrganizationAuth auth = AdminUtil.initAuth(session, securityContext, organizationManager, organization);

        if (auth.hasView()) {
            return ModelToRepresentation.toRepresentation(organization, true);
        } else {
            auth.requireAny();

            OrganizationRepresentation rep = new OrganizationRepresentation();
            rep.setOrganization(organization.getName());
            return rep;
        }
    }

    /**
     * Update organization information.
     *
     * @param rep The representation of the organization to be changed
     * @return Generic Response object
     * @summary Update organization information
     */
    @PUT
    @Path("/{organization}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateOrganization(@PathParam("organization") String organizationName, @Valid final OrganizationRepresentation rep) {
        OrganizationModel organization = AdminUtil.initOrganization(organizationName, organizationManager);
        OrganizationAuth auth = AdminUtil.initAuth(session, securityContext, organizationManager, organization);

        auth.requireManage();

        logger.debug("updating organization: " + organization.getName());

        if (Config.getAdminOrganization().equals(organization.getName())
                && (rep.getOrganization() != null && !rep.getOrganization().equals(Config.getAdminOrganization()))) {
            return ErrorResponse.error("Can't rename master organization", Status.BAD_REQUEST);
        }

        try {
            if (!Constants.GENERATE.equals(rep.getPublicKey()) && (rep.getPrivateKey() != null && rep.getPublicKey() != null)) {
                try {
                    KeyPairVerifier.verify(rep.getPrivateKey(), rep.getPublicKey());
                } catch (VerificationException e) {
                    return ErrorResponse.error(e.getMessage(), Status.BAD_REQUEST);
                }
            }

            if (!Constants.GENERATE.equals(rep.getPublicKey()) && (rep.getCertificate() != null)) {
                try {
                    X509Certificate cert = PemUtils.decodeCertificate(rep.getCertificate());
                    if (cert == null) {
                        return ErrorResponse.error("Failed to decode certificate", Status.BAD_REQUEST);
                    }
                } catch (Exception e) {
                    return ErrorResponse.error("Failed to decode certificate", Status.BAD_REQUEST);
                }
            }

            RepresentationToModel.updateOrganization(rep, organization);

            // Refresh periodic tasks for send documents
            organizationManager.reschedulePeriodicTask(organization);

            AdminUtil.initAdminEvent(adminEvent, organization, securityContext.getClientUser(session), clientConnection)
                    .operation(OperationType.UPDATE)
                    .representation(rep)
                    .success();

            return Response.noContent().build();
        } catch (ModelDuplicateException e) {
            return ErrorResponse.exists("Organization with same name exists");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ErrorResponse.error("Failed to update organization", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Deletes organization with given name.
     */
    @DELETE
    @Path("/{organization}")
    public void deleteOrganization(@PathParam("organization") String organizationName) {
        OrganizationModel organization = AdminUtil.initOrganization(organizationName, organizationManager);

        requireDelete();

        if (Config.getAdminOrganization().equals(organization.getName())) {
            throw new BadRequestException("Organization " + Config.getAdminOrganization() + " should not be deleted");
        }

        if (!organizationManager.removeOrganization(organization)) {
            throw new NotFoundException("Organization doesn't exist");
        }
    }

}
