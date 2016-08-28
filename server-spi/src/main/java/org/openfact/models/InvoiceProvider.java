package org.openfact.models;

import java.util.List;
import java.util.Map;

import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;
import org.openfact.provider.Provider;

public interface InvoiceProvider extends Provider {

    InvoiceModel addInvoice(OrganizationModel organization);
    
    InvoiceModel addInvoice(OrganizationModel organization, int series, int number);
    
    
    InvoiceModel getInvoiceById(String id, OrganizationModel organization);
    
    InvoiceModel getInvoiceBySeriesAndNumber(int set, int number, OrganizationModel organization);

    boolean removeInvoice(OrganizationModel organization, InvoiceModel invoice);
    
    
    List<InvoiceModel> getInvoices(OrganizationModel organization, Integer firstResult, Integer maxResults);

    List<InvoiceModel> searchForInvoice(String filterText, OrganizationModel organization);
    
    List<InvoiceModel> searchForInvoice(String filterText, OrganizationModel organization, Integer firstResult, Integer maxResults);
    
    List<InvoiceModel> searchForInvoiceByAttributes(Map<String, String> attributes, OrganizationModel organization);
    
    List<InvoiceModel> searchForInvoiceByAttributes(Map<String, String> attributes, OrganizationModel organization, Integer firstResult, Integer maxResults);    


    SearchResultsModel<InvoiceModel> search(OrganizationModel organization, SearchCriteriaModel criteria);

    SearchResultsModel<InvoiceModel> search(OrganizationModel organization, SearchCriteriaModel criteria, String filterText);

	List<InvoiceModel> searchForInvoiceByAttribute(String string, String string2, OrganizationModel organization);       
        
}
