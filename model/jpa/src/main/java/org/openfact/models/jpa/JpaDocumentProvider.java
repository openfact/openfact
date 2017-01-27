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
import java.util.*;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.jboss.logging.Logger;
import org.openfact.models.*;
import org.openfact.models.enums.RequiredAction;
import org.openfact.models.jpa.entities.DocumentAttributeEntity;
import org.openfact.models.jpa.entities.DocumentEntity;
import org.openfact.models.search.SearchCriteriaFilterOperator;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;

public class JpaDocumentProvider extends AbstractHibernateStorage implements DocumentProvider {

    protected static final Logger logger = Logger.getLogger(JpaDocumentProvider.class);

    protected static final String DOCUMENT_ID = "documentId";
    protected static final String CREATED_TIMESTAMP = "createdTimestamp";
    protected static final String CUSTOMER_REGISTRATION_NAME = "customerRegistrationName";
    protected static final String CUSTOMER_ASSIGNED_ACCOUNT_ID = "customerAssignedAccountId";
    protected static final String CUSTOMER_ELECTRONIC_MAIL = "customerElectronicMail";

    protected static final String SEND_EVENT_DESTINY_TYPE = "destinyType";
    protected static final String SEND_EVENT_TYPE = "type";
    protected static final String SEND_EVENT_RESULT = "result";

    protected final OpenfactSession session;
    protected EntityManager em;

