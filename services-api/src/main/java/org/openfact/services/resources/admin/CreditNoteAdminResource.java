package org.openfact.services.resources.admin;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.cache.NoCache;
import org.openfact.representations.idm.ubl.CreditNoteRepresentation;
import org.openfact.representations.idm.ubl.common.CreditNoteLineRepresentation;

/**
 * @author carlosthe19916@sistcoop.com
 */
public interface CreditNoteAdminResource {

    /**
     * Get the creditNote with the specified creditNoteId.
     *
     * @return The creditNote with the specified creditNoteId
     * @summary Get the creditNote with the specified creditNoteId
     */
    @GET
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    CreditNoteRepresentation getCreditNote();

    @GET
    @Path("lines")
    @Produces(MediaType.APPLICATION_JSON)
    List<CreditNoteLineRepresentation> getLines();

    /**
     * Deletes creditNote with given creditNoteId.
     *
     * @throws AuthorizationException
     *             The user is not authorized to delete this creditNote.
     */
    @DELETE
    Response deleteCreditNote();

}
