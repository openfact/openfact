package org.openfact.services.resources.admin;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.jboss.resteasy.annotations.cache.NoCache;
import org.openfact.representations.idm.OrganizationRepresentation;
import org.openfact.representations.idm.search.SearchCriteriaRepresentation;
import org.openfact.representations.idm.search.SearchResultsRepresentation;

/**
 * @author carlosthe19916@sistcoop.com
 */
public interface OrganizationsAdminResource {

    /**
     * Create a new organization.
     *
     * @param rep
     *            The representation of the organization that will be created
     * @return The organization created on Response format
     * @summary Create a new organization
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    Response importOrganization(@Context final UriInfo uriInfo, @Valid final OrganizationRepresentation rep);

    /**
     * Get all organizations.
     *
     * @return All organizations
     * @summary Get all organizations
     */
    @GET
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    List<OrganizationRepresentation> getOrganizations(@QueryParam("filterText") String filterText,
            @QueryParam("organization") String organizationName,
            @QueryParam("supplierName") String supplierName,
            @QueryParam("registrationName") String registrationName, @QueryParam("first") Integer firstResult,
            @QueryParam("max") Integer maxResults);

    @POST
    @Path("search")
    @Produces(MediaType.APPLICATION_JSON)
    SearchResultsRepresentation<OrganizationRepresentation> searchOrganizations(
            @Valid final SearchCriteriaRepresentation criteria);

    /**
     * @param organization
     *            The organization name
     */
    @Path("{organization}")
    OrganizationAdminResource getOrganizationAdmin(@Context final HttpHeaders headers,
            @PathParam("organization") final String name);

}
