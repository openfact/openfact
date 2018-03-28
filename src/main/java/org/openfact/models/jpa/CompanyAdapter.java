package org.openfact.models.jpa;

import org.openfact.models.CompanyModel;
import org.openfact.models.ModelType;
import org.openfact.models.UserModel;
import org.openfact.models.jpa.entities.CompanyEntity;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CompanyAdapter implements CompanyModel, JpaModel<CompanyEntity> {

    private final EntityManager em;
    private final CompanyEntity company;

    public CompanyAdapter(EntityManager em, CompanyEntity company) {
        this.em = em;
        this.company = company;
    }

    public static CompanyEntity toEntity(CompanyModel model, EntityManager em) {
        if (model instanceof CompanyAdapter) {
            return ((CompanyAdapter) model).getEntity();
        }
        return em.getReference(CompanyEntity.class, model.getId());
    }

    @Override
    public CompanyEntity getEntity() {
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
