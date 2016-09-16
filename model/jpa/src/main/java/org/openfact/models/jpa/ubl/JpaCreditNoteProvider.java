package org.openfact.models.jpa.ubl;

import java.util.List;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.jpa.AbstractHibernateStorage;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.provider.CreditNoteProvider;

public class JpaCreditNoteProvider extends AbstractHibernateStorage implements CreditNoteProvider {

    protected static final Logger logger = Logger.getLogger(JpaCreditNoteProvider.class);

    private final OpenfactSession session;
    protected EntityManager em;

    public JpaCreditNoteProvider(OpenfactSession session, EntityManager em) {
        this.session = session;
        this.em = em;
    }

    @Override
    public void close() {
        // TODO Auto-generated method stub

    }

    @Override
    public CreditNoteModel addCreditNote(OrganizationModel organization) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CreditNoteModel getCreditNoteById(OrganizationModel organization, String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean removeCreditNote(OrganizationModel organization, String id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean removeCreditNote(OrganizationModel organization, CreditNoteModel crebitNote) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<CreditNoteModel> getCreditNotes(OrganizationModel organization) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CreditNoteModel> getCreditNotes(OrganizationModel organization, Integer firstResult,
            Integer maxResults) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CreditNoteModel> searchForCreditNote(String filterText, OrganizationModel organization) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CreditNoteModel> searchForCreditNote(String filterText, OrganizationModel organization,
            Integer firstResult, Integer maxResults) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SearchResultsModel<CreditNoteModel> searchForCreditNote(OrganizationModel organization,
            SearchCriteriaModel criteria) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SearchResultsModel<CreditNoteModel> searchForCreditNote(OrganizationModel organization,
            SearchCriteriaModel criteria, String filterText) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getCreditNotesCount(OrganizationModel organization) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    protected EntityManager getEntityManager() {
        // TODO Auto-generated method stub
        return null;
    }

}
