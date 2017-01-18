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
package org.openfact.models.jpa;

import org.jboss.logging.Logger;
import org.openfact.common.util.MultivaluedHashMap;
import org.openfact.component.ComponentFactory;
import org.openfact.component.ComponentModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.RequiredActionProviderModel;
import org.openfact.models.enums.DocumentType;
import org.openfact.models.jpa.entities.*;
import org.openfact.models.utils.ComponentUtil;
import org.openfact.models.utils.OpenfactModelUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.*;

public class OrganizationAdapter implements OrganizationModel, JpaModel<OrganizationEntity> {

    protected static final Logger logger = Logger.getLogger(OrganizationAdapter.class);

    private static final String BROWSER_HEADER_PREFIX = "_browser_header.";
    protected OrganizationEntity organization;
    protected EntityManager em;
    protected OpenfactSession session;

    public OrganizationAdapter(OpenfactSession session, EntityManager em, OrganizationEntity organization) {
        this.session = session;
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

    /**
     * Required actions
     */
    @Override
    public RequiredActionProviderModel addRequiredActionProvider(RequiredActionProviderModel model) {
        RequiredActionProviderEntity auth = new RequiredActionProviderEntity();
        String id = (model.getId() == null) ? OpenfactModelUtils.generateId() : model.getId();
        auth.setId(id);
        auth.setAlias(model.getAlias());
        auth.setName(model.getName());
        auth.setOrganization(organization);
        auth.setProviderId(model.getProviderId());
        auth.setConfig(model.getConfig());
        auth.setEnabled(model.isEnabled());
        auth.setDefaultAction(model.isDefaultAction());
        organization.getRequiredActionProviders().add(auth);
        em.persist(auth);
        em.flush();
        model.setId(auth.getId());
        return model;
    }

    @Override
    public void removeRequiredActionProvider(RequiredActionProviderModel model) {
        RequiredActionProviderEntity entity = em.find(RequiredActionProviderEntity.class, model.getId());
        if (entity == null) return;
        em.remove(entity);
        em.flush();

    }

    @Override
    public RequiredActionProviderModel getRequiredActionProviderById(String id) {
        RequiredActionProviderEntity entity = em.find(RequiredActionProviderEntity.class, id);
        if (entity == null) return null;
        return entityToModel(entity);
    }

    public RequiredActionProviderModel entityToModel(RequiredActionProviderEntity entity) {
        RequiredActionProviderModel model = new RequiredActionProviderModel();
        model.setId(entity.getId());
        model.setProviderId(entity.getProviderId());
        model.setAlias(entity.getAlias());
        model.setEnabled(entity.isEnabled());
        model.setDefaultAction(entity.isDefaultAction());
        model.setName(entity.getName());
        Map<String, String> config = new HashMap<>();
        if (entity.getConfig() != null) config.putAll(entity.getConfig());
        model.setConfig(config);
        return model;
    }

    @Override
    public void updateRequiredActionProvider(RequiredActionProviderModel model) {
        RequiredActionProviderEntity entity = em.find(RequiredActionProviderEntity.class, model.getId());
        if (entity == null) return;
        entity.setAlias(model.getAlias());
        entity.setProviderId(model.getProviderId());
        entity.setEnabled(model.isEnabled());
        entity.setDefaultAction(model.isDefaultAction());
        entity.setName(model.getName());
        if (entity.getConfig() == null) {
            entity.setConfig(model.getConfig());
        } else {
            entity.getConfig().clear();
            entity.getConfig().putAll(model.getConfig());
        }
        em.flush();

    }

    @Override
    public List<RequiredActionProviderModel> getRequiredActionProviders() {
        Collection<RequiredActionProviderEntity> entities = organization.getRequiredActionProviders();
        if (entities.isEmpty()) return Collections.EMPTY_LIST;
        List<RequiredActionProviderModel> actions = new LinkedList<>();
        for (RequiredActionProviderEntity entity : entities) {
            actions.add(entityToModel(entity));
        }
        return Collections.unmodifiableList(actions);
    }

    @Override
    public RequiredActionProviderModel getRequiredActionProviderByAlias(String alias) {
        for (RequiredActionProviderModel action : getRequiredActionProviders()) {
            if (action.getAlias().equals(alias)) return action;
        }
        return null;
    }

    @Override
    public void removeAttachedDocuments(DocumentType documentType, String documentId) {
        em.createNamedQuery("deleteInvoiceAttachedDocumentAttributesByOrganizationTypeAndDocumentId")
                .setParameter("organizationId", organization.getId())
                .setParameter("documentType", documentType)
                .setParameter("documentId", documentId)
                .executeUpdate();
        em.createNamedQuery("deleteInvoiceAttachedDocumentsByOrganizationTypeAndDocumentId")
                .setParameter("organizationId", organization.getId())
                .setParameter("documentType", documentType)
                .setParameter("documentId", documentId)
                .executeUpdate();

        em.createNamedQuery("deleteCreditNoteAttachedDocumentAttributesByOrganizationTypeAndDocumentId")
                .setParameter("organizationId", organization.getId())
                .setParameter("documentType", documentType)
                .setParameter("documentId", documentId)
                .executeUpdate();
        em.createNamedQuery("deleteCreditNoteAttachedDocumentsByOrganizationTypeAndDocumentId")
                .setParameter("organizationId", organization.getId())
                .setParameter("documentType", documentType)
                .setParameter("documentId", documentId)
                .executeUpdate();

        em.createNamedQuery("deleteDebitNoteAttachedDocumentAttributesByOrganizationTypeAndDocumentId")
                .setParameter("organizationId", organization.getId())
                .setParameter("documentType", documentType)
                .setParameter("documentId", documentId)
                .executeUpdate();
        em.createNamedQuery("deleteDebitNoteAttachedDocumentsByOrganizationTypeAndDocumentId")
                .setParameter("organizationId", organization.getId())
                .setParameter("documentType", documentType)
                .setParameter("documentId", documentId)
                .executeUpdate();
    }

    /**
     * Components
     */
    @Override
    public ComponentModel addComponentModel(ComponentModel model) {
        model = importComponentModel(model);
        ComponentUtil.notifyCreated(session, this, model);

        return model;
    }

    @Override
    public ComponentModel importComponentModel(ComponentModel model) {
        ComponentFactory componentFactory = ComponentUtil.getComponentFactory(session, model);
        if (componentFactory == null) {
            throw new IllegalArgumentException("Invalid component type");
        }

        componentFactory.validateConfiguration(session, this, model);

        ComponentEntity c = new ComponentEntity();
        if (model.getId() == null) {
            c.setId(OpenfactModelUtils.generateId());
        } else {
            c.setId(model.getId());
        }
        c.setName(model.getName());
        c.setParentId(model.getParentId());
        if (model.getParentId() == null) {
            c.setParentId(this.getId());
            model.setParentId(this.getId());
        }
        c.setProviderType(model.getProviderType());
        c.setProviderId(model.getProviderId());
        c.setSubType(model.getSubType());
        c.setOrganization(organization);
        em.persist(c);
        setConfig(model, c);
        model.setId(c.getId());
        return model;
    }

    protected void setConfig(ComponentModel model, ComponentEntity c) {
        for (String key : model.getConfig().keySet()) {
            List<String> vals = model.getConfig().get(key);
            if (vals == null) {
                continue;
            }
            for (String val : vals) {
                ComponentConfigEntity config = new ComponentConfigEntity();
                config.setId(OpenfactModelUtils.generateId());
                config.setName(key);
                config.setValue(val);
                config.setComponent(c);
                em.persist(config);
            }
        }
    }

    @Override
    public void updateComponent(ComponentModel component) {
        ComponentUtil.getComponentFactory(session, component).validateConfiguration(session, this, component);

        ComponentEntity c = em.find(ComponentEntity.class, component.getId());
        if (c == null) return;
        c.setName(component.getName());
        c.setProviderId(component.getProviderId());
        c.setProviderType(component.getProviderType());
        c.setParentId(component.getParentId());
        c.setSubType(component.getSubType());
        em.createNamedQuery("deleteComponentConfigByComponent").setParameter("component", c).executeUpdate();
        em.flush();
        setConfig(component, c);


    }

    @Override
    public void removeComponent(ComponentModel component) {
        ComponentEntity c = em.find(ComponentEntity.class, component.getId());
        if (c == null) return;
        //session.users().preRemove(this, component);
        removeComponents(component.getId());
        em.createNamedQuery("deleteComponentConfigByComponent").setParameter("component", c).executeUpdate();
        em.remove(c);
    }

    @Override
    public void removeComponents(String parentId) {
        TypedQuery<String> query = em.createNamedQuery("getComponentIdsByParent", String.class)
                .setParameter("organization", organization)
                .setParameter("parentId", parentId);
        List<String> results = query.getResultList();
        if (results.isEmpty()) return;
        for (String id : results) {
            //session.users().preRemove(this, getComponent(id));
        }
        em.createNamedQuery("deleteComponentConfigByParent").setParameter("parentId", parentId).executeUpdate();
        em.createNamedQuery("deleteComponentByParent").setParameter("parentId", parentId).executeUpdate();

    }

    @Override
    public List<ComponentModel> getComponents(String parentId, String providerType) {
        if (parentId == null) parentId = getId();
        TypedQuery<ComponentEntity> query = em.createNamedQuery("getComponentsByParentAndType", ComponentEntity.class)
                .setParameter("organization", organization)
                .setParameter("parentId", parentId)
                .setParameter("providerType", providerType);
        List<ComponentEntity> results = query.getResultList();
        List<ComponentModel> rtn = new LinkedList<>();
        for (ComponentEntity c : results) {
            ComponentModel model = entityToModel(c);
            rtn.add(model);

        }
        return rtn;
    }

    @Override
    public List<ComponentModel> getComponents(String parentId) {
        TypedQuery<ComponentEntity> query = em.createNamedQuery("getComponentsByParent", ComponentEntity.class)
                .setParameter("organization", organization)
                .setParameter("parentId", parentId);
        List<ComponentEntity> results = query.getResultList();
        List<ComponentModel> rtn = new LinkedList<>();
        for (ComponentEntity c : results) {
            ComponentModel model = entityToModel(c);
            rtn.add(model);

        }
        return rtn;
    }

    protected ComponentModel entityToModel(ComponentEntity c) {
        ComponentModel model = new ComponentModel();
        model.setId(c.getId());
        model.setName(c.getName());
        model.setProviderType(c.getProviderType());
        model.setProviderId(c.getProviderId());
        model.setSubType(c.getSubType());
        model.setParentId(c.getParentId());
        MultivaluedHashMap<String, String> config = new MultivaluedHashMap<>();
        TypedQuery<ComponentConfigEntity> configQuery = em.createNamedQuery("getComponentConfig", ComponentConfigEntity.class)
                .setParameter("component", c);
        List<ComponentConfigEntity> configResults = configQuery.getResultList();
        for (ComponentConfigEntity configEntity : configResults) {
            config.add(configEntity.getName(), configEntity.getValue());
        }
        model.setConfig(config);
        return model;
    }

    @Override
    public List<ComponentModel> getComponents() {
        TypedQuery<ComponentEntity> query = em.createNamedQuery("getComponents", ComponentEntity.class)
                .setParameter("organization", organization);
        List<ComponentEntity> results = query.getResultList();
        List<ComponentModel> rtn = new LinkedList<>();
        for (ComponentEntity c : results) {
            ComponentModel model = entityToModel(c);
            rtn.add(model);

        }
        return rtn;
    }

    @Override
    public ComponentModel getComponent(String id) {
        ComponentEntity c = em.find(ComponentEntity.class, id);
        if (c == null) return null;
        return entityToModel(c);
    }

    @Override
    public Map<String, String> getBrowserSecurityHeaders() {
        Map<String, String> attributes = getAttributes();
        if (attributes.isEmpty())
            return Collections.EMPTY_MAP;
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
