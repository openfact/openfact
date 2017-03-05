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
import org.openfact.services.resource.security.Resource;
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
@Path("/admin/organizations/{organization}")
public class OrganizationAdminResource {

    protected static final Logger logger = Logger.getLogger(OrganizationAdminResource.class);

    @Context
    private UriInfo uriInfo;

    @Context
    private OpenfactSession session;

    @Context
    private OpenfactClientConnection clientConnection;

    @PathParam("organization")
    private String organizationName;
    private OrganizationModel organization;

    @Inject
    private OrganizationManager organizationManager;

    @Inject
    private SecurityContextProvider securityContextProvider;

    @Inject
    private AdminEventBuilder adminEvent;

    private void init() {
        organization = organizationManager.getOrganizationByName(organizationName);
        if (organization == null) {
            throw new NotFoundException("Organization not found.");
        }

        adminEvent = new AdminEventBuilder().organization(organization);
    }

    private OrganizationAuth buildOrganizationAuth() {
        init();

        List<OrganizationModel> permittedOrganizations = securityContextProvider.getPermittedOrganizations(session);
        if (!permittedOrganizations.contains(organizationManager.getOpenfactAdminstrationOrganization()) && !permittedOrganizations.contains(organization)) {
            throw new ForbiddenException();
        }

        return securityContextProvider.getClientUser(session).organizationAuth(Resource.ORGANIZATION);
    }

    private void requireDelete() {
        init();

        List<OrganizationModel> permittedOrganizations = securityContextProvider.getPermittedOrganizations(session);
        if (!permittedOrganizations.contains(organizationManager.getOpenfactAdminstrationOrganization()) && !securityContextProvider.getClientUser(session).hasAppRole(AdminRoles.ADMIN)) {
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
    @Produces(MediaType.APPLICATION_JSON)
    public OrganizationRepresentation getOrganization() {
        OrganizationAuth auth = buildOrganizationAuth();
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
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateOrganization(@Valid final OrganizationRepresentation rep) {
        OrganizationAuth auth = buildOrganizationAuth();
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

            adminEvent.operation(OperationType.UPDATE).representation(rep).success();

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
    public void deleteOrganization() {
        requireDelete();

        if (!organizationManager.removeOrganization(organization)) {
            throw new NotFoundException("Organization doesn't exist");
        }
    }

}
