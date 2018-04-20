package org.openfact.core.models.jpa;

import org.openfact.core.models.DocumentModel;
import org.openfact.core.models.jpa.entities.DocumentEntity;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DocumentAdapter implements DocumentModel, JpaModel<DocumentEntity> {

    private final DocumentEntity entity;

    public DocumentAdapter(DocumentEntity document) {
        this.entity = document;
    }

    public static DocumentEntity toEntity(DocumentModel model, EntityManager em) {
        if (model instanceof DocumentAdapter) {
            return ((DocumentAdapter) model).getEntity();
        }
        return em.getReference(DocumentEntity.class, model.getId());
    }

    @Override
    public DocumentEntity getEntity() {
        return entity;
    }

    @Override
    public String getId() {
        return entity.getId();
    }

    @Override
    public String getType() {
        return entity.getType();
    }

    @Override
    public String getAssignedId() {
        return entity.getAssignedId();
    }

    @Override
    public String getSupplierAssignedId() {
        return entity.getSupplierAssignedId();
    }

    @Override
    public String getCustomerAssignedId() {
        return entity.getCustomerAssignedId();
    }

    @Override
    public Double getAmount() {
        return entity.getAmount();
    }

    @Override
    public Double getTax() {
        return entity.getTax();
    }

    @Override
    public String getCurrency() {
        return entity.getCurrency();
    }

    @Override
    public Date getIssueDate() {
        return entity.getIssueDate();
    }

    @Override
    public String getSupplierName() {
        return entity.getSupplierName();
    }

    @Override
    public String getCustomerName() {
        return entity.getCustomerName();
    }

}
