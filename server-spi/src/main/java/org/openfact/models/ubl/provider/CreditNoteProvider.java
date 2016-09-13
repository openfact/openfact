package org.openfact.models.ubl.provider;

import java.util.List;

import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.OrganizationModel;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;
import org.openfact.provider.Provider;

public interface CreditNoteProvider extends Provider {

    /**
     * Create
     */
    CreditNoteModel addInvoice(OrganizationModel organization);
    
    /**
     * Find
     */
    CreditNoteModel getInvoiceById(OrganizationModel organization, String id);

    /**
     * Remove*/
    boolean removeInvoice(OrganizationModel organization, String id);
    
    boolean removeInvoice(OrganizationModel organization, CreditNoteModel invoice);           
    
    /**
     * Get invoices by organization
     */
    List<CreditNoteModel> getInvoices(OrganizationModel organization);
    
    List<CreditNoteModel> getInvoices(OrganizationModel organization, Integer firstResult, Integer maxResults);       
        
    /**
     * Search by filterText
     */
    List<CreditNoteModel> searchForInvoice(String filterText, OrganizationModel organization);
    
    List<CreditNoteModel> searchForInvoice(String filterText, OrganizationModel organization, Integer firstResult, Integer maxResults);
    
    /**
     * Search advanced
     */
    SearchResultsModel<CreditNoteModel> searchForInvoice(OrganizationModel organization, SearchCriteriaModel criteria);

    SearchResultsModel<CreditNoteModel> searchForInvoice(OrganizationModel organization, SearchCriteriaModel criteria, String filterText);
    
    /**
     * Count*/
    int getInvoicesCount(OrganizationModel organization);

}
