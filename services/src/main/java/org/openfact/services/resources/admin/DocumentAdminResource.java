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

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriInfo;

import org.jboss.resteasy.annotations.cache.NoCache;
import org.json.JSONObject;
import org.openfact.common.ClientConnection;
import org.openfact.events.admin.OperationType;
import org.openfact.models.*;
import org.openfact.models.enums.DestinyType;
import org.openfact.models.enums.SendEventStatus;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.models.utils.OpenfactModelUtils;
import org.openfact.report.ExportFormat;
import org.openfact.report.ReportException;
import org.openfact.representations.idm.DocumentRepresentation;
import org.openfact.representations.idm.SendEventRepresentation;
import org.openfact.representations.idm.ThirdPartyEmailRepresentation;
import org.openfact.services.ErrorResponse;
import org.openfact.services.ServicesLogger;
import org.openfact.services.managers.DocumentManager;
import org.openfact.models.SendEventModel;
import org.openfact.models.SendException;
import org.openfact.ubl.UBLReportProvider;
import org.w3c.dom.Document;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DocumentAdminResource {

    private static final ServicesLogger logger = ServicesLogger.LOGGER;

    @Context
    protected UriInfo uriInfo;

    @Context
    protected OpenfactSession session;

    @Context
    protected ClientConnection clientConnection;

    protected OrganizationModel organization;
    protected DocumentModel document;

    private OrganizationAuth auth;
    private AdminEventBuilder adminEvent;

    public DocumentAdminResource(OrganizationModel organization, OrganizationAuth auth, AdminEventBuilder adminEvent, DocumentModel document) {
        this.auth = auth;
        this.organization = organization;
        this.adminEvent = adminEvent;
        this.document = document;

        auth.init(OrganizationAuth.Resource.DOCUMENT);
    }

    /**
     * Get the document with the specified documentId.
     *
     * @return The document with the specified documentId
     * @summary Get the document with the specified documentId
     */
    @GET
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public DocumentRepresentation getDocument() {
        auth.requireView();

        if (document == null) {
            throw new NotFoundException("Document not found");
        }

        DocumentRepresentation rep = ModelToRepresentation.toRepresentation(document);
        return rep;
    }

    @GET
    @Path("representation/json")
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDocumentAsJson() {
        auth.requireView();

        if (document == null) {
            throw new NotFoundException("Document not found");
        }

        JSONObject jsonObject = document.getXmlAsJSONObject();
        if (jsonObject != null) {
            return Response.ok(jsonObject.toString()).build();
        } else {
            return ErrorResponse.exists("No json attached to current document");
        }
    }

    @GET
    @Path("representation/xml")
    @NoCache
    @Produces("application/xml")
    public Response getDebitNoteAsXml() {
        auth.requireView();

        if (document == null) {
            throw new NotFoundException("Document not found");
        }

        Document document = this.document.getXmlAsDocument();
        if (document != null) {
            return Response.ok(document).build();
        } else {
            return ErrorResponse.exists("No xml document attached to current document");
        }
    }

    /**
     * Get the document report with the specified documentId.
     *
     * @return The byte[] with the specified documentId
     * @throws Exception
     * @summary Get the byte[] with the specified documentId
     */
    @GET
    @Path("report")
    public Response getPdf(
            @QueryParam("theme") String theme,
            @QueryParam("format") @DefaultValue("pdf") String format) {

        auth.requireView();

        if (document == null) {
            throw new NotFoundException("Document not found");
        }

        ExportFormat exportFormat = ExportFormat.valueOf(format.toUpperCase());

        try {
            byte[] reportBytes = session.getProvider(UBLReportProvider.class)
                    .document()
                    .setOrganization(organization)
                    .setThemeName(theme)
                    .getReport(document, exportFormat);

            ResponseBuilder response = Response.ok(reportBytes);
            switch (exportFormat) {
                case PDF:
                    response.type("application/pdf");
                    response.header("content-disposition", "attachment; filename=\"" + document.getDocumentId() + ".pdf\"");
                    break;
                case HTML:
                    response.type("application/html");
                    break;
            }

            return response.build();
        } catch (ReportException e) {
            return ErrorResponse.error("Error generating report", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Deletes document with given documentId.
     *
     * @throws AuthorizationException The user is not authorized to delete this document.
     */
    @DELETE
    public Response deleteDocument() {
        auth.requireManage();

        if (document == null) {
            throw new NotFoundException("Document not found");
        }

        boolean removed = new DocumentManager(session).removeDocument(organization, document);
        if (removed) {
            adminEvent.operation(OperationType.DELETE).resourcePath(uriInfo).success();
            return Response.noContent().build();
        } else {
            return ErrorResponse.error("Document couldn't be deleted", Response.Status.BAD_REQUEST);
        }
    }

    @POST
    @Path("send-to-customer")
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public SendEventRepresentation sendToCustomer() {
        auth.requireManage();

        if (document == null) {
            throw new NotFoundException("Document not found");
        }

        SendEventModel sendEvent = document.addSendEvent(DestinyType.CUSTOMER);

        OpenfactModelUtils.runThreadInTransaction(session.getOpenfactSessionFactory(), sessionThread -> {
            DocumentManager manager = new DocumentManager(sessionThread);

            OrganizationModel organizationThread = sessionThread.organizations().getOrganization(organization.getId());
            DocumentModel documentThread = sessionThread.documents().getDocumentById(document.getId(), organizationThread);
            SendEventModel sendEventThread = documentThread.getSendEventById(sendEvent.getId());
            try {
                manager.sendToCustomerParty(organizationThread, documentThread, sendEventThread);
            } catch (ModelInsuficientData e) {
                sendEventThread.setResult(SendEventStatus.ERROR);
                sendEventThread.setDescription(e.getMessage());
            } catch (SendException e) {
                sendEventThread.setResult(SendEventStatus.ERROR);
                if (e.getMessage() != null) {
                    sendEventThread.setDescription(e.getMessage().length() < 200 ? e.getMessage() : e.getMessage().substring(0, 197).concat("..."));
                } else {
                    sendEventThread.setDescription("Internal Server Error");
                }
                logger.error("Internal Server Error sending to customer", e);
            }
        });

        return ModelToRepresentation.toRepresentation(sendEvent);
    }

    @POST
    @Path("send-to-third-party")
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public SendEventRepresentation sendToThirdParty() {
        auth.requireManage();

        if (document == null) {
            throw new NotFoundException("Document not found");
        }

        SendEventModel sendEvent = document.addSendEvent(DestinyType.THIRD_PARTY);

        OpenfactModelUtils.runThreadInTransaction(session.getOpenfactSessionFactory(), sessionThread -> {
            DocumentManager manager = new DocumentManager(sessionThread);

            OrganizationModel organizationThread = sessionThread.organizations().getOrganization(organization.getId());
            DocumentModel documentThread = sessionThread.documents().getDocumentById(document.getId(), organizationThread);
            SendEventModel sendEventThread = documentThread.getSendEventById(sendEvent.getId());
            try {
                manager.sendToThirdParty(organizationThread, documentThread, sendEventThread);
            } catch (ModelInsuficientData e) {
                sendEventThread.setResult(SendEventStatus.ERROR);
                sendEventThread.setDescription(e.getMessage());
            } catch (SendException e) {
                sendEventThread.setResult(SendEventStatus.ERROR);
                if (e.getMessage() != null) {
                    sendEventThread.setDescription(e.getMessage().length() < 200 ? e.getMessage() : e.getMessage().substring(0, 197).concat("..."));
                } else {
                    sendEventThread.setDescription("Internal Server Error");
                }
                logger.error("Internal Server Error sending to third party", e);
            }
        });

        return ModelToRepresentation.toRepresentation(sendEvent);
    }

    @POST
    @Path("send-to-third-party-by-email")
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public SendEventRepresentation sendToThirdPartyByEmail(ThirdPartyEmailRepresentation thirdParty) {
        auth.requireManage();

        if (document == null) {
            throw new NotFoundException("Document not found");
        }

        if (thirdParty == null || thirdParty.getEmail() == null) {
            throw new BadRequestException("Invalid email sended");
        }

        SendEventModel sendEvent = document.addSendEvent(DestinyType.CUSTOM_EMAIL);

        OpenfactModelUtils.runThreadInTransaction(session.getOpenfactSessionFactory(), sessionThread -> {
            DocumentManager manager = new DocumentManager(sessionThread);

            OrganizationModel organizationThread = sessionThread.organizations().getOrganization(organization.getId());
            DocumentModel documentThread = sessionThread.documents().getDocumentById(document.getId(), organizationThread);
            SendEventModel sendEventThread = documentThread.getSendEventById(sendEvent.getId());
            try {
                manager.sendToThirdPartyByEmail(organizationThread, documentThread, thirdParty.getEmail());
            } catch (ModelInsuficientData e) {
                sendEventThread.setResult(SendEventStatus.ERROR);
                sendEventThread.setDescription(e.getMessage());
            } catch (SendException e) {
                sendEventThread.setResult(SendEventStatus.ERROR);
                if (e.getMessage() != null) {
                    sendEventThread.setDescription(e.getMessage().length() < 200 ? e.getMessage() : e.getMessage().substring(0, 197).concat("..."));
                } else {
                    sendEventThread.setDescription("Internal Server Error");
                }
                logger.error("Internal Server Error sending to customer", e);
            }
        });

        return ModelToRepresentation.toRepresentation(sendEvent);
    }

    @GET
    @Path("send-events")
    @Produces(MediaType.APPLICATION_JSON)
    public List<SendEventRepresentation> getSendEvents(
            @QueryParam("destinyType") String destinyType,
            @QueryParam("result") String result,
            @QueryParam("first") Integer firstResult,
            @QueryParam("max") Integer maxResults) {

        auth.requireView();

        if (document == null) {
            throw new NotFoundException("Document not found");
        }

        firstResult = firstResult != null ? firstResult : -1;
        maxResults = maxResults != null ? maxResults : Constants.DEFAULT_MAX_RESULTS;

        List<SendEventModel> sendEventModels;
        if (destinyType != null || result != null) {
            Map<String, String> attributes = new HashMap<>();
            if (destinyType != null) {
                attributes.put(DocumentModel.SEND_EVENT_DESTINY, destinyType);
            }
            if (result != null) {
                attributes.put(DocumentModel.SEND_EVENT_STATUS, result);
            }
            sendEventModels = document.searchForSendEvent(attributes, firstResult, maxResults);
        } else {
            sendEventModels = document.getSendEvents(firstResult, maxResults);
        }

        return sendEventModels.stream()
                .map(f -> ModelToRepresentation.toRepresentation(f))
                .collect(Collectors.toList());
    }

}
