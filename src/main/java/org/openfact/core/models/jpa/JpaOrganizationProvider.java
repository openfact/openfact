package org.openfact.core.models.jpa;

import org.openfact.core.models.OrganizationModel;
import org.openfact.core.models.OrganizationProvider;
import org.openfact.core.models.UserModel;
import org.openfact.core.models.jpa.entities.OrganizationEntity;
import org.openfact.core.models.utils.ModelUtils;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.TimeZone;

@Transactional
@ApplicationScoped
public class JpaOrganizationProvider implements OrganizationProvider {

    @PersistenceContext
    private EntityManager em;

    @Override
    public OrganizationModel addOrganization(String id, String name) {
        OrganizationEntity entity = new OrganizationEntity();
        entity.setId(id);
        entity.setName(name);
        entity.setTimeZone(TimeZone.getDefault().toString());
        em.persist(entity);

        return new OrganizationAdapter(entity);
    }

    @Override
    public OrganizationModel addOrganization(String name, UserModel owner) {
        OrganizationEntity entity = new OrganizationEntity();
        entity.setId(ModelUtils.generateId());
        entity.setName(name);
        entity.setTimeZone(TimeZone.getDefault().toString());
        entity.setOwner(UserAdapter.toEntity(owner, em));
        em.persist(entity);

        return new OrganizationAdapter(entity);
    }

    @Override
    public Optional<OrganizationModel> getOrganization(String id) {
        OrganizationEntity organizationEntity = em.find(OrganizationEntity.class, id);
        if (organizationEntity == null) return Optional.empty();
        return Optional.of(new OrganizationAdapter(organizationEntity));
    }

}
