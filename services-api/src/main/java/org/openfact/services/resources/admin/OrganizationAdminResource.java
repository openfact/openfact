package org.openfact.services.resources.admin;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.cache.NoCache;
import org.openfact.representations.idm.OrganizationRepresentation;

public interface OrganizationAdminResource {

	@GET
	@NoCache
	@Produces(MediaType.APPLICATION_JSON)
	OrganizationRepresentation getOrganization();

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	Response updateOrganization(final OrganizationRepresentation rep);

	@DELETE
	void deleteOrganization();

    @Path("invoices")
    InvoicesAdminResource invoices();
    
}
