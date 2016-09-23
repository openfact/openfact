package org.openfact.models.ubl.provider;

import java.util.List;

import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.OrganizationModel;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;
import org.openfact.provider.Provider;

public interface CreditNoteProvider extends Provider {

    CreditNoteModel addCreditNote(OrganizationModel organization);

    CreditNoteModel addCreditNote(OrganizationModel organization, String ID);

    CreditNoteModel getCreditNoteById(OrganizationModel organization, String id);

    CreditNoteModel getInvoiceByID(OrganizationModel organizationModel, String ID);

    boolean removeCreditNote(OrganizationModel organization, String id);

    boolean removeCreditNote(OrganizationModel organization, CreditNoteModel crebitNote);

    List<CreditNoteModel> getCreditNotes(OrganizationModel organization);

    List<CreditNoteModel> getCreditNotes(OrganizationModel organization, Integer firstResult,
            Integer maxResults);

    List<CreditNoteModel> searchForCreditNote(String filterText, OrganizationModel organization);

    List<CreditNoteModel> searchForCreditNote(String filterText, OrganizationModel organization,
            Integer firstResult, Integer maxResults);

    SearchResultsModel<CreditNoteModel> searchForCreditNote(OrganizationModel organization,
            SearchCriteriaModel criteria);

    SearchResultsModel<CreditNoteModel> searchForCreditNote(OrganizationModel organization,
            SearchCriteriaModel criteria, String filterText);

    int getCreditNotesCount(OrganizationModel organization);

}
