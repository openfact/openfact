package org.openfact.services.resources.admin;

import java.security.cert.X509Certificate;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.cache.NoCache;
import org.keycloak.KeyPairVerifier;
import org.keycloak.common.VerificationException;
import org.keycloak.common.util.PemUtils;
import org.openfact.Config;
import org.openfact.events.admin.OperationType;
import org.openfact.models.ModelDuplicateException;
import org.openfact.models.OpenfactContext;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.models.utils.RepresentationToModel;
import org.openfact.representations.idm.OrganizationRepresentation;
import org.openfact.services.ErrorResponse;
import org.openfact.services.managers.OrganizationManager;
import org.openfact.services.resource.security.OrganizationAuth;
import org.openfact.services.resource.security.Resource;
import org.openfact.services.resource.security.SecurityContextProvider;

@Stateless
@Path("/admin/organizations/{organization}")
public class OrganizationAdminResource {

    protected static final Logger logger = Logger.getLogger(OrganizationAdminResource.class);

    @Context
    protected UriInfo uriInfo;

    @Context
    protected OpenfactSession session;

    @PathParam("organization")
    private String organizationName;
    private OrganizationModel organization;

    @Inject
    private OrganizationManager organizationManager;

    @Inject
    private SecurityContextProvider securityContextProvider;
    private OrganizationAuth auth;

    @Inject
    private AdminEventBuilder adminEvent;

    @PostConstruct
    private void init() {
        auth = securityContextProvider.getCurrentUser(session).organizationAuth(Resource.ORGANIZATION);
        organization = organizationManager.getOrganizationByName(organizationName);
    }

    /**
     * Get the organization with the specified organization name.
     *
     * @return The organization with the specified name
     * @summary Get the organization with the specified name
     */
    @GET
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public OrganizationRepresentation getOrganization() {
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
        auth.requireManage();

        logger.debug("updating organization: " + organization.getName());

        if (Config.getAdminOrganization().equals(organization.getName())
                && (rep.getOrganization() != null
                && !rep.getOrganization().equals(Config.getAdminOrganization()))) {
            return ErrorResponse.error("Can't rename master organization", Status.BAD_REQUEST);
        }

        try {
            if (!"GENERATE".equals(rep.getPublicKey())
                    && (rep.getPrivateKey() != null && rep.getPublicKey() != null)) {
                try {
                    KeyPairVerifier.verify(rep.getPrivateKey(), rep.getPublicKey());
                } catch (VerificationException e) {
                    return ErrorResponse.error(e.getMessage(), Status.BAD_REQUEST);
                }
            }

            if (!"GENERATE".equals(rep.getPublicKey()) && (rep.getCertificate() != null)) {
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
            //organizationManager.reschedulePeriodicTask(organization);

            adminEvent.operation(OperationType.UPDATE).representation(rep).success();
            return Response.noContent().build();
        } catch (ModelDuplicateException e) {
            return ErrorResponse.exists("Organization with same name exists");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ErrorResponse.error("Failed to update organization",
                    Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Deletes organization with given name.
     */
    @DELETE
    public void deleteOrganization(@Context final UriInfo uriInfo) {
        auth.requireManage();

        if (!organizationManager.removeOrganization(organization)) {
            throw new NotFoundException("Organization doesn't exist");
        }
    }

}
