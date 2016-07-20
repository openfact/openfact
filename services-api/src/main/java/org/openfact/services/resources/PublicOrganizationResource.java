package org.openfact.services.resources;

import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.cache.NoCache;
import org.openfact.representations.idm.PublishedOrganizationRepresentation;

public interface PublicOrganizationResource {

	@Path("/")
	@OPTIONS
	public Response accountPreflight();

	@GET
	@NoCache
	@Produces(MediaType.APPLICATION_JSON)
	public PublishedOrganizationRepresentation getOrganization();

}
