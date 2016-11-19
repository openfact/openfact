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
import org.openfact.models.ModelException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.utils.ModelToReport;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.report.ReportProvider;
import org.openfact.report.ReportTheme;
import org.openfact.report.ReportTheme.Type;
import org.openfact.representations.idm.report.InvoiceReport;
import org.openfact.representations.idm.ubl.InvoiceRepresentation;
import org.openfact.representations.idm.ubl.common.InvoiceLineRepresentation;
import org.openfact.services.ErrorResponse;
import org.openfact.services.ServicesLogger;
import org.openfact.services.managers.InvoiceManager;
import org.openfact.ubl.UblIDGeneratorProvider;
import org.w3c.dom.Document;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

public class InvoiceAdminResource {

	private static final ServicesLogger logger = ServicesLogger.LOGGER;

	protected OrganizationModel organization;
	protected InvoiceModel invoice;
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

	public InvoiceAdminResource(OrganizationModel organization, OrganizationAuth auth, AdminEventBuilder adminEvent,
			InvoiceModel invoice) {
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
	public InvoiceRepresentation getInvoice(@QueryParam("includeXml") boolean includeXml) {
		auth.requireView();

		if (invoice == null) {
			throw new NotFoundException("Invoice not found");
		}

		InvoiceRepresentation rep = ModelToRepresentation.toRepresentation(invoice, includeXml);
		return rep;
	}

	@GET
	@Path("text")
	@NoCache
	@Produces("application/text")
	public Response getInvoiceAsText() {
		auth.requireView();

		if (invoice == null) {
			throw new NotFoundException("Invoice not found");
		}

		String text = null;
		try {
			Document document = DocumentUtils.byteToDocument(ArrayUtils.toPrimitive(invoice.getXmlDocument()));
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

		if (invoice == null) {
			throw new NotFoundException("Invoice not found");
		}

		Document document = null;
		try {
			document = DocumentUtils.byteToDocument(ArrayUtils.toPrimitive(invoice.getXmlDocument()));
		} catch (Exception e) {
			return ErrorResponse.exists("Invalid xml");
		}

		Response.ResponseBuilder response = Response.ok((Object) document);
		response.header("Content-Disposition", "attachment; filename=\"" + invoice.getID() + ".xml\"");
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
	@Path("pdf")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public byte[] getPdf() throws Exception {
		auth.requireView();

		if (invoice == null) {
			throw new NotFoundException("Invoice not found");
		}
		ReportProvider provider = session.getProvider(ReportProvider.class);
		byte[] report = provider.processReport(invoice);
		return report;
	}

	@GET
	@Path("lines")
	@Produces(MediaType.APPLICATION_JSON)
	public List<InvoiceLineRepresentation> getLines() {
		auth.requireView();

        return invoice.getInvoiceLine().stream().map(f -> ModelToRepresentation.toRepresentation(f))
                .collect(Collectors.toList());
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

}
