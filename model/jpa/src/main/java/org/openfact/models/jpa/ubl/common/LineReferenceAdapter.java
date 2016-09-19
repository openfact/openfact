package org.openfact.models.jpa.ubl.common;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
import org.openfact.models.jpa.JpaModel;
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
        return this.lineReference.getUUID();
    }

    @Override
    public void setUUID(String value) {
        this.lineReference.setUUID(value);
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
        return this.lineReference.getDocumentReference();
    }

    @Override
    public void setDocumentReference(DocumentReferenceAdapter value) {
        this.lineReference.setDocumentReference(value);
    }

    @Override
    public String getId() {
        return this.lineReference.getId();
    }

    @Override
    public void setId(String value) {
        this.lineReference.setId(value);
    }

}
