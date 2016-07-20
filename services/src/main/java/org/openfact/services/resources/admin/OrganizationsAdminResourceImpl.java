package org.openfact.services.resources.admin;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.jboss.logging.Logger;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.openfact.models.AdminRoles;
import org.openfact.models.ModelDuplicateException;
import org.openfact.models.OrganizationModel;
import org.openfact.models.RepeidSession;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.representations.idm.OrganizationRepresentation;
import org.openfact.services.ErrorResponse;
import org.openfact.services.managers.OrganizationManager;
import org.openfact.services.resources.RepeidApplication;
import org.openfact.services.resources.admin.OrganizationAdminResource;
import org.openfact.services.resources.admin.OrganizationsAdminResource;

public class OrganizationsAdminResourceImpl implements OrganizationsAdminResource {

	private static final Logger logger = Logger.getLogger(OrganizationsAdminResourceImpl.class);

	protected AdminAuth auth;
	// protected TokenManager tokenManager;

	@Context
	protected RepeidSession session;

	@Context
	protected RepeidApplication repeid;

	// @Context
	// protected ClientConnection clientConnection;

	public OrganizationsAdminResourceImpl() {
		// this.auth = auth;
		// this.tokenManager = tokenManager;
	}

	@Override
	public List<OrganizationRepresentation> getOrganizations() {
		// OrganizationManager organizationManager = new
		// OrganizationManager(session);
		List<OrganizationRepresentation> reps = new ArrayList<>();
		// if
		// (auth.getOrganization().equals(organizationManager.getRepeidAdminstrationRealm()))
		// {
		List<OrganizationModel> organizations = session.organizations().getOrganizations();
		for (OrganizationModel organization : organizations) {
			addOrganizationRep(reps,
					organization/* , organization.getMasterAdminClient() */);
		}
		// } else {
		// ClientModel adminApp = auth.getOrganization()
		// .getClientByClientId(organizationManager.getRealmAdminClientId(auth.getOrganization()));
		// addRealmRep(reps, auth.getOrganization(), adminApp);
		// }
		logger.debug(("getOrganizations()"));
		return reps;
	}

	@Override
	public Response importOrganization(UriInfo uriInfo, OrganizationRepresentation rep) {
		OrganizationManager organizationManager = new OrganizationManager(session);
		//organizationManager.setContextPath(repeid.getContextPath());
		// if
		// (!auth.getRealm().equals(realmManager.getKeycloakAdminstrationRealm()))
		// {
		// throw new ForbiddenException();
		// }
		// if (!auth.hasRealmRole(AdminRoles.CREATE_REALM)) {
		// throw new ForbiddenException();
		// }
		logger.debugv("importRealm: {0}", rep.getName());

		try {
			OrganizationModel organization = organizationManager.importOrganization(rep);
			// grantPermissionsToRealmCreator(realm);

			URI location = AdminRootImpl.organizationUrl(uriInfo).path(organization.getName()).build();
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
		if (organization == null)
			throw new NotFoundException("Organization not found.");

		// if
		// (!auth.getRealm().equals(organizationManager.getKeycloakAdminstrationRealm())
		// && !auth.getRealm().equals(organization)) {
		// throw new ForbiddenException();
		// }
		// RealmAuth realmAuth;

		// if
		// (auth.getRealm().equals(organizationManager.getKeycloakAdminstrationRealm()))
		// {
		// realmAuth = new RealmAuth(auth, organization.getMasterAdminClient());
		// } else {
		// realmAuth = new RealmAuth(auth,
		// organization.getClientByClientId(organizationManager.getRealmAdminClientId(auth.getRealm())));
		// }

		// AdminEventBuilder adminEvent = new AdminEventBuilder(organization,
		// auth, session, clientConnection);
		session.getContext().setOrganization(organization);

		OrganizationAdminResource adminResource = new OrganizationAdminResourceImpl(/*realmAuth, organization, tokenManager, adminEvent*/);
		ResteasyProviderFactory.getInstance().injectProperties(adminResource);
		// resourceContext.initResource(adminResource);
		return adminResource;
	}

	protected void addOrganizationRep(List<OrganizationRepresentation> reps,
			OrganizationModel organization/*
											 * , ClientModel
											 * realmManagementClient
											 */) {
		// if (!auth.hasOneOfAppRole(realmManagementClient,
		// AdminRoles.ALL_REALM_ROLES)) {
		// throw new ForbiddenException();
		// }

		// if (auth.hasAppRole(realmManagementClient, AdminRoles.VIEW_REALM)) {
		reps.add(ModelToRepresentation.toRepresentation(organization, false));
		// } else if (auth.hasOneOfAppRole(realmManagementClient,
		// AdminRoles.ALL_REALM_ROLES)) {
		// OrganizationRepresentation rep = new OrganizationRepresentation();
		// rep.setRealm(organization.getName());
		// reps.add(rep);
		// }
	}

}
