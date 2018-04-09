package org.openfact.core.models.jpa;

import org.openfact.core.models.ModelType;
import org.openfact.core.models.OrganizationModel;
import org.openfact.core.models.UserModel;
import org.openfact.core.models.jpa.entities.OrganizationEntity;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public class OrganizationAdapter implements OrganizationModel, JpaModel<OrganizationEntity> {

    private final EntityManager em;
    private final OrganizationEntity organization;

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
    public ModelType getType() {
        return ModelType.ORGANIZATION;
    }

    @Override
    public String getName() {
        return organization.getName();
    }

    @Override
    public void setName(String name) {
        organization.setName(name);
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
    public boolean getUseCustomCertificates() {
        return organization.isUseCustomCertificates();
    }

    @Override
    public void setUseCustomCertificates(boolean useCustomCertificates) {
        organization.setUseCustomCertificates(useCustomCertificates);
    }

    @Override
    public boolean getUseCustomSmtpConfig() {
        return organization.isUseCustomSmtpConfig();
    }

    @Override
    public void setUseCustomSmtpConfig(boolean useCustomSmtpConfig) {
        organization.setUseCustomSmtpConfig(useCustomSmtpConfig);
    }

    @Override
    public Map<String, String> getSmtpConfig() {
        Map<String, String> config = new HashMap<>();
        config.putAll(organization.getSmtpConfig());
        return Collections.unmodifiableMap(config);
    }

    @Override
    public void setSmtpConfig(Map<String, String> smtpConfig) {
        organization.setSmtpConfig(smtpConfig);
    }

    @Override
    public UserModel getOwner() {
        return new UserAdapter(em, organization.getOwner());
    }

    @Override
    public TimeZone getTimeZone() {
        return TimeZone.getTimeZone(organization.getTimeZone());
    }
}
