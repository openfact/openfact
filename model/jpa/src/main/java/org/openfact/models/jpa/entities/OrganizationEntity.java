package org.openfact.models.jpa.entities;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Type;
import org.openfact.models.jpa.entities.ubl.CreditNoteEntity;
import org.openfact.models.jpa.entities.ubl.DebitNoteEntity;
import org.openfact.models.jpa.entities.ubl.InvoiceEntity;

/**
 * @author carlosthe19916@sistcoop.com
 */

@Entity
@Table(name = "ORGANIZATION")
@NamedQueries({
        @NamedQuery(name = "getAllOrganizationIds", query = "select organization.id from OrganizationEntity organization"),
        @NamedQuery(name = "getOrganizationIdByName", query = "select organization.id from OrganizationEntity organization where organization.name = :name"),
        @NamedQuery(name = "getOrganizationsCount", query = "select count(organization.id) from OrganizationEntity organization") })
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
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean enabled;

    @Column(name = "ASSIGNED_IDENTIFICATION_ID")
    private String assignedIdentificationId;

    @Column(name = "ADDITIONAL_ACCOUNT_ID")
    private String additionalAccountId;

    @Column(name = "SUPPLIER_NAME")
    private String supplierName;

    @Column(name = "REGISTRATION_NAME")
    private String registrationName;

    /**
     * Certificate
     */
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
    @Column(name = "POSTAL_ADRESS_ID")
    protected String postalAddressId;

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
     * Events
     */
    @Column(name = "EVENTS_ENABLED")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    protected boolean eventsEnabled;

    @Column(name = "EVENTS_EXPIRATION")
    protected long eventsExpiration;

    @ElementCollection
    @Column(name = "VALUE")
    @CollectionTable(name = "ORGANIZATION_EVENTS_LISTENERS", joinColumns = {
            @JoinColumn(name = "ORGANIZATION_ID") })
    protected Set<String> eventsListeners = new HashSet<String>();

    @ElementCollection
    @Column(name = "VALUE")
    @CollectionTable(name = "ORGANIZATION_ENABLED_EVENT_TYPES", joinColumns = {
            @JoinColumn(name = "ORGANIZATION_ID") })
    protected Set<String> enabledEventTypes = new HashSet<String>();

    @Column(name = "ADMIN_EVENTS_ENABLED")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    protected boolean adminEventsEnabled;

    @Column(name = "ADMIN_EVENTS_DETAILS_ENABLED")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    protected boolean adminEventsDetailsEnabled;

    /**
     * Themes
     */
    @Column(name = "LOGIN_THEME")
    protected String loginTheme;

    @Column(name = "ACCOUNT_THEME")
    protected String accountTheme;

    @Column(name = "ADMIN_THEME")
    protected String adminTheme;

    @Column(name = "EMAIL_THEME")
    protected String emailTheme;

    /**
     * Locale
     */
    @Column(name = "INTERNATIONALIZATION_ENABLED")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    protected boolean internationalizationEnabled;

    @ElementCollection
    @Column(name = "VALUE")
    @CollectionTable(name = "ORGANIZATION_SUPPORTED_LOCALES", joinColumns = {
            @JoinColumn(name = "ORGANIZATION_ID") })
    protected Set<String> supportedLocales = new HashSet<String>();

    @Column(name = "DEFAULT_LOCALE")
    protected String defaultLocale;

    /**
     * Locale for taxs
     */
    @Column(name = "INTERNATIONALIZATION_UBL_ENABLED")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    protected boolean internationalizationUblEnabled;

    @ElementCollection
    @Column(name = "VALUE")
    @CollectionTable(name = "ORGANIZATION_SUPPORTED_UBL_LOCALES", joinColumns = {
            @JoinColumn(name = "ORGANIZATION_ID") })
    protected Set<String> supportedUblLocales = new HashSet<String>();

    @Column(name = "DEFAULT_UBL_LOCALE")
    protected String defaultUblLocale;

    /**
     * Tasks
     */
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
    @Type(type = "org.hibernate.type.LocalTimeType")
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
    @CollectionTable(name = "ORGANIZATION_SMTP_CONFIG", joinColumns = {
            @JoinColumn(name = "ORGANIZATION_ID") })
    private Map<String, String> smtpConfig = new HashMap<String, String>();

    /**
     * Atributes
     */
    @ElementCollection
    @MapKeyColumn(name = "NAME")
    @Column(name = "VALUE", length = 2048)
    @CollectionTable(name = "ORGANIZATION_ATTRIBUTES", joinColumns = {
            @JoinColumn(name = "ORGANIZATION_ID") })
    protected Map<String, String> attributes = new HashMap<String, String>();

    /**
     * Currencies
     */
    @OneToMany(mappedBy = "organization", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<CurrencyEntity> currencies = new HashSet<>();

    /** Required actions */
    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true, mappedBy = "organization")
    protected Collection<OrganizationRequiredActionEntity> requiredActions = new ArrayList<>();

    /**
     * Cascade relations
     */
    @OneToMany(mappedBy = "organization", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<InvoiceEntity> invoices = new ArrayList<>();
    @OneToMany(mappedBy = "organization", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<CreditNoteEntity> creditNotes = new ArrayList<>();
    @OneToMany(mappedBy = "organization", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<DebitNoteEntity> debitNotes = new ArrayList<>();

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
     * @return the postalAddressId
     */
    public String getPostalAddressId() {
        return postalAddressId;
    }

    /**
     * @param postalAddressId
     *            the postalAddressId to set
     */
    public void setPostalAddressId(String postalAddressId) {
        this.postalAddressId = postalAddressId;
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
     * @return the eventsEnabled
     */
    public boolean isEventsEnabled() {
        return eventsEnabled;
    }

    /**
     * @param eventsEnabled
     *            the eventsEnabled to set
     */
    public void setEventsEnabled(boolean eventsEnabled) {
        this.eventsEnabled = eventsEnabled;
    }

    /**
     * @return the eventsExpiration
     */
    public long getEventsExpiration() {
        return eventsExpiration;
    }

    /**
     * @param eventsExpiration
     *            the eventsExpiration to set
     */
    public void setEventsExpiration(long eventsExpiration) {
        this.eventsExpiration = eventsExpiration;
    }

    /**
     * @return the eventsListeners
     */
    public Set<String> getEventsListeners() {
        return eventsListeners;
    }

    /**
     * @param eventsListeners
     *            the eventsListeners to set
     */
    public void setEventsListeners(Set<String> eventsListeners) {
        this.eventsListeners = eventsListeners;
    }

    /**
     * @return the enabledEventTypes
     */
    public Set<String> getEnabledEventTypes() {
        return enabledEventTypes;
    }

    /**
     * @param enabledEventTypes
     *            the enabledEventTypes to set
     */
    public void setEnabledEventTypes(Set<String> enabledEventTypes) {
        this.enabledEventTypes = enabledEventTypes;
    }

    /**
     * @return the adminEventsEnabled
     */
    public boolean isAdminEventsEnabled() {
        return adminEventsEnabled;
    }

    /**
     * @param adminEventsEnabled
     *            the adminEventsEnabled to set
     */
    public void setAdminEventsEnabled(boolean adminEventsEnabled) {
        this.adminEventsEnabled = adminEventsEnabled;
    }

    /**
     * @return the adminEventsDetailsEnabled
     */
    public boolean isAdminEventsDetailsEnabled() {
        return adminEventsDetailsEnabled;
    }

    /**
     * @param adminEventsDetailsEnabled
     *            the adminEventsDetailsEnabled to set
     */
    public void setAdminEventsDetailsEnabled(boolean adminEventsDetailsEnabled) {
        this.adminEventsDetailsEnabled = adminEventsDetailsEnabled;
    }

    /**
     * @return the loginTheme
     */
    public String getLoginTheme() {
        return loginTheme;
    }

    /**
     * @param loginTheme
     *            the loginTheme to set
     */
    public void setLoginTheme(String loginTheme) {
        this.loginTheme = loginTheme;
    }

    /**
     * @return the accountTheme
     */
    public String getAccountTheme() {
        return accountTheme;
    }

    /**
     * @param accountTheme
     *            the accountTheme to set
     */
    public void setAccountTheme(String accountTheme) {
        this.accountTheme = accountTheme;
    }

    /**
     * @return the adminTheme
     */
    public String getAdminTheme() {
        return adminTheme;
    }

    /**
     * @param adminTheme
     *            the adminTheme to set
     */
    public void setAdminTheme(String adminTheme) {
        this.adminTheme = adminTheme;
    }

    /**
     * @return the emailTheme
     */
    public String getEmailTheme() {
        return emailTheme;
    }

    /**
     * @param emailTheme
     *            the emailTheme to set
     */
    public void setEmailTheme(String emailTheme) {
        this.emailTheme = emailTheme;
    }

    /**
     * @return the internationalizationEnabled
     */
    public boolean isInternationalizationEnabled() {
        return internationalizationEnabled;
    }

    /**
     * @param internationalizationEnabled
     *            the internationalizationEnabled to set
     */
    public void setInternationalizationEnabled(boolean internationalizationEnabled) {
        this.internationalizationEnabled = internationalizationEnabled;
    }

    /**
     * @return the supportedLocales
     */
    public Set<String> getSupportedLocales() {
        return supportedLocales;
    }

    /**
     * @param supportedLocales
     *            the supportedLocales to set
     */
    public void setSupportedLocales(Set<String> supportedLocales) {
        this.supportedLocales = supportedLocales;
    }

    /**
     * @return the defaultLocale
     */
    public String getDefaultLocale() {
        return defaultLocale;
    }

    /**
     * @param defaultLocale
     *            the defaultLocale to set
     */
    public void setDefaultLocale(String defaultLocale) {
        this.defaultLocale = defaultLocale;
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
     * @return the requiredActions
     */
    public Collection<OrganizationRequiredActionEntity> getRequiredActions() {
        return requiredActions;
    }

    /**
     * @param requiredActions
     *            the requiredActions to set
     */
    public void setRequiredActions(Collection<OrganizationRequiredActionEntity> requiredActions) {
        this.requiredActions = requiredActions;
    }

    /**
     * @return the internationalizationUblEnabled
     */
    public boolean isInternationalizationUblEnabled() {
        return internationalizationUblEnabled;
    }

    /**
     * @param internationalizationUblEnabled
     *            the internationalizationUblEnabled to set
     */
    public void setInternationalizationUblEnabled(boolean internationalizationUblEnabled) {
        this.internationalizationUblEnabled = internationalizationUblEnabled;
    }

    /**
     * @return the supportedUblLocales
     */
    public Set<String> getSupportedUblLocales() {
        return supportedUblLocales;
    }

    /**
     * @param supportedUblLocales
     *            the supportedUblLocales to set
     */
    public void setSupportedUblLocales(Set<String> supportedUblLocales) {
        this.supportedUblLocales = supportedUblLocales;
    }

    /**
     * @return the defaultUblLocale
     */
    public String getDefaultUblLocale() {
        return defaultUblLocale;
    }

    /**
     * @param defaultUblLocale
     *            the defaultUblLocale to set
     */
    public void setDefaultUblLocale(String defaultUblLocale) {
        this.defaultUblLocale = defaultUblLocale;
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
     * @return the creditNotes
     */
    public List<CreditNoteEntity> getCreditNotes() {
        return creditNotes;
    }

    /**
     * @param creditNotes
     *            the creditNotes to set
     */
    public void setCreditNotes(List<CreditNoteEntity> creditNotes) {
        this.creditNotes = creditNotes;
    }

    /**
     * @return the debitNotes
     */
    public List<DebitNoteEntity> getDebitNotes() {
        return debitNotes;
    }

    /**
     * @param debitNotes
     *            the debitNotes to set
     */
    public void setDebitNotes(List<DebitNoteEntity> debitNotes) {
        this.debitNotes = debitNotes;
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
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
