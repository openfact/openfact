package org.openfact.models.storage;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

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
public class LocalStorageInvoiceProvider implements StorageInvoiceProvider
{
    private OpenfactSession session;

    public LocalStorageInvoiceProvider(OpenfactSession session) {
        this.session = session;
    }
    public InvoiceProvider getDelegate() {
        return session.invoices();
    }

    @Override
    public InvoiceModel addInvoice(OrganizationModel organization, InvoiceType type, String currencyCode, LocalDate issueDate) {
        InvoiceModel invoice = this.getDelegate().addInvoice(organization, type, currencyCode, issueDate);
        /*
        * implement  sing
        * */
        return invoice;
    }

    @Override
    public InvoiceModel addInvoice(OrganizationModel organization, String id, InvoiceType type, String currencyCode, LocalDate issueDate) {
        InvoiceModel invoice = this.getDelegate().addInvoice(organization,  id, type,  currencyCode, issueDate);
        /*implements sing */
        return invoice;
    }

    @Override
    public InvoiceModel getInvoiceById(String id, OrganizationModel organization) {
        InvoiceModel invoiceModel = this.getDelegate().getInvoiceById(id, organization);
        return invoiceModel;
    }

    @Override
    public InvoiceModel getInvoiceBySeriesAndNumber(int set, int number, OrganizationModel organization) {
        InvoiceModel invoiceModel = this.getDelegate().getInvoiceBySeriesAndNumber(set,number, organization);
        return invoiceModel;
    }

    @Override
    public boolean removeInvoice(OrganizationModel organization, InvoiceModel invoice) {
        boolean status = this.getDelegate().removeInvoice(organization, invoice);
        return status;
    }

    @Override
    public List<InvoiceModel> getInvoices(OrganizationModel organization, Integer firstResult, Integer maxResults) {
        List<InvoiceModel> invoices=this.getDelegate().getInvoices(organization,firstResult,maxResults);
        return invoices;
    }

    @Override
    public List<InvoiceModel> searchForInvoice(String filterText, OrganizationModel organization, Integer firstResult, Integer maxResults) {
        List<InvoiceModel> result=this.getDelegate().searchForInvoice(filterText,organization,firstResult,maxResults);
        return result;
    }

    @Override
    public List<InvoiceModel> searchForInvoiceByAttributes(Map<String, String> attributes, OrganizationModel organization) {
        List<InvoiceModel> result=this.getDelegate().searchForInvoiceByAttributes(attributes,organization);
        return result;
    }

    @Override
    public List<InvoiceModel> searchForInvoiceByAttributes(Map<String, String> attributes, OrganizationModel organization, Integer firstResult, Integer maxResults) {
        List<InvoiceModel> result=this.getDelegate().searchForInvoiceByAttributes(attributes,organization,firstResult,maxResults);
        return result;
    }

    @Override
    public SearchResultsModel<InvoiceModel> search(OrganizationModel organization, SearchCriteriaModel criteria) {
        SearchResultsModel<InvoiceModel> resultsModel = this.getDelegate().search(organization, criteria);
        return resultsModel;
    }

    @Override
    public SearchResultsModel<InvoiceModel> search(OrganizationModel organization, SearchCriteriaModel criteria, String filterText) {
        SearchResultsModel<InvoiceModel> resultsModel = this.getDelegate().search(organization, criteria, filterText);
        return resultsModel;
    }

    @Override
    public void close() {
        System.out.println("___");
    }

}