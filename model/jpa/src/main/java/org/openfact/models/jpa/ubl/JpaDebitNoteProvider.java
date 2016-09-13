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

    private final OpenfactSession session;
    protected EntityManager em;

    public JpaDebitNoteProvider(OpenfactSession session, EntityManager em) {
        this.session = session;
        this.em = em;
    }

    @Override
    public void close() {
        // TODO Auto-generated method stub
    }

    @Override
    protected EntityManager getEntityManager() {
        return this.em;
    }

    @Override
    public DebitNoteModel addInvoice(OrganizationModel organization) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DebitNoteModel getInvoiceById(OrganizationModel organization, String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean removeInvoice(OrganizationModel organization, String id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean removeInvoice(OrganizationModel organization, DebitNoteModel invoice) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<DebitNoteModel> getInvoices(OrganizationModel organization) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<DebitNoteModel> getInvoices(OrganizationModel organization, Integer firstResult,
            Integer maxResults) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<DebitNoteModel> searchForInvoice(String filterText, OrganizationModel organization) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<DebitNoteModel> searchForInvoice(String filterText, OrganizationModel organization,
            Integer firstResult, Integer maxResults) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SearchResultsModel<DebitNoteModel> searchForInvoice(OrganizationModel organization,
            SearchCriteriaModel criteria) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SearchResultsModel<DebitNoteModel> searchForInvoice(OrganizationModel organization,
            SearchCriteriaModel criteria, String filterText) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getInvoicesCount(OrganizationModel organization) {
        // TODO Auto-generated method stub
        return 0;
    }

}