    public JpaDocumentProvider(OpenfactSession session, EntityManager em) {
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
    public DocumentModel addDocument(String type, String documentId, OrganizationModel organization) {
        if (session.documents().getDocumentByDocumentTypeAndId(type, documentId, organization) != null) {
            throw new ModelDuplicateException("Document documentId[" + documentId + "] exists");
        }

        DocumentEntity entity = new DocumentEntity();
        entity.setDocumentType(type);
        entity.setDocumentId(documentId);
        entity.setCreatedTimestamp(LocalDateTime.now());
        entity.setOrganizationId(organization.getId());
        entity.setEnabled(true);
        em.persist(entity);
        em.flush();

        final DocumentModel adapter = new DocumentAdapter(session, organization, em, entity);
        session.getOpenfactSessionFactory().publish(new DocumentModel.DocumentCreationEvent() {
            @Override
            public DocumentModel getCreatedDocument() {
                return adapter;
            }
        });

        return adapter;
    }

    @Override
    public DocumentModel getDocumentById(String id, OrganizationModel organization) {
        TypedQuery<DocumentEntity> query = em.createNamedQuery("getOrganizationDocumentById", DocumentEntity.class);
        query.setParameter("id", id);
        query.setParameter("organizationId", organization.getId());
        List<DocumentEntity> entities = query.getResultList();
        if (entities.size() == 0) return null;
        return new DocumentAdapter(session, organization, em, entities.get(0));
    }

    @Override
    public DocumentModel getDocumentByDocumentTypeAndId(String documentType, String documentId, OrganizationModel organization) {
        TypedQuery<DocumentEntity> query = em.createNamedQuery("getOrganizationDocumentByDocumentTypeAndId", DocumentEntity.class);
        query.setParameter("documentType", documentType);
        query.setParameter("documentId", documentId);
        query.setParameter("organizationId", organization.getId());
        List<DocumentEntity> entities = query.getResultList();
        if (entities.size() == 0) return null;
        return new DocumentAdapter(session, organization, em, entities.get(0));
    }

    @Override
    public boolean removeDocument(String id, OrganizationModel organization) {
        DocumentEntity entity = em.find(DocumentEntity.class, id);
        if (entity == null) return false;
        removeDocument(entity);
        return true;
    }

    private void removeDocument(DocumentEntity document) {
        String id = document.getId();
        em.flush();
        em.clear();

        document = em.find(DocumentEntity.class, id);
        if (document != null) {
            em.remove(document);
        }

        em.flush();
    }

    @Override
    public void preRemove(OrganizationModel organization) {
        int num = em.createNamedQuery("deleteDocumentRequiredActionsByOrganization").setParameter("organizationId", organization.getId()).executeUpdate();

        num = em.createNamedQuery("deleteAttatchedDocumentAttributesByOrganization").setParameter("organizationId", organization.getId()).executeUpdate();
        num = em.createNamedQuery("deleteAttatchedDocumentByOrganization").setParameter("organizationId", organization.getId()).executeUpdate();

        num = em.createNamedQuery("deleteDocumentSendEventDestinyAttributesByOrganization").setParameter("organizationId", organization.getId()).executeUpdate();
        num = em.createNamedQuery("deleteDocumentSendEventResponseAttributesByOrganization").setParameter("organizationId", organization.getId()).executeUpdate();
        num = em.createNamedQuery("deleteDocumentSendEventByOrganization").setParameter("organizationId", organization.getId()).executeUpdate();

        num = em.createNamedQuery("deleteDocumentAttributesByOrganization").setParameter("organizationId", organization.getId()).executeUpdate();
        num = em.createNamedQuery("deleteDocumentsByOrganization").setParameter("organizationId", organization.getId()).executeUpdate();
    }

    @Override
    public List<DocumentModel> getDocuments(OrganizationModel organization) {
        return getDocuments(organization, -1, -1);
    }

    @Override
    public List<DocumentModel> getDocuments(OrganizationModel organization, int firstResult, int maxResults) {
        TypedQuery<DocumentEntity> query = em.createNamedQuery("getAllDocumentsByOrganization", DocumentEntity.class);
        query.setParameter("organizationId", organization.getId());
        if (firstResult != -1) {
            query.setFirstResult(firstResult);
        }
        if (maxResults != -1) {
            query.setMaxResults(maxResults);
        }
        List<DocumentEntity> results = query.getResultList();
        return results.stream().map(f -> new DocumentAdapter(session, organization, em, f)).collect(Collectors.toList());
    }

    @Override
    public List<DocumentModel> getDocuments(OrganizationModel organization, String documentType) {
        return getDocuments(organization, documentType, -1, -1);
    }

    @Override
    public List<DocumentModel> getDocuments(OrganizationModel organization, String documentType, int firstResult, int maxResults) {
        TypedQuery<DocumentEntity> query = em.createNamedQuery("getAllDocumentsByOrganizationAndDocumentType", DocumentEntity.class);
        query.setParameter("organizationId", organization.getId());
        query.setParameter("documentType", documentType);
        if (firstResult != -1) {
            query.setFirstResult(firstResult);
        }
        if (maxResults != -1) {
            query.setMaxResults(maxResults);
        }
        List<DocumentEntity> results = query.getResultList();
        return results.stream().map(f -> new DocumentAdapter(session, organization, em, f)).collect(Collectors.toList());
    }

    @Override
    public List<DocumentModel> getDocuments(OrganizationModel organization, String documentType, List<RequiredAction> requeridAction) {
        return getDocuments(organization, documentType, requeridAction, -1, -1);
    }

    @Override
    public List<DocumentModel> getDocuments(OrganizationModel organization, String documentType, List<RequiredAction> requeridAction, int firstResult, int maxResults) {
        String queryJql = "select i from DocumentEntity i where i.organizationId=:organizationId and i.documentType=:documentType and :requiredAction in elements(i.requeridAction) order by i.createdTimestamp ";

        TypedQuery<DocumentEntity> query = em.createQuery(queryJql, DocumentEntity.class);
        query.setParameter("organizationId", organization.getId());
        query.setParameter("documentType", documentType);
        query.setParameter("requiredAction", requeridAction);
        List<DocumentEntity> results = query.getResultList();
        return results.stream().map(f -> new DocumentAdapter(session, organization, em, f)).collect(Collectors.toList());
    }

    @Override
    public List<DocumentModel> searchForDocument(String filterText, OrganizationModel organization) {
        return searchForDocument(filterText, organization, -1, -1);
    }

    @Override
    public List<DocumentModel> searchForDocument(String filterText, OrganizationModel organization, int firstResult, int maxResults) {
        TypedQuery<DocumentEntity> query = em.createNamedQuery("searchForDocument", DocumentEntity.class);
        query.setParameter("organizationId", organization.getId());
        query.setParameter("search", "%" + filterText.toLowerCase() + "%");
        if (firstResult != -1) {
            query.setFirstResult(firstResult);
        }
        if (maxResults != -1) {
            query.setMaxResults(maxResults);
        }
        List<DocumentEntity> results = query.getResultList();
        return results.stream().map(f -> new DocumentAdapter(session, organization, em, f)).collect(Collectors.toList());
    }

    @Override
    public SearchResultsModel<DocumentModel> searchForDocument(SearchCriteriaModel criteria, OrganizationModel organization) {
        criteria.addFilter("organizationId", organization.getId(), SearchCriteriaFilterOperator.eq);

        SearchResultsModel<DocumentEntity> entityResult = find(criteria, DocumentEntity.class);
        List<DocumentEntity> entities = entityResult.getModels();

        SearchResultsModel<DocumentModel> searchResult = new SearchResultsModel<>();
        List<DocumentModel> models = searchResult.getModels();

        entities.forEach(f -> models.add(new DocumentAdapter(session, organization, em, f)));
        searchResult.setTotalSize(entityResult.getTotalSize());
        return searchResult;
    }

    @Override
    public SearchResultsModel<DocumentModel> searchForDocument(String filterText, SearchCriteriaModel criteria, OrganizationModel organization) {
        criteria.addFilter("organizationId", organization.getId(), SearchCriteriaFilterOperator.eq);

        SearchResultsModel<DocumentEntity> entityResult = findFullText(criteria, DocumentEntity.class, filterText, DOCUMENT_ID, CUSTOMER_REGISTRATION_NAME, CUSTOMER_ASSIGNED_ACCOUNT_ID, CUSTOMER_ELECTRONIC_MAIL);
        List<DocumentEntity> entities = entityResult.getModels();

        SearchResultsModel<DocumentModel> searchResult = new SearchResultsModel<>();
        List<DocumentModel> models = searchResult.getModels();

        entities.forEach(f -> models.add(new DocumentAdapter(session, organization, em, f)));
        searchResult.setTotalSize(entityResult.getTotalSize());
        return searchResult;
    }

    @Override
    public int getDocumentsCount(OrganizationModel organization) {
        Query query = em.createNamedQuery("getOrganizationDocumentCount");
        Long result = (Long) query.getSingleResult();
        return result.intValue();
    }

    @Override
    public ScrollModel<DocumentModel> getDocumentScroll(OrganizationModel organization) {
        return getDocumentScroll(organization, true);
    }

    @Override
    public ScrollModel<DocumentModel> getDocumentScroll(OrganizationModel organization, boolean asc) {
        return getDocumentScroll(organization, -1, asc);
    }

    @Override
    public ScrollModel<DocumentModel> getDocumentScroll(OrganizationModel organization, int scrollSize, boolean asc) {
        if (scrollSize == -1) {
            scrollSize = 100;
        }

        String queryName = null;
        if (asc) {
            queryName = "getAllDocumentsByOrganization";
        } else {
            queryName = "getAllDocumentsByOrganizationDesc";
        }

        TypedQuery<DocumentEntity> query = em.createNamedQuery(queryName, DocumentEntity.class);
        query.setParameter("organizationId", organization.getId());

        return new ScrollAdapter<>(DocumentEntity.class, query, f -> new DocumentAdapter(session, organization, em, f), scrollSize);
    }

    @Override
    public ScrollModel<DocumentModel> getDocumentScroll(OrganizationModel organization, String documentType) {
        return getDocumentScroll(organization, documentType, true);
    }

    @Override
    public ScrollModel<DocumentModel> getDocumentScroll(OrganizationModel organization, String documentType, boolean asc) {
        return getDocumentScroll(organization, documentType, -1, asc);
    }

    @Override
    public ScrollModel<DocumentModel> getDocumentScroll(OrganizationModel organization, String documentType, int scrollSize, boolean asc) {
        if (scrollSize == -1) {
            scrollSize = 100;
        }

        String queryName = null;
        if (asc) {
            queryName = "getAllDocumentsByOrganizationAndDocumentType";
        } else {
            queryName = "getAllDocumentsByOrganizationAndDocumentTypeDesc";
        }

        TypedQuery<DocumentEntity> query = em.createNamedQuery(queryName, DocumentEntity.class);
        query.setParameter("organizationId", organization.getId());
        query.setParameter("documentType", organization.getId());

        return new ScrollAdapter<>(DocumentEntity.class, query, f -> new DocumentAdapter(session, organization, em, f), scrollSize);
    }

    @Override
    public ScrollModel<List<DocumentModel>> getDocumentScroll(OrganizationModel organization, int scrollSize, String... requiredAction) {
        if (scrollSize == -1) {
            scrollSize = 10;
        }

        TypedQuery<DocumentEntity> query = em.createNamedQuery("getAllDocumentsByRequiredActionAndOrganization", DocumentEntity.class);
        query.setParameter("organizationId", organization.getId());
        query.setParameter("requiredAction", new ArrayList<>(Arrays.asList(requiredAction)));

        return new ScrollPagingAdapter<>(DocumentEntity.class, query, f -> f.stream().map(m -> new DocumentAdapter(session, organization, em, m)).collect(Collectors.toList()), scrollSize);
    }

    @Override
    public ScrollModel<List<DocumentModel>> getDocumentScroll(OrganizationModel organization, String documentType, int scrollSize, String... requiredAction) {
        if (scrollSize == -1) {
            scrollSize = 10;
        }

        TypedQuery<DocumentEntity> query = em.createNamedQuery("getAllDocumentsByRequiredActionAndOrganizationAndDocumentType", DocumentEntity.class);
        query.setParameter("organizationId", organization.getId());
        query.setParameter("requiredAction", new ArrayList<>(Arrays.asList(requiredAction)));
        query.setParameter("documentType", documentType);

        return new ScrollPagingAdapter<>(DocumentEntity.class, query, f -> f.stream().map(m -> new DocumentAdapter(session, organization, em, m)).collect(Collectors.toList()), scrollSize);
    }

    @Override
    public List<DocumentModel> searchForDocument(Map<String, String> attributes, OrganizationModel organization) {
        return searchForDocument(attributes, organization, -1, -1);
    }

    @Override
    public List<DocumentModel> searchForDocument(Map<String, String> attributes, OrganizationModel organization, int firstResult, int maxResults) {
        StringBuilder builder = new StringBuilder("select u from DocumentEntity u where u.organizationId = :organizationId");
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            String attribute = null;
            String parameterName = null;
            if (entry.getKey().equals(DocumentModel.DOCUMENT_ID)) {
                attribute = "lower(u.documentId)";
                parameterName = JpaDocumentProvider.DOCUMENT_ID;
            }
            if (attribute == null) continue;
            builder.append(" and ");
            builder.append(attribute).append(" like :").append(parameterName);
        }
        builder.append(" order by u.createdTimestamp");
        String q = builder.toString();
        TypedQuery<DocumentEntity> query = em.createQuery(q, DocumentEntity.class);
        query.setParameter("organizationId", organization.getId());
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            String parameterName = null;
            if (entry.getKey().equals(DocumentModel.DOCUMENT_ID)) {
                parameterName = JpaDocumentProvider.DOCUMENT_ID;
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
        List<DocumentEntity> results = query.getResultList();
        return results.stream().map(f -> new DocumentAdapter(session, organization, em, f)).collect(Collectors.toList());
    }

    @Override
    public List<DocumentModel> searchForDocumentByAttribute(String attrName, String attrValue, OrganizationModel organization) {
        return searchForDocumentByAttribute(attrName, attrValue, organization, -1, -1);
    }

    @Override
    public List<DocumentModel> searchForDocumentByAttribute(String attrName, String attrValue, OrganizationModel organization, int firstResult, int maxResults) {
        TypedQuery<DocumentAttributeEntity> query = em.createNamedQuery("getDocumentAttributesByNameAndValue", DocumentAttributeEntity.class);
        query.setParameter("name", attrName);
        query.setParameter("value", attrValue);
        if (firstResult != -1) {
            query.setFirstResult(firstResult);
        }
        if (maxResults != -1) {
            query.setMaxResults(maxResults);
        }
        List<DocumentAttributeEntity> results = query.getResultList();

        List<DocumentModel> documents = new ArrayList<>();
        for (DocumentAttributeEntity attr : results) {
            DocumentEntity entity = attr.getDocument();
            documents.add(new DocumentAdapter(session, organization, em, entity));
        }
        return documents;
    }

    @Override
    public List<DocumentModel> searchForDocumentByAttribute(String documentType, String attrName, String attrValue, OrganizationModel organization) {
        return searchForDocumentByAttribute(documentType, attrName, attrValue, organization, -1, -1);
    }

    @Override
    public List<DocumentModel> searchForDocumentByAttribute(String documentType, String attrName, String attrValue, OrganizationModel organization, int firstResult, int maxResults) {
        TypedQuery<DocumentAttributeEntity> query = em.createNamedQuery("getDocumentAttributesByNameAndValueAndDocumentType", DocumentAttributeEntity.class);
        query.setParameter("name", attrName);
        query.setParameter("value", attrValue);
        query.setParameter("documentType", documentType);
        if (firstResult != -1) {
            query.setFirstResult(firstResult);
        }
        if (maxResults != -1) {
            query.setMaxResults(maxResults);
        }
        List<DocumentAttributeEntity> results = query.getResultList();

        List<DocumentModel> documents = new ArrayList<>();
        for (DocumentAttributeEntity attr : results) {
            DocumentEntity entity = attr.getDocument();
            documents.add(new DocumentAdapter(session, organization, em, entity));
        }
        return documents;
    }
}
