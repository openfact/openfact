package org.openfact.models.jpa.entities;

import org.hibernate.annotations.GenericGenerator;
import org.openfact.models.enums.AdditionalAccountType;

import javax.persistence.*;

@Table(name = "CUSTOMER")
@Entity
public class CustomerEntity {

    @Id
    @Access(AccessType.PROPERTY)
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", length = 36)
    private String id;

    // Ruc number
    @Column(name = "ASSIGNED_IDENTIFICATION_ID")
    protected String assignedIdentificationId;

    // Document type
    @Column(name = "ADDITIONAL_ACCOUNT_ID")
    protected AdditionalAccountType additionalAccountId;

    // Nombre comercial
    @Column(name = "REGISTRATION_NAME")
    protected String registrationName;

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

    public AdditionalAccountType getAdditionalAccountId() {
        return additionalAccountId;
    }

    public void setAdditionalAccountId(AdditionalAccountType additionalAccountId) {
        this.additionalAccountId = additionalAccountId;
    }

    public String getRegistrationName() {
        return registrationName;
    }

    public void setRegistrationName(String registrationName) {
        this.registrationName = registrationName;
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
