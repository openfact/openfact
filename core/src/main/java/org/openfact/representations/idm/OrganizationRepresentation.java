package org.openfact.representations.idm;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class OrganizationRepresentation {

	private String id;
	private String name;
	private String description;
	private Boolean enabled;

	private String assignedIdentificationId;
	private String additionalAccountId;
	private String supplierName;
	private String registrationName;	
	private CertificateRepresentation certificate;
	protected Map<String, String> smtpServer;
	private PostalAddressRepresentation postalAddress;
	private TasksScheduleRepresentation tasksSchedule;
	private Set<CurrencyRepresentation> currencies;
	private Set<DocumentRepresentation> documents;
	protected List<InvoiceRepresentation> invoices;
	protected Map<String, String> attributes;

	protected String openfactVersion;
	
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
	
	public Map<String, String> getSmtpServer() {
		return smtpServer;
	}

	public void setSmtpServer(Map<String, String> smtpServer) {
		this.smtpServer = smtpServer;
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

	public Set<CurrencyRepresentation> getCurrencies() {
		return currencies;
	}

	public void setCurrencies(Set<CurrencyRepresentation> currencies) {
		this.currencies = currencies;
	}

	public Set<DocumentRepresentation> getDocuments() {
		return documents;
	}

	public void setDocuments(Set<DocumentRepresentation> documents) {
		this.documents = documents;
	}

	public List<InvoiceRepresentation> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<InvoiceRepresentation> invoices) {
		this.invoices = invoices;
	}

	public Map<String, String> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}

	public CertificateRepresentation getCertificate() {
		return certificate;
	}

	public void setCertificate(CertificateRepresentation certificate) {
		this.certificate = certificate;
	}

    /**
     * @return the openfactVersion
     */
    public String getOpenfactVersion() {
        return openfactVersion;
    }

    /**
     * @param openfactVersion the openfactVersion to set
     */
    public void setOpenfactVersion(String openfactVersion) {
        this.openfactVersion = openfactVersion;
    }

}
