package org.openfact.models.jpa;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.DocumentModel;
import org.openfact.models.ModelException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.enums.DocumentType;
import org.openfact.models.jpa.entities.DocumentEntity;
import org.openfact.models.jpa.entities.CheckableDocumentEntity;
import org.openfact.models.jpa.entities.ComposedDocumentEntity;
import org.openfact.models.jpa.entities.SimpleDocumentEntity;
import org.openfact.models.jpa.entities.ValuableDocumentEntity;

public class DocumentAdapter implements DocumentModel, JpaModel<DocumentEntity> {

    protected static final Logger logger = Logger.getLogger(DocumentAdapter.class);

    protected OrganizationModel organization;
    protected DocumentEntity document;
    protected EntityManager em;
    protected OpenfactSession session;

    public DocumentAdapter(OrganizationModel organization, OpenfactSession session, EntityManager em,
            DocumentEntity document) {
        this.organization = organization;
        this.session = session;
        this.em = em;
        this.document = document;
    }

    @Override
    public DocumentEntity getEntity() {
        return document;
    }

    public static DocumentEntity toEntity(DocumentModel model, EntityManager em) {
        if (model instanceof DocumentAdapter) {
            return ((DocumentAdapter) model).getEntity();
        }
        return em.getReference(DocumentEntity.class, model.getId());
    }

    public static DocumentModel toModel(DocumentEntity entity, OrganizationModel organization,
            OpenfactSession session, EntityManager em) {
        if (entity instanceof SimpleDocumentEntity) {
            SimpleDocumentEntity simpleDocument = (SimpleDocumentEntity) entity;
            return new SimpleDocumentAdapter(organization, session, em, simpleDocument);
        } else if (entity instanceof ValuableDocumentEntity) {
            ValuableDocumentEntity valuableDocument = (ValuableDocumentEntity) entity;
            return new ValuableDocumentAdapter(organization, session, em, valuableDocument);
        } else if (entity instanceof ComposedDocumentEntity) {
            ComposedDocumentEntity valuableDocument = (ComposedDocumentEntity) entity;
            return new ComposedDocumentAdapter(organization, session, em, valuableDocument);
        } else if (entity instanceof CheckableDocumentEntity) {
            CheckableDocumentEntity checkableDocument = (CheckableDocumentEntity) entity;
            return new CheckableDocumentAdapter(organization, session, em, checkableDocument);
        } else {
            throw new ModelException("Entity no encontrado");
        }
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
    public DocumentModel getParent() {
        DocumentEntity parent = document.getParent();
        if(parent != null) {
            return toModel(document.getParent(), organization, session, em);
        }
        return null;   
    }
    
    @Override
    public OrganizationModel getOrganization() {
        return organization;
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
        DocumentAdapter other = (DocumentAdapter) obj;
        if (document == null) {
            if (other.document != null)
                return false;
        } else if (!document.equals(other.document))
            return false;
        return true;
    }   

}
