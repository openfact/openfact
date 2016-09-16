package org.openfact.models.jpa.ubl;

import java.util.List;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.jpa.AbstractHibernateStorage;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.provider.DebitNoteProvider;

public class JpaDebitNoteProvider extends AbstractHibernateStorage implements DebitNoteProvider {

    protected static final Logger logger = Logger.getLogger(JpaDebitNoteProvider.class);

    public JpaDebitNoteProvider(OpenfactSession session, EntityManager em) {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void close() {
        // TODO Auto-generated method stub

    }

    @Override
    public DebitNoteModel addDebitNote(OrganizationModel organization) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DebitNoteModel getDebitNoteById(OrganizationModel organization, String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean removeDebitNote(OrganizationModel organization, String id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean removeDebitNote(OrganizationModel organization, DebitNoteModel debitNote) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<DebitNoteModel> getDebitNotes(OrganizationModel organization) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<DebitNoteModel> getDebitNotes(OrganizationModel organization, Integer firstResult,
            Integer maxResults) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<DebitNoteModel> searchForDebitNote(String filterText, OrganizationModel organization) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<DebitNoteModel> searchForDebitNote(String filterText, OrganizationModel organization,
            Integer firstResult, Integer maxResults) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SearchResultsModel<DebitNoteModel> searchForDebitNote(OrganizationModel organization,
            SearchCriteriaModel criteria) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SearchResultsModel<DebitNoteModel> searchForDebitNote(OrganizationModel organization,
            SearchCriteriaModel criteria, String filterText) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getDebitNotesCount(OrganizationModel organization) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    protected EntityManager getEntityManager() {
        // TODO Auto-generated method stub
        return null;
    }

}
