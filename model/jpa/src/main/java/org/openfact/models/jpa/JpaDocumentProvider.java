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

    protected static final String DOCUMENT_ID = "documentId";
    protected static final String DOCUMENT_TYPE = "documentType";
    protected static final String CREATED_TIMESTAMP = "createdTimestamp";
    protected static final String CUSTOMER_REGISTRATION_NAME = "customerRegistrationName";
    protected static final String CUSTOMER_ASSIGNED_ACCOUNT_ID = "customerAssignedAccountId";
    protected static final String CUSTOMER_ELECTRONIC_MAIL = "customerElectronicMail";

    protected static final String SEND_EVENT_DESTINY = "destiny";
    protected static final String SEND_EVENT_STATUS = "status";

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
        if (session.documents().getDocumentByDocumentTypeAndId(documentType, documentId, organization) != null) {
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
    public DocumentModel getDocumentByDocumentTypeAndId(String documentType, String documentId, OrganizationModel organization) {
        TypedQuery<UBLDocumentEntity> query = em.createNamedQuery("getOrganizationDocumentByDocumentTypeAndId", UBLDocumentEntity.class);
        query.setParameter("documentType", documentType.toUpperCase());
        query.setParameter("documentId", documentId.toUpperCase());
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
        int num = em.createNamedQuery("deleteDocumentRequiredActionsByOrganization").setParameter("organizationId", organization.getId()).executeUpdate();

        num = em.createNamedQuery("deleteAttachedDocumentByOrganization").setParameter("organizationId", organization.getId()).executeUpdate();

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
        TypedQuery<UBLDocumentEntity> query = em.createNamedQuery("getAllDocumentsByOrganization", UBLDocumentEntity.class);
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
    public List<DocumentModel> getDocuments(OrganizationModel organization, String documentType) {
        return getDocuments(organization, documentType, -1, -1);
    }

    @Override
    public List<DocumentModel> getDocuments(OrganizationModel organization, String documentType, int firstResult, int maxResults) {
        TypedQuery<UBLDocumentEntity> query = em.createNamedQuery("getAllDocumentsByOrganizationAndDocumentType", UBLDocumentEntity.class);
        query.setParameter("organizationId", organization.getId());
        query.setParameter("documentType", documentType.toUpperCase());
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
    public List<DocumentModel> getDocuments(OrganizationModel organization, String documentType, List<RequiredAction> requiredAction) {
        return getDocuments(organization, documentType, requiredAction, -1, -1);
    }

    @Override
    public List<DocumentModel> getDocuments(OrganizationModel organization, String documentType, List<RequiredAction> requiredAction, int firstResult, int maxResults) {
        String queryJql = "select i from UBLDocumentEntity i where i.organizationId=:organizationId and i.documentType=:documentType and :requiredAction in elements(i.requiredAction) order by i.createdTimestamp";

        TypedQuery<UBLDocumentEntity> query = em.createQuery(queryJql, UBLDocumentEntity.class);
        query.setParameter("organizationId", organization.getId());
        query.setParameter("documentType", documentType.toUpperCase());
        query.setParameter("requiredAction", requiredAction);
        List<UBLDocumentEntity> results = query.getResultList();
        return results.stream().map(f -> new UBLDocumentAdapter(session, organization, em, f)).collect(Collectors.toList());
    }

    @Override
    public List<DocumentModel> searchForDocument(String filterText, OrganizationModel organization) {
        return searchForDocument(filterText, organization, -1, -1);
    }

    @Override
    public List<DocumentModel> searchForDocument(String filterText, OrganizationModel organization, int firstResult, int maxResults) {
        TypedQuery<UBLDocumentEntity> query = em.createNamedQuery("searchForDocument", UBLDocumentEntity.class);
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
        DocumentCountQuery queryCount = session.documents().createCountQuery(organization);

        // Filtertext
        if (filterText != null && !filterText.trim().isEmpty()) {
            query.filterText(filterText, DOCUMENT_ID, CUSTOMER_REGISTRATION_NAME, CUSTOMER_ASSIGNED_ACCOUNT_ID, CUSTOMER_ELECTRONIC_MAIL);
            queryCount.filterText(filterText, DOCUMENT_ID, CUSTOMER_REGISTRATION_NAME, CUSTOMER_ASSIGNED_ACCOUNT_ID, CUSTOMER_ELECTRONIC_MAIL);
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
                    queryCount.requiredAction(array);
                } else if (filter.getName().equalsIgnoreCase(CREATED_TIMESTAMP)) {
                    if (filter.getOperator().equals(SearchCriteriaFilterOperator.gt) || filter.getOperator().equals(SearchCriteriaFilterOperator.gte)) {
                        query.fromDate((LocalDateTime) filter.getValue());
                        queryCount.fromDate((LocalDateTime) filter.getValue());
                    } else {
                        query.toDate((LocalDateTime) filter.getValue());
                        queryCount.toDate((LocalDateTime) filter.getValue());
                    }
                } else {
                    query.addFilter(filter);
                    queryCount.addFilter(filter);
                }
            }
        }

        // Orders
        if (criteria.getOrders() != null && !criteria.getOrders().isEmpty()) {
            criteria.getOrders().stream().forEach(c -> {
                if (c.isAscending()) {
                    query.orderByAsc(c.getName());
                } else {
                    query.orderByDesc(c.getName());
                }
            });
        }

        // Paging
        if (criteria.getPaging() != null) {
            int page = criteria.getPaging().getPage();
            int pageSize = criteria.getPaging().getPageSize();
            int start = (page - 1) * pageSize;

            query.firstResult(start);
            query.maxResults(pageSize);
        } else {
            query.firstResult(0);
            query.maxResults(Constants.DEFAULT_MAX_RESULTS);
        }

        SearchResultsModel<DocumentModel> searchResult = new SearchResultsModel<>();
        searchResult.setModels(query.getResultList());
        searchResult.setTotalSize(queryCount.getTotalCount());
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

        TypedQuery<UBLDocumentEntity> query = em.createNamedQuery(queryName, UBLDocumentEntity.class);
        query.setParameter("organizationId", organization.getId());

        return new ScrollAdapter<>(UBLDocumentEntity.class, query, f -> new UBLDocumentAdapter(session, organization, em, f), scrollSize);
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

        TypedQuery<UBLDocumentEntity> query = em.createNamedQuery(queryName, UBLDocumentEntity.class);
        query.setParameter("organizationId", organization.getId());
        query.setParameter("documentType", documentType.toUpperCase());

        return new ScrollAdapter<>(UBLDocumentEntity.class, query, f -> new UBLDocumentAdapter(session, organization, em, f), scrollSize);
    }

    @Override
    public ScrollModel<List<DocumentModel>> getDocumentScroll(OrganizationModel organization, int scrollSize, String... requiredAction) {
        if (scrollSize == -1) {
            scrollSize = 10;
        }

        TypedQuery<UBLDocumentEntity> query = em.createNamedQuery("getAllDocumentsByRequiredActionAndOrganization", UBLDocumentEntity.class);
        query.setParameter("organizationId", organization.getId());
        query.setParameter("requiredAction", new ArrayList<>(Arrays.asList(requiredAction)));

        return new ScrollPagingAdapter<>(UBLDocumentEntity.class, query, f -> f.stream().map(m -> new UBLDocumentAdapter(session, organization, em, m)).collect(Collectors.toList()), scrollSize);
    }

    @Override
    public ScrollModel<List<DocumentModel>> getDocumentScroll(OrganizationModel organization, String documentType, int scrollSize, String... requiredAction) {
        if (scrollSize == -1) {
            scrollSize = 10;
        }

        TypedQuery<UBLDocumentEntity> query = em.createNamedQuery("getAllDocumentsByRequiredActionAndOrganizationAndDocumentType", UBLDocumentEntity.class);
        query.setParameter("organizationId", organization.getId());
        query.setParameter("requiredAction", new ArrayList<>(Arrays.asList(requiredAction)));
        query.setParameter("documentType", documentType.toUpperCase());

        return new ScrollPagingAdapter<>(UBLDocumentEntity.class, query, f -> f.stream().map(m -> new UBLDocumentAdapter(session, organization, em, m)).collect(Collectors.toList()), scrollSize);
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
            if (entry.getKey().equals(DocumentModel.DOCUMENT_TYPE)) {
                attribute = "lower(u.documentType)";
                parameterName = JpaDocumentProvider.DOCUMENT_TYPE;
            } else if (entry.getKey().equals(DocumentModel.DOCUMENT_ID)) {
                attribute = "lower(u.documentId)";
                parameterName = JpaDocumentProvider.DOCUMENT_ID;
            }
            if (attribute == null) continue;
            builder.append(" and ");
            builder.append(attribute).append(" like :").append(parameterName);
        }
        builder.append(" order by u.createdTimestamp");
        String q = builder.toString();
        TypedQuery<UBLDocumentEntity> query = em.createQuery(q, UBLDocumentEntity.class);
        query.setParameter("organizationId", organization.getId());
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            String parameterName = null;
            if (entry.getKey().equals(DocumentModel.DOCUMENT_TYPE)) {
                parameterName = JpaDocumentProvider.DOCUMENT_TYPE;
            } else if (entry.getKey().equals(DocumentModel.DOCUMENT_ID)) {
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
        List<UBLDocumentEntity> results = query.getResultList();
        return results.stream().map(f -> new UBLDocumentAdapter(session, organization, em, f)).collect(Collectors.toList());
    }

    @Override
    public List<DocumentModel> searchForDocumentByAttribute(String attrName, String attrValue, OrganizationModel organization) {
        return searchForDocumentByAttribute(attrName, attrValue, organization, -1, -1);
    }

    @Override
    public List<DocumentModel> searchForDocumentByAttribute(String attrName, String attrValue, OrganizationModel organization, int firstResult, int maxResults) {
        TypedQuery<UBLDocumentAttributeEntity> query = em.createNamedQuery("getDocumentAttributesByNameAndValue", UBLDocumentAttributeEntity.class);
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
        TypedQuery<UBLDocumentAttributeEntity> query = em.createNamedQuery("getDocumentAttributesByNameAndValueAndDocumentType", UBLDocumentAttributeEntity.class);
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

    @Override
    public DocumentCountQuery createCountQuery(OrganizationModel organization) {
        return new JpaDocumentCountQuery(session, organization, em);
    }

}
