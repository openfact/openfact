package org.openfact.core.models;

import java.util.Set;

public interface RoleModel {

    String OWNER_ID = "owner";
    String COLLABORATOR_ID = "collaborator";

    String getId();

    String getName();
    void setName(String name);

    boolean isAutoGrant();
    void setAutoGrant(boolean autoGrant);

    Set<PermissionType> getPermissions();
    void setPermissions(Set<PermissionType> permissions);
}
