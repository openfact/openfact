package org.openfact.services.resources.admin;

import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.openfact.common.ClientConnection;
import org.openfact.events.admin.OperationType;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.representations.idm.ubl.CreditNoteRepresentation;
import org.openfact.representations.idm.ubl.common.CreditNoteLineRepresentation;
import org.openfact.services.ErrorResponse;
import org.openfact.services.ServicesLogger;
import org.openfact.services.managers.CreditNoteManager;

public class CreditNoteAdminResourceImpl implements CreditNoteAdminResource {

    private static final ServicesLogger logger = ServicesLogger.LOGGER;

    protected OrganizationModel organization;
    protected CreditNoteModel creditNote;
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

    public CreditNoteAdminResourceImpl(OrganizationModel organization, OrganizationAuth auth,
            AdminEventBuilder adminEvent, CreditNoteModel creditNote) {
        this.auth = auth;
        this.organization = organization;
        this.adminEvent = adminEvent;
        this.creditNote = creditNote;

        auth.init(OrganizationAuth.Resource.CREDIT_NOTE);
    }

    @Override
    public CreditNoteRepresentation getCreditNote() {
        auth.requireView();

        if (creditNote == null) {
            throw new NotFoundException("Credit Note not found");
        }

        CreditNoteRepresentation rep = ModelToRepresentation.toRepresentation(creditNote);
        return rep;
    }

    @Override
    public List<CreditNoteLineRepresentation> getLines() {
        auth.requireView();

        return creditNote.getCreditNoteLine().stream().map(f -> ModelToRepresentation.toRepresentation(f)).collect(Collectors.toList());
    }

    @Override
    public Response deleteCreditNote() {
        auth.requireManage();

        if (creditNote == null) {
            throw new NotFoundException("Credit Note not found");
        }

        boolean removed = new CreditNoteManager(session).removeCreditNote(organization, creditNote);
        if (removed) {
            adminEvent.operation(OperationType.DELETE).resourcePath(uriInfo).success();
            return Response.noContent().build();
        } else {
            return ErrorResponse.error("Credit Note couldn't be deleted", Response.Status.BAD_REQUEST);
        }
    }

}
