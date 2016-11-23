/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.openfact.models.jpa.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Type;

/**
 * @author carlosthe19916@sistcoop.com
 */

@Entity
@Table(name = "ORGANIZATION")
@NamedQueries({
        @NamedQuery(name = "getAllOrganizationIds", query = "select organization.id from OrganizationEntity organization"),
        @NamedQuery(name = "getOrganizationIdByName", query = "select organization.id from OrganizationEntity organization where organization.name = :name"),
        @NamedQuery(name = "getOrganizationsCount", query = "select count(organization.id) from OrganizationEntity organization"),
        @NamedQuery(name = "searchForOrganization", query = "select organization from OrganizationEntity organization where lower(organization.name) like :filterText or lower(organization.supplierName) like :filterText or lower(organization.registrationName) like :filterText") })
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

    @Type(type = "org.hibernate.type.LocalDateTimeType")
    @Column(name = "CREATED_TIMESTAMP")
    private LocalDateTime createdTimestamp;

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
    
    @Column(name = "REPORT_THEME")
    protected String reportTheme;

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
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TASK_FIRST_TIME")
    protected Date taskFirstTime;

    @Column(name = "TASK_DELAY")
    protected long taskDelay;

    @Column(name = "TASK_ENABLED")
    protected boolean tasksEnabled;

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
     * Ubl sender config
     */
    @ElementCollection
    @MapKeyColumn(name = "NAME")
    @Column(name = "VALUE")
    @CollectionTable(name = "ORGANIZATION_UBLSENDER_CONFIG", joinColumns = {
            @JoinColumn(name = "ORGANIZATION_ID") })
    private Map<String, String> ublSenderConfig = new HashMap<String, String>();

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
    @ElementCollection
    @Column(name = "VALUE")
    @CollectionTable(name = "ORGANIZATION_SUPPORTED_CURRENCIES", joinColumns = {
            @JoinColumn(name = "ORGANIZATION_ID") })
    protected Set<String> supportedCurrencies = new HashSet<String>();

    @Column(name = "DEFAULT_CURRENCY")
    protected String defaultCurrency;

    /**
     * Cascade relations
     */
    @OneToMany(mappedBy = "organization", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<JobReportEntity> jobReports= new ArrayList<>();
    @OneToMany(mappedBy = "organization", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<InvoiceEntity> invoices = new ArrayList<>();
    @OneToMany(mappedBy = "organization", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<CreditNoteEntity> creditNotes = new ArrayList<>();
    @OneToMany(mappedBy = "organization", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<DebitNoteEntity> debitNotes = new ArrayList<>();

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

    public String getLoginTheme() {
        return loginTheme;
    }

    public void setLoginTheme(String loginTheme) {
        this.loginTheme = loginTheme;
    }

    public String getAccountTheme() {
        return accountTheme;
    }

    public void setAccountTheme(String accountTheme) {
        this.accountTheme = accountTheme;
    }

    public String getAdminTheme() {
        return adminTheme;
    }

    public void setAdminTheme(String adminTheme) {
        this.adminTheme = adminTheme;
    }

    public String getEmailTheme() {
        return emailTheme;
    }

    public void setEmailTheme(String emailTheme) {
        this.emailTheme = emailTheme;
    }

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

    public boolean isInternationalizationUblEnabled() {
        return internationalizationUblEnabled;
    }

    public void setInternationalizationUblEnabled(boolean internationalizationUblEnabled) {
        this.internationalizationUblEnabled = internationalizationUblEnabled;
    }

    public Set<String> getSupportedUblLocales() {
        return supportedUblLocales;
    }

    public void setSupportedUblLocales(Set<String> supportedUblLocales) {
        this.supportedUblLocales = supportedUblLocales;
    }

    public String getDefaultUblLocale() {
        return defaultUblLocale;
    }

    public void setDefaultUblLocale(String defaultUblLocale) {
        this.defaultUblLocale = defaultUblLocale;
    }

    public long getTaskDelay() {
        return taskDelay;
    }

    public void setTaskDelay(long taskDelay) {
        this.taskDelay = taskDelay;
    }

    public Map<String, String> getSmtpConfig() {
        return smtpConfig;
    }

    public void setSmtpConfig(Map<String, String> smtpConfig) {
        this.smtpConfig = smtpConfig;
    }

    public Map<String, String> getUblSenderConfig() {
        return ublSenderConfig;
    }

    public void setUblSenderConfig(Map<String, String> ublSenderConfig) {
        this.ublSenderConfig = ublSenderConfig;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

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
    
    public List<InvoiceEntity> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<InvoiceEntity> invoices) {
        this.invoices = invoices;
    }

    public List<CreditNoteEntity> getCreditNotes() {
        return creditNotes;
    }

    public void setCreditNotes(List<CreditNoteEntity> creditNotes) {
        this.creditNotes = creditNotes;
    }
    
    public List<JobReportEntity> getJobReports() {
		return jobReports;
	}

	public void setJobReports(List<JobReportEntity> jobReports) {
		this.jobReports = jobReports;
	}

	public List<DebitNoteEntity> getDebitNotes() {
        return debitNotes;
    }

    public void setDebitNotes(List<DebitNoteEntity> debitNotes) {
        this.debitNotes = debitNotes;
    }

    public Date getTaskFirstTime() {
        return taskFirstTime;
    }

    public void setTaskFirstTime(Date taskFirstTime) {
        this.taskFirstTime = taskFirstTime;
    }

    public boolean getTasksEnabled() {
        return tasksEnabled;
    }

    public void setTasksEnabled(boolean tasksEnabled) {
        this.tasksEnabled = tasksEnabled;
    }

    public String getReportTheme() {
        return reportTheme;
    }

    public void setReportTheme(String reportTheme) {
        this.reportTheme = reportTheme;
    }

}
