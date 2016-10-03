package org.openfact.representations.idm;

import java.util.List;
import java.util.Map;

import org.openfact.representations.idm.ubl.CreditNoteRepresentation;
import org.openfact.representations.idm.ubl.DebitNoteRepresentation;
import org.openfact.representations.idm.ubl.InvoiceRepresentation;

public class OrganizationRepresentation {

    private String id;
    private String organization;
    private String description;
    private Boolean enabled;

    private String assignedIdentificationId;
    private String additionalAccountId;
    private String supplierName;
    private String registrationName;

//    protected String privateKey;
//    protected String publicKey;
//    protected String certificate;
//    protected String codeSecret;

    protected Map<String, String> smtpServer;
    private CertificateRepresentation certificate;
    private PostalAddressRepresentation postalAddress;
    private TasksScheduleRepresentation tasksSchedule;
    protected Map<String, String> attributes;

    protected List<InvoiceRepresentation> invoices;
    protected List<CreditNoteRepresentation> creditNotes;
    protected List<DebitNoteRepresentation> debitNotes;

    protected String openfactVersion;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the organization
     */
    public String getOrganization() {
        return organization;
    }

    /**
     * @param organization
     *            the organization to set
     */
    public void setOrganization(String organization) {
        this.organization = organization;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the enabled
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * @param enabled
     *            the enabled to set
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * @return the assignedIdentificationId
     */
    public String getAssignedIdentificationId() {
        return assignedIdentificationId;
    }

    /**
     * @param assignedIdentificationId
     *            the assignedIdentificationId to set
     */
    public void setAssignedIdentificationId(String assignedIdentificationId) {
        this.assignedIdentificationId = assignedIdentificationId;
    }

    /**
     * @return the additionalAccountId
     */
    public String getAdditionalAccountId() {
        return additionalAccountId;
    }

    /**
     * @param additionalAccountId
     *            the additionalAccountId to set
     */
    public void setAdditionalAccountId(String additionalAccountId) {
        this.additionalAccountId = additionalAccountId;
    }

    /**
     * @return the supplierName
     */
    public String getSupplierName() {
        return supplierName;
    }

    /**
     * @param supplierName
     *            the supplierName to set
     */
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    /**
     * @return the registrationName
     */
    public String getRegistrationName() {
        return registrationName;
    }

    /**
     * @param registrationName
     *            the registrationName to set
     */
    public void setRegistrationName(String registrationName) {
        this.registrationName = registrationName;
    }

   

    /**
     * @return the smtpServer
     */
    public Map<String, String> getSmtpServer() {
        return smtpServer;
    }

    /**
     * @param smtpServer
     *            the smtpServer to set
     */
    public void setSmtpServer(Map<String, String> smtpServer) {
        this.smtpServer = smtpServer;
    }

    /**
     * @return the postalAddress
     */
    public PostalAddressRepresentation getPostalAddress() {
        return postalAddress;
    }

    /**
     * @param postalAddress
     *            the postalAddress to set
     */
    public void setPostalAddress(PostalAddressRepresentation postalAddress) {
        this.postalAddress = postalAddress;
    }

    /**
     * @return the tasksSchedule
     */
    public TasksScheduleRepresentation getTasksSchedule() {
        return tasksSchedule;
    }

    /**
     * @param tasksSchedule
     *            the tasksSchedule to set
     */
    public void setTasksSchedule(TasksScheduleRepresentation tasksSchedule) {
        this.tasksSchedule = tasksSchedule;
    }

    /**
     * @return the attributes
     */
    public Map<String, String> getAttributes() {
        return attributes;
    }

    /**
     * @param attributes
     *            the attributes to set
     */
    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    /**
     * @return the invoices
     */
    public List<InvoiceRepresentation> getInvoices() {
        return invoices;
    }

    /**
     * @param invoices
     *            the invoices to set
     */
    public void setInvoices(List<InvoiceRepresentation> invoices) {
        this.invoices = invoices;
    }

    /**
     * @return the creditNotes
     */
    public List<CreditNoteRepresentation> getCreditNotes() {
        return creditNotes;
    }

    /**
     * @param creditNotes
     *            the creditNotes to set
     */
    public void setCreditNotes(List<CreditNoteRepresentation> creditNotes) {
        this.creditNotes = creditNotes;
    }

    /**
     * @return the debitNotes
     */
    public List<DebitNoteRepresentation> getDebitNotes() {
        return debitNotes;
    }

    /**
     * @param debitNotes
     *            the debitNotes to set
     */
    public void setDebitNotes(List<DebitNoteRepresentation> debitNotes) {
        this.debitNotes = debitNotes;
    }

    /**
     * @return the openfactVersion
     */
    public String getOpenfactVersion() {
        return openfactVersion;
    }

    /**
     * @param openfactVersion
     *            the openfactVersion to set
     */
    public void setOpenfactVersion(String openfactVersion) {
        this.openfactVersion = openfactVersion;
    }

	public CertificateRepresentation getCertificate() {
		return certificate;
	}

	public void setCertificate(CertificateRepresentation certificate) {
		this.certificate = certificate;
	}
    

}
