package org.openfact.services.resources.admin;

import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.jboss.resteasy.annotations.cache.NoCache;
import org.openfact.common.ClientConnection;
import org.openfact.events.admin.OperationType;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.representations.idm.ubl.DebitNoteRepresentation;
import org.openfact.representations.idm.ubl.common.DebitNoteLineRepresentation;
import org.openfact.services.ErrorResponse;
import org.openfact.services.ServicesLogger;
import org.openfact.services.managers.DebitNoteManager;

public class DebitNoteAdminResource {

    private static final ServicesLogger logger = ServicesLogger.LOGGER;

    protected OrganizationModel organization;
    protected DebitNoteModel debitNote;
    private OrganizationAuth auth;
    private AdminEventBuilder adminEvent;

    @Context
    protected UriInfo uriInfo;

    @Context
    protected OpenfactSession session;

    @Context
    protected ClientConnection clientConnection;

    @Context
    protected HttpHeaders headers;

    public DebitNoteAdminResource(OrganizationModel organization, OrganizationAuth auth,
            AdminEventBuilder adminEvent, DebitNoteModel debitNote) {
        this.auth = auth;
        this.organization = organization;
        this.adminEvent = adminEvent;
        this.debitNote = debitNote;

        auth.init(OrganizationAuth.Resource.DEBIT_NOTE);
    }

    /**
     * Get the debitNote with the specified debitNoteId.
     *
     * @return The debitNote with the specified debitNoteId
     * @summary Get the debitNote with the specified debitNoteId
     */
    @GET
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public DebitNoteRepresentation getDebitNote() {
        auth.requireView();

        if (debitNote == null) {
            throw new NotFoundException("Debit Note not found");
        }

        DebitNoteRepresentation rep = ModelToRepresentation.toRepresentation(debitNote);
        return rep;
    }

    @GET
    @Path("lines")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DebitNoteLineRepresentation> getLines() {
        auth.requireView();

        return debitNote.getDebitNoteLine().stream().map(f -> ModelToRepresentation.toRepresentation(f))
                .collect(Collectors.toList());
    }

    /**
     * Deletes debitNote with given debitNoteId.
     *
     * @throws AuthorizationException
     *             The user is not authorized to delete this debitNote.
     */
    @DELETE
    public Response deleteDebitNote() {
        auth.requireManage();

        if (debitNote == null) {
            throw new NotFoundException("Debit Note not found");
        }

        boolean removed = new DebitNoteManager(session).removeDebitNote(organization, debitNote);
        if (removed) {
            adminEvent.operation(OperationType.DELETE).resourcePath(uriInfo).success();
            return Response.noContent().build();
        } else {
            return ErrorResponse.error("Debit Note couldn't be deleted", Response.Status.BAD_REQUEST);
        }
    }

}
