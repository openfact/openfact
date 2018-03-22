package org.openfact.models.jpa;

import org.openfact.models.CompanyModel;
import org.openfact.models.CompanyProvider;
import org.openfact.models.jpa.entities.CompanyEntity;
import org.openfact.models.utils.ModelUtils;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class JpaCompanyProvider implements CompanyProvider {

    @PersistenceContext
    private EntityManager em;

    @Override
    public CompanyModel addCompany(String name) {
        CompanyEntity entity = new CompanyEntity();
        entity.setId(ModelUtils.generateId());
        entity.setName(name);
        em.persist(entity);
        return new CompanyAdapter(em, entity);
    }

}
