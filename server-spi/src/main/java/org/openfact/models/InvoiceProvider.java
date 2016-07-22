package org.openfact.models;

import java.time.LocalDate;

import org.openfact.models.enums.InvoiceType;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;
import org.openfact.provider.Provider;

public interface InvoiceProvider extends Provider {

    InvoiceModel addInvoice(OrganizationModel organization, CustomerModel customer, InvoiceType type,
            InvoiceIdModel invoiceId, String currencyCode, LocalDate issueDate);

    InvoiceModel addInvoice(OrganizationModel organization, CustomerModel customer, String id,
            InvoiceType type, InvoiceIdModel invoiceId, String currencyCode, LocalDate issueDate);

    InvoiceModel getInvoiceById(String id, OrganizationModel organization);

    boolean removeInvoice(OrganizationModel organization, InvoiceModel invoice);

    SearchResultsModel<InvoiceModel> search(OrganizationModel organization, SearchCriteriaModel criteria);

    SearchResultsModel<InvoiceModel> search(OrganizationModel organization, SearchCriteriaModel criteria,
            String filterText);

}
