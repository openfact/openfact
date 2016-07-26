package org.openfact.representations.idm;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class OrganizationRepresentation {

    private String id;
    private String name;
    private boolean enabled;
    private String assignedIdentificationId;
    private String additionalAccountId;
    private String supplierName;
    private String registrationName;
    private PostalAddressRepresentation postalAddress;

    /**
     * @return The unique id.
     */
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

    public String getAdditionalAccountId() {
        return additionalAccountId;
    }

    public void setAdditionalAccountId(String additionalAccountId) {
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

    public PostalAddressRepresentation getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(PostalAddressRepresentation postalAddress) {
        this.postalAddress = postalAddress;
    }

}
