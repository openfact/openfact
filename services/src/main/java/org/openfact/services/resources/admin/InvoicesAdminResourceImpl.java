package org.openfact.services.resources.admin;

import java.io.StringWriter;
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
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

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
import org.openfact.services.ServicesLogger;
import org.openfact.ubl.UblException;
import org.openfact.ubl.UblProvider;
import org.w3c.dom.Document;

public class InvoicesAdminResourceImpl implements InvoicesAdminResource {

	private static final ServicesLogger logger = ServicesLogger.ROOT_LOGGER;

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
	public List<InvoiceRepresentation> getInvoices(String filterText, String type, String currencyCode,
			Integer firstResult, Integer maxResults) {
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
			invoices = session.invoices().searchForInvoiceByAttributes(attributes, organization, firstResult,
					maxResults);
		} else {
			invoices = session.invoices().getInvoices(organization, firstResult, maxResults);
		}

		return invoices.stream().map(f -> ModelToRepresentation.toRepresentation(f)).collect(Collectors.toList());
	}

	@Override
	public Response createInvoice(InvoiceRepresentation rep) {
		auth.requireManage();

		if (!checkOrganization(organization)) {
			return ErrorResponse.exists("Can't create invoice because organization has insuficient data");
		}

		try {				
			InvoiceModel invoice = RepresentationToModel.createInvoice(session, organization, rep, organization.getDocuments(), true);
            logger.addInvoiceSuccess(invoice.getId(), organization.getName());                                            
            
			URI uri = uriInfo.getAbsolutePathBuilder().path(invoice.getId()).build();
            return Response.created(uri).entity(ModelToRepresentation.toRepresentation(invoice)).build();
		} catch (ModelDuplicateException e) {
			if (session.getTransactionManager().isActive()) {
				session.getTransactionManager().setRollbackOnly();
			}
			return ErrorResponse.exists("Invoice exists with same Set and Number");
		} catch (ModelException e) {
			if (session.getTransactionManager().isActive()) {
				session.getTransactionManager().setRollbackOnly();
			}
			return ErrorResponse.exists("Could not create invoice");
		}
	}

	private boolean checkOrganization(OrganizationModel organization) {
		if (organization.getAdditionalAccountId() == null) {
			return false;
		}
		if (organization.getAssignedIdentificationId() == null) {
			return false;
		}
		if (organization.getRegistrationName() == null) {
			return false;
		}
		if (organization.getSupplierName() == null) {
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
			results = session.invoices().searchForInvoice(organization, criteriaModel);
		} else {
			results = session.invoices().searchForInvoice(organization, criteriaModel, filterText);
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
