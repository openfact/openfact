package org.openfact.core.models.jpa;

import org.openfact.core.models.ModelType;
import org.openfact.core.models.OrganizationModel;
import org.openfact.core.models.UserModel;
import org.openfact.core.models.jpa.entities.OrganizacionEntity;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class OrganizationAdapter implements OrganizationModel, JpaModel<OrganizacionEntity> {

    private final EntityManager em;
    private final OrganizacionEntity company;

    public OrganizationAdapter(EntityManager em, OrganizacionEntity company) {
        this.em = em;
        this.company = company;
    }

    public static OrganizacionEntity toEntity(OrganizationModel model, EntityManager em) {
        if (model instanceof OrganizationAdapter) {
            return ((OrganizationAdapter) model).getEntity();
        }
        return em.getReference(OrganizacionEntity.class, model.getId());
    }

    @Override
    public OrganizacionEntity getEntity() {
        return company;
    }

    @Override
    public String getId() {
        return company.getId();
    }

    @Override
    public ModelType getType() {
        return ModelType.COMPANY;
    }

    @Override
    public String getName() {
        return company.getName();
    }

    @Override
    public void setName(String name) {
        company.setName(name);
    }

    @Override
    public String getDescription() {
        return company.getDescription();
    }

    @Override
    public void setDescription(String description) {
        company.setDescription(description);
    }

    @Override
    public boolean getUseCustomCertificates() {
        return company.isUseCustomCertificates();
    }

    @Override
    public void setUseCustomCertificates(boolean useCustomCertificates) {
        company.setUseCustomCertificates(useCustomCertificates);
    }

    @Override
    public boolean getUseCustomSmtpConfig() {
        return company.isUseCustomSmtpConfig();
    }

    @Override
    public void setUseCustomSmtpConfig(boolean useCustomSmtpConfig) {
        company.setUseCustomSmtpConfig(useCustomSmtpConfig);
    }

    @Override
    public Map<String, String> getSmtpConfig() {
        Map<String, String> config = new HashMap<>();
        config.putAll(company.getSmtpConfig());
        return Collections.unmodifiableMap(config);
    }

    @Override
    public void setSmtpConfig(Map<String, String> smtpConfig) {
        company.setSmtpConfig(smtpConfig);
    }

    @Override
    public UserModel getOwner() {
        return new UserAdapter(em, company.getOwner());
    }
}
