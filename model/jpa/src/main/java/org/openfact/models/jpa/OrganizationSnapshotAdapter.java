package org.openfact.models.jpa;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.DocumentSnapshotModel;
import org.openfact.models.InvoiceModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationSnapshotModel;
import org.openfact.models.jpa.entities.DocumentSnapshotEntity;
import org.openfact.models.jpa.entities.OrganizationSnapshotEntity;

public class OrganizationSnapshotAdapter
        implements OrganizationSnapshotModel, JpaModel<OrganizationSnapshotEntity> {

    protected static final Logger logger = Logger.getLogger(OrganizationSnapshotAdapter.class);

    protected InvoiceModel invoice;
    protected OrganizationSnapshotEntity organizationSnapshot;
    protected EntityManager em;
    protected OpenfactSession session;

    public OrganizationSnapshotAdapter(OpenfactSession session, InvoiceModel invoice, EntityManager em,
            OrganizationSnapshotEntity organizationSnapshot) {
        this.session = session;
        this.em = em;
        this.invoice = invoice;
        this.organizationSnapshot = organizationSnapshot;
    }

    @Override
    public OrganizationSnapshotEntity getEntity() {
        return organizationSnapshot;
    }

    @Override
    public String getId() {
        return organizationSnapshot.getId();
    }

    @Override
    public String getAssignedIdentificationId() {
        return organizationSnapshot.getAssignedIdentificationId();
    }

    @Override
    public void setAssignedIdentificationId(String assignedIdentificationId) {
        organizationSnapshot.setAssignedIdentificationId(assignedIdentificationId);
    }

    @Override
    public DocumentSnapshotModel getAdditionalAccountId() {
        return new DocumentSnapshotAdapter(session, em, organizationSnapshot.getAdditionalAccountId());
    }

    @Override
    public void setAdditionalAccountId(String documentName, String documentId) {
        DocumentSnapshotEntity document = new DocumentSnapshotEntity();
        document.setName(documentName);
        document.setDocumentId(documentId);
        organizationSnapshot.setAdditionalAccountId(document);
    }

    @Override
    public String getSupplierName() {
        return organizationSnapshot.getSupplierName();
    }

    @Override
    public void setSuppliername(String supplierName) {
        organizationSnapshot.setSupplierName(supplierName);
    }

    @Override
    public String getRegistrationName() {
        return organizationSnapshot.getRegistrationName();
    }

    @Override
    public void setRegistrationName(String registrationName) {
        organizationSnapshot.setRegistrationName(registrationName);
    }

    @Override
    public String getAddress() {
        return organizationSnapshot.getAddress();
    }

    @Override
    public void setAddress(String address) {
        organizationSnapshot.setAddress(address);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((organizationSnapshot == null) ? 0 : organizationSnapshot.hashCode());
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
        OrganizationSnapshotAdapter other = (OrganizationSnapshotAdapter) obj;
        if (organizationSnapshot == null) {
            if (other.organizationSnapshot != null)
                return false;
        } else if (!organizationSnapshot.equals(other.organizationSnapshot))
            return false;
        return true;
    }

}
