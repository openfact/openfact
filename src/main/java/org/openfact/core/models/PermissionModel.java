package org.openfact.core.models;

import org.openfact.core.security.PermissionType;

public interface PermissionModel {
    PermissionType getPermission();
    OrganizationModel getOrganization();
}
