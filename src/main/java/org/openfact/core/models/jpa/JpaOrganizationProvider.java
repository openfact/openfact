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

@Transactional
@ApplicationScoped
public class JpaOrganizationProvider implements OrganizationProvider {

    @PersistenceContext
    private EntityManager em;

    @Inject
    private Event<OrganizationEntity> organizationEntityEvent;

    @Override
    public OrganizationModel addOrganization(String name, UserModel owner) {
        OrganizationEntity entity = new OrganizationEntity();
        entity.setId(ModelUtils.generateId());
        entity.setName(name);
        entity.setOwner(UserAdapter.toEntity(owner, em));
        em.persist(entity);

        organizationEntityEvent.fire(entity);

        return new OrganizationAdapter(em, entity);
    }

    @Override
    public Optional<OrganizationModel> getOrganization(String id) {
        OrganizationEntity organizationEntity = em.find(OrganizationEntity.class, id);
        if (organizationEntity == null) return Optional.empty();
        return Optional.of(new OrganizationAdapter(em, organizationEntity));
    }

}
