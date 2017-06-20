package org.openfact.models.jpa;

import org.openfact.models.DocumentLineModel;
import org.openfact.models.DocumentModel;
import org.openfact.models.OrganizationModel;
import org.openfact.models.jpa.entities.DocumentEntity;
import org.openfact.models.jpa.entities.DocumentLineEntity;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class DocumentAdapter implements DocumentModel, JpaModel<DocumentEntity> {

    private OrganizationModel organization;
    private DocumentEntity document;
    private EntityManager em;

    public DocumentAdapter(OrganizationModel organization, EntityManager em, DocumentEntity document) {
        this.organization = organization;
        this.em = em;
        this.document = document;
    }

    public static DocumentEntity toEntity(DocumentModel model, EntityManager em) {
        if (model instanceof DocumentAdapter) {
            return ((DocumentAdapter) model).getEntity();
        }
        return em.getReference(DocumentEntity.class, model.getId());
    }

    public DocumentLineModel toDocumentLineModel(DocumentLineEntity documentLine) {
        return new DocumentLineAdapter(this, em, documentLine);
    }

    @Override
    public DocumentEntity getEntity() {
        return document;
    }

    @Override
    public String getId() {
        return document.getId();
    }

    @Override
    public String getID() {
        return document.getDocumentId();
    }

    @Override
    public String getDocumentType() {
        return document.getDocumentType();
    }

    @Override
    public LocalDateTime getCreatedTimestamp() {
        return document.getCreatedTimestamp();
    }

    @Override
    public boolean isEnabled() {
        return document.isEnabled();
    }

    @Override
    public void disable() {
        document.setEnabled(false);
    }

    @Override
    public OrganizationModel getOrganization() {
        return organization;
    }

    @Override
    public String getCurrencyCode() {
        return document.getDocumentCurrencyCode();
    }

    @Override
    public void setCurrencyCode(String currencyCode) {
        document.setDocumentCurrencyCode(currencyCode);
    }

    @Override
    public String getCustomerRegistrationName() {
        return document.getCustomerRegistrationName();
    }

    @Override
    public void setCustomerRegistrationName(String value) {
        document.setCustomerRegistrationName(value);
    }

    @Override
    public String getCustomerAssignedAccountId() {
        return document.getCustomerAssignedAccountId();
    }

    @Override
    public void setCustomerAssignedAccountId(String value) {
        document.setCustomerAssignedAccountId(value);
    }

    @Override
    public String getCustomerElectronicMail() {
        return document.getCustomerElectronicMail();
    }

    @Override
    public void setCustomerElectronicMail(String value) {
        document.setCustomerElectronicMail(value);
    }

    @Override
    public DocumentLineModel addLine() {
        DocumentLineEntity entity = new DocumentLineEntity();
        entity.setDocument(document);
        em.persist(entity);

        document.getLines().add(entity);
        return toDocumentLineModel(entity);
    }

    @Override
    public List<DocumentLineModel> getLines() {
        return document.getLines().stream()
                .map(this::toDocumentLineModel)
                .collect(Collectors.toList());
    }

    @Override
    public boolean removeLine(DocumentLineModel line) {
        boolean result = false;
        Iterator<DocumentLineEntity> it = document.getLines().iterator();
        while (it.hasNext()) {
            DocumentLineEntity l = it.next();
            if (l.getId().equals(line.getId())) {
                it.remove();
                em.remove(l);
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof DocumentModel)) return false;

        DocumentModel that = (DocumentModel) o;
        return that.getId().equals(getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

}