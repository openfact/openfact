package org.openfact.models.ubl.provider;

import java.util.List;

import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.OrganizationModel;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;
import org.openfact.provider.Provider;

public interface DebitNoteProvider extends Provider {

    DebitNoteModel addDebitNote(OrganizationModel organization);

    DebitNoteModel addDebitNote(OrganizationModel organization, String ID);

    DebitNoteModel getDebitNoteById(OrganizationModel organization, String id);

    DebitNoteModel getDebitNoteByID(OrganizationModel organization, String ID);

    boolean removeDebitNote(OrganizationModel organization, String id);

    boolean removeDebitNote(OrganizationModel organization, DebitNoteModel debitNote);

    List<DebitNoteModel> getDebitNotes(OrganizationModel organization);

    List<DebitNoteModel> getDebitNotes(OrganizationModel organization, Integer firstResult,
            Integer maxResults);

    List<DebitNoteModel> searchForDebitNote(String filterText, OrganizationModel organization);

    List<DebitNoteModel> searchForDebitNote(String filterText, OrganizationModel organization,
            Integer firstResult, Integer maxResults);

    SearchResultsModel<DebitNoteModel> searchForDebitNote(OrganizationModel organization,
            SearchCriteriaModel criteria);

    SearchResultsModel<DebitNoteModel> searchForDebitNote(OrganizationModel organization,
            SearchCriteriaModel criteria, String filterText);

    int getDebitNotesCount(OrganizationModel organization);

}
