package org.openfact.core.models.jpa;

import org.openfact.core.models.*;
import org.openfact.core.models.jpa.entities.RoleMembershipEntity;
import org.openfact.core.models.utils.ModelUtils;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Transactional
@ApplicationScoped
public class JpaRoleMembershipProvider implements RoleMembershipProvider {

    @PersistenceContext
    private EntityManager em;

    @Inject
    private Event<ModelCreationEvent<RoleMembershipModel>> creationEvent;

    @Inject
    private Event<ModelRemoveEvent<RoleMembershipModel>> removeEvent;

    @Override
    public RoleMembershipModel addRoleMembership(UserModel user, RoleModel role, OrganizationModel organization) {
        RoleMembershipEntity entity = new RoleMembershipEntity();
        entity.setId(ModelUtils.generateId());
        entity.setCreatedOn(new Date());
        entity.setUser(UserAdapter.toEntity(user, em));
        entity.setRole(RoleAdapter.toEntity(role, em));
        entity.setOrganization(OrganizationAdapter.toEntity(organization, em));

        em.persist(entity);

        final RoleMembershipAdapter roleMembership = new RoleMembershipAdapter(entity);
        creationEvent.fire(() -> roleMembership);
        return roleMembership;
    }

    @Override
    public Set<RoleMembershipModel> getMemberships(UserModel user) {
        TypedQuery<RoleMembershipEntity> typedQuery = em.createNamedQuery("getRoleMembershipsByUserId", RoleMembershipEntity.class);
        typedQuery.setParameter("userId", user.getId());
        return typedQuery.getResultList().stream()
                .map(RoleMembershipAdapter::new)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<RoleMembershipModel> getMemberships(UserModel user, OrganizationModel organization) {
        TypedQuery<RoleMembershipEntity> typedQuery = em.createNamedQuery("getRoleMembershipsByUserIdAndOrganizationId", RoleMembershipEntity.class);
        typedQuery.setParameter("userId", user.getId());
        typedQuery.setParameter("organizationId", organization.getId());
        return typedQuery.getResultList().stream()
                .map(RoleMembershipAdapter::new)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<RoleMembershipModel> getMemberships(OrganizationModel organization) {
        TypedQuery<RoleMembershipEntity> typedQuery = em.createNamedQuery("getRoleMembershipsByOrganizationId", RoleMembershipEntity.class);
        typedQuery.setParameter("organizationId", organization.getId());
        return typedQuery.getResultList().stream()
                .map(RoleMembershipAdapter::new)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<RoleMembershipModel> getMembershipsByUsername(String username) {
        TypedQuery<RoleMembershipEntity> typedQuery = em.createNamedQuery("getRoleMembershipsByUserUsername", RoleMembershipEntity.class);
        typedQuery.setParameter("username", username);
        return typedQuery.getResultList().stream()
                .map(RoleMembershipAdapter::new)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<RoleMembershipModel> getMembershipsByIdentityId(String identityId) {
        TypedQuery<RoleMembershipEntity> typedQuery = em.createNamedQuery("getRoleMembershipsByUserIdentityId", RoleMembershipEntity.class);
        typedQuery.setParameter("identityId", identityId);
        return typedQuery.getResultList().stream()
                .map(RoleMembershipAdapter::new)
                .collect(Collectors.toSet());
    }

    @Override
    public boolean removeRoleMembership(RoleMembershipModel roleMembership) {
        RoleMembershipEntity entity = RoleMembershipAdapter.toEntity(roleMembership, em);
        em.remove(entity);
        removeEvent.fire(() -> roleMembership);
        return true;
    }
}
