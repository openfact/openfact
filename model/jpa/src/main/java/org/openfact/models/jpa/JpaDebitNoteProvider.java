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
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.jboss.logging.Logger;
import org.openfact.models.*;
import org.openfact.models.enums.RequiredAction;
import org.openfact.models.jpa.entities.DebitNoteAttributeEntity;
import org.openfact.models.jpa.entities.DebitNoteEntity;
import org.openfact.models.jpa.entities.InvoiceAttributeEntity;
import org.openfact.models.jpa.entities.InvoiceEntity;
import org.openfact.models.search.SearchCriteriaFilterOperator;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;

public class JpaDebitNoteProvider extends AbstractHibernateStorage implements DebitNoteProvider {

    protected static final Logger logger = Logger.getLogger(JpaDebitNoteProvider.class);

    protected static final String DOCUMENT_ID = "documentId";
    protected static final String ISSUE_DATETIME = "issueDateTime";
    protected static final String DOCUMENT_CURRENCY_CODE = "documentCurrencyCode";
    protected static final String CUSTOMER_REGISTRATION_NAME = "customerRegistrationName";
    protected static final String CUSTOMER_ASSIGNED_ACCOUNT_ID = "customerAssignedAccountId";
    protected static final String PAYABLE_AMOUNT = "payableAmount";

    protected static final String SEND_EVENT_DESTINY_TYPE = "destinyType";
    protected static final String SEND_EVENT_TYPE = "type";
    protected static final String SEND_EVENT_RESULT = "result";

    protected final OpenfactSession session;
    protected EntityManager em;

    public JpaDebitNoteProvider(OpenfactSession session, EntityManager em) {
        this.session = session;
        this.em = em;
    }

