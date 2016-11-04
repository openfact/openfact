/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.openfact.models;

import org.openfact.component.ComponentModel;
import org.openfact.provider.ProviderEvent;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface OrganizationModel {

    String NAME = "name";
    String DESCRIPTION = "description";
    String ASSIGNED_IDENTIFICATION_ID = "assignedIdentificationId";
    String SUPPLIER_NAME = "supplierName";
    String REGISTRATION_NAME = "registrationName";

    String getId();

    String getName();

    void setName(String name);

    String getDescription();

    void setDescription(String description);

    boolean isEnabled();

    void setEnabled(boolean enabled);

    String getAssignedIdentificationId();

    void setAssignedIdentificationId(String assignedIdentificationId);

    String getAdditionalAccountId();

    void setAdditionalAccountId(String additionalAccount);

    String getSupplierName();

    void setSupplierName(String supplierName);

    String getRegistrationName();

    void setRegistrationName(String registrationName);

    LocalDateTime getCreatedTimestamp();

    /**
     * Postal address
     */
    String getPostalAddressId();

    void setPostalAddressId(String postalAddressId);

    String getStreetName();

    void setStreetName(String streetName);

    String getCitySubdivisionName();

    void setCitySubdivisionName(String citySubdivisionName);

    String getCityName();

    void setCityName(String cityName);

    String getCountrySubentity();

    void setCountrySubentity(String countrySubentity);

    String getDistrict();

    void setDistrict(String district);

    String getCountryIdentificationCode();

    void setCountryIdentificationCode(String countryIdentificationCode);

    /**
     * Themes
     */
    String getEmailTheme();

    void setEmailTheme(String name);

    /**
     * Internationalization
     */
    boolean isInternationalizationEnabled();

    void setInternationalizationEnabled(boolean enabled);

    Set<String> getSupportedLocales();

    void setSupportedLocales(Set<String> locales);

    String getDefaultLocale();

    void setDefaultLocale(String locale);

    /**
     * Task schedules
     */
    Date getTaskFirstTime();

    void setTaskFirstTime(Date firstTime);

    long getTaskDelay();

    void setTaskDelay(long taskDelay);

    boolean isTasksEnabled();

    void setTaskEnabled(boolean taskEnabled);

    /**
     * Currencies
     */
    Set<String> getSupportedCurrencies();

    void setSupportedCurrencies(Set<String> currencies);

    String getDefaultCurrency();

    void setDefaultCurrency(String currency);

    /**
     * Events
     */
    boolean isEventsEnabled();

    void setEventsEnabled(boolean enabled);

    Set<String> getEventsListeners();

    void setEventsListeners(Set<String> listeners);

    Set<String> getEnabledEventTypes();

    void setEnabledEventTypes(Set<String> enabledEventTypes);

    boolean isAdminEventsEnabled();

    void setAdminEventsEnabled(boolean enabled);

    boolean isAdminEventsDetailsEnabled();

    void setAdminEventsDetailsEnabled(boolean enabled);

    long getEventsExpiration();

    void setEventsExpiration(long expiration);

    /**
     * Smtp for email
     */
    Map<String, String> getSmtpConfig();

    void setSmtpConfig(Map<String, String> smtpConfig);

    /**
     * Attributes
     */
    void setAttribute(String name, String value);

    void removeAttribute(String name);

    String getAttribute(String name);

    Map<String, String> getAttributes();

    String getDisplayName();

    void setDisplayName(String displayName);

    String getDisplayNameHtml();

    void setDisplayNameHtml(String displayNameHtml);

    /**
     * Components
     */
    ComponentModel addComponentModel(ComponentModel model);

    void updateComponent(ComponentModel component);

    void removeComponent(ComponentModel component);

    void removeComponents(String parentId);

    List<ComponentModel> getComponents(String parentId, String providerType);

    List<ComponentModel> getComponents(String parentId);

    List<ComponentModel> getComponents();

    ComponentModel getComponent(String id);

    /**
     * Headers
     */
    Map<String, String> getBrowserSecurityHeaders();

    void setBrowserSecurityHeaders(Map<String, String> headers);

    public static enum RequiredAction {
        ACTION1, ACTION2, ACTION3, ACTION4
    }

    /**
     * Events interfaces
     */
    interface OrganizationCreationEvent extends ProviderEvent {
        OrganizationModel getCreatedOrganization();
    }

    interface OrganizationPostCreateEvent extends ProviderEvent {
        OrganizationModel getCreatedOrganization();

        OpenfactSession getOpenfactSession();
    }

    interface OrganizationRemovedEvent extends ProviderEvent {
        OrganizationModel getOrganization();

        OpenfactSession getOpenfactSession();
    }

}
