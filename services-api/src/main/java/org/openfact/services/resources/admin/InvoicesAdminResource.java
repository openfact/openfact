package org.openfact.services.resources.admin;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.cache.NoCache;
import org.openfact.representations.idm.InvoiceRepresentation;
import org.openfact.representations.idm.search.SearchCriteriaRepresentation;
import org.openfact.representations.idm.search.SearchResultsRepresentation;

public interface InvoicesAdminResource {

    /*
     * @Path("{organization}") OrganizationAdminResource
     * getOrganizationAdmin(@Context final HttpHeaders headers,
     * 
     * @PathParam("organization") final String name);
     */

    @GET
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    List<InvoiceRepresentation> getInvoices(@QueryParam("filterText") final String filterText,
            @QueryParam("first") final int first, @QueryParam("max") final int max);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    Response createInvoice(final InvoiceRepresentation rep);

    @POST
    @Path("search")
    @Produces(MediaType.APPLICATION_JSON)
    SearchResultsRepresentation<InvoiceRepresentation> search(final SearchCriteriaRepresentation criteria);
    
}
