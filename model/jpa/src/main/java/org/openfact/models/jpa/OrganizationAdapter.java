package org.openfact.models.jpa;

import org.jboss.logging.Logger;
import org.openfact.models.OrganizationModel;
import org.openfact.models.jpa.entities.OrganizationAttributeEntity;
import org.openfact.models.jpa.entities.OrganizationAttributes;
import org.openfact.models.jpa.entities.OrganizationEntity;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.*;

public class OrganizationAdapter implements OrganizationModel, JpaModel<OrganizationEntity> {

    private static final Logger logger = Logger.getLogger(OrganizationAdapter.class);

    private static final String BROWSER_HEADER_PREFIX = "_browser_header.";

    private final OrganizationEntity organization;
    private final EntityManager em;

    public OrganizationAdapter(EntityManager em, OrganizationEntity organization) {
        this.em = em;
        this.organization = organization;
    }

    public static OrganizationEntity toEntity(OrganizationModel model, EntityManager em) {
        if (model instanceof OrganizationAdapter) {
            return ((OrganizationAdapter) model).getEntity();
        }
        return em.getReference(OrganizationEntity.class, model.getId());
    }

    @Override
    public OrganizationEntity getEntity() {
        return organization;
    }

    @Override
    public String getId() {
        return organization.getId();
    }

    @Override
    public String getName() {
        return organization.getName();
    }

    @Override
    public void setName(String name) {
        organization.setName(name);
        em.flush();
    }

    @Override
    public String getDescription() {
        return organization.getDescription();
    }

    @Override
    public void setDescription(String description) {
        organization.setDescription(description);
    }

    @Override
    public boolean isEnabled() {
        return organization.isEnabled();
    }

    @Override
    public void setEnabled(boolean enabled) {
        organization.setEnabled(enabled);
        em.flush();
    }

    @Override
    public String getAssignedIdentificationId() {
        return organization.getAssignedIdentificationId();
    }

    @Override
    public void setAssignedIdentificationId(String assignedIdentificationId) {
        organization.setAssignedIdentificationId(assignedIdentificationId);
    }

    @Override
    public String getAdditionalAccountId() {
        return organization.getAdditionalAccountId();
    }

    @Override
    public void setAdditionalAccountId(String additionalAccount) {
        organization.setAdditionalAccountId(additionalAccount);
    }

    @Override
    public String getSupplierName() {
        return organization.getSupplierName();
    }

    @Override
    public void setSupplierName(String supplierName) {
        organization.setSupplierName(supplierName);
    }

    @Override
    public String getRegistrationName() {
        return organization.getRegistrationName();
    }

    @Override
    public void setRegistrationName(String registrationName) {
        organization.setRegistrationName(registrationName);
    }

    @Override
    public LocalDateTime getCreatedTimestamp() {
        return organization.getCreatedTimestamp();
    }

    @Override
    public String getPostalAddressId() {
        return organization.getPostalAddressId();
    }

    @Override
    public void setPostalAddressId(String postalAddressId) {
        organization.setPostalAddressId(postalAddressId);
    }

    @Override
    public String getStreetName() {
        return organization.getStreetName();
    }

    @Override
    public void setStreetName(String streetName) {
        organization.setStreetName(streetName);
    }

    @Override
    public String getCitySubdivisionName() {
        return organization.getCitySubdivisionName();
    }

    @Override
    public void setCitySubdivisionName(String citySubdivisionName) {
        organization.setCitySubdivisionName(citySubdivisionName);
    }

    @Override
    public String getCityName() {
        return organization.getCityName();
    }

    @Override
    public void setCityName(String cityName) {
        organization.setCityName(cityName);
    }

    @Override
    public String getCountrySubentity() {
        return organization.getCountrySubentity();
    }

    @Override
    public void setCountrySubentity(String countrySubentity) {
        organization.setCountrySubentity(countrySubentity);
    }

    @Override
    public String getDistrict() {
        return organization.getDistrict();
    }

    @Override
    public void setDistrict(String district) {
        organization.setDistrict(district);
    }

    @Override
    public String getCountryIdentificationCode() {
        return organization.getCountryIdentificationCode();
    }

    @Override
    public void setCountryIdentificationCode(String countryIdentificationCode) {
        organization.setCountryIdentificationCode(countryIdentificationCode);
    }

    @Override
    public Date getTaskFirstTime() {
        return organization.getTaskFirstTime();
    }

