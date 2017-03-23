package org.openfact.models.jpa;

import org.jboss.logging.Logger;
import org.openfact.models.*;
import org.openfact.models.jpa.entities.DocumentEntity;
import org.openfact.provider.ProviderEvent;
import org.openfact.models.types.DocumentType;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class JpaDocumentProvider implements DocumentProvider {

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

    @Inject
    private FileProvider fileProvider;

    @PersistenceContext
    private EntityManager em;

    private DocumentAdapter toAdapter(OrganizationModel organization, DocumentEntity entity) {
        return new DocumentAdapter(organization, em, entity, fileProvider);
    }

    @Override
    public DocumentModel addDocument(DocumentType documentType, String documentId, OrganizationModel organization) throws ModelException {
        return addDocument(documentType.toString(), documentId, organization);
    }

    @Override
    public DocumentQuery createQuery(OrganizationModel organization) {
        return new JpaDocumentQuery(em, fileProvider, organization);
    }

    @Override
    public DocumentModel addDocument(String documentType, String documentId, OrganizationModel organization) throws ModelException {
        if (getDocumentByTypeAndDocumentId(documentType, documentId, organization) != null) {
            throw new ModelDuplicateException("Document documentId[" + documentId + "] exists");
        }

        DocumentEntity entity = new DocumentEntity();
        entity.setDocumentType(documentType.toUpperCase());
        entity.setDocumentId(documentId.toUpperCase());
        entity.setCreatedTimestamp(LocalDateTime.now());
        entity.setOrganizationId(organization.getId());
        entity.setEnabled(true);
        em.persist(entity);
        em.flush();

        final DocumentModel adapter = toAdapter(organization, entity);
        event.fire((DocumentModel.DocumentCreationEvent) () -> adapter);

        logger.debug("Document documentId[" + documentId + "] created on organization " + organization.getName());
        return adapter;
    }

    @Override
    public DocumentModel getDocumentById(String id, OrganizationModel organization) {
        TypedQuery<DocumentEntity> query = em.createNamedQuery("getOrganizationDocumentByDocumentPkId", DocumentEntity.class);
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
        TypedQuery<DocumentEntity> query = em.createNamedQuery("getOrganizationDocumentByDocumentTypeAndDocumentId", DocumentEntity.class);
        query.setParameter("documentType", documentType.toUpperCase());
        query.setParameter("documentId", documentId.toUpperCase());
        query.setParameter("organizationId", organization.getId());
        List<DocumentEntity> entities = query.getResultList();
        if (entities.size() == 0) return null;
        return toAdapter(organization, entities.get(0));
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
        em.createNamedQuery("deleteDocumentRequiredActionsByOrganization").setParameter("organizationId", organization.getId()).executeUpdate();

        em.createNamedQuery("deleteAttachedDocumentsByOrganization").setParameter("organizationId", organization.getId()).executeUpdate();

        em.createNamedQuery("deleteSendEventAttachedFilesByOrganization").setParameter("organizationId", organization.getId()).executeUpdate();
        em.createNamedQuery("deleteSendEventAttributesByOrganization").setParameter("organizationId", organization.getId()).executeUpdate();
        em.createNamedQuery("deleteSendEventsByOrganization").setParameter("organizationId", organization.getId()).executeUpdate();

        em.createNamedQuery("deleteDocumentAttributesByOrganization").setParameter("organizationId", organization.getId()).executeUpdate();

        em.createNamedQuery("deleteDocumentLineAttributesByOrganization").setParameter("organizationId", organization.getId()).executeUpdate();
        em.createNamedQuery("deleteDocumentLinesByOrganization").setParameter("organizationId", organization.getId()).executeUpdate();

        em.createNamedQuery("deleteDocumentsByOrganization").setParameter("organizationId", organization.getId()).executeUpdate();
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
        TypedQuery<DocumentEntity> query = em.createNamedQuery("searchForDocument", DocumentEntity.class);
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
        Query query = em.createNamedQuery("getOrganizationDocumentCount");
        Long result = (Long) query.getSingleResult();
        return result.intValue();
    }

}
