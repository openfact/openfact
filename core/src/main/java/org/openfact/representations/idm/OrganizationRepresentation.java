package org.openfact.representations.idm;

public class OrganizationRepresentation {

    /**
     * The unique id.
     */
    private String id;

    /**
     * The name of the organization.
     */
    private String name;

    /**
     * true is the organization is enabled, false otherwise.
     */
    private boolean enabled;

    /**
     * The number of the document, RUC number.
     */
    private String assignedIdentificationId;

    /**
     * The document type, DNI or RUC.
     */
    private String additionalAccountId;

    /**
     * Legal name of the organization, Razon social.
     */
    private String supplierName;

    /**
     * Registration name of the organization, Nombre comercial.
     */
    private String registrationName;

    /**
     * Postal address of the organization.
     */
    private PostalAddressRepresentation postalAddress;

    public OrganizationRepresentation() {

    }

    /**
     * @return The unique id.
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *            The organization id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return The name of the organization.
     */
    public String getName() {
        return name;
    }

    /**
     * @param id
     *            The organization name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return true is the organization is enabled, false otherwise.
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * @param enabled
     *            true or false
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * @return the number of the document, RUC number.
     */
    public String getAssignedIdentificationId() {
        return assignedIdentificationId;
    }

    /**
     * @param assignedIdentificationId
     *            The organization assignedIdentificationId
     */
    public void setAssignedIdentificationId(String assignedIdentificationId) {
        this.assignedIdentificationId = assignedIdentificationId;
    }

    /**
     * @return the document type, DNI or RUC.
     */
    public String getAdditionalAccountId() {
        return additionalAccountId;
    }

    /**
     * @param additionalAccountId
     *            The organization additionalAccountId
     */
    public void setAdditionalAccountId(String additionalAccountId) {
        this.additionalAccountId = additionalAccountId;
    }

    /**
     * @return legal name of the organization, Razon social.
     */
    public String getSupplierName() {
        return supplierName;
    }

    /**
     * @param supplierName
     *            The organization supplierName
     */
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    /**
     * @return registration name of the organization, Nombre comercial.
     */
    public String getRegistrationName() {
        return registrationName;
    }

    /**
     * @param registrationName
     *            The organization registrationName
     */
    public void setRegistrationName(String registrationName) {
        this.registrationName = registrationName;
    }

    /**
     * @return postal address of the organization.
     */
    public PostalAddressRepresentation getPostalAddress() {
        return postalAddress;
    }

    /**
     * @param postalAddress
     *            The organization postalAddress
     */
    public void setPostalAddress(PostalAddressRepresentation postalAddress) {
        this.postalAddress = postalAddress;
    }

}
