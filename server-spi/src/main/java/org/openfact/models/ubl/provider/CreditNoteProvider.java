package org.openfact.models.ubl.provider;

import java.util.List;

import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.OrganizationModel;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;
import org.openfact.provider.Provider;

 public interface CreditNoteProvider extends Provider {

    
    CreditNoteModel addInvoice(OrganizationModel organization);
    
    
    CreditNoteModel getInvoiceById(OrganizationModel organization, String id);

    
    boolean removeInvoice(OrganizationModel organization, String id);
    
    boolean removeInvoice(OrganizationModel organization, CreditNoteModel invoice);           
    
    
    List<CreditNoteModel> getInvoices(OrganizationModel organization);
    
    List<CreditNoteModel> getInvoices(OrganizationModel organization, Integer firstResult, Integer maxResults);       
        
    
    List<CreditNoteModel> searchForInvoice(String filterText, OrganizationModel organization);
    
    List<CreditNoteModel> searchForInvoice(String filterText, OrganizationModel organization, Integer firstResult, Integer maxResults);
    
    
    SearchResultsModel<CreditNoteModel> searchForInvoice(OrganizationModel organization, SearchCriteriaModel criteria);

    SearchResultsModel<CreditNoteModel> searchForInvoice(OrganizationModel organization, SearchCriteriaModel criteria, String filterText);
    
    
    int getInvoicesCount(OrganizationModel organization);

}
