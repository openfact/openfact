package org.openfact.models.ubl.provider;

import java.util.List;

import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.OrganizationModel;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;
import org.openfact.provider.Provider;

public interface InvoiceProvider extends Provider {

    InvoiceModel addInvoice(OrganizationModel organization);

    InvoiceModel getInvoiceById(OrganizationModel organization, String id);

    boolean removeInvoice(OrganizationModel organization, String id);

    boolean removeInvoice(OrganizationModel organization, InvoiceModel invoice);

    List<InvoiceModel> getInvoices(OrganizationModel organization);

    List<InvoiceModel> getInvoices(OrganizationModel organization, Integer firstResult, Integer maxResults);

    List<InvoiceModel> searchForInvoice(String filterText, OrganizationModel organization);

    List<InvoiceModel> searchForInvoice(String filterText, OrganizationModel organization, Integer firstResult, Integer maxResults);

    SearchResultsModel<InvoiceModel> searchForInvoice(OrganizationModel organization, SearchCriteriaModel criteria);

    SearchResultsModel<InvoiceModel> searchForInvoice(OrganizationModel organization, SearchCriteriaModel criteria, String filterText);

    int getInvoicesCount(OrganizationModel organization);

}
