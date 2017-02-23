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

import java.util.*;
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

    @PUT
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateDocument(DocumentRepresentation rep) {
        auth.requireManage();

        try {
            if (document == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            Set<String> actionsToRemove;
            if (rep.getRequiredActions() != null) {
                actionsToRemove = new HashSet<>(document.getRequiredActions());
                actionsToRemove.removeAll(rep.getRequiredActions());
            } else {
                actionsToRemove = Collections.emptySet();
            }

            updateDocumentFromRep(document, rep, actionsToRemove);
            adminEvent.operation(OperationType.UPDATE).resourcePath(uriInfo).representation(rep).success();

            if (session.getTransactionManager().isActive()) {
                session.getTransactionManager().commit();
            }
            return Response.noContent().build();
        } catch (ModelDuplicateException e) {
            return ErrorResponse.exists("Document exists with same documentId or id");
        } catch (ModelException me) {
            logger.warn("Could not update document!", me);
            return ErrorResponse.exists("Could not update user!");
        } catch (Exception me) { // JPA
            logger.warn("Could not update document!", me);// may be committed by JTA which can't
            return ErrorResponse.exists("Could not update document!");
        }
    }

    public static void updateDocumentFromRep(DocumentModel document, DocumentRepresentation rep, Set<String> actionsToRemove) {
        for (String action : actionsToRemove) {
            document.removeRequiredAction(action);
        }

        if (rep.getRequiredActions() != null) {
            Set<String> newActions = rep.getRequiredActions();
            newActions.removeAll(document.getRequiredActions());
            for (String action : newActions) {
                document.addRequiredAction(action);
            }
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
    public Response sendToCustomer() {
        auth.requireManage();

        if (document == null) {
            throw new NotFoundException("Document not found");
        }

        return sendDocument(session, organization, document, DestinyType.CUSTOMER, null);
    }

    @POST
    @Path("send-to-third-party")
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public Response sendToThirdParty() {
        auth.requireManage();

        if (document == null) {
            throw new NotFoundException("Document not found");
        }

        return sendDocument(session, organization, document, DestinyType.THIRD_PARTY, null);
    }

    @POST
    @Path("send-to-third-party-by-email")
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public Response sendToThirdPartyByEmail(ThirdPartyEmailRepresentation thirdParty) {
        auth.requireManage();

        if (document == null) {
            throw new NotFoundException("Document not found");
        }

        if (thirdParty == null || thirdParty.getEmail() == null) {
            throw new BadRequestException("Invalid email sended");
        }

        return sendDocument(session, organization, document, DestinyType.CUSTOM_EMAIL, thirdParty.getEmail());
    }

    private Response sendDocument(OpenfactSession session, OrganizationModel organization, DocumentModel document, DestinyType destiny, String customEmail) {
        DocumentManager manager = new DocumentManager(session);
        SendEventModel sendEvent = null;
        try {
            switch (destiny) {
                case CUSTOMER:
                    sendEvent = manager.sendToCustomerParty(organization, document);
                    break;
                case THIRD_PARTY:
                    sendEvent = manager.sendToThirdParty(organization, document);
                    break;
                case CUSTOM_EMAIL:
                    sendEvent = manager.sendToThirdPartyByEmail(organization, document, customEmail);
                    break;
                default:
                    throw new IllegalStateException("Invalid " + destiny + " type");
            }
        } catch (ModelInsuficientData e) {
            if (sendEvent != null) {
                sendEvent.setResult(SendEventStatus.ERROR);
                sendEvent.setDescription(e.getMessage());
            }
            return ErrorResponse.error(e.getMessage(), Response.Status.BAD_REQUEST);
        } catch (SendException e) {
            if (sendEvent != null) {
                sendEvent.setResult(SendEventStatus.ERROR);
                if (e.getMessage() != null) {
                    sendEvent.setDescription(e.getMessage().length() < 200 ? e.getMessage() : e.getMessage().substring(0, 197).concat("..."));
                } else {
                    sendEvent.setDescription("Internal Server Error");
                }
            }
            logger.error("Internal Server Error sending to customer", e);
            return ErrorResponse.error("Internal Server Error", Response.Status.INTERNAL_SERVER_ERROR);
        }

        return Response.ok(ModelToRepresentation.toRepresentation(sendEvent)).build();
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
