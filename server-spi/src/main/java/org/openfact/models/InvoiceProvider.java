package org.openfact.models;

import java.util.List;
import java.util.Map;

import org.openfact.models.InvoiceModel.RequiredAction;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;
import org.openfact.provider.Provider;

public interface InvoiceProvider extends Provider {

    /**
     * Create
     */
    InvoiceModel addInvoice(OrganizationModel organization);
    
    InvoiceModel addInvoice(OrganizationModel organization, int series, int number);
    
    /**
     * Find
     */
    InvoiceModel getInvoiceById(String id, OrganizationModel organization);
    
    InvoiceModel getInvoiceBySeriesAndNumber(int series, int number, OrganizationModel organization);

    /**
     * Remove*/
    boolean removeInvoice(OrganizationModel organization, InvoiceModel invoice);           
    
    /**
     * Get invoices by organization
     */
    List<InvoiceModel> getInvoices(OrganizationModel organization);
    
    List<InvoiceModel> getInvoices(OrganizationModel organization, Integer firstResult, Integer maxResults);       
    
    /**
     * Get invoices by Required actions
     */
    List<InvoiceModel> searchForInvoiceByRequiredAction(String action);
    
    List<InvoiceModel> searchForInvoiceByRequiredAction(RequiredAction action);
    
    List<InvoiceModel> searchForInvoiceByRequiredAction(String action, OrganizationModel organization);
    
    List<InvoiceModel> searchForInvoiceByRequiredAction(RequiredAction action, OrganizationModel organization);
    
    /**
     * Search by attribute
     */
    List<InvoiceModel> searchForInvoiceByAttribute(String key, String value, OrganizationModel organization);
    
    List<InvoiceModel> searchForInvoiceByAttributes(Map<String, String> attributes, OrganizationModel organization);
    
    List<InvoiceModel> searchForInvoiceByAttributes(Map<String, String> attributes, OrganizationModel organization, Integer firstResult, Integer maxResults);    

        
    /**
     * Search by filterText
     */
    List<InvoiceModel> searchForInvoice(String filterText, OrganizationModel organization);
    
    List<InvoiceModel> searchForInvoice(String filterText, OrganizationModel organization, Integer firstResult, Integer maxResults);
    
    /**
     * Search advanced
     */
    SearchResultsModel<InvoiceModel> searchForInvoice(OrganizationModel organization, SearchCriteriaModel criteria);

    SearchResultsModel<InvoiceModel> searchForInvoice(OrganizationModel organization, SearchCriteriaModel criteria, String filterText);
    
    /**
     * Count*/
    int getInvoicesCount(OrganizationModel organization);
        
}
