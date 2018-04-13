package org.openfact.core.models;

import org.openfact.core.security.PermissionType;

import java.util.Set;

public interface RoleModel {

    String OWNER_ID = "owner";
    String COLLABORATOR_ID = "collaborator";

    String getId();

    String getName();
    void setName(String name);

    Set<PermissionType> getPermissions();
    void setPermissions(Set<PermissionType> permissions);
}
