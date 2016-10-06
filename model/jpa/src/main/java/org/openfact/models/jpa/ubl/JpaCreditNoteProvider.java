package org.openfact.models.jpa.ubl;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.jboss.logging.Logger;
import org.openfact.models.ModelDuplicateException;
import org.openfact.models.ModelException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.jpa.AbstractHibernateStorage;
import org.openfact.models.jpa.OrganizationAdapter;
import org.openfact.models.jpa.entities.ubl.CreditNoteEntity;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.provider.CreditNoteProvider;

public class JpaCreditNoteProvider extends AbstractHibernateStorage implements CreditNoteProvider {

    protected static final Logger logger = Logger.getLogger(JpaCreditNoteProvider.class);

    private static final String TYPE = "type";
    private static final String CURRENCY_CODE = "currencyCode";
    
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
    public CreditNoteModel addCreditNote(OrganizationModel organization, String ID) {
        if(ID == null) {
            throw new ModelException("Invalid ID, Null value");
        }
        
        if (session.creditNotes().getCreditNoteByID(organization, ID) != null) {
            throw new ModelDuplicateException("Credit note ID existed");
        }
        
        CreditNoteEntity creditNote = new CreditNoteEntity();
        creditNote.setID(ID);
        creditNote.setOrganization(OrganizationAdapter.toEntity(organization, em));
        em.persist(creditNote);
        em.flush();

        final CreditNoteModel adapter = new CreditNoteAdapter(session, organization, em, creditNote);
        session.getOpenfactSessionFactory().publish(new CreditNoteModel.CreditNoteCreationEvent() {
            @Override
            public CreditNoteModel getCreatedCreditNote() {
                return adapter;
            }
        });

        return adapter;
    }

    @Override
    public CreditNoteModel getCreditNoteById(OrganizationModel organization, String id) {
        TypedQuery<CreditNoteEntity> query = em.createNamedQuery("getOrganizationCreditNoteById",
                CreditNoteEntity.class);
        query.setParameter("id", id);
        query.setParameter("organizationId", organization.getId());
        List<CreditNoteEntity> entities = query.getResultList();
        if (entities.size() == 0)
            return null;
        return new CreditNoteAdapter(session, organization, em, entities.get(0));
    }

    @Override
    public CreditNoteModel getCreditNoteByID(OrganizationModel organization, String ID) {
        TypedQuery<CreditNoteEntity> query = em.createNamedQuery("getOrganizationCreditNoteByID",
                CreditNoteEntity.class);
        query.setParameter("ID", ID);
        query.setParameter("organizationId", organization.getId());
        List<CreditNoteEntity> entities = query.getResultList();
        if (entities.size() == 0)
            return null;
        return new CreditNoteAdapter(session, organization, em, entities.get(0));
    }

    @Override
    public boolean removeCreditNote(OrganizationModel organization, String id) {
        return removeCreditNote(organization, getCreditNoteById(organization, id));
    }

    @Override
    public boolean removeCreditNote(OrganizationModel organization, CreditNoteModel creditNote) {
        CreditNoteEntity creditNoteEntity = em.find(CreditNoteEntity.class, creditNote.getId());
        if (creditNoteEntity == null)
            return false;
        removeCreditNote(creditNoteEntity);
        session.getOpenfactSessionFactory().publish(new CreditNoteModel.CreditNoteRemovedEvent() {
            @Override
            public CreditNoteModel getCreditNote() {
                return creditNote;
            }

            @Override
            public OpenfactSession getOpenfactSession() {
                return session;
            }
        });
        return true;
    }

    private void removeCreditNote(CreditNoteEntity creditNote) {
        String id = creditNote.getId();
        creditNote = em.find(CreditNoteEntity.class, id);
        if (creditNote != null) {
            em.remove(creditNote);
        }

        em.flush();
    }

    @Override
    public List<CreditNoteModel> getCreditNotes(OrganizationModel organization) {
        return getCreditNotes(organization, -1, -1);
    }

