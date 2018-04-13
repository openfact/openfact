package org.openfact.core.models.jpa;

import org.openfact.core.models.OrganizationModel;
import org.openfact.core.models.RoleMembershipModel;
import org.openfact.core.models.RoleModel;
import org.openfact.core.models.UserModel;
import org.openfact.core.models.jpa.entities.RoleEntity;
import org.openfact.core.models.jpa.entities.RoleMembershipEntity;
import org.openfact.core.security.PermissionType;

import javax.persistence.EntityManager;

public class RoleMembershipAdapter implements RoleMembershipModel, JpaModel<RoleMembershipEntity> {

    private final RoleMembershipEntity roleMembership;

    public RoleMembershipAdapter(RoleMembershipEntity roleMembership) {
        this.roleMembership = roleMembership;
    }

    public static RoleMembershipEntity toEntity(RoleMembershipModel model, EntityManager em) {
        if (model instanceof RoleMembershipAdapter) {
            return ((RoleMembershipAdapter)model).getEntity();
        }
        return em.getReference(RoleMembershipEntity.class, model.getId());
    }

    @Override
    public RoleMembershipEntity getEntity() {
        return roleMembership;
    }

    @Override
    public String getId() {
        return roleMembership.getId();
    }

    @Override
    public UserModel getUser() {
        return new UserAdapter(roleMembership.getUser());
    }

    @Override
    public RoleModel getRole() {
        return new RoleAdapter(roleMembership.getRole());
    }

    @Override
    public OrganizationModel getOrganization() {
        return new OrganizationAdapter(roleMembership.getOrganization());
    }
}
