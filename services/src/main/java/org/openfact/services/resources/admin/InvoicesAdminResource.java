package org.openfact.services.resources.admin;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
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

import org.jboss.resteasy.annotations.cache.NoCache;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.openfact.common.ClientConnection;
import org.openfact.events.admin.OperationType;
import org.openfact.models.ModelDuplicateException;
import org.openfact.models.ModelException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
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

/**
 * @author carlosthe19916@sistcoop.com
 */
@Consumes(MediaType.APPLICATION_JSON)
public class InvoicesAdminResource {

    private static final ServicesLogger logger = ServicesLogger.LOGGER;

    protected OrganizationModel organization;
    private OrganizationAuth auth;
    private AdminEventBuilder adminEvent;

    @Context
    protected UriInfo uriInfo;

    @Context
    protected OpenfactSession session;

    @Context
    protected ClientConnection clientConnection;

    @Context
    protected HttpHeaders headers;

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
            return ErrorResponse.exists("Debit Note exists with same ID");
        }

        try {
            InvoiceModel invoice = invoiceManager.addInvoice(organization, rep);

            if (session.getTransactionManager().isActive()) {
                session.getTransactionManager().commit();
            }

            adminEvent.operation(OperationType.CREATE).resourcePath(uriInfo, invoice.getId())
                    .representation(rep).success();

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
        }
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
