package org.openfact.models.storage;

import java.time.LocalDate;

import org.openfact.models.CustomerModel;
import org.openfact.models.InvoiceIdModel;
import org.openfact.models.InvoiceModel;
import org.openfact.models.InvoiceProvider;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.enums.InvoiceType;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;
import org.openfact.storage.StorageInvoiceProvider;

/**
 * Created by Alex Pariona-"alexpariona@openfact.com" on 01/08/2016.
 */
public class LocalStorageInvoiceProvider {
    private OpenfactSession session;

    public LocalStorageInvoiceProvider(OpenfactSession session) {
        this.session = session;
    }

    public InvoiceProvider getDelegate() {
        return null;
    }

    public InvoiceModel addInvoice(OrganizationModel organization, CustomerModel customer, InvoiceType type, InvoiceIdModel invoiceId, String currencyCode, LocalDate issueDate) {
        return null;
    }

    public InvoiceModel addInvoice(OrganizationModel organization, CustomerModel customer, String id, InvoiceType type, InvoiceIdModel invoiceId, String currencyCode, LocalDate issueDate) {
       // InvoiceModel invoice = this.getDelegate().addInvoice(organization, customer, id, type, invoiceId, currencyCode, issueDate);

        return null;
    }

    public InvoiceModel getInvoiceById(String id, OrganizationModel organization) {
        InvoiceModel invoiceModel = this.getDelegate().getInvoiceById(id, organization);
        return invoiceModel;
    }

    public boolean removeInvoice(OrganizationModel organization, InvoiceModel invoice) {
        boolean status = this.getDelegate().removeInvoice(organization, invoice);
        return status;
    }

    public SearchResultsModel<InvoiceModel> search(OrganizationModel organization, SearchCriteriaModel criteria) {
        SearchResultsModel resultsModel = this.getDelegate().search(organization, criteria);
        return resultsModel;
    }

    public SearchResultsModel<InvoiceModel> search(OrganizationModel organization, SearchCriteriaModel criteria, String filterText) {
        SearchResultsModel resultsModel = this.getDelegate().search(organization, criteria, filterText);
        return resultsModel;
    }

    public void close() {
        System.out.println("Closing conexion data base");
    }
}