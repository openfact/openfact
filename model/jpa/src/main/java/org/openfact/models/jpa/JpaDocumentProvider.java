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
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.jboss.logging.Logger;
import org.openfact.models.DocumentModel;
import org.openfact.models.DocumentProvider;
import org.openfact.models.ModelDuplicateException;
import org.openfact.models.OrganizationModel;
import org.openfact.models.enums.DocumentType;
import org.openfact.models.jpa.entities.DocumentEntity;
import org.openfact.provider.ProviderEvent;

public class JpaDocumentProvider implements DocumentProvider, HibernateWrapper {

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
    public static final String CUSTOMER_SEND_EVENT_FAILURES = "customerSendEventFailures";
    public static final String THIRD_PARTY_SEND_EVENT_FAILURES = "thirdPartySendEventFailures";

    @Inject
    private Event<ProviderEvent> event;

    @PersistenceContext
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    private DocumentAdapter toAdapter(OrganizationModel organization, DocumentEntity entity) {
        return new DocumentAdapter(organization, em, entity);
    }

    @Override
    public DocumentModel addDocument(DocumentType documentType, String documentId, OrganizationModel organization) {
        return addDocument(documentType.toString(), documentId, organization);
    }

    @Override
    public DocumentModel addDocument(String documentType, String documentId, OrganizationModel organization) {
        if (getDocumentByTypeAndDocumentId(documentType, documentId, organization) != null) {
            throw new ModelDuplicateException("Document documentId[" + documentId + "] exists");
        }

        DocumentEntity entity = new DocumentEntity();
        entity.setDocumentType(documentType.toUpperCase());
        entity.setDocumentId(documentId.toUpperCase());
        entity.setCreatedTimestamp(LocalDateTime.now());
        entity.setOrganizationId(organization.getId());
        entity.setEnabled(true);
        getSession().persist(entity);
        getSession().flush();

        final DocumentModel adapter = toAdapter(organization, entity);
        event.fire((DocumentModel.DocumentCreationEvent) () -> adapter);

        logger.debug("Document documentId[" + documentId + "] created on organization " + organization.getName());
        return adapter;
    }

    @Override
    public DocumentModel getDocumentById(String id, OrganizationModel organization) {
        TypedQuery<DocumentEntity> query = getSession().createNamedQuery("getOrganizationDocumentByDocumentPkId", DocumentEntity.class);
        query.setParameter("documentPkId", id);
        query.setParameter("organizationId", organization.getId());
        List<DocumentEntity> entities = query.getResultList();
        if (entities.size() == 0) return null;
        return toAdapter(organization, entities.get(0));
    }

    @Override
    public DocumentModel getDocumentByTypeAndDocumentId(DocumentType documentType, String documentId, OrganizationModel organization) {
        return getDocumentByTypeAndDocumentId(documentType.toString(), documentId, organization);
    }

    @Override
    public DocumentModel getDocumentByTypeAndDocumentId(String documentType, String documentId, OrganizationModel organization) {
        TypedQuery<DocumentEntity> query = getSession().createNamedQuery("getOrganizationDocumentByDocumentTypeAndDocumentId", DocumentEntity.class);
        query.setParameter("documentType", documentType.toUpperCase());
        query.setParameter("documentId", documentId.toUpperCase());
        query.setParameter("organizationId", organization.getId());
        List<DocumentEntity> entities = query.getResultList();
        if (entities.size() == 0) return null;
        return toAdapter(organization, entities.get(0));
    }

    @Override
    public boolean removeDocument(String id, OrganizationModel organization) {
        DocumentEntity entity = getSession().find(DocumentEntity.class, id);
        if (entity == null) return false;
        removeDocument(entity);
        return true;
    }

    private void removeDocument(DocumentEntity document) {
        String id = document.getId();
        getSession().flush();
        getSession().clear();

        document = getSession().find(DocumentEntity.class, id);
        if (document != null) {
            getSession().remove(document);
        }

        getSession().flush();
    }

    @Override
    public void preRemove(OrganizationModel organization) {
        getSession().createNamedQuery("deleteDocumentRequiredActionsByOrganization").setParameter("organizationId", organization.getId()).executeUpdate();

        getSession().createNamedQuery("deleteAttachedDocumentsByOrganization").setParameter("organizationId", organization.getId()).executeUpdate();

        getSession().createNamedQuery("deleteSendEventAttachedFilesByOrganization").setParameter("organizationId", organization.getId()).executeUpdate();
        getSession().createNamedQuery("deleteSendEventAttributesByOrganization").setParameter("organizationId", organization.getId()).executeUpdate();
        getSession().createNamedQuery("deleteSendEventsByOrganization").setParameter("organizationId", organization.getId()).executeUpdate();

        getSession().createNamedQuery("deleteDocumentAttributesByOrganization").setParameter("organizationId", organization.getId()).executeUpdate();

        getSession().createNamedQuery("deleteDocumentLineAttributesByOrganization").setParameter("organizationId", organization.getId()).executeUpdate();
        getSession().createNamedQuery("deleteDocumentLinesByOrganization").setParameter("organizationId", organization.getId()).executeUpdate();

        getSession().createNamedQuery("deleteDocumentsByOrganization").setParameter("organizationId", organization.getId()).executeUpdate();
    }

    @Override
    public List<DocumentModel> getDocuments(OrganizationModel organization) {
        return getDocuments(organization, -1, -1);
    }

    @Override
    public List<DocumentModel> getDocuments(OrganizationModel organization, int firstResult, int maxResults) {
        TypedQuery<DocumentEntity> query = getSession().createNamedQuery("getAllDocumentsByOrganization", DocumentEntity.class);
        query.setParameter("organizationId", organization.getId());
        if (firstResult != -1) {
            query.setFirstResult(firstResult);
        }
        if (maxResults != -1) {
            query.setMaxResults(maxResults);
        }
        return query.getResultList().stream()
                .map(entity -> toAdapter(organization, entity))
                .collect(Collectors.toList());
    }

    @Override
    public List<DocumentModel> searchForDocument(String filterText, OrganizationModel organization) {
        return searchForDocument(filterText, organization, -1, -1);
    }

    @Override
    public List<DocumentModel> searchForDocument(String filterText, OrganizationModel organization, int firstResult, int maxResults) {
        TypedQuery<DocumentEntity> query = getSession().createNamedQuery("searchForDocument", DocumentEntity.class);
        query.setParameter("organizationId", organization.getId());
        query.setParameter("search", "%" + filterText.toLowerCase() + "%");
        if (firstResult != -1) {
            query.setFirstResult(firstResult);
        }
        if (maxResults != -1) {
            query.setMaxResults(maxResults);
        }
        return query.getResultList().stream()
                .map(entity -> toAdapter(organization, entity))
                .collect(Collectors.toList());
    }

    @Override
    public int getDocumentsCount(OrganizationModel organization) {
        Query query = getSession().createNamedQuery("getOrganizationDocumentCount");
        Long result = (Long) query.getSingleResult();
        return result.intValue();
    }

}
