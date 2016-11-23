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
import org.openfact.models.CreditNoteModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.report.ReportProvider;
import org.openfact.report.ReportTheme;
import org.openfact.report.ReportThemeProvider;
import org.openfact.representations.idm.CreditNoteRepresentation;
import org.openfact.services.ErrorResponse;
import org.openfact.services.ServicesLogger;
import org.openfact.services.managers.CreditNoteManager;
import org.w3c.dom.Document;

public class CreditNoteAdminResource {

    private static final ServicesLogger logger = ServicesLogger.LOGGER;

    protected OrganizationModel organization;
    protected CreditNoteModel creditNote;
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

    public CreditNoteAdminResource(OrganizationModel organization, OrganizationAuth auth,
            AdminEventBuilder adminEvent, CreditNoteModel creditNote) {
        this.auth = auth;
        this.organization = organization;
        this.adminEvent = adminEvent;
        this.creditNote = creditNote;

        auth.init(OrganizationAuth.Resource.CREDIT_NOTE);
    }

    /**
     * Get the creditNote with the specified creditNoteId.
     *
     * @return The creditNote with the specified creditNoteId
     * @summary Get the creditNote with the specified creditNoteId
     */
    @GET
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public CreditNoteRepresentation getCreditNote() {
        auth.requireView();

        if (creditNote == null) {
            throw new NotFoundException("CreditNote not found");
        }

        CreditNoteRepresentation rep = ModelToRepresentation.toRepresentation(creditNote);
        return rep;
    }

    @GET
    @Path("representation/json")
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCreditNoteAsJson() {
        auth.requireView();

        if (creditNote == null) {
            throw new NotFoundException("CreditNote not found");
        }

        JSONObject result = null;
        try {
            Document document = DocumentUtils.byteToDocument(creditNote.getXmlDocument());
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
    public Response getCreditNoteAsText() {
        auth.requireView();

        if (creditNote == null) {
            throw new NotFoundException("CreditNote not found");
        }

        String result = null;
        try {
            Document document = DocumentUtils.byteToDocument(creditNote.getXmlDocument());
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
    public Response getCreditNoteAsXml() {
        auth.requireView();

        if (creditNote == null) {
            throw new NotFoundException("CreditNote not found");
        }

        Document result = null;
        try {
            result = DocumentUtils.byteToDocument(creditNote.getXmlDocument());
        } catch (Exception e) {
            return ErrorResponse.exists("Invalid xml parser");
        }

        Response.ResponseBuilder response = Response.ok((Object) result);
        return response.build();
    }

    /**
     * Get the creditNote report with the specified creditNoteId.
     *
     * @return The byte[] with the specified creditNoteId
     * @throws Exception
     * @summary Get the byte[] with the specified creditNoteId
     */
    @GET
    @Path("representation/pdf")
    @Produces("application/pdf")
    public Response getPdf(@PathParam("themeType") String themType, @PathParam("themeName") String themeName)
            throws Exception {
        auth.requireView();

        if (creditNote == null) {
            throw new NotFoundException("CreditNote not found");
        }
        ReportThemeProvider themeProvider = session.getProvider(ReportThemeProvider.class, "extending");
        ReportTheme theme = themeProvider.getReportTheme(themeName,
                ReportTheme.Type.valueOf(themType.toUpperCase()));
        ReportProvider provider = session.getProvider(ReportProvider.class, themeName);
        byte[] report = provider.processReport(creditNote, theme);
        ResponseBuilder response = Response.ok(report);
        response.type("application/pdf");
        response.header("content-disposition",
                "attachment; filename=\"" + creditNote.getDocumentId() + ".pdf\"");
        return response.build();
    }

    /**
     * Deletes creditNote with given creditNoteId.
     *
     * @throws AuthorizationException
     *             The user is not authorized to delete this creditNote.
     */
    @DELETE
    public Response deleteCreditNote() {
        auth.requireManage();

        if (creditNote == null) {
            throw new NotFoundException("CreditNote not found");
        }

        boolean removed = new CreditNoteManager(session).removeCreditNote(organization, creditNote);
        if (removed) {
            adminEvent.operation(OperationType.DELETE).resourcePath(uriInfo).success();
            return Response.noContent().build();
        } else {
            return ErrorResponse.error("CreditNote couldn't be deleted", Response.Status.BAD_REQUEST);
        }
    }

}
