/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.openfact.models.jpa;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.jboss.logging.Logger;
import org.openfact.models.*;
import org.openfact.models.enums.RequiredAction;
import org.openfact.models.jpa.entities.CreditNoteAttributeEntity;
import org.openfact.models.jpa.entities.CreditNoteEntity;
import org.openfact.models.jpa.entities.InvoiceEntity;
import org.openfact.models.search.SearchCriteriaFilterOperator;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;

public class JpaCreditNoteProvider extends AbstractHibernateStorage implements CreditNoteProvider {

    protected static final Logger logger = Logger.getLogger(JpaCreditNoteProvider.class);

    private static final String DOCUMENT_ID = "DOCUMENT_ID";
    private static final String ISSUE_DATETIME = "issueDateTime";

    private final OpenfactSession session;
    protected EntityManager em;

    public JpaCreditNoteProvider(OpenfactSession session, EntityManager em) {
        this.session = session;
        this.em = em;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void close() {
    }

    @Override
    public CreditNoteModel addCreditNote(OrganizationModel organization, String documentId) {
        if (documentId == null) {
            throw new ModelException("Invalid documentId, Null value");
        }

        if (session.creditNotes().getCreditNoteByDocumentId(organization, documentId) != null) {
            throw new ModelDuplicateException("Credit note documentId existed");
        }

        CreditNoteEntity creditNote = new CreditNoteEntity();
        creditNote.setDocumentId(documentId);
        creditNote.setCreatedTimestamp(LocalDateTime.now());
        creditNote.setOrganizationId(organization.getId());
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
        TypedQuery<CreditNoteEntity> query = em.createNamedQuery("getOrganizationCreditNoteById", CreditNoteEntity.class);
        query.setParameter("id", id);
        query.setParameter("organizationId", organization.getId());
        List<CreditNoteEntity> entities = query.getResultList();
        if (entities.size() == 0)
            return null;
        return new CreditNoteAdapter(session, organization, em, entities.get(0));
    }

    @Override
    public CreditNoteModel getCreditNoteByDocumentId(OrganizationModel organization, String documentId) {
        TypedQuery<CreditNoteEntity> query = em.createNamedQuery("getOrganizationCreditNoteByDocumentId", CreditNoteEntity.class);
        query.setParameter("documentId", documentId);
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
        if (creditNoteEntity == null) return false;
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
        em.flush();
        em.clear();
        
        creditNote = em.find(CreditNoteEntity.class, id);
        if (creditNote != null) {
            em.remove(creditNote);
        }

        em.flush();
    }

    @Override
    public void preRemove(OrganizationModel organization) {
        int num = em.createNamedQuery("deleteCreditNoteRequiredActionsByOrganization").setParameter("organizationId", organization.getId()).executeUpdate();
        num = em.createNamedQuery("deleteCreditNoteAttributesByOrganization").setParameter("organizationId", organization.getId()).executeUpdate();
        num = em.createNamedQuery("deleteCreditNotesByOrganization").setParameter("organizationId", organization.getId()).executeUpdate();
    }

    @Override
    public List<CreditNoteModel> getCreditNotes(OrganizationModel organization) {
        return getCreditNotes(organization, -1, -1);
    }

    @Override
    public List<CreditNoteModel> getCreditNotes(OrganizationModel organization, Integer firstResult, Integer maxResults) {
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
        List<CreditNoteModel> creditNotes = results.stream().map(f -> new CreditNoteAdapter(session, organization, em, f)).collect(Collectors.toList());
        return creditNotes;
    }

    @Override
    public List<CreditNoteModel> searchForCreditNote(OrganizationModel organization, String filterText) {
        return searchForCreditNote(organization, filterText, -1, -1);
    }

    @Override
    public List<CreditNoteModel> searchForCreditNote(OrganizationModel organization, String filterText, Integer firstResult, Integer maxResults) {
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
        List<CreditNoteModel> creditNotes = results.stream().map(f -> new CreditNoteAdapter(session, organization, em, f)).collect(Collectors.toList());
        return creditNotes;
    }

    @Override
    public SearchResultsModel<CreditNoteModel> searchForCreditNote(OrganizationModel organization, SearchCriteriaModel criteria) {
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
    public SearchResultsModel<CreditNoteModel> searchForCreditNote(OrganizationModel organization, SearchCriteriaModel criteria, String filterText) {
        criteria.addFilter("organization.id", organization.getId(), SearchCriteriaFilterOperator.eq);

        SearchResultsModel<CreditNoteEntity> entityResult = findFullText(criteria, CreditNoteEntity.class, filterText, DOCUMENT_ID);
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
    public List<CreditNoteModel> getCreditNotes(OrganizationModel organization, List<RequiredAction> requeridAction, boolean intoRequeridAction) {
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
        List<CreditNoteModel> creditNotes = results.stream().map(f -> new CreditNoteAdapter(session, organization, em, f)).collect(Collectors.toList());
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
    public ScrollModel<CreditNoteModel> getCreditNotesScroll(OrganizationModel organization, boolean asc, int scrollSize) {
        if (scrollSize == -1) {
            scrollSize = 10;
        }

        TypedQuery<CreditNoteEntity> query = em.createNamedQuery("getAllCreditNotesByOrganization", CreditNoteEntity.class);
        query.setParameter("organizationId", organization.getId());

        ScrollAdapter<CreditNoteModel, CreditNoteEntity> result = new ScrollAdapter<>(CreditNoteEntity.class, query, f -> {
            return new CreditNoteAdapter(session, organization, em, f);
        });

        return result;
    }

    @Override
    public ScrollModel<List<CreditNoteModel>> getCreditNotesScroll(OrganizationModel organization, int scrollSize, RequiredAction... requiredAction) {
        if (scrollSize == -1) {
            scrollSize = 10;
        }

        TypedQuery<CreditNoteEntity> query = em.createNamedQuery("getAllCreditNotesByRequiredActionAndOrganization", CreditNoteEntity.class);
        query.setParameter("organizationId", organization.getId());
        query.setParameter("requiredAction", new ArrayList<RequiredAction>(Arrays.asList(requiredAction)));

        ScrollModel<List<CreditNoteModel>> result = new ScrollPagingAdapter<>(CreditNoteEntity.class, query, f -> {
            return f.stream().map(m -> new CreditNoteAdapter(session, organization, em, m)).collect(Collectors.toList());
        });
        return null;
    }

}
