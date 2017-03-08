package org.openfact.models.jpa.entities;

import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "ORGANIZATION")
@NamedQueries({
        @NamedQuery(name = "getAllOrganizations", query = "select organization from OrganizationEntity organization"),
        @NamedQuery(name = "getAllOrganizationIds", query = "select organization.id from OrganizationEntity organization"),
        @NamedQuery(name = "getOrganizationByName", query = "select organization from OrganizationEntity organization where organization.name = :name"),
        @NamedQuery(name = "getOrganizationIdByName", query = "select organization.id from OrganizationEntity organization where organization.name = :name"),
        @NamedQuery(name = "getOrganizationsCount", query = "select count(organization.id) from OrganizationEntity organization"),
        @NamedQuery(name = "searchForOrganization", query = "select organization from OrganizationEntity organization where lower(organization.name) like :filterText or lower(organization.supplierName) like :filterText or lower(organization.registrationName) like :filterText")
})
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

    @Column(name = "POSTAL_ADRESS_ID")
    private String postalAddressId;

    @Column(name = "STREET_NAME")
    private String streetName;

    @Column(name = "CITY_SUBDIVISION_NAME")
    private String citySubdivisionName;

    @Column(name = "CITY_NAME")
    private String cityName;

    @Column(name = "COUNTRY_SUBENTITY")
    private String countrySubentity;

    @Column(name = "DISTRICT")
    private String district;

    @Column(name = "COUNTRY_IDENTIFICATION_CODE")
    private String countryIdentificationCode;

    @Column(name = "EVENTS_ENABLED")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean eventsEnabled;

    @Column(name = "EVENTS_EXPIRATION")
    private long eventsExpiration;

    @ElementCollection
    @Column(name = "VALUE")
    @CollectionTable(name = "ORGANIZATION_EVENTS_LISTENERS", joinColumns = {@JoinColumn(name = "ORGANIZATION_ID")})
    private Set<String> eventsListeners = new HashSet<>();

    @ElementCollection
    @Column(name = "VALUE")
    @CollectionTable(name = "ORGANIZATION_ENABLED_EVENT_TYPES", joinColumns = {@JoinColumn(name = "ORGANIZATION_ID")})
    private Set<String> enabledEventTypes = new HashSet<>();

    @Column(name = "ADMIN_EVENTS_ENABLED")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean adminEventsEnabled;

    @Column(name = "ADMIN_EVENTS_DETAILS_ENABLED")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean adminEventsDetailsEnabled;

    @Column(name = "EMAIL_THEME")
    private String emailTheme;

    @Column(name = "REPORT_THEME")
    private String reportTheme;

    @Column(name = "INTERNATIONALIZATION_ENABLED")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean internationalizationEnabled;

    @ElementCollection
    @Column(name = "VALUE")
    @CollectionTable(name = "ORGANIZATION_SUPPORTED_LOCALES", joinColumns = {@JoinColumn(name = "ORGANIZATION_ID")})
    private Set<String> supportedLocales = new HashSet<>();

    @Column(name = "DEFAULT_LOCALE")
    private String defaultLocale;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TASK_FIRST_TIME")
    private Date taskFirstTime;

    @Column(name = "TASK_DELAY")
    private long taskDelay;

    @Column(name = "TASK_ENABLED")
    private boolean tasksEnabled;

    @Column(name = "LOGO_FILE_ID")
    private String logoFileId;

    @ElementCollection
    @MapKeyColumn(name = "NAME")
    @Column(name = "VALUE")
    @CollectionTable(name = "ORGANIZATION_SMTP_CONFIG", joinColumns = {@JoinColumn(name = "ORGANIZATION_ID")})
    private Map<String, String> smtpConfig = new HashMap<>();

    @OneToMany(cascade = {CascadeType.REMOVE}, orphanRemoval = true, mappedBy = "organization")
    private Collection<OrganizationAttributeEntity> attributes = new ArrayList<>();

    @ElementCollection
    @Column(name = "VALUE")
    @CollectionTable(name = "ORGANIZATION_SUPPORTED_CURRENCIES", joinColumns = {@JoinColumn(name = "ORGANIZATION_ID")})
    private Set<String> supportedCurrencies = new HashSet<>();

    @Column(name = "DEFAULT_CURRENCY")
    private String defaultCurrency;

    @Type(type = "org.hibernate.type.LocalDateTimeType")
    @Column(name = "CREATED_TIMESTAMP")
    private LocalDateTime createdTimestamp;

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

    public LocalDateTime getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(LocalDateTime createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    /**
     * Postal address
     */
    public String getPostalAddressId() {
        return postalAddressId;
    }

    public void setPostalAddressId(String postalAddressId) {
        this.postalAddressId = postalAddressId;
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

    /**
     * Events
     */
    public boolean isEventsEnabled() {
        return eventsEnabled;
    }

    public void setEventsEnabled(boolean eventsEnabled) {
        this.eventsEnabled = eventsEnabled;
    }

    public long getEventsExpiration() {
        return eventsExpiration;
    }

    public void setEventsExpiration(long eventsExpiration) {
        this.eventsExpiration = eventsExpiration;
    }

    public Set<String> getEventsListeners() {
        return eventsListeners;
    }

    public void setEventsListeners(Set<String> eventsListeners) {
        this.eventsListeners = eventsListeners;
    }

    public Set<String> getEnabledEventTypes() {
        return enabledEventTypes;
    }

    public void setEnabledEventTypes(Set<String> enabledEventTypes) {
        this.enabledEventTypes = enabledEventTypes;
    }

    public boolean isAdminEventsEnabled() {
        return adminEventsEnabled;
    }

    public void setAdminEventsEnabled(boolean adminEventsEnabled) {
        this.adminEventsEnabled = adminEventsEnabled;
    }

    public boolean isAdminEventsDetailsEnabled() {
        return adminEventsDetailsEnabled;
    }

    public void setAdminEventsDetailsEnabled(boolean adminEventsDetailsEnabled) {
        this.adminEventsDetailsEnabled = adminEventsDetailsEnabled;
    }

    /**
     * Themes
     */
    public String getEmailTheme() {
        return emailTheme;
    }

    public void setEmailTheme(String emailTheme) {
        this.emailTheme = emailTheme;
    }

    public String getReportTheme() {
        return reportTheme;
    }

    public void setReportTheme(String reportTheme) {
        this.reportTheme = reportTheme;
    }

    /**
     * Locale
     */
    public boolean isInternationalizationEnabled() {
        return internationalizationEnabled;
    }

    public void setInternationalizationEnabled(boolean internationalizationEnabled) {
        this.internationalizationEnabled = internationalizationEnabled;
    }

    public Set<String> getSupportedLocales() {
        return supportedLocales;
    }

    public void setSupportedLocales(Set<String> supportedLocales) {
        this.supportedLocales = supportedLocales;
    }

    public String getDefaultLocale() {
        return defaultLocale;
    }

    public void setDefaultLocale(String defaultLocale) {
        this.defaultLocale = defaultLocale;
    }

    /**
     * Tasks
     */
    public Date getTaskFirstTime() {
        return taskFirstTime;
    }

    public void setTaskFirstTime(Date taskFirstTime) {
        this.taskFirstTime = taskFirstTime;
    }

    public long getTaskDelay() {
        return taskDelay;
    }

    public void setTaskDelay(long taskDelay) {
        this.taskDelay = taskDelay;
    }

    public boolean isTasksEnabled() {
        return tasksEnabled;
    }

    public void setTasksEnabled(boolean tasksEnabled) {
        this.tasksEnabled = tasksEnabled;
    }

    /**
     * Smtp
     */
    public Map<String, String> getSmtpConfig() {
        return smtpConfig;
    }

    public void setSmtpConfig(Map<String, String> smtpConfig) {
        this.smtpConfig = smtpConfig;
    }

    /**
     * Atributes
     */
    public Collection<OrganizationAttributeEntity> getAttributes() {
        return attributes;
    }

    public void setAttributes(Collection<OrganizationAttributeEntity> attributes) {
        this.attributes = attributes;
    }

    /**
     * Currencies
     */
    public Set<String> getSupportedCurrencies() {
        return supportedCurrencies;
    }

    public void setSupportedCurrencies(Set<String> supportedCurrencies) {
        this.supportedCurrencies = supportedCurrencies;
    }

    public String getDefaultCurrency() {
        return defaultCurrency;
    }

    public void setDefaultCurrency(String defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
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
        if (getId() == null) {
            if (other.getId() != null)
                return false;
        } else if (!getId().equals(other.getId()))
            return false;
        return true;
    }

    public String getLogoFileId() {
        return logoFileId;
    }

    public void setLogoFileId(String logoFileId) {
        this.logoFileId = logoFileId;
    }
}
