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
import org.openfact.models.enums.SendResultType;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.models.utils.OpenfactModelUtils;
import org.openfact.report.ExportFormat;
import org.openfact.representations.idm.InvoiceRepresentation;
import org.openfact.representations.idm.SendEventRepresentation;
import org.openfact.representations.idm.ThirdPartyEmailRepresentation;
import org.openfact.services.ErrorResponse;
import org.openfact.services.ServicesLogger;
import org.openfact.services.managers.InvoiceManager;
import org.openfact.models.SendEventModel;
import org.openfact.models.SendException;
import org.openfact.ubl.UBLReportProvider;
import org.w3c.dom.Document;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InvoiceAdminResource {

    private static final ServicesLogger logger = ServicesLogger.LOGGER;

    @Context
    protected UriInfo uriInfo;

    @Context
    protected OpenfactSession session;

    @Context
    protected ClientConnection clientConnection;

    protected OrganizationModel organization;
    protected InvoiceModel invoice;

    private OrganizationAuth auth;
    private AdminEventBuilder adminEvent;

    public InvoiceAdminResource(OrganizationModel organization, OrganizationAuth auth, AdminEventBuilder adminEvent, InvoiceModel invoice) {
        this.auth = auth;
        this.organization = organization;
        this.adminEvent = adminEvent;
        this.invoice = invoice;

        auth.init(OrganizationAuth.Resource.INVOICE);
    }

    /**
     * Get the invoice with the specified invoiceId.
     *
     * @return The invoice with the specified invoiceId
     * @summary Get the invoice with the specified invoiceId
     */
    @GET
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public InvoiceRepresentation getInvoice() {
        auth.requireView();

        if (invoice == null) {
            throw new NotFoundException("Invoice not found");
        }

        InvoiceRepresentation rep = ModelToRepresentation.toRepresentation(invoice);
        return rep;
    }

    @GET
    @Path("representation/json")
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInvoiceAsJson() {
        auth.requireView();

        if (invoice == null) {
            throw new NotFoundException("Invoice not found");
        }

        JSONObject jsonObject = invoice.getXmlAsJSONObject();
        if (jsonObject != null) {
            return Response.ok(jsonObject.toString()).build();
        } else {
            return ErrorResponse.exists("No json attached to current invoice");
        }
    }

    @GET
    @Path("representation/xml")
    @NoCache
    @Produces("application/xml")
    public Response getDebitNoteAsXml() {
        auth.requireView();

        if (invoice == null) {
            throw new NotFoundException("Invoice not found");
        }

        Document document = invoice.getXmlAsDocument();
        if (document != null) {
            return Response.ok(document).build();
        } else {
            return ErrorResponse.exists("No xml document attached to current invoice");
        }
    }

    /**
     * Get the invoice report with the specified invoiceId.
     *
     * @return The byte[] with the specified invoiceId
     * @throws Exception
     * @summary Get the byte[] with the specified invoiceId
     */
    @GET
    @Path("report")
    public Response getPdf(
            @QueryParam("theme") String theme,
            @QueryParam("format") @DefaultValue("pdf") String format) throws Exception {

        auth.requireView();

        if (invoice == null) {
            throw new NotFoundException("Invoice not found");
        }

        ExportFormat exportFormat = ExportFormat.valueOf(format.toUpperCase());

        byte[] reportBytes = session.getProvider(UBLReportProvider.class).invoice()
                .setOrganization(organization)
                .setThemeName(theme)
                .getReport(invoice, exportFormat);

        ResponseBuilder response = Response.ok(reportBytes);
        switch (exportFormat) {
            case PDF:
                response.type("application/pdf");
                response.header("content-disposition", "attachment; filename=\"" + invoice.getDocumentId() + ".pdf\"");
                break;
            case HTML:
                response.type("application/html");
                break;
        }
        return response.build();
    }

    /**
     * Deletes invoice with given invoiceId.
     *
     * @throws AuthorizationException The user is not authorized to delete this invoice.
     */
    @DELETE
    public Response deleteInvoice() {
        auth.requireManage();

        if (invoice == null) {
            throw new NotFoundException("Invoice not found");
        }

        boolean removed = new InvoiceManager(session).removeInvoice(organization, invoice);
        if (removed) {
            adminEvent.operation(OperationType.DELETE).resourcePath(uriInfo).success();
            return Response.noContent().build();
        } else {
            return ErrorResponse.error("Invoice couldn't be deleted", Response.Status.BAD_REQUEST);
        }
    }

    @POST
    @Path("send-to-customer")
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public SendEventRepresentation sendToCustomer() {
        auth.requireManage();

        if (invoice == null) {
            throw new NotFoundException("Invoice not found");
        }

        SendEventModel sendEvent = invoice.addSendEvent(DestinyType.CUSTOMER);

        OpenfactModelUtils.runThreadInTransaction(session.getOpenfactSessionFactory(), sessionThread -> {
            InvoiceManager manager = new InvoiceManager(sessionThread);

            OrganizationModel organizationThread = sessionThread.organizations().getOrganization(organization.getId());
            InvoiceModel invoiceThread = sessionThread.invoices().getInvoiceById(organizationThread, invoice.getId());
            SendEventModel sendEventThread = invoiceThread.getSendEventById(sendEvent.getId());
            try {
                manager.sendToCustomerParty(organizationThread, invoiceThread, sendEventThread);
            } catch (ModelInsuficientData e) {
                sendEvent.setResult(SendResultType.ERROR);
                sendEvent.setDescription(e.getMessage());
            } catch (SendException e) {
                sendEvent.setResult(SendResultType.ERROR);
                sendEvent.setDescription("Internal server error");
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

        if (invoice == null) {
            throw new NotFoundException("Invoice not found");
        }

        SendEventModel sendEvent = invoice.addSendEvent(DestinyType.THIRD_PARTY);

        OpenfactModelUtils.runThreadInTransaction(session.getOpenfactSessionFactory(), sessionThread -> {
            InvoiceManager manager = new InvoiceManager(sessionThread);

            OrganizationModel organizationThread = sessionThread.organizations().getOrganization(organization.getId());
            InvoiceModel invoiceThread = sessionThread.invoices().getInvoiceById(organizationThread, invoice.getId());
            SendEventModel sendEventThread = invoiceThread.getSendEventById(sendEvent.getId());
            try {
                manager.sendToTrirdParty(organizationThread, invoiceThread, sendEventThread);
            } catch (ModelInsuficientData e) {
                sendEvent.setResult(SendResultType.ERROR);
                sendEvent.setDescription(e.getMessage());
            } catch (SendException e) {
                sendEvent.setResult(SendResultType.ERROR);
                sendEvent.setDescription("Internal server error");
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

        if (invoice == null) {
            throw new NotFoundException("Invoice not found");
        }

        if (thirdParty == null || thirdParty.getEmail() == null) {
            throw new BadRequestException("Invalid email sended");
        }

        SendEventModel sendEvent = invoice.addSendEvent(DestinyType.THIRD_PARTY_BY_EMAIL);

        OpenfactModelUtils.runThreadInTransaction(session.getOpenfactSessionFactory(), sessionThread -> {
            InvoiceManager manager = new InvoiceManager(sessionThread);

            OrganizationModel organizationThread = sessionThread.organizations().getOrganization(organization.getId());
            InvoiceModel invoiceThread = sessionThread.invoices().getInvoiceById(organizationThread, invoice.getId());
            SendEventModel sendEventThread = invoiceThread.getSendEventById(sendEvent.getId());
            try {
                manager.sendToThirdPartyByEmail(organizationThread, invoiceThread, thirdParty.getEmail());
            } catch (ModelInsuficientData e) {
                sendEvent.setResult(SendResultType.ERROR);
                sendEvent.setDescription(e.getMessage());
            } catch (SendException e) {
                sendEvent.setResult(SendResultType.ERROR);
                sendEvent.setDescription("Internal server error");
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
            @QueryParam("type") String type,
            @QueryParam("result") String result,
            @QueryParam("first") Integer firstResult,
            @QueryParam("max") Integer maxResults) {

        auth.requireView();

        if (invoice == null) {
            throw new NotFoundException("Invoice not found");
        }

        firstResult = firstResult != null ? firstResult : -1;
        maxResults = maxResults != null ? maxResults : Constants.DEFAULT_MAX_RESULTS;

        List<SendEventModel> sendEventModels;
        if (destinyType != null || type != null || result != null) {
            Map<String, String> attributes = new HashMap<>();
            if (destinyType != null) {
                attributes.put(InvoiceModel.SEND_EVENT_DESTINY_TYPE, destinyType);
            }
            if (type != null) {
                attributes.put(InvoiceModel.SEND_EVENT_TYPE, type);
            }
            if (result != null) {
                attributes.put(InvoiceModel.SEND_EVENT_RESULT, result);
            }
            sendEventModels = invoice.searchForSendEvent(attributes, firstResult, maxResults);
        } else {
            sendEventModels = invoice.getSendEvents(firstResult, maxResults);
        }

        return sendEventModels.stream()
                .map(f -> ModelToRepresentation.toRepresentation(f))
                .collect(Collectors.toList());
    }

}
