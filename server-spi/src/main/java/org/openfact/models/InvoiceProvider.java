package org.openfact.models;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.openfact.models.enums.InvoiceType;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;
import org.openfact.provider.Provider;

public interface InvoiceProvider extends Provider {

    InvoiceModel addInvoice(OrganizationModel organization, InvoiceType type, String currencyCode, LocalDate issueDate);

    InvoiceModel addInvoice(OrganizationModel organization, String id, InvoiceType type, String currencyCode, LocalDate issueDate);

    
    InvoiceModel getInvoiceById(String id, OrganizationModel organization);
    
    InvoiceModel getInvoiceBySetAndNumber(int set, int number, OrganizationModel organization);

    boolean removeInvoice(OrganizationModel organization, InvoiceModel invoice);   
    
    
    List<InvoiceModel> getInvoices(OrganizationModel organization, Integer firstResult, Integer maxResults);

    List<InvoiceModel> searchForInvoice(String filterText, OrganizationModel organization, Integer firstResult, Integer maxResults);
    
    List<InvoiceModel> searchForInvoiceByAttributes(Map<String, String> attributes, OrganizationModel organizatio);
    
    List<InvoiceModel> searchForInvoiceByAttributes(Map<String, String> attributes, OrganizationModel organization, Integer firstResult, Integer maxResults);    


    SearchResultsModel<InvoiceModel> search(OrganizationModel organization, SearchCriteriaModel criteria);

    SearchResultsModel<InvoiceModel> search(OrganizationModel organization, SearchCriteriaModel criteria, String filterText);
    
    /*
     * Customer resources*/
    
    CustomerModel addCustomer(InvoiceModel invoice, String registrationName);
    
    
    /*
     * InvoiceId resources*/
    
    InvoiceIdModel addInvoiceId(InvoiceModel invoice, int set, int number);

}
