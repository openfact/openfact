package org.openfact.models.jpa.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;

public class ExternalReferenceAdapter implements ExternalReferenceModel, JpaModel<ExternalReferenceEntity> {

    protected static final Logger logger = Logger.getLogger(ExternalReferenceAdapter.class);
    protected ExternalReferenceEntity externalReference;
    protected EntityManager em;
    protected OpenfactSession session;

    public ExternalReferenceAdapter(OpenfactSession session, EntityManager em,
            ExternalReferenceEntity externalReference) {
        this.session = session;
        this.em = em;
        this.externalReference = externalReference;
    }

    String getURI() {
        return this.externalReference.getURI();
    }

    void setURI(String value) {
        this.externalReference.setURI(value);
    }

    String getDocumentHash() {
        return this.externalReference.getDocumentHash();
    }

    void setDocumentHash(String value) {
        this.externalReference.setDocumentHash(value);
    }

    LocalDate getExpiryDate() {
        return this.externalReference.getExpiryDate();
    }

    void setExpiryDate(LocalDate value) {
        this.externalReference.setExpiryDate(value);
    }

    LocalTime getExpiryTime() {
        return this.externalReference.getExpiryTime();
    }

    void setExpiryTime(LocalTime value) {
        this.externalReference.setExpiryTime(value);
    }

    String getId() {
        return this.externalReference.getId();
    }

    void setId(String value) {
        this.externalReference.setId(value);
    }

}
