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
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriInfo;

import org.jboss.resteasy.annotations.cache.NoCache;
import org.json.JSONObject;
import org.json.XML;
import org.openfact.OpenfactJSONObject;
import org.openfact.common.ClientConnection;
import org.openfact.common.converts.DocumentUtils;
import org.openfact.events.admin.OperationType;
import org.openfact.models.*;
import org.openfact.models.enums.DestinyType;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.report.ExportFormat;
import org.openfact.report.ReportTemplateProvider;
import org.openfact.report.ReportTheme;
import org.openfact.report.ReportThemeProvider;
import org.openfact.representations.idm.DebitNoteRepresentation;
import org.openfact.representations.idm.SendEventRepresentation;
import org.openfact.representations.idm.ThirdPartyEmailRepresentation;
import org.openfact.services.ErrorResponse;
import org.openfact.services.ServicesLogger;
import org.openfact.services.managers.DebitNoteManager;
import org.openfact.services.managers.DebitNoteManager;
import org.openfact.services.scheduled.ScheduledTaskRunner;
import org.openfact.timer.ScheduledTask;
import org.openfact.ubl.UBLReportProvider;
import org.w3c.dom.Document;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class DebitNoteAdminResource {

    private static final ServicesLogger logger = ServicesLogger.LOGGER;
    
    @Context
    protected UriInfo uriInfo;
    
    @Context
    protected OpenfactSession session;
    
    @Context
    protected ClientConnection clientConnection;
    @Context

    protected OrganizationModel organization;
    protected DebitNoteModel debitNote;
    
    private OrganizationAuth auth;
    private AdminEventBuilder adminEvent;

    public DebitNoteAdminResource(OrganizationModel organization, OrganizationAuth auth, AdminEventBuilder adminEvent, DebitNoteModel debitNote) {
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
    @Path("representation/json")
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDebitNoteAsJson() {
        auth.requireView();

        if (debitNote == null) {
            throw new NotFoundException("DebitNote not found");
        }

        OpenfactJSONObject jsonObject = debitNote.getXmlAsJSONObject();
        if (jsonObject != null) {
            return Response.ok(jsonObject.getJsonObject().toString()).build();
        } else {
            return ErrorResponse.exists("No json attached to current debit note");
        }
    }

    @GET
    @Path("representation/xml")
    @NoCache
    @Produces("application/xml")
    public Response getDebitNoteAsXml() {
        auth.requireView();

        if (debitNote == null) {
            throw new NotFoundException("Debit Note not found");
        }

        Document document = debitNote.getXmlAsDocument();
        if (document != null) {
            return Response.ok(document).build();
        } else {
            return ErrorResponse.exists("No xml document attached to current debit note");
        }
    }

    /**
     * Get the debitNote report with the specified debitNoteId.
     *
     * @return The byte[] with the specified debitNoteId
     * @throws Exception
     * @summary Get the byte[] with the specified debitNoteId
     */
    @GET
    @Path("report")
    public Response getPdf(
            @QueryParam("theme") String theme,
            @QueryParam("format") @DefaultValue("pdf") String format) throws Exception {

        auth.requireView();

        if (debitNote == null) {
            throw new NotFoundException("Debit Note not found");
        }

        ExportFormat exportFormat = ExportFormat.valueOf(format.toUpperCase());

        byte[] reportBytes = session.getProvider(UBLReportProvider.class).debitNote()
                .setOrganization(organization)
                .setThemeName(theme)
                .getReport(debitNote, exportFormat);

        ResponseBuilder response = Response.ok(reportBytes);
        switch (exportFormat) {
            case PDF:
                response.type("application/pdf");
                response.header("content-disposition", "attachment; filename=\"" + debitNote.getDocumentId() + ".pdf\"");
                break;
            case HTML:
                response.type("application/html");
                break;
        }
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

    @POST
    @Path("send-to-customer")
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public void sendToCustomer() {
        auth.requireManage();

        if (debitNote == null) {
            throw new NotFoundException("DebitNote not found");
        }

        SendEventModel sendEvent = debitNote.addSendEvent(DestinyType.CUSTOMER);

        // Thread
        ExecutorService executorService = null;
        try {
            executorService = Executors.newCachedThreadPool();

            ScheduledTaskRunner scheduledTaskRunner = new ScheduledTaskRunner(session.getOpenfactSessionFactory(), new ScheduledTask() {
                @Override
                public void run(OpenfactSession session) {
                    DebitNoteManager debitNoteManager = new DebitNoteManager(session);
                    try {
                        OrganizationModel organizationThread = session.organizations().getOrganization(organization.getId());
                        DebitNoteModel debitNoteThread = session.debitNotes().getDebitNoteById(organizationThread, debitNote.getId());
                        SendEventModel sendEventThread = debitNoteThread.getSendEventById(sendEvent.getId());

                        debitNoteManager.sendToCustomerParty(organizationThread, debitNoteThread, sendEventThread);
                    } catch (SendException e) {
                        throw new InternalServerErrorException(e);
                    }
                }
            });
            executorService.execute(scheduledTaskRunner);
        } finally {
            if (executorService != null) {
                executorService.shutdown();
            }
        }
    }

    @POST
    @Path("send-to-third-party")
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public void sendToThirdParty() {
        auth.requireManage();

        if (debitNote == null) {
            throw new NotFoundException("DebitNote not found");
        }

        SendEventModel sendEvent = debitNote.addSendEvent(DestinyType.CUSTOMER);

        // Thread
        ExecutorService executorService = null;
        try {
            executorService = Executors.newCachedThreadPool();

            ScheduledTaskRunner scheduledTaskRunner = new ScheduledTaskRunner(session.getOpenfactSessionFactory(), new ScheduledTask() {
                @Override
                public void run(OpenfactSession session) {
                    DebitNoteManager debitNoteManager = new DebitNoteManager(session);
                    try {
                        OrganizationModel organizationThread = session.organizations().getOrganization(organization.getId());
                        DebitNoteModel debitNoteThread = session.debitNotes().getDebitNoteById(organizationThread, debitNote.getId());
                        SendEventModel sendEventThread = debitNoteThread.getSendEventById(sendEvent.getId());

                        debitNoteManager.sendToTrirdParty(organizationThread, debitNoteThread, sendEventThread);
                    } catch (SendException e) {
                        throw new InternalServerErrorException(e);
                    }
                }
            });
            executorService.execute(scheduledTaskRunner);
        } finally {
            if (executorService != null) {
                executorService.shutdown();
            }
        }
    }

    @POST
    @Path("send-to-third-party-by-email")
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public void sendToThirdPartyByEmail(ThirdPartyEmailRepresentation thirdParty) {
        auth.requireManage();

        if (debitNote == null) {
            throw new NotFoundException("DebitNote not found");
        }

        if (thirdParty == null || thirdParty.getEmail() == null) {
            throw new BadRequestException("Invalid email sended");
        }

        SendEventModel sendEvent = debitNote.addSendEvent(DestinyType.THIRD_PARTY_BY_EMAIL);

        // Thread
        ExecutorService executorService = null;
        try {
            executorService = Executors.newCachedThreadPool();

            ScheduledTaskRunner scheduledTaskRunner = new ScheduledTaskRunner(session.getOpenfactSessionFactory(), new ScheduledTask() {
                @Override
                public void run(OpenfactSession session) {
                    DebitNoteManager debitNoteManager = new DebitNoteManager(session);
                    try {
                        OrganizationModel organizationThread = session.organizations().getOrganization(organization.getId());
                        DebitNoteModel debitNoteThread = session.debitNotes().getDebitNoteById(organizationThread, debitNote.getId());
                        SendEventModel sendEventThread = debitNoteThread.getSendEventById(sendEvent.getId());

                        debitNoteManager.sendToThirdPartyByEmail(organizationThread, debitNoteThread, sendEventThread, thirdParty.getEmail());
                    } catch (SendException e) {
                        throw new InternalServerErrorException(e);
                    }
                }
            });
            executorService.execute(scheduledTaskRunner);
        } finally {
            if (executorService != null) {
                executorService.shutdown();
            }
        }
    }

    @GET
    @Path("send-events")
    @Produces(MediaType.APPLICATION_JSON)
    public List<SendEventRepresentation> getSendEvents(
            @QueryParam("destinyType") String destinyType,
            @QueryParam("type") String type,
            @QueryParam("result") String result,
            @QueryParam("first") Integer firstResult,
            @QueryParam("max") Integer maxResults) {

        auth.requireView();

        if (debitNote == null) {
            throw new NotFoundException("DebitNote not found");
        }

        firstResult = firstResult != null ? firstResult : -1;
        maxResults = maxResults != null ? maxResults : Constants.DEFAULT_MAX_RESULTS;

        List<SendEventModel> sendEventModels;
        if (destinyType != null || type != null || result != null) {
            Map<String, String> attributes = new HashMap<>();
            if (destinyType != null) {
                attributes.put(DebitNoteModel.SEND_EVENT_DESTINY_TYPE, destinyType);
            }
            if (type != null) {
                attributes.put(DebitNoteModel.SEND_EVENT_TYPE, type);
            }
            if (result != null) {
                attributes.put(DebitNoteModel.SEND_EVENT_RESULT, result);
            }
            sendEventModels = debitNote.searchForSendEvent(attributes, firstResult, maxResults);
        } else {
            sendEventModels = debitNote.getSendEvents(firstResult, maxResults);
        }

        return sendEventModels.stream()
                .map(f -> ModelToRepresentation.toRepresentation(f))
                .collect(Collectors.toList());
    }

}
