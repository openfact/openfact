package org.openfact.models.jpa;

import org.openfact.models.CompanyModel;
import org.openfact.models.ModelType;
import org.openfact.models.jpa.entities.CompanyEntity;

import javax.persistence.EntityManager;

public class CompanyAdapter implements CompanyModel {

    private final EntityManager em;
    private final CompanyEntity company;

    public CompanyAdapter(EntityManager em, CompanyEntity company) {
        this.em = em;
        this.company = company;
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
}
