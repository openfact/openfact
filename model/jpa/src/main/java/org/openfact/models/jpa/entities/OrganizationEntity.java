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
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
     * Certificate*/
    @Column(name="USER_ACTION_LIFESPAN")
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
     * Postal address*/
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
     * Tasks*/
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

    /**
     * Collections*/
    @ElementCollection
    @Column(name = "VALUE")
    @CollectionTable(name = "SUBMIT_DAY", joinColumns = { @JoinColumn(name = "SUBMIT_DAY_ID") })
    private Set<DayOfWeek> submitDays = new HashSet<DayOfWeek>();

    @OneToMany(mappedBy = "organization", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<CurrencyEntity> currencies = new HashSet<>();

    @OneToMany(mappedBy = "organization", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<DocumentEntity> documents = new HashSet<>();

    @OneToMany(mappedBy = "organization", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<CertifiedEntity> certifieds = new ArrayList<>();

    @OneToMany(mappedBy = "organization", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<InvoiceEntity> invoices = new ArrayList<>();

    @ElementCollection
    @MapKeyColumn(name = "NAME")
    @Column(name = "VALUE")
    @CollectionTable(name = "ORGANIZATION_SMTP_CONFIG", joinColumns = {
            @JoinColumn(name = "ORGANIZATION_ID") })
    private Map<String, String> smtpConfig = new HashMap<String, String>();

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

    public SimpleDocumentEntity getAdditionalAccountId() {
        return additionalAccountId;
    }

    public void setAdditionalAccountId(SimpleDocumentEntity additionalAccountId) {
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

    public Set<CurrencyEntity> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(Set<CurrencyEntity> currencies) {
        this.currencies = currencies;
    }

    public Set<DocumentEntity> getDocuments() {
        return documents;
    }

    public void setDocuments(Set<DocumentEntity> documents) {
        this.documents = documents;
    }

    public List<CertifiedEntity> getCertifieds() {
        return certifieds;
    }

    public void setCertifieds(List<CertifiedEntity> certifieds) {
        this.certifieds = certifieds;
    }

    public List<InvoiceEntity> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<InvoiceEntity> invoices) {
        this.invoices = invoices;
    }

    public Map<String, String> getSmtpConfig() {
        return smtpConfig;
    }

    public void setSmtpConfig(Map<String, String> smtpConfig) {
        this.smtpConfig = smtpConfig;
    }   

    public int getAccessCodeLifespanUserAction() {
        return accessCodeLifespanUserAction;
    }

    public void setAccessCodeLifespanUserAction(int accessCodeLifespanUserAction) {
        this.accessCodeLifespanUserAction = accessCodeLifespanUserAction;
    }

    public String getPublicKeyPem() {
        return publicKeyPem;
    }

    public void setPublicKeyPem(String publicKeyPem) {
        this.publicKeyPem = publicKeyPem;
    }

    public String getPrivateKeyPem() {
        return privateKeyPem;
    }

    public void setPrivateKeyPem(String privateKeyPem) {
        this.privateKeyPem = privateKeyPem;
    }

    public String getCertificatePem() {
        return certificatePem;
    }

    public void setCertificatePem(String certificatePem) {
        this.certificatePem = certificatePem;
    }

    public String getCodeSecret() {
        return codeSecret;
    }

    public void setCodeSecret(String codeSecret) {
        this.codeSecret = codeSecret;
    }

    public int getAttempNumber() {
        return attempNumber;
    }

    public void setAttempNumber(int attempNumber) {
        this.attempNumber = attempNumber;
    }

    public long getLapseTime() {
        return lapseTime;
    }

    public void setLapseTime(long lapseTime) {
        this.lapseTime = lapseTime;
    }

    public int getOnErrorAttempNumber() {
        return onErrorAttempNumber;
    }

    public void setOnErrorAttempNumber(int onErrorAttempNumber) {
        this.onErrorAttempNumber = onErrorAttempNumber;
    }

    public long getOnErrorLapseTime() {
        return onErrorLapseTime;
    }

    public void setOnErrorLapseTime(long onErrorLapseTime) {
        this.onErrorLapseTime = onErrorLapseTime;
    }

    public long getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(long delayTime) {
        this.delayTime = delayTime;
    }

    public LocalTime getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(LocalTime submitTime) {
        this.submitTime = submitTime;
    }

    public Set<DayOfWeek> getSubmitDays() {
        return submitDays;
    }

    public void setSubmitDays(Set<DayOfWeek> submitDays) {
        this.submitDays = submitDays;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCitySubdivisionName() {
        return citySubdivisionName;
    }

    public void setCitySubdivisionName(String citySubdivisionName) {
        this.citySubdivisionName = citySubdivisionName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountrySubentity() {
        return countrySubentity;
    }

    public void setCountrySubentity(String countrySubentity) {
        this.countrySubentity = countrySubentity;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCountryIdentificationCode() {
        return countryIdentificationCode;
    }

    public void setCountryIdentificationCode(String countryIdentificationCode) {
        this.countryIdentificationCode = countryIdentificationCode;
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
