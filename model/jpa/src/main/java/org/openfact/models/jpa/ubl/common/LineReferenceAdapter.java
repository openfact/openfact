package org.openfact.models.jpa.ubl.common;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.LineReferenceEntity;
import org.openfact.models.ubl.common.DocumentReferenceModel;
import org.openfact.models.ubl.common.LineReferenceModel;

public class LineReferenceAdapter implements LineReferenceModel, JpaModel<LineReferenceEntity> {

    protected static final Logger logger = Logger.getLogger(LineReferenceAdapter.class);
    protected LineReferenceEntity lineReference;
    protected EntityManager em;
    protected OpenfactSession session;

    public LineReferenceAdapter(OpenfactSession session, EntityManager em,
            LineReferenceEntity lineReference) {
        this.session = session;
        this.em = em;
        this.lineReference = lineReference;
    }

    @Override
    public String getLineID() {
        return this.lineReference.getLineID();
    }

    @Override
    public void setLineID(String value) {
        this.lineReference.setLineID(value);
    }

    @Override
    public String getUUID() {
        return this.lineReference.getUuid();
    }

    @Override
    public void setUUID(String value) {
        this.lineReference.setUuid(value);
    }

    @Override
    public String getLineStatusCode() {
        return this.lineReference.getLineStatusCode();
    }

    @Override
    public void setLineStatusCode(String value) {
        this.lineReference.setLineStatusCode(value);
    }

    @Override
    public DocumentReferenceModel getDocumentReference() {
        return new DocumentReferenceAdapter(session, em, this.lineReference.getDocumentReference());
    }

    @Override
    public void setDocumentReference(DocumentReferenceModel value) {
        this.lineReference.setDocumentReference(DocumentReferenceAdapter.toEntity(value, em));
    }

    @Override
    public String getId() {
        return this.lineReference.getId();
    }

    @Override
    public void setId(String value) {
        this.lineReference.setId(value);
    }

    @Override
    public LineReferenceEntity getEntity() {
        return lineReference;
    }

    public static LineReferenceEntity toEntity(LineReferenceModel model, EntityManager em) {
        if (model instanceof LineReferenceAdapter) {
            return ((LineReferenceAdapter) model).getEntity();
        }
        return em.getReference(LineReferenceEntity.class, model.getId());
    }

}
