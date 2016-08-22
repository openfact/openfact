package org.openfact.models.jpa;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.DocumentSavedModel;
import org.openfact.models.InvoiceModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationSavedModel;
import org.openfact.models.jpa.entities.DocumentSavedEntity;
import org.openfact.models.jpa.entities.OrganizationSavedEntity;

public class OrganizationSavedAdapter implements OrganizationSavedModel, JpaModel<OrganizationSavedEntity> {

    protected static final Logger logger = Logger.getLogger(OrganizationSavedAdapter.class);

    protected InvoiceModel invoice;
    protected OrganizationSavedEntity organizationSaved;
    protected EntityManager em;
    protected OpenfactSession session;

    public OrganizationSavedAdapter(OpenfactSession session, InvoiceModel invoice, EntityManager em,
            OrganizationSavedEntity organizationSaved) {
        this.session = session;
        this.em = em;
        this.invoice = invoice;
        this.organizationSaved = organizationSaved;
    }

    @Override
    public OrganizationSavedEntity getEntity() {
        return organizationSaved;
    }

    @Override
    public String getId() {
        return organizationSaved.getId();
    }

    @Override
    public String getAssignedIdentificationId() {
        return organizationSaved.getAssignedIdentificationId();
    }

    @Override
    public void setAssignedIdentificationId(String assignedIdentificationId) {
        organizationSaved.setAssignedIdentificationId(assignedIdentificationId);
    }

    @Override
    public DocumentSavedModel getAdditionalAccountId() {
        return new DocumentSavedAdapter(session, em, organizationSaved.getAdditionalAccountId());
    }

    @Override
    public void setAdditionalAccountId(String documentName, String documentId) {
        DocumentSavedEntity document = new DocumentSavedEntity();
        document.setName(documentName);
        document.setDocumentId(documentId);
        organizationSaved.setAdditionalAccountId(document);
    }

    @Override
    public String getSupplierName() {
        return organizationSaved.getSupplierName();
    }

    @Override
    public void setSuppliername(String supplierName) {
        organizationSaved.setSupplierName(supplierName);
    }

    @Override
    public String getRegistrationName() {
        return organizationSaved.getRegistrationName();
    }

    @Override
    public void setRegistrationName(String registrationName) {
        organizationSaved.setRegistrationName(registrationName);
    }

    @Override
    public String getAddress() {
        return organizationSaved.getAddress();
    }

    @Override
    public void setAddress(String address) {
        organizationSaved.setAddress(address);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((organizationSaved == null) ? 0 : organizationSaved.hashCode());
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
        OrganizationSavedAdapter other = (OrganizationSavedAdapter) obj;
        if (organizationSaved == null) {
            if (other.organizationSaved != null)
                return false;
        } else if (!organizationSaved.equals(other.organizationSaved))
            return false;
        return true;
    }

}