    @Override
    public void close() {
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public DebitNoteModel addDebitNote(OrganizationModel organization, String documentId) {
        if (session.debitNotes().getDebitNoteByDocumentId(organization, documentId) != null) {
            throw new ModelDuplicateException("Invoice documentId[" + documentId + "] exists");
        }

        DebitNoteEntity debitNote = new DebitNoteEntity();
        debitNote.setDocumentId(documentId);
        debitNote.setCreatedTimestamp(LocalDateTime.now());
        debitNote.setOrganizationId(organization.getId());
        em.persist(debitNote);
        em.flush();

        final DebitNoteModel adapter = new DebitNoteAdapter(session, organization, em, debitNote);
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
        if (entities.size() == 0) return null;
        return new DebitNoteAdapter(session, organization, em, entities.get(0));
    }

    @Override
    public DebitNoteModel getDebitNoteByDocumentId(OrganizationModel organization, String ID) {
        TypedQuery<DebitNoteEntity> query = em.createNamedQuery("getOrganizationDebitNoteByDocumentId", DebitNoteEntity.class);
        query.setParameter("documentId", ID);
        query.setParameter("organizationId", organization.getId());
        List<DebitNoteEntity> entities = query.getResultList();
        if (entities.size() == 0) return null;
        return new DebitNoteAdapter(session, organization, em, entities.get(0));
    }

    @Override
    public boolean removeDebitNote(OrganizationModel organization, String id) {
        return removeDebitNote(organization, getDebitNoteById(organization, id));
    }

    @Override
    public boolean removeDebitNote(OrganizationModel organization, DebitNoteModel debitNote) {
        DebitNoteEntity debitNoteEntity = em.find(DebitNoteEntity.class, debitNote.getId());
        if (debitNoteEntity == null) return false;
        removeDebitNote(debitNoteEntity);
        session.getOpenfactSessionFactory().publish(new DebitNoteModel.DebitNoteRemovedEvent() {
            @Override
            public DebitNoteModel getDebitNote() {
                return debitNote;
            }

            @Override
            public OpenfactSession getOpenfactSession() {
                return session;
            }
        });
        return true;
    }

    private void removeDebitNote(DebitNoteEntity debitNote) {
        String id = debitNote.getId();
        em.flush();
        em.clear();

        debitNote = em.find(DebitNoteEntity.class, id);
        if (debitNote != null) {
            em.remove(debitNote);
        }

        em.flush();
    }

    @Override
    public void preRemove(OrganizationModel organization) {
        int num = em.createNamedQuery("deleteDebitNoteRequiredActionsByOrganization").setParameter("organizationId", organization.getId()).executeUpdate();

        num = em.createNamedQuery("deleteDebitNoteAttatchedDocumentAttributesByOrganization").setParameter("organizationId", organization.getId()).executeUpdate();
        num = em.createNamedQuery("deleteDebitNoteAttatchedDocumentByOrganization").setParameter("organizationId", organization.getId()).executeUpdate();

        num = em.createNamedQuery("deleteDebitNoteSendEventDestinyAttributesByOrganization").setParameter("organizationId", organization.getId()).executeUpdate();
        num = em.createNamedQuery("deleteDebitNoteSendEventResponseAttributesByOrganization").setParameter("organizationId", organization.getId()).executeUpdate();
        num = em.createNamedQuery("deleteDebitNoteSendEventByOrganization").setParameter("organizationId", organization.getId()).executeUpdate();

        num = em.createNamedQuery("deleteDebitNoteAttributesByOrganization").setParameter("organizationId", organization.getId()).executeUpdate();
        num = em.createNamedQuery("deleteDebitNotesByOrganization").setParameter("organizationId", organization.getId()).executeUpdate();
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
        return results.stream().map(f -> new DebitNoteAdapter(session, organization, em, f)).collect(Collectors.toList());
    }

    @Override
    public List<DebitNoteModel> searchForDebitNote(OrganizationModel organization, String filterText) {
        return searchForDebitNote(organization, filterText, -1, -1);
    }

    @Override
    public List<DebitNoteModel> searchForDebitNote(OrganizationModel organization, String filterText, Integer firstResult, Integer maxResults) {
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
        return results.stream().map(f -> new DebitNoteAdapter(session, organization, em, f)).collect(Collectors.toList());
    }

    @Override
    public SearchResultsModel<DebitNoteModel> searchForDebitNote(OrganizationModel organization, SearchCriteriaModel criteria) {
        criteria.addFilter("organizationId", organization.getId(), SearchCriteriaFilterOperator.eq);

        SearchResultsModel<DebitNoteEntity> entityResult = find(criteria, DebitNoteEntity.class);
        List<DebitNoteEntity> entities = entityResult.getModels();

        SearchResultsModel<DebitNoteModel> searchResult = new SearchResultsModel<>();
        List<DebitNoteModel> models = searchResult.getModels();

        entities.forEach(f -> models.add(new DebitNoteAdapter(session, organization, em, f)));
        searchResult.setTotalSize(entityResult.getTotalSize());
        return searchResult;
    }

    @Override
    public SearchResultsModel<DebitNoteModel> searchForDebitNote(OrganizationModel organization, SearchCriteriaModel criteria, String filterText) {
        criteria.addFilter("organizationId", organization.getId(), SearchCriteriaFilterOperator.eq);

        SearchResultsModel<DebitNoteEntity> entityResult = findFullText(criteria, DebitNoteEntity.class, filterText, DOCUMENT_ID);
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
    public List<DebitNoteModel> getDebitNotes(OrganizationModel organization, List<RequiredAction> requeridAction, boolean intoRequeridAction) {
        String queryName = "";
        if (intoRequeridAction) {
            queryName = "select i from DebitNoteEntity i where i.organizationId = :organizationId and :requeridAction in elements(i.requeridAction) order by i.issueDateTime ";
        } else {
            queryName = "select i from DebitNoteEntity i where i.organizationId = :organizationId and :requeridAction not in elements(i.requeridAction) order by i.issueDateTime ";
        }
        TypedQuery<DebitNoteEntity> query = em.createQuery(queryName, DebitNoteEntity.class);
        query.setParameter("organizationId", organization.getId());
        query.setParameter("requeridAction", requeridAction);
        List<DebitNoteEntity> results = query.getResultList();
        List<DebitNoteModel> debitNotes = results.stream().map(f -> new DebitNoteAdapter(session, organization, em, f)).collect(Collectors.toList());
        return debitNotes;
    }

    @Override
    public ScrollModel<DebitNoteModel> getDebitNotesScroll(OrganizationModel organization) {
        return getDebitNotesScroll(organization, true);
    }

    @Override
    public ScrollModel<DebitNoteModel> getDebitNotesScroll(OrganizationModel organization, boolean asc) {
        return getDebitNotesScroll(organization, asc, -1);
    }

    @Override
    public ScrollModel<DebitNoteModel> getDebitNotesScroll(OrganizationModel organization, boolean asc, int scrollSize) {
        if (scrollSize == -1) {
            scrollSize = 10;
        }

        String queryName = null;
        if(asc) {
            queryName = "getAllDebitNotesByOrganization";
        } else {
            queryName = "getAllDebitNotesByOrganizationDesc";
        }

        TypedQuery<DebitNoteEntity> query = em.createNamedQuery(queryName, DebitNoteEntity.class);
        query.setParameter("organizationId", organization.getId());

        ScrollAdapter<DebitNoteModel, DebitNoteEntity> result = new ScrollAdapter<>(DebitNoteEntity.class, query, f -> {
            return new DebitNoteAdapter(session, organization, em, f);
        });

        return result;
    }

    @Override
    public ScrollModel<List<DebitNoteModel>> getDebitNotesScroll(OrganizationModel organization, int scrollSize, String... requiredAction) {
        if (scrollSize == -1) {
            scrollSize = 10;
        }

        TypedQuery<DebitNoteEntity> query = em.createNamedQuery("getAllDebitNotesByRequiredActionAndOrganization", DebitNoteEntity.class);
        query.setParameter("organizationId", organization.getId());
        query.setParameter("requiredAction", new ArrayList<>(Arrays.asList(requiredAction)));

        ScrollModel<List<DebitNoteModel>> result = new ScrollPagingAdapter<>(DebitNoteEntity.class, query, f -> {
            return f.stream().map(m -> new DebitNoteAdapter(session, organization, em, m)).collect(Collectors.toList());
        });
        return result;
    }

    @Override
    public List<DebitNoteModel> searchForDebitNote(Map<String, String> attributes, OrganizationModel organization) {
        return searchForDebitNote(attributes, organization, -1, -1);
    }

    @Override
    public List<DebitNoteModel> searchForDebitNote(Map<String, String> attributes, OrganizationModel organization, int firstResult, int maxResults) {
        StringBuilder builder = new StringBuilder("select u from DebitNoteEntity u where u.organizationId = :organizationId");
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            String attribute = null;
            String parameterName = null;
            if (entry.getKey().equals(DebitNoteModel.DOCUMENT_ID)) {
                attribute = "lower(u.documentId)";
                parameterName = JpaDebitNoteProvider.DOCUMENT_ID;
            }
            if (attribute == null) continue;
            builder.append(" and ");
            builder.append(attribute).append(" like :").append(parameterName);
        }
        builder.append(" order by u.createdTimestamp");
        String q = builder.toString();
        TypedQuery<DebitNoteEntity> query = em.createQuery(q, DebitNoteEntity.class);
        query.setParameter("organizationId", organization.getId());
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            String parameterName = null;
            if (entry.getKey().equals(DebitNoteModel.DOCUMENT_ID)) {
                parameterName = JpaDebitNoteProvider.DOCUMENT_ID;
            }
            if (parameterName == null) continue;
            query.setParameter(parameterName, "%" + entry.getValue().toLowerCase() + "%");
        }
        if (firstResult != -1) {
            query.setFirstResult(firstResult);
        }
        if (maxResults != -1) {
            query.setMaxResults(maxResults);
        }
        List<DebitNoteEntity> results = query.getResultList();
        List<DebitNoteModel> debitNotes = results.stream().map(f -> new DebitNoteAdapter(session, organization, em, f)).collect(Collectors.toList());
        return debitNotes;
    }

    @Override
    public List<DebitNoteModel> searchForDebitNoteByAttribute(String attrName, String attrValue, OrganizationModel organization) {
        TypedQuery<DebitNoteAttributeEntity> query = em.createNamedQuery("getDebitNoteAttributesByNameAndValue", DebitNoteAttributeEntity.class);
        query.setParameter("name", attrName);
        query.setParameter("value", attrValue);
        List<DebitNoteAttributeEntity> results = query.getResultList();

        List<DebitNoteModel> debitNotes = new ArrayList<>();
        for (DebitNoteAttributeEntity attr : results) {
            DebitNoteEntity debitNote = attr.getDebitNote();
            debitNotes.add(new DebitNoteAdapter(session, organization, em, debitNote));
        }
        return debitNotes;
    }

}
