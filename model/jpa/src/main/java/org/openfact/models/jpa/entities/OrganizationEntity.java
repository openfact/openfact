package org.openfact.models.jpa.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.openfact.models.enums.AdditionalAccountType;

@Table(name = "ORGANIZATION")
@Entity
@NamedQueries({
        @NamedQuery(name = "getAllOrganizationIds", query = "select organization.id from OrganizationEntity organization"),
        @NamedQuery(name = "getOrganizationIdByName", query = "select organization.id from OrganizationEntity organization where organization.name = :name"),})
public class OrganizationEntity {

    @Id
    @Column(name = "ID", length = 36)
    @Access(AccessType.PROPERTY)
    protected String id;

    @Column(name = "NAME", unique = true)
    protected String name;

    @Column(name = "ENABLED")
    protected boolean enabled;

    // Ruc number
    @Column(name = "ASSIGNED_IDENTIFICATION_ID")
    protected String assignedIdentificationId;

    // Document type
    @Column(name = "ADDITIONAL_ACCOUNT_ID")
    protected AdditionalAccountType additionalAccountId;

    // Razon social
    @Column(name = "SUPPLIER_NAME")
    protected String supplierName;

    // Nombre comercial
    @Column(name = "REGISTRATION_NAME")
    protected String registrationName;

    // Direccion
    @OneToOne(mappedBy = "organization", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    protected PostalAddressEntity postalAddress;

    // Certificado
    @OneToMany(mappedBy = "organization", cascade = CascadeType.REMOVE, orphanRemoval = true)
    protected List<CertifiedEntity> certifieds = new ArrayList<>();

    // Invoices
    @OneToMany(mappedBy = "organization", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<InvoiceEntity> invoices = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getAssignedIdentificationId() {
        return assignedIdentificationId;
    }

    public void setAssignedIdentificationId(String assignedIdentificationId) {
        this.assignedIdentificationId = assignedIdentificationId;
    }

    public AdditionalAccountType getAdditionalAccountId() {
        return additionalAccountId;
    }

    public void setAdditionalAccountId(AdditionalAccountType additionalAccountId) {
        this.additionalAccountId = additionalAccountId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getRegistrationName() {
        return registrationName;
    }

    public void setRegistrationName(String registrationName) {
        this.registrationName = registrationName;
    }

    public PostalAddressEntity getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(PostalAddressEntity postalAddress) {
        this.postalAddress = postalAddress;
    }

    public List<InvoiceEntity> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<InvoiceEntity> invoices) {
        this.invoices = invoices;
    }

    public List<CertifiedEntity> getCertifieds() {
        return certifieds;
    }

    public void setCertifieds(List<CertifiedEntity> certifieds) {
        this.certifieds = certifieds;
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
        OrganizationEntity other = (OrganizationEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
