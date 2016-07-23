package org.openfact.services.resources;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.jboss.logging.Logger;
import org.jboss.resteasy.spi.HttpRequest;
import org.jboss.resteasy.spi.HttpResponse;
import org.openfact.models.OrganizationModel;
import org.openfact.representations.idm.PublishedOrganizationRepresentation;
import org.openfact.services.resources.PublicOrganizationResource;

public class PublicOrganizationResourceImpl implements PublicOrganizationResource {

	private static final Logger logger = Logger.getLogger(PublicOrganizationResourceImpl.class);

	@Context
	protected UriInfo uriInfo;

	@Context
	protected HttpRequest request;

	@Context
	protected HttpResponse response;

	protected OrganizationModel organization;

	public PublicOrganizationResourceImpl(OrganizationModel organization) {
		this.organization = organization;
	}

	@Override
	public Response accountPreflight() {
		return Cors.add(request, Response.ok()).auth().preflight().build();
	}

	@Override
	public PublishedOrganizationRepresentation getOrganization() {
		Cors.add(request).allowedOrigins(Cors.ACCESS_CONTROL_ALLOW_ORIGIN_WILDCARD).auth().build(response);
		return organizationRep(organization, uriInfo);
	}

	public static PublishedOrganizationRepresentation organizationRep(OrganizationModel organization, UriInfo uriInfo) {
		PublishedOrganizationRepresentation rep = new PublishedOrganizationRepresentation();
		rep.setOrganization(organization.getName());
		rep.setSupplierName(organization.getSupplierName());
		return rep;
	}

}
