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

import com.helger.ubl21.UBL21Reader;
import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;
import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.annotations.cache.NoCache;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.json.JSONObject;
import org.json.XML;
import org.openfact.common.ClientConnection;
import org.openfact.email.EmailException;
import org.openfact.events.admin.OperationType;
import org.openfact.models.ModelDuplicateException;
import org.openfact.models.ModelException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.enums.RequiredActionDocument;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.models.utils.RepresentationToModel;
import org.openfact.representations.idm.search.SearchCriteriaRepresentation;
import org.openfact.representations.idm.search.SearchResultsRepresentation;
import org.openfact.representations.idm.ubl.InvoiceRepresentation;
import org.openfact.services.ErrorResponse;
import org.openfact.services.ServicesLogger;
import org.openfact.services.managers.InvoiceManager;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author carlosthe19916@sistcoop.com
 */
@Consumes(MediaType.APPLICATION_JSON)
public class InvoicesAdminResource {

    private static final ServicesLogger logger = ServicesLogger.LOGGER;

    protected OrganizationModel organization;
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

    public InvoicesAdminResource(OrganizationModel organization, OrganizationAuth auth,
                                 AdminEventBuilder adminEvent) {
        this.auth = auth;
        this.organization = organization;
        this.adminEvent = adminEvent;

        auth.init(OrganizationAuth.Resource.INVOICE);
    }

    /**
     * @param invoiceId
     *            The invoiceId of the invoice
     */
    @Path("{invoiceId}")
    public InvoiceAdminResource getInvoiceAdmin(@PathParam("invoiceId") final String invoiceId) {
        InvoiceModel invoice = session.invoices().getInvoiceById(organization, invoiceId);
        if (invoice == null) {
            throw new NotFoundException("Debit Note not found");
        }

        InvoiceAdminResource invoiceResource = new InvoiceAdminResource(organization, auth, adminEvent,
                invoice);
        ResteasyProviderFactory.getInstance().injectProperties(invoiceResource);
        return invoiceResource;
    }

    @GET
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public List<InvoiceRepresentation> getInvoices(@QueryParam("filterText") String filterText,
                                                   @QueryParam("first") Integer firstResult, @QueryParam("max") Integer maxResults) {
        auth.requireView();

        firstResult = firstResult != null ? firstResult : -1;
        maxResults = maxResults != null ? maxResults : -1;

        List<InvoiceModel> invoices;
        if (filterText == null) {
            invoices = session.invoices().getInvoices(organization, firstResult, maxResults);
        } else {
            invoices = session.invoices().searchForInvoice(organization, filterText.trim(), firstResult,
                    maxResults);
        }
        return invoices.stream().map(f -> ModelToRepresentation.toRepresentation(f))
                .collect(Collectors.toList());
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createInvoice(@Valid final InvoiceRepresentation rep) {
        auth.requireManage();

        InvoiceManager invoiceManager = new InvoiceManager(session);

        // Double-check duplicated ID
        if (rep.getIdUbl() != null && invoiceManager.getInvoiceByID(organization, rep.getIdUbl()) != null) {
            return ErrorResponse.exists("Invoice exists with same ID");
        }

        try {
            InvoiceModel invoice = invoiceManager.addInvoice(organization, rep);

            adminEvent.operation(OperationType.CREATE).resourcePath(uriInfo, invoice.getId())
                    .representation(rep).success();

            if (session.getTransactionManager().isActive()) {
                session.getTransactionManager().commit();
            }

            // Send Email
            if (rep.getRequiredActions().contains(RequiredActionDocument.SEND_EMAIL_CUSTOMER.toString())) {
                invoiceManager.sendEmailToCustomerEmail(invoice);
            }

            URI location = uriInfo.getAbsolutePathBuilder().path(invoice.getId()).build();
            return Response.created(location).build();
        } catch (ModelDuplicateException e) {
            if (session.getTransactionManager().isActive()) {
                session.getTransactionManager().setRollbackOnly();
            }
            return ErrorResponse.exists("Invoice exists with same id or ID");
        } catch (ModelException me) {
            if (session.getTransactionManager().isActive()) {
                session.getTransactionManager().setRollbackOnly();
            }
            return ErrorResponse.exists("Could not create debit note");
        } catch (EmailException e) {
            ServicesLogger.LOGGER.failedToSendActionsEmail(e);
            return ErrorResponse.error("Invoice Created but, Failed to send execute actions email", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @POST
    @Path("xml")
    @Consumes("multipart/form-data")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createInvoiceFromXml(final MultipartFormDataInput input) {
        auth.requireManage();

        Map<String, List<InputPart>> uploadForm = input.getFormDataMap();
        List<InputPart> inputParts = uploadForm.get("uploadFile");

        for (InputPart inputPart : inputParts) {
            try {
                InputStream inputStream = inputPart.getBody(InputStream.class, null);
                byte[] bytes = IOUtils.toByteArray(inputStream);

                InvoiceManager invoiceManager = new InvoiceManager(session);
                InvoiceType invoiceType = UBL21Reader.invoice().read(bytes);

                // Double-check duplicated ID
                if (invoiceType.getIDValue() != null
                        && invoiceManager.getInvoiceByID(organization, invoiceType.getIDValue()) != null) {
                    return ErrorResponse.exists("Invoice exists with same ID");
                }

                InvoiceModel invoice = invoiceManager.addInvoice(organization, invoiceType);

                if (session.getTransactionManager().isActive()) {
                    session.getTransactionManager().commit();
                }

                JSONObject json = XML.toJSONObject(invoiceType.toString());
                adminEvent.operation(OperationType.CREATE).resourcePath(uriInfo, invoice.getId())
                        .representation(json).success();
            } catch (IOException e) {
                logger.error("Error reading input data", e);
                return ErrorResponse.error("Error Reading data", Response.Status.BAD_REQUEST);
            } catch (ModelDuplicateException e) {
                if (session.getTransactionManager().isActive()) {
                    session.getTransactionManager().setRollbackOnly();
                }
                return ErrorResponse.exists("Invoice exists with same id or ID");
            } catch (ModelException me) {
                if (session.getTransactionManager().isActive()) {
                    session.getTransactionManager().setRollbackOnly();
                }
                return ErrorResponse.exists("Could not create debit note");
            }
        }

        return Response.ok().build();
    }

    @POST
    @Path("search")
    @Produces(MediaType.APPLICATION_JSON)
    public SearchResultsRepresentation<InvoiceRepresentation> search(
            final SearchCriteriaRepresentation criteria) {
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
