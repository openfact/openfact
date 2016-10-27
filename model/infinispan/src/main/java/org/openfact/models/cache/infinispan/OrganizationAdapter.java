/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates
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
 */

package org.openfact.models.cache.infinispan;

import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openfact.component.ComponentModel;
import org.openfact.models.OrganizationModel;
import org.openfact.models.cache.infinispan.entities.CachedOrganization;
import org.openfact.models.utils.OpenfactModelUtils;

/**
 * @author <a href="mailto:bill@burkecentral.com">Bill Burke</a>
 * @version $Revision: 1 $
 */
public class OrganizationAdapter implements OrganizationModel {
    protected CachedOrganization cached;
    protected OrganizationCacheSession cacheSession;
    protected OrganizationModel updated;
    protected OrganizationCache cache;
    protected volatile transient PublicKey publicKey;
    protected volatile transient PrivateKey privateKey;
    protected volatile transient Key codeSecretKey;
    protected volatile transient X509Certificate certificate;

    public OrganizationAdapter(CachedOrganization cached, OrganizationCacheSession cacheSession) {
        this.cached = cached;
        this.cacheSession = cacheSession;
    }

    protected void getDelegateForUpdate() {
        if (updated == null) {
            cacheSession.registerOrganizationInvalidation(cached.getId());
            updated = cacheSession.getDelegate().getOrganization(cached.getId());
            if (updated == null)
                throw new IllegalStateException("Not found in database");
        }
    }

    protected boolean invalidated;

    public void invalidate() {
        invalidated = true;
    }

    protected boolean isUpdated() {
        if (updated != null)
            return true;
        if (!invalidated)
            return false;
        updated = cacheSession.getDelegate().getOrganization(cached.getId());
        if (updated == null)
            throw new IllegalStateException("Not found in database");
        return true;
    }

    @Override
    public String getId() {
        if (isUpdated())
            return updated.getId();
        return cached.getId();
    }

    @Override
    public String getName() {
        if (isUpdated())
            return updated.getName();
        return cached.getName();
    }

    @Override
    public void setName(String name) {
        getDelegateForUpdate();
        updated.setName(name);
    }

    @Override
    public String getDisplayName() {
        if (isUpdated())
            return updated.getDisplayName();
        return cached.getDisplayName();
    }

    @Override
    public void setDisplayName(String displayName) {
        getDelegateForUpdate();
        updated.setDisplayName(displayName);
    }

    @Override
    public String getDisplayNameHtml() {
        if (isUpdated())
            return updated.getDisplayNameHtml();
        return cached.getDisplayNameHtml();
    }

    @Override
    public void setDisplayNameHtml(String displayNameHtml) {
        getDelegateForUpdate();
        updated.setDisplayNameHtml(displayNameHtml);
    }

    @Override
    public boolean isEnabled() {
        if (isUpdated())
            return updated.isEnabled();
        return cached.isEnabled();
    }

    @Override
    public void setEnabled(boolean enabled) {
        getDelegateForUpdate();
        updated.setEnabled(enabled);
    }

    @Override
    public String getKeyId() {
        if (isUpdated())
            return updated.getKeyId();
        return cached.getKeyId();
    }

    @Override
    public String getPublicKeyPem() {
        if (isUpdated())
            return updated.getPublicKeyPem();
        return cached.getPublicKeyPem();
    }

    @Override
    public void setPublicKeyPem(String publicKeyPem) {
        getDelegateForUpdate();
        updated.setPublicKeyPem(publicKeyPem);
    }

    @Override
    public String getPrivateKeyPem() {
        if (isUpdated())
            return updated.getPrivateKeyPem();
        return cached.getPrivateKeyPem();
    }

    @Override
    public void setPrivateKeyPem(String privateKeyPem) {
        getDelegateForUpdate();
        updated.setPrivateKeyPem(privateKeyPem);
    }

    @Override
    public PublicKey getPublicKey() {
        if (isUpdated())
            return updated.getPublicKey();
        if (publicKey != null)
            return publicKey;
        publicKey = cached.getPublicKey();
        if (publicKey != null)
            return publicKey;
        publicKey = OpenfactModelUtils.getPublicKey(getPublicKeyPem());
        return publicKey;
    }

