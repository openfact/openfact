package org.openfact.models.jpa;

import org.openfact.models.DocumentModel;
import org.openfact.models.DocumentModel.DocumentType;
import org.openfact.models.DocumentProvider;
import org.openfact.models.ModelException;
import org.openfact.models.OrganizationModel;
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

    @Inject
    private EntityManager em;

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
}
