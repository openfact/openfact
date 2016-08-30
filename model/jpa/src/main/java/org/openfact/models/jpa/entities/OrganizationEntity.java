package org.openfact.models.jpa.entities;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

/**
 * @author carlosthe19916@sistcoop.com
 */

@Entity
@Table(name = "ORGANIZATION")
@NamedQueries({
		@NamedQuery(name = "getAllOrganizationIds", query = "select organization.id from OrganizationEntity organization"),
		@NamedQuery(name = "getOrganizationIdByName", query = "select organization.id from OrganizationEntity organization where organization.name = :name"), })
public class OrganizationEntity {

	@Id
	@Column(name = "ID", length = 36)
	@Access(AccessType.PROPERTY)
	private String id;

	@NaturalId(mutable = true)
	@Column(name = "NAME", unique = true)
	private String name;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "ENABLED")
	private boolean enabled;

	@Column(name = "ASSIGNED_IDENTIFICATION_ID")
	private String assignedIdentificationId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey, name = "ADDITIONAL_ACCOUNT_ID")
	private SimpleDocumentEntity additionalAccountId;

	@Column(name = "SUPPLIER_NAME")
	private String supplierName;

	@Column(name = "REGISTRATION_NAME")
	private String registrationName;

	/**
	 * Certificate
	 */
	@Column(name = "USER_ACTION_LIFESPAN")
	protected int accessCodeLifespanUserAction;

	@Column(name = "PUBLIC_KEY", length = 4000)
	protected String publicKeyPem;

	@Column(name = "PRIVATE_KEY", length = 4000)
	protected String privateKeyPem;

	@Column(name = "CERTIFICATE", length = 4000)
	protected String certificatePem;

	@Column(name = "CODE_SECRET", length = 255)
	protected String codeSecret;

	/**
	 * Postal address
	 */
	@Column(name = "STREET_NAME")
	protected String streetName;

	@Column(name = "CITY_SUBDIVISION_NAME")
	protected String citySubdivisionName;

	@Column(name = "CITY_NAME")
	protected String cityName;

	@Column(name = "COUNTRY_SUBENTITY")
	protected String countrySubentity;

	@Column(name = "DISTRICT")
	protected String district;

	@Column(name = "COUNTRY_IDENTIFICATION_CODE")
	protected String countryIdentificationCode;

	/**
	 * Tasks
	 */
	@Column(name = "MAX_INVOICE_NUMBER")
	protected int maxInvoiceNumber;

	@Column(name = "ATTEMP_NUMBER")
	protected int attempNumber;

	@Column(name = "LAPSE_TIME")
	protected long lapseTime;

	@Column(name = "ON_ERROR_ATTEMP_NUMBER")
	protected int onErrorAttempNumber;

	@Column(name = "ON_ERROR_LAPSE_TIME")
	protected long onErrorLapseTime;

	@Column(name = "DELAY_TIME")
	protected long delayTime;

	@Column(name = "SUBMIT_TIME")
	protected LocalTime submitTime;

	@ElementCollection
	@Column(name = "VALUE")
	@CollectionTable(name = "SUBMIT_DAY", joinColumns = { @JoinColumn(name = "SUBMIT_DAY_ID") })
	private Set<DayOfWeek> submitDays = new HashSet<DayOfWeek>();

	/**
	 * Smtp
	 */
	@ElementCollection
	@MapKeyColumn(name = "NAME")
	@Column(name = "VALUE")
	@CollectionTable(name = "ORGANIZATION_SMTP_CONFIG", joinColumns = { @JoinColumn(name = "ORGANIZATION_ID") })
	private Map<String, String> smtpConfig = new HashMap<String, String>();

	/**
	 * Collections
	 */
	@OneToMany(mappedBy = "organization", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, orphanRemoval = true)
	private Set<CurrencyEntity> currencies = new HashSet<>();

	@OneToMany(mappedBy = "organization", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, orphanRemoval = true)
	private Set<DocumentEntity> documents = new HashSet<>();

	@OneToMany(mappedBy = "organization", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<CertifiedEntity> certifieds = new ArrayList<>();

	@OneToMany(mappedBy = "organization", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<InvoiceEntity> invoices = new ArrayList<>();

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @param enabled
	 *            the enabled to set
	 */
	public void setEnabled(boolean enabled) {
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
	public SimpleDocumentEntity getAdditionalAccountId() {
		return additionalAccountId;
	}

	/**
	 * @param additionalAccountId
	 *            the additionalAccountId to set
	 */
	public void setAdditionalAccountId(SimpleDocumentEntity additionalAccountId) {
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
	 * @return the accessCodeLifespanUserAction
	 */
	public int getAccessCodeLifespanUserAction() {
		return accessCodeLifespanUserAction;
	}

	/**
	 * @param accessCodeLifespanUserAction
	 *            the accessCodeLifespanUserAction to set
	 */
	public void setAccessCodeLifespanUserAction(int accessCodeLifespanUserAction) {
		this.accessCodeLifespanUserAction = accessCodeLifespanUserAction;
	}

	/**
	 * @return the publicKeyPem
	 */
	public String getPublicKeyPem() {
		return publicKeyPem;
	}

	/**
	 * @param publicKeyPem
	 *            the publicKeyPem to set
	 */
	public void setPublicKeyPem(String publicKeyPem) {
		this.publicKeyPem = publicKeyPem;
	}

	/**
	 * @return the privateKeyPem
	 */
	public String getPrivateKeyPem() {
		return privateKeyPem;
	}

	/**
	 * @param privateKeyPem
	 *            the privateKeyPem to set
	 */
	public void setPrivateKeyPem(String privateKeyPem) {
		this.privateKeyPem = privateKeyPem;
	}

	/**
	 * @return the certificatePem
	 */
	public String getCertificatePem() {
		return certificatePem;
	}

	/**
	 * @param certificatePem
	 *            the certificatePem to set
	 */
	public void setCertificatePem(String certificatePem) {
		this.certificatePem = certificatePem;
	}

	/**
	 * @return the codeSecret
	 */
	public String getCodeSecret() {
		return codeSecret;
	}

	/**
	 * @param codeSecret
	 *            the codeSecret to set
	 */
	public void setCodeSecret(String codeSecret) {
		this.codeSecret = codeSecret;
	}

	/**
	 * @return the streetName
	 */
	public String getStreetName() {
		return streetName;
	}

	/**
	 * @param streetName
	 *            the streetName to set
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	/**
	 * @return the citySubdivisionName
	 */
	public String getCitySubdivisionName() {
		return citySubdivisionName;
	}

	/**
	 * @param citySubdivisionName
	 *            the citySubdivisionName to set
	 */
	public void setCitySubdivisionName(String citySubdivisionName) {
		this.citySubdivisionName = citySubdivisionName;
	}

	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * @param cityName
	 *            the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	/**
	 * @return the countrySubentity
	 */
	public String getCountrySubentity() {
		return countrySubentity;
	}

	/**
	 * @param countrySubentity
	 *            the countrySubentity to set
	 */
	public void setCountrySubentity(String countrySubentity) {
		this.countrySubentity = countrySubentity;
	}

	/**
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}

	/**
	 * @param district
	 *            the district to set
	 */
	public void setDistrict(String district) {
		this.district = district;
	}

	/**
	 * @return the countryIdentificationCode
	 */
	public String getCountryIdentificationCode() {
		return countryIdentificationCode;
	}

	/**
	 * @param countryIdentificationCode
	 *            the countryIdentificationCode to set
	 */
	public void setCountryIdentificationCode(String countryIdentificationCode) {
		this.countryIdentificationCode = countryIdentificationCode;
	}

	/**
	 * @return the attempNumber
	 */
	public int getAttempNumber() {
		return attempNumber;
	}

	/**
	 * @param attempNumber
	 *            the attempNumber to set
	 */
	public void setAttempNumber(int attempNumber) {
		this.attempNumber = attempNumber;
	}

	/**
	 * @return the lapseTime
	 */
	public long getLapseTime() {
		return lapseTime;
	}

	/**
	 * @param lapseTime
	 *            the lapseTime to set
	 */
	public void setLapseTime(long lapseTime) {
		this.lapseTime = lapseTime;
	}

	/**
	 * @return the onErrorAttempNumber
	 */
	public int getOnErrorAttempNumber() {
		return onErrorAttempNumber;
	}

	/**
	 * @param onErrorAttempNumber
	 *            the onErrorAttempNumber to set
	 */
	public void setOnErrorAttempNumber(int onErrorAttempNumber) {
		this.onErrorAttempNumber = onErrorAttempNumber;
	}

	/**
	 * @return the onErrorLapseTime
	 */
	public long getOnErrorLapseTime() {
		return onErrorLapseTime;
	}

	/**
	 * @param onErrorLapseTime
	 *            the onErrorLapseTime to set
	 */
	public void setOnErrorLapseTime(long onErrorLapseTime) {
		this.onErrorLapseTime = onErrorLapseTime;
	}

	/**
	 * @return the delayTime
	 */
	public long getDelayTime() {
		return delayTime;
	}

	/**
	 * @param delayTime
	 *            the delayTime to set
	 */
	public void setDelayTime(long delayTime) {
		this.delayTime = delayTime;
	}

	/**
	 * @return the submitTime
	 */
	public LocalTime getSubmitTime() {
		return submitTime;
	}

	/**
	 * @param submitTime
	 *            the submitTime to set
	 */
	public void setSubmitTime(LocalTime submitTime) {
		this.submitTime = submitTime;
	}

	/**
	 * @return the submitDays
	 */
	public Set<DayOfWeek> getSubmitDays() {
		return submitDays;
	}

	/**
	 * @param submitDays
	 *            the submitDays to set
	 */
	public void setSubmitDays(Set<DayOfWeek> submitDays) {
		this.submitDays = submitDays;
	}

	/**
	 * @return the currencies
	 */
	public Set<CurrencyEntity> getCurrencies() {
		return currencies;
	}

	/**
	 * @param currencies
	 *            the currencies to set
	 */
	public void setCurrencies(Set<CurrencyEntity> currencies) {
		this.currencies = currencies;
	}

	/**
	 * @return the documents
	 */
	public Set<DocumentEntity> getDocuments() {
		return documents;
	}

	/**
	 * @param documents
	 *            the documents to set
	 */
	public void setDocuments(Set<DocumentEntity> documents) {
		this.documents = documents;
	}

	/**
	 * @return the certifieds
	 */
	public List<CertifiedEntity> getCertifieds() {
		return certifieds;
	}

	/**
	 * @param certifieds
	 *            the certifieds to set
	 */
	public void setCertifieds(List<CertifiedEntity> certifieds) {
		this.certifieds = certifieds;
	}

	/**
	 * @return the invoices
	 */
	public List<InvoiceEntity> getInvoices() {
		return invoices;
	}

	/**
	 * @param invoices
	 *            the invoices to set
	 */
	public void setInvoices(List<InvoiceEntity> invoices) {
		this.invoices = invoices;
	}

	/**
	 * @return the smtpConfig
	 */
	public Map<String, String> getSmtpConfig() {
		return smtpConfig;
	}

	/**
	 * @param smtpConfig
	 *            the smtpConfig to set
	 */
	public void setSmtpConfig(Map<String, String> smtpConfig) {
		this.smtpConfig = smtpConfig;
	}

	/**
	 * @return the maxInvoiceNumber
	 */
	public int getMaxInvoiceNumber() {
		return maxInvoiceNumber;
	}

	/**
	 * @param maxInvoiceNumber
	 *            the maxInvoiceNumber to set
	 */
	public void setMaxInvoiceNumber(int maxInvoiceNumber) {
		this.maxInvoiceNumber = maxInvoiceNumber;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrganizationEntity other = (OrganizationEntity) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
