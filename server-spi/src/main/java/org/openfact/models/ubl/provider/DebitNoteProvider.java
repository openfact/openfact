package org.openfact.models.ubl.provider;

import java.util.List;

import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.OrganizationModel;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;
import org.openfact.provider.Provider;

 public interface DebitNoteProvider extends Provider {

    
    DebitNoteModel addInvoice(OrganizationModel organization);
    
    
    DebitNoteModel getInvoiceById(OrganizationModel organization, String id);

    
    boolean removeInvoice(OrganizationModel organization, String id);
    
    boolean removeInvoice(OrganizationModel organization, DebitNoteModel invoice);           
    
    
    List<DebitNoteModel> getInvoices(OrganizationModel organization);
    
    List<DebitNoteModel> getInvoices(OrganizationModel organization, Integer firstResult, Integer maxResults);       
        
    
    List<DebitNoteModel> searchForInvoice(String filterText, OrganizationModel organization);
    
    List<DebitNoteModel> searchForInvoice(String filterText, OrganizationModel organization, Integer firstResult, Integer maxResults);
    
    
    SearchResultsModel<DebitNoteModel> searchForInvoice(OrganizationModel organization, SearchCriteriaModel criteria);

    SearchResultsModel<DebitNoteModel> searchForInvoice(OrganizationModel organization, SearchCriteriaModel criteria, String filterText);
    
    
    int getInvoicesCount(OrganizationModel organization);

}
