package org.openfact.services.resources.admin.ubl;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.openfact.common.ClientConnection;
import org.openfact.events.admin.OperationType;
import org.openfact.models.ModelDuplicateException;
import org.openfact.models.ModelException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.search.SearchCriteriaFilterOperator;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.models.utils.RepresentationToModelUBL;
import org.openfact.representations.idm.search.PagingRepresentation;
import org.openfact.representations.idm.search.SearchCriteriaFilterOperatorRepresentation;
import org.openfact.representations.idm.search.SearchCriteriaRepresentation;
import org.openfact.representations.idm.search.SearchResultsRepresentation;
import org.openfact.representations.idm.ubl.InvoiceRepresentation;
import org.openfact.services.ErrorResponse;
import org.openfact.services.ServicesLogger;
import org.openfact.services.resources.admin.AdminEventBuilder;
import org.openfact.services.resources.admin.OrganizationAuth;

public class InvoicesAdminResourceImpl implements InvoicesAdminResource {

    private static final ServicesLogger logger = ServicesLogger.ROOT_LOGGER;

    private AdminEventBuilder adminEvent;
    
    protected OrganizationAuth auth;
    protected OrganizationModel organization;

    @Context
    protected UriInfo uriInfo;

    @Context
    protected OpenfactSession session;

    @Context
    protected ClientConnection clientConnection;

    public InvoicesAdminResourceImpl(OrganizationModel organization, OrganizationAuth auth, AdminEventBuilder adminEvent) {
        this.organization = organization;
        this.auth = auth;
        
        this.adminEvent = adminEvent;
        auth.init(OrganizationAuth.Resource.INVOICE);
    }

    public static final CacheControl noCache = new CacheControl();

    static {
        noCache.setNoCache(true);
    }

    @Override
    public List<InvoiceRepresentation> getInvoices(String filterText, Integer firstResult, Integer maxResults) {
        auth.requireView();

        firstResult = firstResult != null ? firstResult : -1;
        maxResults = maxResults != null ? maxResults : -1;

        List<InvoiceModel> invoices;
        if (filterText != null) {
            invoices = session.invoicesUBL().searchForInvoice(filterText.trim(), organization, firstResult, maxResults);
        } else {
            invoices = session.invoicesUBL().getInvoices(organization, firstResult, maxResults);
        }

        return invoices.stream().map(f -> ModelToRepresentation.toRepresentation(f)).collect(Collectors.toList());
    }

    @Override
    public Response createInvoice(InvoiceRepresentation rep) {
        auth.requireManage();

        try {               
            InvoiceModel invoice = RepresentationToModelUBL.createInvoice(session, organization, rep);
            logger.addInvoiceSuccess(invoice.getId(), organization.getName());                                            
            
            adminEvent.operation(OperationType.CREATE).resourcePath(uriInfo, invoice.getId()).representation(rep).success();
            
            URI uri = uriInfo.getAbsolutePathBuilder().path(invoice.getId()).build();
            return Response.created(uri).build();
        } catch (ModelDuplicateException e) {
            if (session.getTransactionManager().isActive()) {
                session.getTransactionManager().setRollbackOnly();
            }
            return ErrorResponse.exists("Invoice exists");
        } catch (ModelException e) {
            if (session.getTransactionManager().isActive()) {
                session.getTransactionManager().setRollbackOnly();
            }
            return ErrorResponse.exists("Could not create invoice");
        }
    }

    @Override
    public SearchResultsRepresentation<InvoiceRepresentation> search(SearchCriteriaRepresentation criteria) {
        SearchCriteriaModel criteriaModel = new SearchCriteriaModel();

        Function<SearchCriteriaFilterOperatorRepresentation, SearchCriteriaFilterOperator> function = f -> {
            return SearchCriteriaFilterOperator.valueOf(f.toString());
        };
        criteria.getFilters().forEach(f -> {
            criteriaModel.addFilter(f.getName(), f.getValue(), function.apply(f.getOperator()));
        });
        criteria.getOrders().forEach(f -> criteriaModel.addOrder(f.getName(), f.isAscending()));
        PagingRepresentation paging = criteria.getPaging();
        criteriaModel.setPageSize(paging.getPageSize());
        criteriaModel.setPage(paging.getPage());

        String filterText = criteria.getFilterText();
        SearchResultsModel<InvoiceModel> results = null;
        if (filterText == null) {
            results = session.invoicesUBL().searchForInvoice(organization, criteriaModel);
        } else {
            results = session.invoicesUBL().searchForInvoice(organization, criteriaModel, filterText);
        }
        SearchResultsRepresentation<InvoiceRepresentation> rep = new SearchResultsRepresentation<>();
        List<InvoiceRepresentation> items = new ArrayList<>();
        results.getModels().forEach(f -> items.add(ModelToRepresentation.toRepresentation(f)));
        rep.setItems(items);
        rep.setTotalSize(results.getTotalSize());
        return rep;
    }

    @Override
    public InvoiceAdminResource getInvoiceAdmin(String invoiceId) {
        InvoiceModel invoice = session.invoicesUBL().getInvoiceById(organization, invoiceId);
        InvoiceAdminResource invoiceResource = new InvoiceAdminResourceImpl(auth, organization, invoice);
        ResteasyProviderFactory.getInstance().injectProperties(invoiceResource);
        // resourceContext.initResource(adminResource);
        return invoiceResource;
    }

}
