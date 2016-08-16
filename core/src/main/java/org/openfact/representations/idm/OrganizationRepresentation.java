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
     * The description of the organization.
     */
    private String description;
    
    /**
     * true is the organization is enabled, false otherwise.
     */
    private Boolean enabled;

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

    private TasksScheduleRepresentation tasksSchedule;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
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

    public TasksScheduleRepresentation getTasksSchedule() {
        return tasksSchedule;
    }

    public void setTasksSchedule(TasksScheduleRepresentation tasksSchedule) {
        this.tasksSchedule = tasksSchedule;
    }

}
