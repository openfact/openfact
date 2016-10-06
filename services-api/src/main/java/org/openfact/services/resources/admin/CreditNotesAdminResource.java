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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.cache.NoCache;
import org.openfact.representations.idm.search.SearchCriteriaRepresentation;
import org.openfact.representations.idm.search.SearchResultsRepresentation;
import org.openfact.representations.idm.ubl.CreditNoteRepresentation;

/**
 * @author carlosthe19916@sistcoop.com
 */
@Consumes(MediaType.APPLICATION_JSON)
public interface CreditNotesAdminResource {

    /**
     * @param creditNoteId
     *            The creditNoteId of the creditNote
     */
    @Path("{creditNoteId}")
    CreditNoteAdminResource getCreditNoteAdmin(@PathParam("creditNoteId") final String creditNoteId);

    @GET
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    List<CreditNoteRepresentation> getCreditNotes(@QueryParam("filterText") String filterText,
            @QueryParam("first") Integer firstResult, @QueryParam("max") Integer maxResults);

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    Response createCreditNote(@Valid final CreditNoteRepresentation rep);

    @POST
    @Path("search")
    @Produces(MediaType.APPLICATION_JSON)
    SearchResultsRepresentation<CreditNoteRepresentation> search(final SearchCriteriaRepresentation criteria);

}
