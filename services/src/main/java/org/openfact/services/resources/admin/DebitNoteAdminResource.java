/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.openfact.services.resources.admin;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriInfo;

import org.jboss.resteasy.annotations.cache.NoCache;
import org.json.JSONObject;
import org.json.XML;
import org.openfact.common.ClientConnection;
import org.openfact.common.converts.DocumentUtils;
import org.openfact.events.admin.OperationType;
import org.openfact.models.DebitNoteModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.report.ReportProvider;
import org.openfact.report.ReportTheme;
import org.openfact.report.ReportThemeProvider;
import org.openfact.representations.idm.DebitNoteRepresentation;
import org.openfact.services.ErrorResponse;
import org.openfact.services.ServicesLogger;
import org.openfact.services.managers.DebitNoteManager;
import org.w3c.dom.Document;

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
    public DebitNoteRepresentation getDebitNote() {
        auth.requireView();

        if (debitNote == null) {
            throw new NotFoundException("DebitNote not found");
        }

        DebitNoteRepresentation rep = ModelToRepresentation.toRepresentation(debitNote);
        return rep;
    }

    @GET
    @Path("representation/json")
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDebitNoteAsJson() {
        auth.requireView();

        if (debitNote == null) {
            throw new NotFoundException("DebitNote not found");
        }

        JSONObject result = null;
        try {
            Document document = DocumentUtils.byteToDocument(debitNote.getXmlDocument());
            String text = DocumentUtils.getDocumentToString(document);
            result = XML.toJSONObject(text);
        } catch (Exception e) {
            return ErrorResponse.exists("Invalid xml");
        }

        Response.ResponseBuilder response = Response.ok(result);
        return response.build();
    }

    @GET
    @Path("representation/text")
    @NoCache
    @Produces("application/text")
    public Response getDebitNoteAsText() {
        auth.requireView();

        if (debitNote == null) {
            throw new NotFoundException("DebitNote not found");
        }

        String result = null;
        try {
            Document document = DocumentUtils.byteToDocument(debitNote.getXmlDocument());
            result = DocumentUtils.getDocumentToString(document);
        } catch (Exception e) {
            return ErrorResponse.exists("Invalid xml");
        }

        Response.ResponseBuilder response = Response.ok(result);
        return response.build();
    }

    @GET
    @Path("representation/xml")
    @NoCache
    @Produces("application/xml")
    public Response getDebitNoteAsXml() {
        auth.requireView();

        if (debitNote == null) {
            throw new NotFoundException("DebitNote not found");
        }

        Document result = null;
        try {
            result = DocumentUtils.byteToDocument(debitNote.getXmlDocument());
        } catch (Exception e) {
            return ErrorResponse.exists("Invalid xml parser");
        }

        Response.ResponseBuilder response = Response.ok((Object) result);
        return response.build();
    }

    /**
     * Get the debitNote report with the specified debitNoteId.
     *
     * @return The byte[] with the specified debitNoteId
     * @throws Exception
     * @summary Get the byte[] with the specified debitNoteId
     */
    @GET
    @Path("representation/pdf")
    @Produces("application/pdf")
    public Response getPdf(@PathParam("themeType") String themType, @PathParam("themeName") String themeName)
            throws Exception {
        auth.requireView();

        if (debitNote == null) {
            throw new NotFoundException("DebitNote not found");
        }
        ReportThemeProvider themeProvider = session.getProvider(ReportThemeProvider.class, "extending");
        ReportTheme theme = themeProvider.getReportTheme(themeName,
                ReportTheme.Type.valueOf(themType.toUpperCase()));
        ReportProvider provider = session.getProvider(ReportProvider.class, themeName);
        byte[] report = provider.processReport(debitNote, theme);
        ResponseBuilder response = Response.ok(report);
        response.type("application/pdf");
        response.header("content-disposition",
                "attachment; filename=\"" + debitNote.getDocumentId() + ".pdf\"");
        return response.build();
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
            throw new NotFoundException("DebitNote not found");
        }

        boolean removed = new DebitNoteManager(session).removeDebitNote(organization, debitNote);
        if (removed) {
            adminEvent.operation(OperationType.DELETE).resourcePath(uriInfo).success();
            return Response.noContent().build();
        } else {
            return ErrorResponse.error("DebitNote couldn't be deleted", Response.Status.BAD_REQUEST);
        }
    }

}
