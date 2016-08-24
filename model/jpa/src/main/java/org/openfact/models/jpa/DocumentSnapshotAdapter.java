package org.openfact.models.jpa;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.DocumentSnapshotModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.entities.DocumentSnapshotEntity;

public class DocumentSnapshotAdapter implements DocumentSnapshotModel, JpaModel<DocumentSnapshotEntity> {

    protected static final Logger logger = Logger.getLogger(DocumentSnapshotAdapter.class);

    protected DocumentSnapshotEntity document;
    protected EntityManager em;
    protected OpenfactSession session;

    public DocumentSnapshotAdapter(OpenfactSession session, EntityManager em, DocumentSnapshotEntity document) {
        this.session = session;
        this.em = em;
        this.document = document;
    }

    @Override
    public DocumentSnapshotEntity getEntity() {
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
