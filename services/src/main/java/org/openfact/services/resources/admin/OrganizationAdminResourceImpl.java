package org.openfact.services.resources.admin;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.jboss.logging.Logger;
import org.openfact.common.ClientConnection;
import org.openfact.models.ModelDuplicateException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.models.utils.RepresentationToModel;
import org.openfact.representations.idm.OrganizationRepresentation;
import org.openfact.services.ErrorResponse;
import org.openfact.services.managers.OrganizationManager;

public class OrganizationAdminResourceImpl implements OrganizationAdminResource {

    protected static final Logger logger = Logger.getLogger(OrganizationAdminResourceImpl.class);

    protected OrganizationAuth auth;
    protected OrganizationModel organization;

    @Context
    protected OpenfactSession session;

    @Context
    protected UriInfo uriInfo;

    @Context
    protected ClientConnection connection;

    @Context
    protected HttpHeaders headers;

    public OrganizationAdminResourceImpl(OrganizationAuth auth, OrganizationModel organization) {
        this.auth = auth;
        this.organization = organization;

        auth.init(OrganizationAuth.Resource.REALM);
        auth.requireAny();
    }

    @Override
    public OrganizationRepresentation getOrganization() {
        if (auth.hasView()) {
            return ModelToRepresentation.toRepresentation(organization, false);
        } else {
            auth.requireAny();

            OrganizationRepresentation rep = new OrganizationRepresentation();
            rep.setName(organization.getName());

            return rep;
        }
    }

    @Override
    public Response updateOrganization(OrganizationRepresentation rep) {
        auth.requireManage();
        logger.debug("updating organization: " + organization.getName());
        try {
            RepresentationToModel.updateOrganization(rep, organization);
            return Response.noContent().build();
        } catch (ModelDuplicateException e) {
            return ErrorResponse.exists("Organization with same name exists");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ErrorResponse.error("Failed to update organization",
                    Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public void deleteOrganization() {
        auth.requireManage();

        if (!new OrganizationManager(session).removeOrganization(organization)) {
            throw new NotFoundException("Organization doesn't exist");
        }
    }

}
