package org.openfact.models.jpa;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.DocumentComponentModel;
import org.openfact.models.ModelException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.enums.DocumentType;
import org.openfact.models.jpa.entities.DocumentComponentEntity;
import org.openfact.models.jpa.entities.DocumentComposedEntity;
import org.openfact.models.jpa.entities.DocumentSimpleEntity;
import org.openfact.models.jpa.entities.DocumentValuableEntity;

public abstract class AbstractDocumentComponentAdapter
        implements DocumentComponentModel, JpaModel<DocumentComponentEntity> {

    protected static final Logger logger = Logger.getLogger(AbstractDocumentComponentAdapter.class);

    protected OrganizationModel organization;
    protected DocumentComponentEntity document;
    protected EntityManager em;
    protected OpenfactSession session;

    public AbstractDocumentComponentAdapter(OrganizationModel organization, OpenfactSession session,
            EntityManager em, DocumentComponentEntity document) {
        this.organization = organization;
        this.session = session;
        this.em = em;
        this.document = document;
    }

    @Override
    public DocumentComponentEntity getEntity() {
        return document;
    }

    public static DocumentComponentEntity toEntity(DocumentComponentModel model, EntityManager em) {
        if (model instanceof AbstractDocumentComponentAdapter) {
            return ((AbstractDocumentComponentAdapter) model).getEntity();
        }
        return em.getReference(DocumentComponentEntity.class, model.getId());
    }

    public static DocumentComponentModel toModel(DocumentComponentEntity entity,
            OrganizationModel organization, OpenfactSession session, EntityManager em) {
        if (entity instanceof DocumentSimpleEntity) {
            DocumentSimpleEntity simpleDocument = (DocumentSimpleEntity) entity;
            return new DocumentSimpleAdapter(organization, session, em, simpleDocument);
        } else if (entity instanceof DocumentValuableEntity) {
            DocumentValuableEntity valuableDocument = (DocumentValuableEntity) entity;
            return new DocumentValuableAdapter(organization, session, em, valuableDocument);
        } else if (entity instanceof DocumentComposedEntity) {
            DocumentComposedEntity valuableDocument = (DocumentComposedEntity) entity;
            return new DocumentComposedAdapter(organization, session, em, valuableDocument);
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
        AbstractDocumentComponentAdapter other = (AbstractDocumentComponentAdapter) obj;
        if (document == null) {
            if (other.document != null)
                return false;
        } else if (!document.equals(other.document))
            return false;
        return true;
    }

}
