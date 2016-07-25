package org.openfact.services.resources.admin;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.jboss.logging.Logger;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.openfact.common.ClientConnection;
import org.openfact.models.AdminRoles;
import org.openfact.models.InvoiceModel;
import org.openfact.models.ModelDuplicateException;
import org.openfact.models.ModelException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.search.SearchCriteriaFilterOperator;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.representations.idm.InvoiceRepresentation;
import org.openfact.representations.idm.OrganizationRepresentation;
import org.openfact.representations.idm.search.PagingRepresentation;
import org.openfact.representations.idm.search.SearchCriteriaFilterOperatorRepresentation;
import org.openfact.representations.idm.search.SearchCriteriaRepresentation;
import org.openfact.representations.idm.search.SearchResultsRepresentation;
import org.openfact.services.ErrorResponse;
import org.openfact.services.managers.OrganizationManager;
import org.openfact.services.resources.OpenfactApplication;

public class InvoicesAdminResourceImpl implements InvoicesAdminResource {

    private static final Logger logger = Logger.getLogger(InvoicesAdminResourceImpl.class);

    protected OrganizationModel organization;

    protected OrganizationAuth auth;

    @Context
    protected ClientConnection clientConnection;

    @Context
    protected UriInfo uriInfo;

    @Context
    protected OpenfactSession session;

    public InvoicesAdminResourceImpl(OrganizationModel organization, OrganizationAuth auth) {
        this.organization = organization;
        this.auth = auth;
        auth.init(OrganizationAuth.Resource.INVOICE);
    }

    public static final CacheControl noCache = new CacheControl();

    static {
        noCache.setNoCache(true);
    }

    @Override
    public List<InvoiceRepresentation> getInvoices(String filterText, String type, String currencyCode,
            Integer firstResult, Integer maxResults) {
        auth.requireView();

        firstResult = firstResult != null ? firstResult : -1;
        maxResults = maxResults != null ? maxResults : -1;

        List<InvoiceRepresentation> results = new ArrayList<InvoiceRepresentation>();
        List<InvoiceModel> invoicesModels;
        if (filterText != null) {
            invoicesModels = session.invoices().searchForInvoice(filterText.trim(), organization, firstResult, maxResults);
        } else if (type != null || currencyCode != null) {
            Map<String, String> attributes = new HashMap<String, String>();
            if (type != null) {
                attributes.put(InvoiceModel.TYPE, type);
            }
            if (currencyCode != null) {
                attributes.put(InvoiceModel.CURRENCY_CODE, currencyCode);
            }
            invoicesModels = session.invoices().searchForInvoiceByAttributes(attributes, organization, firstResult, maxResults);
        } else {
            invoicesModels = session.invoices().getInvoices(organization, firstResult, maxResults, false);
        }

        for (InvoiceModel invoice : invoicesModels) {
            results.add(ModelToRepresentation.toRepresentation(invoice));
        }
        return results;
    }

    @Override
    public Response createInvoice(InvoiceRepresentation rep) {
        /*
         * auth.requireManage();
         * 
         * try { InvoiceModel invoice =
         * session.invoices().addInvoice(organization, rep.getUsername());
         * 
         * if (session.getTransaction().isActive()) {
         * session.getTransaction().commit(); }
         * 
         * return
         * Response.created(uriInfo.getAbsolutePathBuilder().path(invoice.getId(
         * )).build()).build(); } catch (ModelDuplicateException e) { if
         * (session.getTransaction().isActive()) {
         * session.getTransaction().setRollbackOnly(); } return
         * ErrorResponse.exists("Invoice exists with same invoiceId"); } catch
         * (ModelException me) { if (session.getTransaction().isActive()) {
         * session.getTransaction().setRollbackOnly(); } return
         * ErrorResponse.exists("Could not create invoice"); } return null;
         */
        return null;
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
            results = session.invoices().search(organization, criteriaModel);
        } else {
            results = session.invoices().search(organization, criteriaModel, filterText);
        }
        SearchResultsRepresentation<InvoiceRepresentation> rep = new SearchResultsRepresentation<>();
        List<InvoiceRepresentation> items = new ArrayList<>();
        results.getModels().forEach(f -> items.add(ModelToRepresentation.toRepresentacion(f)));
        rep.setItems(items);
        rep.setTotalSize(results.getTotalSize());
        return rep;
    }

}