    @Override
    public void setPublicKey(PublicKey publicKey) {
        this.publicKey = publicKey;
        String publicKeyPem = OpenfactModelUtils.getPemFromKey(publicKey);
        setPublicKeyPem(publicKeyPem);
    }

    @Override
    public X509Certificate getCertificate() {
        if (isUpdated())
            return updated.getCertificate();
        if (certificate != null)
            return certificate;
        certificate = cached.getCertificate();
        if (certificate != null)
            return certificate;
        certificate = OpenfactModelUtils.getCertificate(getCertificatePem());
        return certificate;
    }

    @Override
    public void setCertificate(X509Certificate certificate) {
        this.certificate = certificate;
        String certPem = OpenfactModelUtils.getPemFromCertificate(certificate);
        setCertificatePem(certPem);
    }

    @Override
    public void setCertificatePem(String certificate) {
        getDelegateForUpdate();
        updated.setCertificatePem(certificate);

    }

    @Override
    public PrivateKey getPrivateKey() {
        if (isUpdated())
            return updated.getPrivateKey();
        if (privateKey != null) {
            return privateKey;
        }
        privateKey = cached.getPrivateKey();
        if (privateKey != null) {
            return privateKey;
        }
        privateKey = OpenfactModelUtils.getPrivateKey(getPrivateKeyPem());
        return privateKey;
    }

    @Override
    public void setPrivateKey(PrivateKey privateKey) {
        this.privateKey = privateKey;
        String privateKeyPem = OpenfactModelUtils.getPemFromKey(privateKey);
        setPrivateKeyPem(privateKeyPem);
    }

    @Override
    public String getCodeSecret() {
        return isUpdated() ? updated.getCodeSecret() : cached.getCodeSecret();
    }

    @Override
    public Key getCodeSecretKey() {
        if (codeSecretKey == null) {
            codeSecretKey = OpenfactModelUtils.getSecretKey(getCodeSecret());
        }
        return codeSecretKey;
    }

    @Override
    public void setCodeSecret(String codeSecret) {
        getDelegateForUpdate();
        updated.setCodeSecret(codeSecret);
    }

    @Override
    public Map<String, String> getSmtpConfig() {
        if (isUpdated())
            return updated.getSmtpConfig();
        return cached.getSmtpConfig();
    }

    @Override
    public void setSmtpConfig(Map<String, String> smtpConfig) {
        getDelegateForUpdate();
        updated.setSmtpConfig(smtpConfig);
    }

    @Override
    public boolean isEventsEnabled() {
        if (isUpdated())
            return updated.isEventsEnabled();
        return cached.isEventsEnabled();
    }

    @Override
    public void setEventsEnabled(boolean enabled) {
        getDelegateForUpdate();
        updated.setEventsEnabled(enabled);
    }

    @Override
    public long getEventsExpiration() {
        if (isUpdated())
            return updated.getEventsExpiration();
        return cached.getEventsExpiration();
    }

    @Override
    public void setEventsExpiration(long expiration) {
        getDelegateForUpdate();
        updated.setEventsExpiration(expiration);
    }

    @Override
    public Set<String> getEventsListeners() {
        if (isUpdated())
            return updated.getEventsListeners();
        return cached.getEventsListeners();
    }

    @Override
    public void setEventsListeners(Set<String> listeners) {
        getDelegateForUpdate();
        updated.setEventsListeners(listeners);
    }

    @Override
    public Set<String> getEnabledEventTypes() {
        if (isUpdated())
            return updated.getEnabledEventTypes();
        return cached.getEnabledEventTypes();
    }

    @Override
    public void setEnabledEventTypes(Set<String> enabledEventTypes) {
        getDelegateForUpdate();
        updated.setEnabledEventTypes(enabledEventTypes);
    }

    @Override
    public boolean isAdminEventsEnabled() {
        if (isUpdated())
            return updated.isAdminEventsEnabled();
        return cached.isAdminEventsEnabled();
    }

    @Override
    public void setAdminEventsEnabled(boolean enabled) {
        getDelegateForUpdate();
        updated.setAdminEventsEnabled(enabled);
    }

    @Override
    public boolean isAdminEventsDetailsEnabled() {
        if (isUpdated())
            return updated.isAdminEventsDetailsEnabled();
        return cached.isAdminEventsDetailsEnabled();
    }