    @Override
    public void setTaskFirstTime(Date taskFirstTime) {
        organization.setTaskFirstTime(taskFirstTime);
    }

    @Override
    public long getTaskDelay() {
        return organization.getTaskDelay();
    }

    @Override
    public void setTaskDelay(long taskDelay) {
        organization.setTaskDelay(taskDelay);
    }

    @Override
    public boolean isTasksEnabled() {
        return organization.isTasksEnabled();
    }

    @Override
    public void setTaskEnabled(boolean taskEnabled) {
        organization.setTasksEnabled(taskEnabled);
    }

    @Override
    public Set<String> getSupportedCurrencies() {
        Set<String> supportedCurrencies = organization.getSupportedCurrencies();
        if (supportedCurrencies == null || supportedCurrencies.isEmpty()) return Collections.EMPTY_SET;
        Set<String> copy = new HashSet<>();
        copy.addAll(supportedCurrencies);
        return Collections.unmodifiableSet(copy);
    }

    @Override
    public void setSupportedCurrencies(Set<String> currencies) {
        organization.setSupportedCurrencies(currencies);
        em.flush();
    }

    @Override
    public String getDefaultCurrency() {
        return organization.getDefaultCurrency();
    }

    @Override
    public void setDefaultCurrency(String currency) {
        organization.setDefaultCurrency(currency);
    }

    @Override
    public boolean isEventsEnabled() {
        return organization.isEventsEnabled();
    }

    @Override
    public void setEventsEnabled(boolean enabled) {
        organization.setEventsEnabled(enabled);
        em.flush();
    }

    @Override
    public Set<String> getEventsListeners() {
        Set<String> eventsListeners = organization.getEventsListeners();
        if (eventsListeners.isEmpty()) return Collections.EMPTY_SET;
        Set<String> copy = new HashSet<>();
        copy.addAll(eventsListeners);
        return Collections.unmodifiableSet(copy);
    }

    @Override
    public void setEventsListeners(Set<String> listeners) {
        organization.setEventsListeners(listeners);
        em.flush();
    }

    @Override
    public Set<String> getEnabledEventTypes() {
        Set<String> enabledEventTypes = organization.getEnabledEventTypes();
        if (enabledEventTypes.isEmpty()) return Collections.EMPTY_SET;
        Set<String> copy = new HashSet<>();
        copy.addAll(enabledEventTypes);
        return Collections.unmodifiableSet(copy);
    }

    @Override
    public void setEnabledEventTypes(Set<String> enabledEventTypes) {
        organization.setEnabledEventTypes(enabledEventTypes);
        em.flush();
    }

    @Override
    public boolean isAdminEventsEnabled() {
        return organization.isAdminEventsEnabled();
    }

    @Override
    public void setAdminEventsEnabled(boolean enabled) {
        organization.setAdminEventsEnabled(enabled);
        em.flush();
    }

    @Override
    public boolean isAdminEventsDetailsEnabled() {
        return organization.isAdminEventsDetailsEnabled();
    }

    @Override
    public void setAdminEventsDetailsEnabled(boolean enabled) {
        organization.setAdminEventsDetailsEnabled(enabled);
        em.flush();
    }

    @Override
    public Map<String, String> getSmtpConfig() {
        Map<String, String> config = new HashMap<String, String>();
        config.putAll(organization.getSmtpConfig());
        return Collections.unmodifiableMap(config);
    }

    @Override
    public void setSmtpConfig(Map<String, String> smtpConfig) {
        organization.setSmtpConfig(smtpConfig);
        em.flush();
    }

    /**
     * Attribute
     */
    @Override
    public void setAttribute(String name, String value) {
        for (OrganizationAttributeEntity attr : organization.getAttributes()) {
            if (attr.getName().equals(name)) {
                attr.setValue(value);
                return;
            }
        }
        OrganizationAttributeEntity attr = new OrganizationAttributeEntity();
        attr.setName(name);
        attr.setValue(value);
        attr.setOrganization(organization);
        em.persist(attr);
        organization.getAttributes().add(attr);
    }

    @Override
    public void setAttribute(String name, Boolean value) {
        setAttribute(name, value.toString());
    }

    @Override
    public void setAttribute(String name, Integer value) {
        setAttribute(name, value.toString());
    }

    @Override
    public void setAttribute(String name, Long value) {
        setAttribute(name, value.toString());
    }

