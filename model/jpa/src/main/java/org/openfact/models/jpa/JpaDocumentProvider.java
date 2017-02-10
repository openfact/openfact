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

import org.jboss.logging.Logger;
import org.openfact.models.*;
import org.openfact.models.enums.DocumentType;
import org.openfact.models.enums.RequiredAction;
import org.openfact.models.jpa.entities.UBLDocumentAttributeEntity;
import org.openfact.models.jpa.entities.UBLDocumentEntity;
import org.openfact.models.search.SearchCriteriaFilterModel;
import org.openfact.models.search.SearchCriteriaFilterOperator;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class JpaDocumentProvider extends AbstractHibernateStorage implements DocumentProvider {

    protected static final Logger logger = Logger.getLogger(JpaDocumentProvider.class);

    public static final String ORGANIZATION_ID = "organizationId";
    public static final String DOCUMENT_ID = "documentId";
    public static final String DOCUMENT_TYPE = "documentType";
    public static final String CREATED_TIMESTAMP = "createdTimestamp";
    public static final String DOCUMENT_CURRENCY_CODE = "documentCurrencyCode";
    public static final String CUSTOMER_REGISTRATION_NAME = "customerRegistrationName";
    public static final String CUSTOMER_ASSIGNED_ACCOUNT_ID = "customerAssignedAccountId";
    public static final String CUSTOMER_ELECTRONIC_MAIL = "customerElectronicMail";
    public static final String REQUIRED_ACTIONS = "requiredActions";
    public static final String ENABLED = "enabled";

    public static final String SEND_EVENT_DESTINY = "destiny";
    public static final String SEND_EVENT_STATUS = "status";

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
    public DocumentModel addDocument(DocumentType documentType, String documentId, OrganizationModel organization) {
        return addDocument(documentType.toString(), documentId, organization);
    }

    @Override
    public DocumentModel addDocument(String documentType, String documentId, OrganizationModel organization) {
        if (session.documents().getDocumentByTypeAndUblId(documentType, documentId, organization) != null) {
            throw new ModelDuplicateException("Document documentId[" + documentId + "] exists");
        }

        UBLDocumentEntity entity = new UBLDocumentEntity();
        entity.setDocumentType(documentType.toUpperCase());
        entity.setDocumentId(documentId.toUpperCase());
        entity.setCreatedTimestamp(LocalDateTime.now());
        entity.setOrganizationId(organization.getId());
        entity.setEnabled(true);
        em.persist(entity);
        em.flush();

        final DocumentModel adapter = new UBLDocumentAdapter(session, organization, em, entity);
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
        TypedQuery<UBLDocumentEntity> query = em.createNamedQuery("getOrganizationDocumentById", UBLDocumentEntity.class);
        query.setParameter("id", id);
        query.setParameter("organizationId", organization.getId());
        List<UBLDocumentEntity> entities = query.getResultList();
        if (entities.size() == 0) return null;
        return new UBLDocumentAdapter(session, organization, em, entities.get(0));
    }

    @Override
    public DocumentModel getDocumentByTypeAndUblId(DocumentType documentType, String ublId, OrganizationModel organization) {
        return getDocumentByTypeAndUblId(documentType.toString(), ublId, organization);
    }

    @Override
    public DocumentModel getDocumentByTypeAndUblId(String documentType, String ublId, OrganizationModel organization) {
        TypedQuery<UBLDocumentEntity> query = em.createNamedQuery("getOrganizationDocumentByTypeAndUblId", UBLDocumentEntity.class);
        query.setParameter("documentType", documentType.toUpperCase());
        query.setParameter("ublId", ublId.toUpperCase());
        query.setParameter("organizationId", organization.getId());
        List<UBLDocumentEntity> entities = query.getResultList();
        if (entities.size() == 0) return null;
        return new UBLDocumentAdapter(session, organization, em, entities.get(0));
    }

    @Override
    public boolean removeDocument(String id, OrganizationModel organization) {
        UBLDocumentEntity entity = em.find(UBLDocumentEntity.class, id);
        if (entity == null) return false;
        removeDocument(entity);
        return true;
    }

    private void removeDocument(UBLDocumentEntity document) {
        String id = document.getId();
        em.flush();
        em.clear();

        document = em.find(UBLDocumentEntity.class, id);
        if (document != null) {
            em.remove(document);
        }

        em.flush();
    }

    @Override
    public void preRemove(OrganizationModel organization) {
        int num = em.createNamedQuery("deleteUblDocumentRequiredActionsByOrganization").setParameter("organizationId", organization.getId()).executeUpdate();

        num = em.createNamedQuery("deleteAttachedUblDocumentByOrganization").setParameter("organizationId", organization.getId()).executeUpdate();

        num = em.createNamedQuery("deleteSendEventAttachedFilesByOrganization").setParameter("organizationId", organization.getId()).executeUpdate();
        num = em.createNamedQuery("deleteUblDocumentSendEventAttributesByOrganization").setParameter("organizationId", organization.getId()).executeUpdate();
        num = em.createNamedQuery("deleteUblDocumentSendEventByOrganization").setParameter("organizationId", organization.getId()).executeUpdate();

        num = em.createNamedQuery("deleteUblDocumentAttributesByOrganization").setParameter("organizationId", organization.getId()).executeUpdate();
        num = em.createNamedQuery("deleteUblDocumentsByOrganization").setParameter("organizationId", organization.getId()).executeUpdate();
    }

    @Override
    public List<DocumentModel> getDocuments(OrganizationModel organization) {
        return getDocuments(organization, -1, -1);
    }

    @Override
    public List<DocumentModel> getDocuments(OrganizationModel organization, int firstResult, int maxResults) {
        TypedQuery<UBLDocumentEntity> query = em.createNamedQuery("getAllUblDocumentsByOrganization", UBLDocumentEntity.class);
        query.setParameter("organizationId", organization.getId());
        if (firstResult != -1) {
            query.setFirstResult(firstResult);
        }
        if (maxResults != -1) {
            query.setMaxResults(maxResults);
        }
        List<UBLDocumentEntity> results = query.getResultList();
        return results.stream().map(f -> new UBLDocumentAdapter(session, organization, em, f)).collect(Collectors.toList());
    }

    @Override
    public List<DocumentModel> searchForDocument(String filterText, OrganizationModel organization) {
        return searchForDocument(filterText, organization, -1, -1);
    }

    @Override
    public List<DocumentModel> searchForDocument(String filterText, OrganizationModel organization, int firstResult, int maxResults) {
        TypedQuery<UBLDocumentEntity> query = em.createNamedQuery("searchForUblDocument", UBLDocumentEntity.class);
        query.setParameter("organizationId", organization.getId());
        query.setParameter("search", "%" + filterText.toLowerCase() + "%");
        if (firstResult != -1) {
            query.setFirstResult(firstResult);
        }
        if (maxResults != -1) {
            query.setMaxResults(maxResults);
        }
        List<UBLDocumentEntity> results = query.getResultList();
        return results.stream().map(f -> new UBLDocumentAdapter(session, organization, em, f)).collect(Collectors.toList());
    }

    @Override
    public SearchResultsModel<DocumentModel> searchForDocument(SearchCriteriaModel criteria, OrganizationModel organization) {
        return searchForDocument(null, criteria, organization);
    }

    @Override
    public SearchResultsModel<DocumentModel> searchForDocument(String filterText, SearchCriteriaModel criteria, OrganizationModel organization) {
        DocumentQuery query = session.documents().createQuery(organization);

        // Filtertext
        if (filterText != null && !filterText.trim().isEmpty()) {
            query.filterText(filterText, DOCUMENT_ID, CUSTOMER_REGISTRATION_NAME, CUSTOMER_ASSIGNED_ACCOUNT_ID, CUSTOMER_ELECTRONIC_MAIL);
        }

        // Filters
        if (criteria.getFilters() != null && !criteria.getFilters().isEmpty()) {
            for (SearchCriteriaFilterModel filter : criteria.getFilters()) {
                if (filter.getName().equalsIgnoreCase(DocumentModel.REQUIRED_ACTIONS)) {
                    List<String> requiredActions = new ArrayList<>();
                    if (filter.getValue() instanceof String) {
                        requiredActions.add((String) filter.getValue());
                    } else if (filter.getValue() instanceof Collection) {
                        requiredActions.addAll((Collection) filter.getValue());
                    } else {
                        requiredActions.add(String.valueOf(filter.getValue()));
                    }

                    RequiredAction[] array = requiredActions
                            .stream()
                            .map(f -> RequiredAction.valueOf(f.toUpperCase()))
                            .toArray(size -> new RequiredAction[requiredActions.size()]);

                    query.requiredAction(array);
                } else if (filter.getName().equalsIgnoreCase(CREATED_TIMESTAMP)) {
                    if (filter.getOperator().equals(SearchCriteriaFilterOperator.gt) || filter.getOperator().equals(SearchCriteriaFilterOperator.gte)) {
                        query.fromDate((LocalDateTime) filter.getValue());
                    } else {
                        query.toDate((LocalDateTime) filter.getValue());
                    }
                } else {
                    query.addFilter(filter.getName(), filter.getValue(), filter.getOperator());
                }
            }
        }

        DocumentQuery.EntityQuery entityQuery = query.entityQuery();

        // Orders
        if (criteria.getOrders() != null && !criteria.getOrders().isEmpty()) {
            criteria.getOrders().stream().forEach(c -> {
                if (c.isAscending()) {
                    entityQuery.orderByAsc(c.getName());
                } else {
                    entityQuery.orderByDesc(c.getName());
                }
            });
        }

        return entityQuery.searchResult().getSearchResult(criteria.getPaging());
    }

    @Override
    public int getDocumentsCount(OrganizationModel organization) {
        Query query = em.createNamedQuery("getOrganizationUblDocumentCount");
        Long result = (Long) query.getSingleResult();
        return result.intValue();
    }

    @Override
    public List<DocumentModel> searchForDocumentByAttribute(String attrName, String attrValue, OrganizationModel organization) {
        return searchForDocumentByAttribute(attrName, attrValue, organization, -1, -1);
    }

    @Override
    public List<DocumentModel> searchForDocumentByAttribute(String attrName, String attrValue, OrganizationModel organization, int firstResult, int maxResults) {
        TypedQuery<UBLDocumentAttributeEntity> query = em.createNamedQuery("getUblDocumentAttributesByNameAndValue", UBLDocumentAttributeEntity.class);
        query.setParameter("name", attrName);
        query.setParameter("value", attrValue);
        if (firstResult != -1) {
            query.setFirstResult(firstResult);
        }
        if (maxResults != -1) {
            query.setMaxResults(maxResults);
        }
        List<UBLDocumentAttributeEntity> results = query.getResultList();

        List<DocumentModel> documents = new ArrayList<>();
        for (UBLDocumentAttributeEntity attr : results) {
            UBLDocumentEntity entity = attr.getUblDocument();
            documents.add(new UBLDocumentAdapter(session, organization, em, entity));
        }
        return documents;
    }

    @Override
    public List<DocumentModel> searchForDocumentByAttribute(String documentType, String attrName, String attrValue, OrganizationModel organization) {
        return searchForDocumentByAttribute(documentType, attrName, attrValue, organization, -1, -1);
    }

    @Override
    public List<DocumentModel> searchForDocumentByAttribute(String documentType, String attrName, String attrValue, OrganizationModel organization, int firstResult, int maxResults) {
        TypedQuery<UBLDocumentAttributeEntity> query = em.createNamedQuery("getUblDocumentAttributesByNameAndValueAndDocumentType", UBLDocumentAttributeEntity.class);
        query.setParameter("name", attrName);
        query.setParameter("value", attrValue);
        query.setParameter("documentType", documentType.toUpperCase());
        if (firstResult != -1) {
            query.setFirstResult(firstResult);
        }
        if (maxResults != -1) {
            query.setMaxResults(maxResults);
        }
        List<UBLDocumentAttributeEntity> results = query.getResultList();

        List<DocumentModel> documents = new ArrayList<>();
        for (UBLDocumentAttributeEntity attr : results) {
            UBLDocumentEntity entity = attr.getUblDocument();
            documents.add(new UBLDocumentAdapter(session, organization, em, entity));
        }
        return documents;
    }

    @Override
    public DocumentQuery createQuery(OrganizationModel organization) {
        return new JpaDocumentQuery(session, organization, em);
    }

}
