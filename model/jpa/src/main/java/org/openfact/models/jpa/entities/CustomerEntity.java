package org.openfact.models.jpa.entities;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author carlosthe19916@sistcoop.com
 */

@Entity
@Table(name = "CUSTOMER")
public class CustomerEntity {

    @Id
    @Access(AccessType.PROPERTY)
    @Column(name = "INVOICE_ID", length = 36)
    private String id;

    @Column(name = "ASSIGNED_IDENTIFICATION_ID")
    private String assignedIdentificationId;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "ADDITIONAL_ACCOUNTID_NAME")),
            @AttributeOverride(name = "documentId", column = @Column(name = "ADDITIONAL_ACCOUNTID_DOCUMENTID")) })
    private DocumentSnapshotEntity additionalAccountId;

    @Column(name = "REGISTRATION_NAME")
    private String registrationName;

    @Column(name = "EMAIL")
    private String email;

    @NotNull
    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INVOICE_ID")
    private InvoiceEntityDEPRECATED invoice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAssignedIdentificationId() {
        return assignedIdentificationId;
    }

    public void setAssignedIdentificationId(String assignedIdentificationId) {
        this.assignedIdentificationId = assignedIdentificationId;
    }

    public DocumentSnapshotEntity getAdditionalAccountId() {
        return additionalAccountId;
    }

    public void setAdditionalAccountId(DocumentSnapshotEntity additionalAccountId) {
        this.additionalAccountId = additionalAccountId;
    }

    public String getRegistrationName() {
        return registrationName;
    }

    public void setRegistrationName(String registrationName) {
        this.registrationName = registrationName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public InvoiceEntityDEPRECATED getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceEntityDEPRECATED invoice) {
        this.invoice = invoice;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        CustomerEntity other = (CustomerEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
