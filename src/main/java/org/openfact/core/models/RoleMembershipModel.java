package org.openfact.core.models;

public interface RoleMembershipModel {
    String getId();
    UserModel getUser();
    RoleModel getRole();
    OrganizationModel getOrganization();
}
