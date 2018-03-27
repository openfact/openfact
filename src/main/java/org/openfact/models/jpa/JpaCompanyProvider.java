package org.openfact.models.jpa;

import org.openfact.models.CompanyModel;
import org.openfact.models.CompanyProvider;
import org.openfact.models.UserModel;
import org.openfact.models.jpa.entities.CompanyEntity;
import org.openfact.models.utils.ModelUtils;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@ApplicationScoped
public class JpaCompanyProvider implements CompanyProvider {

    @PersistenceContext
    private EntityManager em;

    @Override
    public CompanyModel addCompany(String name, UserModel owner) {
        CompanyEntity entity = new CompanyEntity();
        entity.setId(ModelUtils.generateId());
        entity.setName(name);
        entity.setOwner(UserAdapter.toEntity(owner, em));
        em.persist(entity);
        return new CompanyAdapter(em, entity);
    }

    @Override
    public Optional<CompanyModel> getCompany(String id) {
        CompanyEntity companyEntity = em.find(CompanyEntity.class, id);
        if (companyEntity == null) return Optional.empty();
        return Optional.of(new CompanyAdapter(em, companyEntity));
    }

}
