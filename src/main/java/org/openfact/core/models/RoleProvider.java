package org.openfact.core.models;

import org.openfact.core.security.PermissionType;

import java.util.Optional;
import java.util.Set;

public interface RoleProvider {

    RoleModel addRole(String name, Set<PermissionType> permissions, boolean autoGrant);

    RoleModel addRole(String id, String name, Set<PermissionType> permissions, boolean autoGrant);

    Optional<RoleModel> getRole(String id);

    Set<RoleModel> getAutoGrantedRoles();

    boolean deleteRole(RoleModel role);

}
