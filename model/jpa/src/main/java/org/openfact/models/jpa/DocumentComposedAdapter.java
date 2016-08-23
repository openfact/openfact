package org.openfact.models.jpa;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.DocumentComponentModel;
import org.openfact.models.DocumentComposedModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.enums.DocumentType;
import org.openfact.models.jpa.entities.DocumentComponentEntity;
import org.openfact.models.jpa.entities.DocumentComposedEntity;

public class DocumentComposedAdapter implements DocumentComposedModel, JpaModel<DocumentComposedEntity> {

    protected static final Logger logger = Logger.getLogger(DocumentComposedAdapter.class);

    protected OrganizationModel organization;
    protected DocumentComposedEntity document;
    protected EntityManager em;
    protected OpenfactSession session;

    public DocumentComposedAdapter(OrganizationModel organization, OpenfactSession session, EntityManager em,
            DocumentComposedEntity document) {
        this.organization = organization;
        this.session = session;
        this.em = em;
        this.document = document;
    }

    @Override
    public DocumentComposedEntity getEntity() {
        return document;
    }

    public static DocumentComposedEntity toEntity(DocumentComposedAdapter model, EntityManager em) {
        if (model instanceof DocumentComposedAdapter) {
            return ((DocumentComposedAdapter) model).getEntity();
        }
        return em.getReference(DocumentComposedEntity.class, model.getId());
    }

    @Override
    public String getId() {
        return document.getId();
    }

    @Override
    public String getName() {
        return document.getName();
    }

    @Override
    public void setName(String name) {
        document.setName(name);
    }

    @Override
    public String getDocumentId() {
        return document.getDocumentId();
    }

    @Override
    public void setDocumentId(String documentId) {
        document.setDocumentId(documentId);
    }

    @Override
    public String getDescription() {
        return document.getDescription();
    }

    @Override
    public void setDescription(String description) {
        document.setDescription(description);
    }

    @Override
    public DocumentType getType() {
        return document.getType();
    }

    @Override
    public void setType(DocumentType type) {
        document.setType(type);
    }

    @Override
    public String getCode() {
        return document.getCode();
    }

    @Override
    public void setCode(String code) {
        document.setCode(code);
    }

    @Override
    public OrganizationModel getOrganization() {
        return organization;
    }

    @Override
    public void addChildren(DocumentComponentModel documentComponent) {
        DocumentComponentEntity entity = AbstractDocumentComponentAdapter.toEntity(documentComponent, em);
        entity.setDocumentParent(document);        
        this.document.add(entity);
        em.flush();
    }

    @Override
    public List<DocumentComponentModel> getChildrens() {
        return document.getChildrens().stream()
                .map(f -> AbstractDocumentComponentAdapter.toModel(f, organization, session, em))
                .collect(Collectors.toList());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((document == null) ? 0 : document.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DocumentComposedAdapter other = (DocumentComposedAdapter) obj;
        if (document == null) {
            if (other.document != null)
                return false;
        } else if (!document.equals(other.document))
            return false;
        return true;
    }

}
