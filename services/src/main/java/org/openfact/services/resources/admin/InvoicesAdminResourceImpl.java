package org.openfact.services.resources.admin;

import java.math.BigDecimal;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.jboss.logging.Logger;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.openfact.common.ClientConnection;
import org.openfact.models.CustomerModel;
import org.openfact.models.InvoiceIdModel;
import org.openfact.models.InvoiceLineModel;
import org.openfact.models.InvoiceModel;
import org.openfact.models.ModelDuplicateException;
import org.openfact.models.ModelException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.enums.AdditionalAccountType;
import org.openfact.models.enums.AdditionalInformationType;
import org.openfact.models.enums.InvoiceType;
import org.openfact.models.enums.MonetaryTotalType;
import org.openfact.models.enums.TaxType;
import org.openfact.models.search.SearchCriteriaFilterOperator;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.representations.idm.CustomerRepresentation;
import org.openfact.representations.idm.InvoiceLineRepresentation;
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
	public List<InvoiceRepresentation> getInvoices(String filterText, String type, String currencyCode,
			Integer firstResult, Integer maxResults) {
		auth.requireView();

		firstResult = firstResult != null ? firstResult : -1;
		maxResults = maxResults != null ? maxResults : -1;

		List<InvoiceRepresentation> results = new ArrayList<InvoiceRepresentation>();
		List<InvoiceModel> invoicesModels;
		if (filterText != null) {
			invoicesModels = session.invoices().searchForInvoice(filterText.trim(), organization, firstResult,
					maxResults);
		} else if (type != null || currencyCode != null) {
			Map<String, String> attributes = new HashMap<String, String>();
			if (type != null) {
				attributes.put(InvoiceModel.TYPE, type);
			}
			if (currencyCode != null) {
				attributes.put(InvoiceModel.CURRENCY_CODE, currencyCode);
			}
			invoicesModels = session.invoices().searchForInvoiceByAttributes(attributes, organization, firstResult,
					maxResults);
		} else {
			invoicesModels = session.invoices().getInvoices(organization, firstResult, maxResults);
		}

		for (InvoiceModel invoice : invoicesModels) {
			results.add(ModelToRepresentation.toRepresentacion(invoice));
		}
		return results;
	}

	@Override
	public Response createInvoice(InvoiceRepresentation rep) {
		auth.requireManage();

		try {
			InvoiceModel invoice = session.invoices().addInvoice(organization, InvoiceType.valueOf(rep.getType()),
					rep.getCurrencyCode(), rep.getIssueDate());
			CustomerModel customerModel = registerCustomerFromRep(rep.getCustomer(), invoice, session);
			InvoiceIdModel invoiceIdModel = registerInvoiceIdFromRep(rep.getInvoiceSeries(), rep.getInvoiceNumber(),
					invoice, session);

			invoice.setCustomer(customerModel);
			invoice.setInvoiceId(invoiceIdModel);
			updateInvoiceFromRep(invoice, rep, organization, session);
			registerInvoiceLines(rep.getLines(), invoice, session);

			URI uri = uriInfo.getAbsolutePathBuilder().path(invoice.getId()).build();
			return Response.created(uri).entity(ModelToRepresentation.toRepresentacion(invoice)).build();
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

	private CustomerModel registerCustomerFromRep(CustomerRepresentation rep, InvoiceModel invoice,
			OpenfactSession session) {
		CustomerModel customer = invoice.registerCustomer(invoice, rep.getRegistrationName());
		customer.setAdditionalAccountId(rep.getAdditionalAccountId() != null
				? AdditionalAccountType.valueOf(rep.getAdditionalAccountId()) : null);
		customer.setAssignedIdentificationId(rep.getAssignedIdentificationId());
		customer.setEmail(rep.getEmail());
		return customer;
	}

	private InvoiceIdModel registerInvoiceIdFromRep(Integer series, Integer number, InvoiceModel invoice,
			OpenfactSession session) {
		if (series == null) {
			series = -1;
		}
		if (number == null) {
			number = -1;
		}
		return invoice.registerInvoiceId(invoice, series, number);
	}

	private void updateInvoiceFromRep(InvoiceModel invoice, InvoiceRepresentation rep, OrganizationModel organization,
			OpenfactSession session) {
		if (rep.getTotalTaxed() != null) {
			invoice.addAdditionalInformation(AdditionalInformationType.GRAVADO, rep.getTotalTaxed());
		}
		if (rep.getTotalUnaffected() != null) {
			invoice.addAdditionalInformation(AdditionalInformationType.INACFECTO, rep.getTotalUnaffected());
		}
		if (rep.getTotalExonerated() != null) {
			invoice.addAdditionalInformation(AdditionalInformationType.EXONERADO, rep.getTotalExonerated());
		}
		if (rep.getTotalByFree() != null) {
			invoice.addAdditionalInformation(AdditionalInformationType.GRATUITO, rep.getTotalByFree());
		}

		if (rep.getTotalIgvTax() != null) {
			invoice.addTotalTax(TaxType.IGV, rep.getTotalIgvTax());
		}
		if (rep.getTotalIscTax() != null) {
			invoice.addTotalTax(TaxType.ISC, rep.getTotalIscTax());
		}
		if (rep.getTotalOtherTax() != null) {
			invoice.addTotalTax(TaxType.OTROS, rep.getTotalOtherTax());
		}

		if (rep.getTotalAmmount() != null) {
			invoice.addTotalLegalMonetary(MonetaryTotalType.IMPORTE_TOTAL, rep.getTotalAmmount());
		}
		if (rep.getTotalTaxed() != null) {
			invoice.addTotalLegalMonetary(MonetaryTotalType.DESCUENTO_TOTAL, rep.getTotalDiscounted());
		}
	}

	private void registerInvoiceLines(List<InvoiceLineRepresentation> invoiceLines, InvoiceModel invoice,
			OpenfactSession session) {
		for (InvoiceLineRepresentation invoiceLine : invoiceLines) {
			BigDecimal price = invoiceLine.getPrice();
			BigDecimal quantity = invoiceLine.getQuantity();
			String unitCode = invoiceLine.getUnitCode();
			String itemDescription = invoiceLine.getItemDescription();

			Map<TaxType, BigDecimal> taxs = new HashMap<>();
			if (invoiceLine.getIgv() != null) {
				taxs.put(TaxType.IGV, invoiceLine.getIgv());
			}
			if (invoiceLine.getIsc() != null) {
				taxs.put(TaxType.ISC, invoiceLine.getIsc());
			}
			if (invoiceLine.getOtherTaxs() != null) {
				taxs.put(TaxType.OTROS, invoiceLine.getOtherTaxs());
			}

			InvoiceLineModel model = invoice.addInvoiceLine(price, quantity, unitCode, itemDescription, taxs);
			model.setAmmount(invoiceLine.getAmmount());
			model.setItemIdentification(invoiceLine.getItemIdentification());
			model.setAllowanceCharge(invoiceLine.getAllowanceCharge());

			logger.debug("Invoice line created with id " + model.getId());
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

	@Override
	public InvoiceAdminResource getInvoiceAdmin(String invoiceId) {
		InvoiceModel invoice = session.invoices().getInvoiceById(invoiceId, organization);
		InvoiceAdminResource invoiceResource = new InvoiceAdminResourceImpl(auth, organization, invoice);
		ResteasyProviderFactory.getInstance().injectProperties(invoiceResource);
		// resourceContext.initResource(adminResource);
		return invoiceResource;
	}

}