    @Override
    public void setAdminEventsDetailsEnabled(boolean enabled) {
        getDelegateForUpdate();
        updated.setAdminEventsDetailsEnabled(enabled);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || !(o instanceof OrganizationModel))
            return false;

        OrganizationModel that = (OrganizationModel) o;
        return that.getId().equals(getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    @Override
    public boolean isInternationalizationEnabled() {
        if (isUpdated())
            return updated.isInternationalizationEnabled();
        return cached.isInternationalizationEnabled();
    }

    @Override
    public void setInternationalizationEnabled(boolean enabled) {
        getDelegateForUpdate();
        updated.setInternationalizationEnabled(enabled);
    }

    @Override
    public Set<String> getSupportedLocales() {
        if (isUpdated())
            return updated.getSupportedLocales();
        return cached.getSupportedLocales();
    }

    @Override
    public void setSupportedLocales(Set<String> locales) {
        getDelegateForUpdate();
        updated.setSupportedLocales(locales);
    }

    @Override
    public String getDefaultLocale() {
        if (isUpdated())
            return updated.getDefaultLocale();
        return cached.getDefaultLocale();
    }

    @Override
    public void setDefaultLocale(String locale) {
        updated.setDefaultLocale(locale);
    }

    @Override
    public Map<String, String> getAttributes() {
        if (isUpdated())
            return updated.getAttributes();
        return cached.getAttributes();
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setDescription(String description) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getAssignedIdentificationId() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setAssignedIdentificationId(String assignedIdentificationId) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getAdditionalAccountId() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setAdditionalAccountId(String additionalAccount) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getSupplierName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setSupplierName(String supplierName) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getRegistrationName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setRegistrationName(String registrationName) {
        // TODO Auto-generated method stub

    }

    @Override
    public LocalDateTime getCreatedTimestamp() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getPostalAddressId() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setPostalAddressId(String postalAddressId) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getStreetName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setStreetName(String streetName) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getCitySubdivisionName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setCitySubdivisionName(String citySubdivisionName) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getCityName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setCityName(String cityName) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getCountrySubentity() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setCountrySubentity(String countrySubentity) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getDistrict() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setDistrict(String district) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getCountryIdentificationCode() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setCountryIdentificationCode(String countryIdentificationCode) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getEmailTheme() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setEmailTheme(String name) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isInternationalizationUblEnabled() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void setInternationalizationUblEnabled(boolean enabled) {
        // TODO Auto-generated method stub

    }

    @Override
    public Set<String> getSupportedUblLocales() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setSupportedUblLocales(Set<String> locales) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getDefaultUblLocale() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setDefaultUblLocale(String locale) {
        // TODO Auto-generated method stub

    }

    @Override
    public Set<String> getSupportedCurrencies() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setSupportedCurrencies(Set<String> currencies) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getDefaultCurrency() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setDefaultCurrency(String currency) {
        // TODO Auto-generated method stub

    }

    @Override
    public Map<String, String> getUblSenderConfig() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setUblSenderConfig(Map<String, String> ublSenderConfig) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getCertificatePem() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setAttribute(String name, String value) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeAttribute(String name) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getAttribute(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<String> getRequiredActions() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void addRequiredAction(RequiredAction action) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addRequiredAction(String actionName) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeRequiredAction(RequiredAction action) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeRequiredAction(String actionName) {
        // TODO Auto-generated method stub

    }

    @Override
    public long getTaskDelay() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setTaskDelay(long taskDelay) {
        // TODO Auto-generated method stub

    }

    @Override
    public Date getTaskFirstTime() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setTaskFirstTime(Date firstTime) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isTasksEnabled() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void setTaskEnabled(boolean taskEnabled) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public ComponentModel addComponentModel(ComponentModel model) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateComponent(ComponentModel component) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void removeComponent(ComponentModel component) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void removeComponents(String parentId) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<ComponentModel> getComponents(String parentId, String providerType) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<ComponentModel> getComponents(String parentId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<ComponentModel> getComponents() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ComponentModel getComponent(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Map<String, String> getBrowserSecurityHeaders() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setBrowserSecurityHeaders(Map<String, String> headers) {
        // TODO Auto-generated method stub
        
    }

}
