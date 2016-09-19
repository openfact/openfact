package org.openfact.models.jpa.ubl.common;

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

    String getLineID() {
        return this.lineReference.getLineID();
    }

    void setLineID(String value) {
        this.lineReference.setLineID(value);
    }

    String getUUID() {
        return this.lineReference.getUUID();
    }

    void setUUID(String value) {
        this.lineReference.setUUID(value);
    }

    String getLineStatusCode() {
        return this.lineReference.getLineStatusCode();
    }

    void setLineStatusCode(String value) {
        this.lineReference.setLineStatusCode(value);
    }

    DocumentReferenceAdapter getDocumentReference() {
        return this.lineReference.getDocumentReference();
    }

    void setDocumentReference(DocumentReferenceAdapter value) {
        this.lineReference.setDocumentReference(value);
    }

    String getId() {
        return this.lineReference.getId();
    }

    void setId(String value) {
        this.lineReference.setId(value);
    }

}
