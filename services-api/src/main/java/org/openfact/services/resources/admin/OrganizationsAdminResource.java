package org.openfact.services.resources.admin;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.jboss.resteasy.annotations.cache.NoCache;
import org.openfact.representations.idm.OrganizationRepresentation;

public interface OrganizationsAdminResource {

    @Path("{organization}")
    OrganizationAdminResource getOrganizationAdmin(@Context final HttpHeaders headers,
            @PathParam("organization") final String name);

    @GET
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    List<OrganizationRepresentation> getOrganizations();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    Response importOrganization(@Context final UriInfo uriInfo, final OrganizationRepresentation rep);

}
