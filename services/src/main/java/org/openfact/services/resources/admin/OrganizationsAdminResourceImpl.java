package org.openfact.services.resources.admin;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.jboss.logging.Logger;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.openfact.common.ClientConnection;
import org.openfact.models.AdminRoles;
import org.openfact.models.ModelDuplicateException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.representations.idm.OrganizationRepresentation;
import org.openfact.services.ErrorResponse;
import org.openfact.services.managers.OrganizationManager;
import org.openfact.services.resources.OpenfactApplication;

public class OrganizationsAdminResourceImpl implements OrganizationsAdminResource {

	private static final Logger logger = Logger.getLogger(OrganizationsAdminResourceImpl.class);

	protected AdminAuth auth;
	
    @Context
    protected OpenfactSession session;

    @Context
    protected OpenfactApplication openfact;

    @Context
    protected ClientConnection clientConnection;

	public OrganizationsAdminResourceImpl(AdminAuth auth) {
        this.auth = auth;
    }

    public static final CacheControl noCache = new CacheControl();

    static {
        noCache.setNoCache(true);
    }

    @Override
	public List<OrganizationRepresentation> getOrganizations() {
        OrganizationManager organizationManager = new OrganizationManager(session);
        List<OrganizationRepresentation> reps = new ArrayList<>();
        if (auth.getOrganization().equals(organizationManager.getOpenfactAdminstrationOrganization())) {
            List<OrganizationModel> organizations = session.organizations().getOrganizations();
            for (OrganizationModel organization : organizations) {
                addOrganizationRep(reps, organization);
            }
        } else {            
            addOrganizationRep(reps, auth.getOrganization());
        }
		logger.debug(("getOrganizations()"));
		return reps;
	}
    
    protected void addOrganizationRep(List<OrganizationRepresentation> reps, OrganizationModel organization) {
        if (!auth.hasOneRole(AdminRoles.ALL_REALM_ROLES)) {
            throw new ForbiddenException();
        }

        if (auth.hasAppRole(AdminRoles.VIEW_REALM)) {
            reps.add(ModelToRepresentation.toRepresentation(organization, false));
        } else if (auth.hasOneRole(AdminRoles.ALL_REALM_ROLES)) {
            OrganizationRepresentation rep = new OrganizationRepresentation();
            rep.setName(organization.getName());
            reps.add(rep);
        }
    }

	@Override
	public Response importOrganization(UriInfo uriInfo, OrganizationRepresentation rep) {
        OrganizationManager organizationManager = new OrganizationManager(session);
        organizationManager.setContextPath(openfact.getContextPath());
        if (!auth.getOrganization().equals(organizationManager.getOpenfactAdminstrationOrganization())) {
            throw new ForbiddenException();
        }
        if (!auth.hasOrganizationRole(AdminRoles.CREATE_ORGANIZATION)) {
            throw new ForbiddenException();
        }
        logger.debugv("importOrganization: {0}", rep.getName());

        try {
            OrganizationModel organization = organizationManager.importOrganization(rep);            

            URI location = AdminRootImpl.organizationsUrl(uriInfo).path(organization.getName()).build();
            logger.debugv("imported realm success, sending back: {0}", location.toString());

            return Response.created(location).build();
        } catch (ModelDuplicateException e) {
            return ErrorResponse.exists("Organization with same name exists");
        }
	}

	@Override
	public OrganizationAdminResource getOrganizationAdmin(HttpHeaders headers, String name) {
	    OrganizationManager organizationManager = new OrganizationManager(session);
        OrganizationModel organization = organizationManager.getOrganizationByName(name);
        if (organization == null) throw new NotFoundException("Organization not found.");

        if (!auth.getOrganization().equals(organizationManager.getOpenfactAdminstrationOrganization())
                && !auth.getOrganization().equals(organization)) {
            throw new ForbiddenException();
        }
        OrganizationAuth organizationAuth;

        if (auth.getOrganization().equals(organizationManager.getOpenfactAdminstrationOrganization())) {
            organizationAuth = new OrganizationAuth(auth);
        } else {
            organizationAuth = new OrganizationAuth(auth);
        }
        
        session.getContext().setOrganization(organization);

        OrganizationAdminResource adminResource = new OrganizationAdminResourceImpl(organizationAuth, organization);
        ResteasyProviderFactory.getInstance().injectProperties(adminResource);
        //resourceContext.initResource(adminResource);
        return adminResource;
	}	

}
