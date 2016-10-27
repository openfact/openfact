package org.openfact.models.jpa;

import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.jboss.logging.Logger;
import org.openfact.common.util.MultivaluedHashMap;
import org.openfact.component.ComponentFactory;
import org.openfact.component.ComponentModel;
import org.openfact.jose.jwk.JWKBuilder;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.jpa.entities.ComponentConfigEntity;
import org.openfact.models.jpa.entities.ComponentEntity;
import org.openfact.models.jpa.entities.OrganizationAttributes;
import org.openfact.models.jpa.entities.OrganizationEntity;
import org.openfact.models.jpa.entities.OrganizationRequiredActionEntity;
import org.openfact.models.utils.ComponentUtil;
import org.openfact.models.utils.OpenfactModelUtils;

public class OrganizationAdapter implements OrganizationModel, JpaModel<OrganizationEntity> {

    protected static final Logger logger = Logger.getLogger(OrganizationAdapter.class);

    protected OrganizationEntity organization;
    protected EntityManager em;
    protected OpenfactSession session;

    protected volatile transient PublicKey publicKey;
    protected volatile transient PrivateKey privateKey;
    protected volatile transient X509Certificate certificate;
    protected volatile transient Key codeSecretKey;

    public OrganizationAdapter(OpenfactSession session, EntityManager em, OrganizationEntity organization) {
        this.session = session;
        this.em = em;
        this.organization = organization;
    }

    @Override
    public OrganizationEntity getEntity() {
        return organization;
    }

    public static OrganizationEntity toEntity(OrganizationModel model, EntityManager em) {
        if (model instanceof OrganizationAdapter) {
            return ((OrganizationAdapter) model).getEntity();
        }
        return em.getReference(OrganizationEntity.class, model.getId());
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
        return organization.getTasksEnabled();
    }

    @Override
    public void setTaskEnabled(boolean taskEnabled) {
        organization.setTasksEnabled(taskEnabled);
    }

    @Override
    public Set<String> getSupportedCurrencies() {
        return organization.getSupportedCurrencies();
    }

    @Override
    public void setSupportedCurrencies(Set<String> currencies) {
        organization.setSupportedCurrencies(currencies);
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
    }

    @Override
    public Set<String> getEventsListeners() {
        return organization.getEventsListeners();
    }

    @Override
    public void setEventsListeners(Set<String> listeners) {
        organization.setEventsListeners(listeners);
    }

    @Override
    public Set<String> getEnabledEventTypes() {
        return organization.getEnabledEventTypes();
    }

    @Override
    public void setEnabledEventTypes(Set<String> enabledEventTypes) {
        organization.setEnabledEventTypes(enabledEventTypes);
    }

    @Override
    public boolean isAdminEventsEnabled() {
        return organization.isAdminEventsEnabled();
    }

    @Override
    public void setAdminEventsEnabled(boolean enabled) {
        organization.setAdminEventsEnabled(enabled);
    }

    @Override
    public boolean isAdminEventsDetailsEnabled() {
        return organization.isAdminEventsDetailsEnabled();
    }

