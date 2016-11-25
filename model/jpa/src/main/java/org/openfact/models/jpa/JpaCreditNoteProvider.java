/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.openfact.models.jpa;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.jboss.logging.Logger;
import org.openfact.models.CreditNoteModel;
import org.openfact.models.CreditNoteProvider;
import org.openfact.models.ModelDuplicateException;
import org.openfact.models.ModelException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.ScrollModel;
import org.openfact.models.enums.RequiredActionDocument;
import org.openfact.models.jpa.entities.CreditNoteEntity;
import org.openfact.models.search.SearchCriteriaFilterOperator;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;

public class JpaCreditNoteProvider extends AbstractHibernateStorage implements CreditNoteProvider {

    protected static final Logger logger = Logger.getLogger(JpaCreditNoteProvider.class);

    private static final String ID = "ID";
    private static final String ISSUE_DATETIME = "issueDateTime";

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
    public CreditNoteModel addCreditNote(OrganizationModel organization, String documentId) {
        if (documentId == null) {
            throw new ModelException("Invalid ID, Null value");
        }

        if (session.creditNotes().getCreditNoteByID(organization, documentId) != null) {
            throw new ModelDuplicateException("Credit note ID existed");
        }

        CreditNoteEntity creditNote = new CreditNoteEntity();
        creditNote.setDocumentId(documentId);
        creditNote.setCreatedTimestamp(LocalDateTime.now());
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
        TypedQuery<CreditNoteEntity> query = em.createNamedQuery("getOrganizationCreditNoteByDocumentId",
                CreditNoteEntity.class);
        query.setParameter("documentId", ID);
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
        TypedQuery<CreditNoteEntity> query = em.createNamedQuery("searchForCreditNote",
                CreditNoteEntity.class);
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
        criteria.addFilter("organization.id", organization.getId(), SearchCriteriaFilterOperator.eq);

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
        criteria.addFilter("organization.id", organization.getId(), SearchCriteriaFilterOperator.eq);

        SearchResultsModel<CreditNoteEntity> entityResult = findFullText(criteria, CreditNoteEntity.class,
                filterText, ID);
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
    public List<CreditNoteModel> getCreditNotes(OrganizationModel organization,
            List<RequiredActionDocument> requeridAction, boolean intoRequeridAction) {
        String queryName = "";
        if (intoRequeridAction) {
            queryName = "select i from CreditNoteEntity i where i.organization.id = :organizationId and :requeridAction in elements(i.requeridAction) order by i.issueDateTime ";
        } else {
            queryName = "select i from CreditNoteEntity i where i.organization.id = :organizationId and :requeridAction not in elements(i.requeridAction) order by i.issueDateTime ";
        }
        TypedQuery<CreditNoteEntity> query = em.createQuery(queryName, CreditNoteEntity.class);
        query.setParameter("organizationId", organization.getId());
        query.setParameter("requeridAction", requeridAction);
        List<CreditNoteEntity> results = query.getResultList();
        List<CreditNoteModel> creditNotes = results.stream()
                .map(f -> new CreditNoteAdapter(session, organization, em, f)).collect(Collectors.toList());
        return creditNotes;
    }

    @Override
    public ScrollModel<CreditNoteModel> getCreditNotesScroll(OrganizationModel organization) {
        return getCreditNotesScroll(organization, true);
    }

    @Override
    public ScrollModel<CreditNoteModel> getCreditNotesScroll(OrganizationModel organization, boolean asc) {
        return getCreditNotesScroll(organization, asc, -1);
    }

    @Override
    public ScrollModel<CreditNoteModel> getCreditNotesScroll(OrganizationModel organization, boolean asc,
            int scrollSize) {
        return getCreditNotesScroll(organization, asc, scrollSize, -1);
    }

    @Override
    public ScrollModel<CreditNoteModel> getCreditNotesScroll(OrganizationModel organization, boolean asc,
            int scrollSize, int fetchSize) {
        if (scrollSize == -1) {
            scrollSize = 5;
        }
        if (fetchSize == -1) {
            scrollSize = 1;
        }

        Criteria criteria = getSession().createCriteria(CreditNoteEntity.class)
                .add(Restrictions.eq("organization.id", organization.getId()))
                .addOrder(asc ? Order.asc("createdTimestamp") : Order.desc("createdTimestamp"));

        JpaScrollAdapter<CreditNoteModel, CreditNoteEntity> result = new JpaScrollAdapter<>(criteria,
                scrollSize, f -> new CreditNoteAdapter(session, organization, em, f));
        return result;
    }

}
