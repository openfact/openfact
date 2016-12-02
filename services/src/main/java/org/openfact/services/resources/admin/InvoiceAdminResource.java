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
import org.openfact.common.ClientConnection;
import org.openfact.common.converts.DocumentUtils;
import org.openfact.events.admin.OperationType;
import org.openfact.models.InvoiceModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.models.utils.OpenfactModelUtils;
import org.openfact.representations.idm.InvoiceRepresentation;
import org.openfact.representations.idm.SendEventRepresentation;
import org.openfact.services.ErrorResponse;
import org.openfact.services.ServicesLogger;
import org.openfact.services.managers.InvoiceManager;
import org.openfact.ubl.SendEventModel;
import org.openfact.ubl.SendException;
import org.openfact.ubl.UBLInvoiceProvider;
import org.openfact.ubl.UBLReportProvider;
import org.w3c.dom.Document;

import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;

import java.util.List;
import java.util.stream.Collectors;

public class InvoiceAdminResource {

    private static final ServicesLogger logger = ServicesLogger.LOGGER;

    @Context
    protected UriInfo uriInfo;

    @Context
    protected OpenfactSession session;

    @Context
    protected ClientConnection clientConnection;

    @Context
    protected HttpHeaders headers;

    protected OrganizationModel organization;
    protected InvoiceModel invoice;

    private OrganizationAuth auth;
    private AdminEventBuilder adminEvent;

    public InvoiceAdminResource(OrganizationModel organization, OrganizationAuth auth,
            AdminEventBuilder adminEvent, InvoiceModel invoice) {
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

        Document document;
        try {
            document = DocumentUtils.byteToDocument(invoice.getXmlDocument());
        } catch (Exception e) {
            return ErrorResponse.exists("Invalid xml");
        }

        InvoiceType type = session.getProvider(UBLInvoiceProvider.class).reader().read(document);

        Response.ResponseBuilder response = Response.ok(type);
        return response.build();
    }

    @GET
    @Path("representation/text")
    @NoCache
    @Produces("application/text")
    public Response getInvoiceAsText() {
        auth.requireView();

        if (invoice == null) {
            throw new NotFoundException("Invoice not found");
        }

        String result = null;
        try {
            Document document = DocumentUtils.byteToDocument(invoice.getXmlDocument());
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

        if (invoice == null) {
            throw new NotFoundException("Invoice not found");
        }

        Document result = null;
        try {
            result = DocumentUtils.byteToDocument(invoice.getXmlDocument());
        } catch (Exception e) {
            return ErrorResponse.exists("Invalid xml parser");
        }

        Response.ResponseBuilder response = Response.ok((Object) result);
        return response.build();
    }

    /**
     * Get the invoice report with the specified invoiceId.
     *
     * @return The byte[] with the specified invoiceId
     * @throws Exception
     * @summary Get the byte[] with the specified invoiceId
     */
    @GET
    @Path("representation/pdf")
    @Produces("application/pdf")
    public Response getPdf(@QueryParam("theme") String theme) throws Exception {
        auth.requireView();

        if (invoice == null) {
            throw new NotFoundException("Invoice not found");
        }

        UBLReportProvider reportProvider = session.getProvider(UBLReportProvider.class);
        byte[] bytes = reportProvider.invoice().setOrganization(organization).setThemeName(theme).getReportAsPdf(invoice);

        ResponseBuilder response = Response.ok(bytes);
        response.type("application/pdf");
        response.header("content-disposition", "attachment; filename=\"" + invoice.getDocumentId() + ".pdf\"");
        return response.build();
    }

    /**
     * Deletes invoice with given invoiceId.
     *
     * @throws AuthorizationException
     *             The user is not authorized to delete this invoice.
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
    public void sendToCustomer() {
        auth.requireManage();

        if (invoice == null) {
            throw new NotFoundException("Invoice not found");
        }

        InvoiceManager invoiceManager = new InvoiceManager(session);
        try {
            invoiceManager.sendToCustomerParty(organization, invoice);
        } catch (SendException e) {
            throw new InternalServerErrorException(e);
        }
    }

    @POST
    @Path("send-to-third-party")
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public void sendToThridParty() {
        auth.requireManage();

        if (invoice == null) {
            throw new NotFoundException("Invoice not found");
        }

        InvoiceManager invoiceManager = new InvoiceManager(session);
        SendEventModel sentEvent;
        try {
            sentEvent = invoiceManager.sendToTrirdParty(organization, invoice);
        } catch (SendException e) {
            throw new InternalServerErrorException(e);
        }
    }

    @GET
    @Path("send-events")
    @Produces(MediaType.APPLICATION_JSON)
    public List<SendEventRepresentation> getSendEvents() {
        auth.requireView();

        if (invoice == null) {
            throw new NotFoundException("Invoice not found");
        }

        List<SendEventModel> sendEvents = invoice.getSendEvents();
        return sendEvents.stream().map(f -> ModelToRepresentation.toRepresentation(f)).collect(Collectors.toList());
    }

}
