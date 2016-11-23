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

import org.jboss.logging.Logger;
import org.openfact.models.DebitNoteModel;
import org.openfact.models.DebitNoteProvider;
import org.openfact.models.ModelDuplicateException;
import org.openfact.models.ModelException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.enums.RequiredActionDocument;
import org.openfact.models.jpa.entities.DebitNoteEntity;
import org.openfact.models.search.SearchCriteriaFilterOperator;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

public class JpaDebitNoteProvider extends AbstractHibernateStorage implements DebitNoteProvider {

    protected static final Logger logger = Logger.getLogger(JpaDebitNoteProvider.class);

    private static final String ID = "ID";
    private static final String ISSUE_DATETIME = "issueDateTime";

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
        return em;
    }
    
    @Override
    public DebitNoteModel addDebitNote(OrganizationModel organization, String documentId) {
        if (documentId == null) {
            throw new ModelException("Invalid ID, Null value");
        }

        if (session.debitNotes().getDebitNoteByID(organization, documentId) != null) {
            throw new ModelDuplicateException("Debit note ID existed");
        }

        DebitNoteEntity creditNote = new DebitNoteEntity();
        creditNote.setDocumentId(documentId);
        creditNote.setOrganization(OrganizationAdapter.toEntity(organization, em));
        em.persist(creditNote);
        em.flush();

        final DebitNoteModel adapter = new DebitNoteAdapter(session, organization, em, creditNote);
        session.getOpenfactSessionFactory().publish(new DebitNoteModel.DebitNoteCreationEvent() {
            @Override
            public DebitNoteModel getCreatedDebitNote() {
                return adapter;
            }
        });

        return adapter;
    }

    @Override
    public DebitNoteModel getDebitNoteById(OrganizationModel organization, String id) {
        TypedQuery<DebitNoteEntity> query = em.createNamedQuery("getOrganizationDebitNoteById", DebitNoteEntity.class);
        query.setParameter("id", id);
        query.setParameter("organizationId", organization.getId());
        List<DebitNoteEntity> entities = query.getResultList();
        if (entities.size() == 0)
            return null;
        return new DebitNoteAdapter(session, organization, em, entities.get(0));
    }

    @Override
    public DebitNoteModel getDebitNoteByID(OrganizationModel organization, String ID) {
        TypedQuery<DebitNoteEntity> query = em.createNamedQuery("getOrganizationDebitNoteByDocumentId", DebitNoteEntity.class);
        query.setParameter("documentId", ID);
        query.setParameter("organizationId", organization.getId());
        List<DebitNoteEntity> entities = query.getResultList();
        if (entities.size() == 0)
            return null;
        return new DebitNoteAdapter(session, organization, em, entities.get(0));
    }

    @Override
    public boolean removeDebitNote(OrganizationModel organization, String id) {
        return removeDebitNote(organization, getDebitNoteById(organization, id));
    }

    @Override
    public boolean removeDebitNote(OrganizationModel organization, DebitNoteModel creditNote) {
        DebitNoteEntity creditNoteEntity = em.find(DebitNoteEntity.class, creditNote.getId());
        if (creditNoteEntity == null)
            return false;
        removeDebitNote(creditNoteEntity);
        session.getOpenfactSessionFactory().publish(new DebitNoteModel.DebitNoteRemovedEvent() {
            @Override
            public DebitNoteModel getDebitNote() {
                return creditNote;
            }

            @Override
            public OpenfactSession getOpenfactSession() {
                return session;
            }
        });
        return true;
    }

    private void removeDebitNote(DebitNoteEntity creditNote) {
        String id = creditNote.getId();
        creditNote = em.find(DebitNoteEntity.class, id);
        if (creditNote != null) {
            em.remove(creditNote);
        }

        em.flush();
    }

    @Override
    public List<DebitNoteModel> getDebitNotes(OrganizationModel organization) {
        return getDebitNotes(organization, -1, -1);
    }

    @Override
    public List<DebitNoteModel> getDebitNotes(OrganizationModel organization, Integer firstResult, Integer maxResults) {
        String queryName = "getAllDebitNotesByOrganization";

        TypedQuery<DebitNoteEntity> query = em.createNamedQuery(queryName, DebitNoteEntity.class);
        query.setParameter("organizationId", organization.getId());
        if (firstResult != -1) {
            query.setFirstResult(firstResult);
        }
        if (maxResults != -1) {
            query.setMaxResults(maxResults);
        }
        List<DebitNoteEntity> results = query.getResultList();
        List<DebitNoteModel> creditNotes = results.stream().map(f -> new DebitNoteAdapter(session, organization, em, f))
                .collect(Collectors.toList());
        return creditNotes;
    }

    @Override
    public List<DebitNoteModel> searchForDebitNote(OrganizationModel organization, String filterText) {
        return searchForDebitNote(organization, filterText, -1, -1);
    }

    @Override
    public List<DebitNoteModel> searchForDebitNote(OrganizationModel organization, String filterText,
                                                   Integer firstResult, Integer maxResults) {
        TypedQuery<DebitNoteEntity> query = em.createNamedQuery("searchForDebitNote", DebitNoteEntity.class);
        query.setParameter("organizationId", organization.getId());
        query.setParameter("search", "%" + filterText.toLowerCase() + "%");
        if (firstResult != -1) {
            query.setFirstResult(firstResult);
        }
        if (maxResults != -1) {
            query.setMaxResults(maxResults);
        }
        List<DebitNoteEntity> results = query.getResultList();
        List<DebitNoteModel> creditNotes = results.stream().map(f -> new DebitNoteAdapter(session, organization, em, f))
                .collect(Collectors.toList());
        return creditNotes;
    }

    @Override
    public SearchResultsModel<DebitNoteModel> searchForDebitNote(OrganizationModel organization,
                                                                 SearchCriteriaModel criteria) {
        criteria.addFilter("organization.id", organization.getId(), SearchCriteriaFilterOperator.eq);

        SearchResultsModel<DebitNoteEntity> entityResult = find(criteria, DebitNoteEntity.class);
        List<DebitNoteEntity> entities = entityResult.getModels();

        SearchResultsModel<DebitNoteModel> searchResult = new SearchResultsModel<>();
        List<DebitNoteModel> models = searchResult.getModels();

        entities.forEach(f -> models.add(new DebitNoteAdapter(session, organization, em, f)));
        searchResult.setTotalSize(entityResult.getTotalSize());
        return searchResult;
    }

    @Override
    public SearchResultsModel<DebitNoteModel> searchForDebitNote(OrganizationModel organization,
                                                                 SearchCriteriaModel criteria, String filterText) {
        criteria.addFilter("organization.id", organization.getId(), SearchCriteriaFilterOperator.eq);

        SearchResultsModel<DebitNoteEntity> entityResult = findFullText(criteria, DebitNoteEntity.class, filterText,
                ID);
        List<DebitNoteEntity> entities = entityResult.getModels();

        SearchResultsModel<DebitNoteModel> searchResult = new SearchResultsModel<>();
        List<DebitNoteModel> models = searchResult.getModels();

        entities.forEach(f -> models.add(new DebitNoteAdapter(session, organization, em, f)));
        searchResult.setTotalSize(entityResult.getTotalSize());
        return searchResult;
    }

    @Override
    public int getDebitNotesCount(OrganizationModel organization) {
        Query query = em.createNamedQuery("getOrganizationDebitNoteCount");
        Long result = (Long) query.getSingleResult();
        return result.intValue();
    }

    @Override
    public List<DebitNoteModel> getDebitNotes(OrganizationModel organization,
                                              List<RequiredActionDocument> requeridAction, boolean intoRequeridAction) {
        String queryName = "";
        if (intoRequeridAction) {
            queryName = "select i from DebitNoteEntity i where i.organization.id = :organizationId and :requeridAction in elements(i.requeridAction) order by i.issueDateTime ";
        } else {
            queryName = "select i from DebitNoteEntity i where i.organization.id = :organizationId and :requeridAction not in elements(i.requeridAction) order by i.issueDateTime ";
        }
        TypedQuery<DebitNoteEntity> query = em.createQuery(queryName, DebitNoteEntity.class);
        query.setParameter("organizationId", organization.getId());
        query.setParameter("requeridAction", requeridAction);
        List<DebitNoteEntity> results = query.getResultList();
        List<DebitNoteModel> creditNotes = results.stream().map(f -> new DebitNoteAdapter(session, organization, em, f))
                .collect(Collectors.toList());
        return creditNotes;
    }

}