    @Override
    public void removeAttribute(String name) {
        Iterator<OrganizationAttributeEntity> it = organization.getAttributes().iterator();
        while (it.hasNext()) {
            OrganizationAttributeEntity attr = it.next();
            if (attr.getName().equals(name)) {
                it.remove();
                em.remove(attr);
            }
        }
    }

    @Override
    public String getAttribute(String name) {
        for (OrganizationAttributeEntity attr : organization.getAttributes()) {
            if (attr.getName().equals(name)) {
                return attr.getValue();
            }
        }
        return null;
    }

    @Override
    public Integer getAttribute(String name, Integer defaultValue) {
        String v = getAttribute(name);
        return v != null ? Integer.parseInt(v) : defaultValue;
    }

    @Override
    public Long getAttribute(String name, Long defaultValue) {
        String v = getAttribute(name);
        return v != null ? Long.parseLong(v) : defaultValue;
    }

    @Override
    public Boolean getAttribute(String name, Boolean defaultValue) {
        String v = getAttribute(name);
        return v != null ? Boolean.parseBoolean(v) : defaultValue;
    }

    @Override
    public Map<String, String> getAttributes() {
        // should always return a copy
        Map<String, String> result = new HashMap<String, String>();
        for (OrganizationAttributeEntity attr : organization.getAttributes()) {
            result.put(attr.getName(), attr.getValue());
        }
        return result;
    }

    /**
     * */

    @Override
    public String getDisplayName() {
        return getAttribute(OrganizationAttributes.DISPLAY_NAME);
    }

    @Override
    public void setDisplayName(String displayName) {
        setAttribute(OrganizationAttributes.DISPLAY_NAME, displayName);
    }

    @Override
    public String getDisplayNameHtml() {
        return getAttribute(OrganizationAttributes.DISPLAY_NAME_HTML);
    }

    @Override
    public void setDisplayNameHtml(String displayNameHtml) {
        setAttribute(OrganizationAttributes.DISPLAY_NAME_HTML, displayNameHtml);
    }

    @Override
    public String getEmailTheme() {
        return organization.getEmailTheme();
    }

    @Override
    public void setEmailTheme(String name) {
        organization.setEmailTheme(name);
        em.flush();
    }

    @Override
    public String getReportTheme() {
        return organization.getReportTheme();
    }

    @Override
    public void setReportTheme(String name) {
        organization.setReportTheme(name);
        em.flush();
    }

    @Override
    public boolean isInternationalizationEnabled() {
        return organization.isInternationalizationEnabled();
    }

    @Override
    public void setInternationalizationEnabled(boolean enabled) {
        organization.setInternationalizationEnabled(enabled);
        em.flush();
    }

    @Override
    public Set<String> getSupportedLocales() {
        Set<String> supportedLocales = organization.getSupportedLocales();
        if (supportedLocales == null || supportedLocales.isEmpty()) return Collections.EMPTY_SET;
        Set<String> copy = new HashSet<>();
        copy.addAll(supportedLocales);
        return Collections.unmodifiableSet(copy);
    }

    @Override
    public void setSupportedLocales(Set<String> locales) {
        organization.setSupportedLocales(locales);
        em.flush();
    }

    @Override
    public String getDefaultLocale() {
        return organization.getDefaultLocale();
    }

    @Override
    public void setDefaultLocale(String locale) {
        organization.setDefaultLocale(locale);
        em.flush();
    }

    @Override
    public long getEventsExpiration() {
        return organization.getEventsExpiration();
    }

    @Override
    public void setEventsExpiration(long expiration) {
        organization.setEventsExpiration(expiration);
        em.flush();
    }

    @Override
    public Map<String, String> getBrowserSecurityHeaders() {
        Map<String, String> attributes = getAttributes();
        if (attributes.isEmpty()) {
            return Collections.EMPTY_MAP;
        }
        Map<String, String> headers = new HashMap<String, String>();
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            if (entry.getKey().startsWith(BROWSER_HEADER_PREFIX)) {
                headers.put(entry.getKey().substring(BROWSER_HEADER_PREFIX.length()), entry.getValue());
            }
        }
        return Collections.unmodifiableMap(headers);
    }

    @Override
    public void setBrowserSecurityHeaders(Map<String, String> headers) {
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            setAttribute(BROWSER_HEADER_PREFIX + entry.getKey(), entry.getValue());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof OrganizationModel)) return false;

        OrganizationModel that = (OrganizationModel) o;
        return that.getId().equals(getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }


}
