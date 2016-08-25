package org.openfact.services.resources.admin;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.jboss.logging.Logger;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.openfact.common.ClientConnection;
import org.openfact.models.InvoiceModel;
import org.openfact.models.ModelDuplicateException;
import org.openfact.models.ModelException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.search.SearchCriteriaFilterOperator;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.models.utils.RepresentationToModel;
import org.openfact.representations.idm.InvoiceRepresentation;
import org.openfact.representations.idm.search.PagingRepresentation;
import org.openfact.representations.idm.search.SearchCriteriaFilterOperatorRepresentation;
import org.openfact.representations.idm.search.SearchCriteriaRepresentation;
import org.openfact.representations.idm.search.SearchResultsRepresentation;
import org.openfact.services.ErrorResponse;

public class InvoicesAdminResourceImpl implements InvoicesAdminResource {

	private static final Logger logger = Logger.getLogger(InvoicesAdminResourceImpl.class);

	protected OrganizationAuth auth;

	protected OrganizationModel organization;

	@Context
	protected UriInfo uriInfo;

	@Context
	protected OpenfactSession session;

	@Context
	protected ClientConnection clientConnection;

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
	public List<InvoiceRepresentation> getInvoices(String filterText, String type, String currencyCode, Integer firstResult, Integer maxResults) {		
	    auth.requireView();

		firstResult = firstResult != null ? firstResult : -1;
		maxResults = maxResults != null ? maxResults : -1;

		List<InvoiceModel> invoices;
		if (filterText != null) {
			invoices = session.invoices().searchForInvoice(filterText.trim(), organization, firstResult, maxResults);
		} else if (type != null || currencyCode != null) {
			Map<String, String> attributes = new HashMap<String, String>();
			if (type != null) {
				attributes.put(InvoiceModel.TYPE, type);
			}
			if (currencyCode != null) {
				attributes.put(InvoiceModel.CURRENCY_CODE, currencyCode);
			}
			invoices = session.invoices().searchForInvoiceByAttributes(attributes, organization, firstResult, maxResults);
		} else {
			invoices = session.invoices().getInvoices(organization, firstResult, maxResults);
		}
	
		return invoices.stream().map(f -> ModelToRepresentation.toRepresentation(f)).collect(Collectors.toList());		
	}

	@Override
	public Response createInvoice(InvoiceRepresentation rep) {
		auth.requireManage();

		if(checkOrganization(organization)) {
		    return ErrorResponse.exists("Can't create invoice because organization has insuficient data");
		}
		
		try {
		    Integer series = rep.getInvoiceSeries();
		    Integer number = rep.getInvoiceNumber();
		    	
		    InvoiceModel invoice;
		    if(series == null && number == null) {
		        invoice = session.invoices().addInvoice(organization);
		    } else {
		        invoice = session.invoices().addInvoice(organization, series, number);
		    } 
		    
		    RepresentationToModel.updateInvoice(rep, Collections.emptySet(), invoice, session, false);
		    		   
		    logger.debug("Invoice created " + invoice.getId());

			URI uri = uriInfo.getAbsolutePathBuilder().path(invoice.getId()).build();
			return Response.created(uri).entity(ModelToRepresentation.toRepresentation(invoice)).build();
		} catch (ModelDuplicateException e) {
			if (session.getTransaction().isActive()) {
				session.getTransaction().setRollbackOnly();
			}
			return ErrorResponse.exists("Invoice exists with same Set and Number");
		} catch (ModelException e) {
			if (session.getTransaction().isActive()) {
				session.getTransaction().setRollbackOnly();
			}
			return ErrorResponse.exists("Could not create invoice");
		}
	}
	
	private boolean checkOrganization(OrganizationModel organization) {
	    if(organization.getAdditionalAccountId() == null) {
	        return false;
	    }
	    if(organization.getAssignedIdentificationId() == null) {
            return false;
        }
	    if(organization.getRegistrationName() == null) {
            return false;
        }
	    if(organization.getSupplierName() == null) {
            return false;
        }
	    return true;
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
		results.getModels().forEach(f -> items.add(ModelToRepresentation.toRepresentation(f)));
		rep.setItems(items);
		rep.setTotalSize(results.getTotalSize());
		return rep;
	}

	@Override
	public InvoiceAdminResource getInvoiceAdmin(String invoiceId) {
		InvoiceModel invoice = session.invoices().getInvoiceById(invoiceId, organization);
		InvoiceAdminResource invoiceResource = new InvoiceAdminResourceImpl(auth, organization, invoice);
		ResteasyProviderFactory.getInstance().injectProperties(invoiceResource);
		// resourceContext.initResource(adminResource);
		return invoiceResource;
	}

}
