package org.openfact.models.jpa;

import org.openfact.models.*;
import org.openfact.models.DocumentModel.DocumentType;
import org.openfact.models.jpa.entities.DocumentEntity;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class JpaDocumentProvider implements DocumentProvider {

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

    private EntityManager em;

    @Inject
    public JpaDocumentProvider(EntityManager em) {
        this.em = em;
    }

    private DocumentAdapter toAdapter(OrganizationModel organization, DocumentEntity entity) {
        return new DocumentAdapter(organization, em, entity);
    }

    @Override
    public DocumentModel addDocument(OrganizationModel organization, String type, String ID) throws ModelException {
        DocumentEntity entity = new DocumentEntity();
        entity.setDocumentType(type.toUpperCase());
        entity.setDocumentId(ID.toUpperCase());
        entity.setCreatedTimestamp(LocalDateTime.now());
        entity.setOrganization(OrganizationAdapter.toEntity(organization, em));
        entity.setEnabled(true);
        em.persist(entity);
        em.flush();

        return toAdapter(organization, entity);
    }

    @Override
    public DocumentModel addDocument(OrganizationModel organization, DocumentType type, String ID) throws ModelException {
        return addDocument(organization, type.toString(), ID);
    }

    @Override
    public DocumentModel getDocument(OrganizationModel organization, String id) {
        TypedQuery<DocumentEntity> query = em.createNamedQuery("getOrganizationDocumentByDocumentPkId", DocumentEntity.class);
        query.setParameter("documentPkId", id);
        query.setParameter("organizationId", organization.getId());
        List<DocumentEntity> entities = query.getResultList();
        if (entities.size() == 0) return null;
        return toAdapter(organization, entities.get(0));
    }

    @Override
    public DocumentModel getDocumentByTypeAndID(OrganizationModel organization, String type, String ID) {
        TypedQuery<DocumentEntity> query = em.createNamedQuery("getOrganizationDocumentByDocumentTypeAndDocumentId", DocumentEntity.class);
        query.setParameter("documentType", type.toUpperCase());
        query.setParameter("documentId", ID.toUpperCase());
        query.setParameter("organizationId", organization.getId());
        List<DocumentEntity> entities = query.getResultList();
        if (entities.size() == 0) return null;
        return toAdapter(organization, entities.get(0));
    }

    @Override
    public DocumentModel getDocumentByTypeAndID(OrganizationModel organization, DocumentType type, String ID) {
        return getDocumentByTypeAndID(organization, type.toString(), ID);
    }

    @Override
    public int getDocumentsCount(OrganizationModel organization) {
        Query query = em.createNamedQuery("getOrganizationDocumentCount").setParameter("organizationId", organization.getId());
        Long result = (Long) query.getSingleResult();
        return result.intValue();
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
    public boolean removeDocument(OrganizationModel organization, DocumentModel document) {
        if (!organization.equals(document.getOrganization())) {
            return false;
        }
        DocumentEntity entity = DocumentAdapter.toEntity(document, em);
        em.remove(entity);
        em.flush();
        return true;
    }

    @Override
    public org.openfact.models.DocumentQuery createQuery(OrganizationModel organization) {
        return new JpaDocumentQuery(em, organization);
    }
}
