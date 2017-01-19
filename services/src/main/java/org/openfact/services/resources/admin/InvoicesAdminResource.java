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

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.annotations.cache.NoCache;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.openfact.common.ClientConnection;
import org.openfact.events.admin.OperationType;
import org.openfact.events.admin.ResourceType;
import org.openfact.models.*;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.models.utils.RepresentationToModel;
import org.openfact.representations.idm.InvoiceRepresentation;
import org.openfact.representations.idm.search.SearchCriteriaRepresentation;
import org.openfact.representations.idm.search.SearchResultsRepresentation;
import org.openfact.services.ErrorResponse;
import org.openfact.services.ServicesLogger;
import org.openfact.services.managers.InvoiceManager;
import org.openfact.ubl.UBLInvoiceProvider;

import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;

/**
 * @author carlosthe19916@sistcoop.com
 */
@Consumes(MediaType.APPLICATION_JSON)
public class InvoicesAdminResource {

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
    protected OrganizationAuth auth;
    protected AdminEventBuilder adminEvent;

    public InvoicesAdminResource(OrganizationModel organization, OrganizationAuth auth, AdminEventBuilder adminEvent) {
        this.auth = auth;
        this.organization = organization;
        this.adminEvent = adminEvent;

        auth.init(OrganizationAuth.Resource.INVOICE);
    }

    /**
     * @param invoiceId The invoiceId of the invoice
     */
    @Path("{invoiceId}")
    public InvoiceAdminResource getInvoiceAdmin(@PathParam("invoiceId") final String invoiceId) {
        InvoiceModel invoice = session.invoices().getInvoiceById(organization, invoiceId);
        if (invoice == null) {
            throw new NotFoundException("Invoice not found");
        }

        InvoiceAdminResource invoiceResource = new InvoiceAdminResource(organization, auth, adminEvent, invoice);
        ResteasyProviderFactory.getInstance().injectProperties(invoiceResource);
        return invoiceResource;
    }

    @GET
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public List<InvoiceRepresentation> getInvoices(
            @QueryParam("filterText") String filterText,
            @QueryParam("documentId") String documentId,
            @QueryParam("first") Integer firstResult,
            @QueryParam("max") Integer maxResults) {

        auth.requireView();

        firstResult = firstResult != null ? firstResult : -1;
        maxResults = maxResults != null ? maxResults : Constants.DEFAULT_MAX_RESULTS;

        List<InvoiceModel> invoiceModels;
        if (filterText != null) {
            invoiceModels = session.invoices().searchForInvoice(organization, filterText.trim(), firstResult, maxResults);
        } else if (documentId != null) {
            Map<String, String> attributes = new HashMap<>();
            if (documentId != null) {
                attributes.put(InvoiceModel.DOCUMENT_ID, documentId);
            }
            invoiceModels = session.invoices().searchForInvoice(attributes, organization, firstResult, maxResults);
        } else {
            invoiceModels = session.invoices().getInvoices(organization, firstResult, maxResults);
        }

        return invoiceModels.stream()
                .map(f -> ModelToRepresentation.toRepresentation(f))
                .collect(Collectors.toList());
    }

    @POST
    @Path("upload")
    @Consumes("multipart/form-data")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createInvoiceFromXml(final MultipartFormDataInput input) {
        auth.requireManage();

        Map<String, List<InputPart>> uploadForm = input.getFormDataMap();
        List<InputPart> inputParts = uploadForm.get("file");

        for (InputPart inputPart : inputParts) {
            try {
                InputStream inputStream = inputPart.getBody(InputStream.class, null);
                byte[] bytes = IOUtils.toByteArray(inputStream);

                InvoiceType invoiceType = session.getProvider(UBLInvoiceProvider.class).reader().read(bytes);
                if (invoiceType == null) {
                    throw new ModelException("Invalid invoice Xml");
                }

                InvoiceManager invoiceManager = new InvoiceManager(session);

                // Double-check duplicated documentId
                if (invoiceType.getIDValue() != null && invoiceManager.getInvoiceByDocumentId(organization, invoiceType.getIDValue()) != null) {
                    throw new ModelDuplicateException("Invoice exists with same documentId[" + invoiceType.getIDValue() + "]");
                }

                InvoiceModel invoice = invoiceManager.addInvoice(organization, invoiceType, Collections.emptyMap());
                adminEvent.operation(OperationType.CREATE).resource(ResourceType.INVOICE).resourcePath(uriInfo, invoice.getId()).representation(invoiceType).success();
            } catch (IOException e) {
                if (session.getTransactionManager().isActive()) {
                    session.getTransactionManager().setRollbackOnly();
                }
                logger.error("Error reading input data", e);
                return ErrorResponse.error("Error Reading data", Response.Status.BAD_REQUEST);
            } catch (ModelDuplicateException e) {
                if (session.getTransactionManager().isActive()) {
                    session.getTransactionManager().setRollbackOnly();
                }
                return ErrorResponse.exists("Invoice exists with same id or documentId");
            } catch (ModelException e) {
                if (session.getTransactionManager().isActive()) {
                    session.getTransactionManager().setRollbackOnly();
                }
                return ErrorResponse.exists("Could not create invoice");
            }
        }

        return Response.ok().build();
    }

    @POST
    @Path("search")
    @Produces(MediaType.APPLICATION_JSON)
    public SearchResultsRepresentation<InvoiceRepresentation> search(final SearchCriteriaRepresentation criteria) {
        auth.requireView();

        SearchCriteriaModel criteriaModel = RepresentationToModel.toModel(criteria);

        String filterText = criteria.getFilterText();
        SearchResultsModel<InvoiceModel> results = null;
        if (filterText != null) {
            results = session.invoices().searchForInvoice(organization, criteriaModel, filterText);
        } else {
            results = session.invoices().searchForInvoice(organization, criteriaModel);
        }
        SearchResultsRepresentation<InvoiceRepresentation> rep = new SearchResultsRepresentation<>();
        List<InvoiceRepresentation> items = new ArrayList<>();
        results.getModels().forEach(f -> items.add(ModelToRepresentation.toRepresentation(f)));
        rep.setItems(items);
        rep.setTotalSize(results.getTotalSize());
        return rep;
    }

}
