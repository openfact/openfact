package org.openfact.core.models.jpa;

import org.openfact.core.models.RoleModel;
import org.openfact.core.models.jpa.entities.RoleEntity;
import org.openfact.core.security.PermissionType;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.Set;

public class RoleAdapter implements RoleModel, JpaModel<RoleEntity> {

    private final RoleEntity role;

    public RoleAdapter(RoleEntity role) {
        this.role = role;
    }

    public static RoleEntity toEntity(RoleModel model, EntityManager em) {
        if (model instanceof RoleAdapter) {
            return ((RoleAdapter)model).getEntity();
        }
        return em.getReference(RoleEntity.class, model.getId());
    }

    @Override
    public RoleEntity getEntity() {
        return role;
    }

    @Override
    public String getId() {
        return role.getId();
    }

    @Override
    public String getName() {
        return role.getName();
    }

    @Override
    public void setName(String name) {
        role.setName(name);
    }

    @Override
    public Set<PermissionType> getPermissions() {
        return new HashSet<>(role.getPermissions());
    }

    @Override
    public void setPermissions(Set<PermissionType> permissions) {
        role.setPermissions(permissions);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RoleModel other = (RoleModel) obj;
        if (getId() == null) {
            if (other.getId() != null)
                return false;
        } else if (!getId().equals(other.getId()))
            return false;
        return true;
    }
}
