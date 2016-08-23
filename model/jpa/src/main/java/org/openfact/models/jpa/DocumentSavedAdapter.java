package org.openfact.models.jpa;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.DocumentSavedModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.entities.DocumentSavedEntity;

public class DocumentSavedAdapter implements DocumentSavedModel, JpaModel<DocumentSavedEntity> {

    protected static final Logger logger = Logger.getLogger(DocumentSavedAdapter.class);

    protected DocumentSavedEntity document;
    protected EntityManager em;
    protected OpenfactSession session;

    public DocumentSavedAdapter(OpenfactSession session, EntityManager em, DocumentSavedEntity document) {
        this.session = session;
        this.em = em;
        this.document = document;
    }

    @Override
    public DocumentSavedEntity getEntity() {
        return document;
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

}
