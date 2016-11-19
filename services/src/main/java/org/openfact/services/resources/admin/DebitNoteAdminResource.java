/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.openfact.services.resources.admin;

import org.apache.commons.lang.ArrayUtils;
import org.jboss.resteasy.annotations.cache.NoCache;
import org.openfact.common.ClientConnection;
import org.openfact.common.converts.DocumentUtils;
import org.openfact.events.admin.OperationType;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.report.ReportProvider;
import org.openfact.representations.idm.ubl.DebitNoteRepresentation;
import org.openfact.representations.idm.ubl.common.DebitNoteLineRepresentation;
import org.openfact.services.ErrorResponse;
import org.openfact.services.ServicesLogger;
import org.openfact.services.managers.DebitNoteManager;
import org.w3c.dom.Document;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;
import java.util.stream.Collectors;

public class DebitNoteAdminResource {

    private static final ServicesLogger logger = ServicesLogger.LOGGER;

    protected OrganizationModel organization;
    protected DebitNoteModel debitNote;
    @Context
    protected UriInfo uriInfo;
    @Context
    protected OpenfactSession session;
    @Context
    protected ClientConnection clientConnection;
    @Context
    protected HttpHeaders headers;
    private OrganizationAuth auth;
    private AdminEventBuilder adminEvent;

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
    public DebitNoteRepresentation getDebitNote(@QueryParam("includeXml") boolean includeXml) {
        auth.requireView();

        if (debitNote == null) {
            throw new NotFoundException("Debit Note not found");
        }

        DebitNoteRepresentation rep = ModelToRepresentation.toRepresentation(debitNote, includeXml);
        return rep;
    }

    @GET
    @Path("text")
    @NoCache
    @Produces("application/text")
    public Response getDebitNoteAsText() {
        auth.requireView();

        if (debitNote == null) {
            throw new NotFoundException("Invoice not found");
        }

        String text = null;
        try {
            Document document = DocumentUtils.byteToDocument(ArrayUtils.toPrimitive(debitNote.getXmlDocument()));
            text = DocumentUtils.getDocumentToString(document);
        } catch (Exception e) {
            return ErrorResponse.exists("Invalid xml");
        }

        Response.ResponseBuilder response = Response.ok(text);
        return response.build();
    }

    @GET
    @Path("xml")
    @NoCache
    @Produces("application/xml")
    public Response getDebitNoteAsXml() {
        auth.requireView();

        if (debitNote == null) {
            throw new NotFoundException("Debit Note not found");
        }

        Document document = null;
        try {
            document = DocumentUtils.byteToDocument(ArrayUtils.toPrimitive(debitNote.getXmlDocument()));
        } catch (Exception e) {
            return ErrorResponse.exists("Invalid xml");
        }

        Response.ResponseBuilder response = Response.ok((Object) document);
        response.header("Content-Disposition", "attachment; filename=\"" + debitNote.getID() + ".xml\"");
        return response.build();
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
	 * Get the debitNote report with the specified debitNoteId.
	 *
	 * @return The byte[] with the specified debitNoteId
	 * @throws Exception
	 * @summary Get the byte[] with the specified debitNoteId
	 */
	@GET
	@Path("pdf")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public byte[] getPdf() throws Exception {
		auth.requireView();

		if (debitNote == null) {
			throw new NotFoundException("Invoice not found");
		}
		ReportProvider provider = session.getProvider(ReportProvider.class);
		byte[] report = provider.processReport(debitNote);
		return report;
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
