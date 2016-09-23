package org.openfact.models.jpa.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.ExternalReferenceEntity;
import org.openfact.models.ubl.common.ExternalReferenceModel;

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

    @Override
    public String getURI() {
        return this.externalReference.getUri();
    }

    @Override
    public void setURI(String value) {
        this.externalReference.setUri(value);
    }

    @Override
    public String getDocumentHash() {
        return this.externalReference.getDocumentHash();
    }

    @Override
    public void setDocumentHash(String value) {
        this.externalReference.setDocumentHash(value);
    }

    @Override
    public LocalDate getExpiryDate() {
        return this.externalReference.getExpiryDate();
    }

    @Override
    public void setExpiryDate(LocalDate value) {
        this.externalReference.setExpiryDate(value);
    }

    @Override
    public LocalTime getExpiryTime() {
        return this.externalReference.getExpiryTime();
    }

    @Override
    public void setExpiryTime(LocalTime value) {
        this.externalReference.setExpiryTime(value);
    }

    @Override
    public String getId() {
        return this.externalReference.getId();
    }

    @Override
    public void setId(String value) {
        this.externalReference.setId(value);
    }

    public static ExternalReferenceEntity toEntity(ExternalReferenceModel model, EntityManager em) {
        if (model instanceof ExternalReferenceModel) {
            return ((ExternalReferenceAdapter) model).getEntity();
        }
        return em.getReference(ExternalReferenceEntity.class, model.getId());
    }

    @Override
    public ExternalReferenceEntity getEntity() {
        return externalReference;
    }

}
