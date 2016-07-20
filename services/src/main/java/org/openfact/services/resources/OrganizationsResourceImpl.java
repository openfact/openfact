package org.openfact.services.resources;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Context;

import org.jboss.logging.Logger;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.openfact.models.OrganizationModel;
import org.openfact.models.RepeidSession;
import org.openfact.services.managers.OrganizationManager;
import org.openfact.services.resources.OrganizationsResource;
import org.openfact.services.resources.PublicOrganizationResource;

public class OrganizationsResourceImpl implements OrganizationsResource {

	private static final Logger logger = Logger.getLogger(OrganizationsResourceImpl.class);

	@Context
	protected RepeidSession session;

	@Override
	public PublicOrganizationResource getOrganizationResource(String name) {
		OrganizationModel organization = init(name);
		PublicOrganizationResource organizationResource = new PublicOrganizationResourceImpl(organization);
		ResteasyProviderFactory.getInstance().injectProperties(organizationResource);
		return organizationResource;
	}

	private OrganizationModel init(String organizationName) {
		OrganizationManager organizationManager = new OrganizationManager(session);
		OrganizationModel organization = organizationManager.getOrganizationByName(organizationName);
		if (organization == null) {
			throw new NotFoundException("Organization does not exist");
		}
		session.getContext().setOrganization(organization);
		return organization;
	}

}