    @Override
    public void setAdminEventsDetailsEnabled(boolean enabled) {
        organization.setAdminEventsDetailsEnabled(enabled);
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

    @Override
    public Map<String, String> getUblSenderConfig() {
        Map<String, String> config = new HashMap<String, String>();
        config.putAll(organization.getUblSenderConfig());
        return Collections.unmodifiableMap(config);
    }

    @Override
    public void setUblSenderConfig(Map<String, String> ublSenderConfig) {
        organization.setUblSenderConfig(ublSenderConfig);
        em.flush();
    }

    @Override
    public String getKeyId() {
        PublicKey publicKey = getPublicKey();
        return publicKey != null ? JWKBuilder.create().rs256(publicKey).getKeyId() : null;
    }

    @Override
    public String getPublicKeyPem() {
        return organization.getPublicKeyPem();
    }

    @Override
    public void setPublicKeyPem(String publicKeyPem) {
        organization.setPublicKeyPem(publicKeyPem);
        em.flush();
    }

    @Override
    public String getPrivateKeyPem() {
        return organization.getPrivateKeyPem();
    }

    @Override
    public void setPrivateKeyPem(String privateKeyPem) {
        organization.setPrivateKeyPem(privateKeyPem);
        em.flush();
    }

    @Override
    public PublicKey getPublicKey() {
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
    public String getCodeSecret() {
        return organization.getCodeSecret();
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
        organization.setCodeSecret(codeSecret);
    }

    @Override
    public X509Certificate getCertificate() {
        if (certificate != null)
            return certificate;
        certificate = OpenfactModelUtils.getCertificate(getCertificatePem());
        return certificate;
    }

    @Override
    public void setCertificate(X509Certificate certificate) {
        this.certificate = certificate;
        String certificatePem = OpenfactModelUtils.getPemFromCertificate(certificate);
        setCertificatePem(certificatePem);
    }

    @Override
    public String getCertificatePem() {
        return organization.getCertificatePem();
    }

    @Override
    public void setCertificatePem(String certificate) {
        organization.setCertificatePem(certificate);
    }

    @Override
    public PrivateKey getPrivateKey() {
        if (privateKey != null)
            return privateKey;
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
    public void setAttribute(String name, String value) {
        organization.getAttributes().put(name, value);

    }

    @Override
    public void removeAttribute(String name) {
        organization.getAttributes().remove(name);
    }

    @Override
    public String getAttribute(String name) {
        return organization.getAttributes().get(name);
    }

    @Override
    public Map<String, String> getAttributes() {
        Map<String, String> copy = new HashMap<>();
        copy.putAll(organization.getAttributes());
        return copy;
    }

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
    }

    @Override
    public boolean isInternationalizationEnabled() {
        return organization.isInternationalizationEnabled();
    }

    @Override
    public void setInternationalizationEnabled(boolean enabled) {
        organization.setInternationalizationEnabled(enabled);
    }

    @Override
    public Set<String> getSupportedLocales() {
        return organization.getSupportedLocales();
    }

    @Override
    public void setSupportedLocales(Set<String> locales) {
        organization.setSupportedLocales(locales);
    }

    @Override
    public String getDefaultLocale() {
        return organization.getDefaultLocale();
    }

    @Override
    public void setDefaultLocale(String locale) {
        organization.setDefaultLocale(locale);
    }

    @Override
    public boolean isInternationalizationUblEnabled() {
        return organization.isInternationalizationUblEnabled();
    }

    @Override
    public void setInternationalizationUblEnabled(boolean enabled) {
        organization.setInternationalizationUblEnabled(enabled);
    }

    @Override
    public Set<String> getSupportedUblLocales() {
        return organization.getSupportedUblLocales();
    }

    @Override
    public void setSupportedUblLocales(Set<String> locales) {
        organization.setSupportedUblLocales(locales);
    }

    @Override
    public String getDefaultUblLocale() {
        return organization.getDefaultUblLocale();
    }

    @Override
    public void setDefaultUblLocale(String locale) {
        organization.setDefaultUblLocale(locale);
    }

    @Override
    public long getEventsExpiration() {
        return organization.getEventsExpiration();
    }

    @Override
    public void setEventsExpiration(long expiration) {
        organization.setEventsExpiration(expiration);
    }

    @Override
    public Set<String> getRequiredActions() {
        Set<String> result = new HashSet<>();
        for (OrganizationRequiredActionEntity attr : organization.getRequiredActions()) {
            result.add(attr.getAction());
        }
        return result;
    }

    @Override
    public void addRequiredAction(RequiredAction action) {
        String actionName = action.name();
        addRequiredAction(actionName);
    }

    @Override
    public void addRequiredAction(String actionName) {
        for (OrganizationRequiredActionEntity attr : organization.getRequiredActions()) {
            if (attr.getAction().equals(actionName)) {
                return;
            }
        }
        OrganizationRequiredActionEntity attr = new OrganizationRequiredActionEntity();
        attr.setAction(actionName);
        attr.setOrganization(organization);
        em.persist(attr);
        organization.getRequiredActions().add(attr);
    }

    @Override
    public void removeRequiredAction(RequiredAction action) {
        String actionName = action.name();
        removeRequiredAction(actionName);
    }

    @Override
    public void removeRequiredAction(String actionName) {
        Iterator<OrganizationRequiredActionEntity> it = organization.getRequiredActions().iterator();
        while (it.hasNext()) {
            OrganizationRequiredActionEntity attr = it.next();
            if (attr.getAction().equals(actionName)) {
                it.remove();
                em.remove(attr);
            }
        }
    }

    @Override
    public ComponentModel addComponentModel(ComponentModel model) {
        ComponentFactory componentFactory = ComponentUtil.getComponentFactory(session, model);
        if (componentFactory == null) {
            throw new IllegalArgumentException("Invalid component type");
        }

        componentFactory.validateConfiguration(session, model);

        ComponentEntity c = new ComponentEntity();
        if (model.getId() == null) {
            c.setId(OpenfactModelUtils.generateId());
        } else {
            c.setId(model.getId());
        }
        c.setName(model.getName());
        c.setParentId(model.getParentId());
        c.setProviderType(model.getProviderType());
        c.setProviderId(model.getProviderId());
        c.setSubType(model.getSubType());
        c.setOrganization(organization);
        em.persist(c);
        setConfig(model, c);
        model.setId(c.getId());
        OpenfactModelUtils.notifyCreated(session, this, model);

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
        ComponentUtil.getComponentFactory(session, component).validateConfiguration(session, component);

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
    

    private static final String BROWSER_HEADER_PREFIX = "_browser_header.";

    @Override
    public Map<String, String> getBrowserSecurityHeaders() {
        Map<String, String> attributes = getAttributes();
        if (attributes.isEmpty()) return Collections.EMPTY_MAP;
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
    
    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
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
        OrganizationModel other = (OrganizationModel) obj;
        if (getId() == null) {
            if (other.getId() != null)
                return false;
        } else if (!getId().equals(other.getId()))
            return false;
        return true;
    }

}