    @Override
    public List<CreditNoteModel> getCreditNotes(OrganizationModel organization, Integer firstResult,
            Integer maxResults) {
        String queryName = "getAllCreditNotesByOrganization";

        TypedQuery<CreditNoteEntity> query = em.createNamedQuery(queryName, CreditNoteEntity.class);
        query.setParameter("organizationId", organization.getId());
        if (firstResult != -1) {
            query.setFirstResult(firstResult);
        }
        if (maxResults != -1) {
            query.setMaxResults(maxResults);
        }
        List<CreditNoteEntity> results = query.getResultList();
        List<CreditNoteModel> creditNotes = results.stream()
                .map(f -> new CreditNoteAdapter(session, organization, em, f)).collect(Collectors.toList());
        return creditNotes;
    }

    @Override
    public List<CreditNoteModel> searchForCreditNote(OrganizationModel organization, String filterText) {
        return searchForCreditNote(organization, filterText, -1, -1);
    }

    @Override
    public List<CreditNoteModel> searchForCreditNote(OrganizationModel organization, String filterText,
            Integer firstResult, Integer maxResults) {
        TypedQuery<CreditNoteEntity> query = em.createNamedQuery("searchForCreditNote", CreditNoteEntity.class);
        query.setParameter("organizationId", organization.getId());
        query.setParameter("search", "%" + filterText.toLowerCase() + "%");
        if (firstResult != -1) {
            query.setFirstResult(firstResult);
        }
        if (maxResults != -1) {
            query.setMaxResults(maxResults);
        }
        List<CreditNoteEntity> results = query.getResultList();
        List<CreditNoteModel> creditNotes = results.stream()
                .map(f -> new CreditNoteAdapter(session, organization, em, f)).collect(Collectors.toList());
        return creditNotes;
    }

    @Override
    public SearchResultsModel<CreditNoteModel> searchForCreditNote(OrganizationModel organization,
            SearchCriteriaModel criteria) {
        SearchResultsModel<CreditNoteEntity> entityResult = find(criteria, CreditNoteEntity.class);
        List<CreditNoteEntity> entities = entityResult.getModels();

        SearchResultsModel<CreditNoteModel> searchResult = new SearchResultsModel<>();
        List<CreditNoteModel> models = searchResult.getModels();

        entities.forEach(f -> models.add(new CreditNoteAdapter(session, organization, em, f)));
        searchResult.setTotalSize(entityResult.getTotalSize());
        return searchResult;
    }

    @Override
    public SearchResultsModel<CreditNoteModel> searchForCreditNote(OrganizationModel organization,
            SearchCriteriaModel criteria, String filterText) {
        SearchResultsModel<CreditNoteEntity> entityResult = findFullText(criteria, CreditNoteEntity.class,
                filterText, TYPE, CURRENCY_CODE);
        List<CreditNoteEntity> entities = entityResult.getModels();

        SearchResultsModel<CreditNoteModel> searchResult = new SearchResultsModel<>();
        List<CreditNoteModel> models = searchResult.getModels();

        entities.forEach(f -> models.add(new CreditNoteAdapter(session, organization, em, f)));
        searchResult.setTotalSize(entityResult.getTotalSize());
        return searchResult;
    }

    @Override
    public int getCreditNotesCount(OrganizationModel organization) {
        Query query = em.createNamedQuery("getOrganizationCreditNoteCount");
        Long result = (Long) query.getSingleResult();
        return result.intValue();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @Override
    public CreditNoteModel getLastCreditNote(OrganizationModel organization, int IDCreditNoteLength, String maskFormater) {
        TypedQuery<CreditNoteEntity> query = em.createNamedQuery("getLastCreditNoteByOrganization", CreditNoteEntity.class);
        query.setParameter("organizationId", organization.getId());
        query.setParameter("IDLength", IDCreditNoteLength);
        query.setParameter("formatter", maskFormater);
        query.setMaxResults(1);
        List<CreditNoteEntity> entities = query.getResultList();
        if (entities.size() == 0)
            return null;
        return new CreditNoteAdapter(session, organization, em, entities.get(0));
    }
}
