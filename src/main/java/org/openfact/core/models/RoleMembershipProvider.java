package org.openfact.core.models;

import java.util.Set;

public interface RoleMembershipProvider {

    RoleMembershipModel addRoleMembership(UserModel user, RoleModel role, OrganizationModel organization);

    Set<RoleMembershipModel> getMemberships(UserModel user);

    Set<RoleMembershipModel> getMemberships(UserModel user, OrganizationModel organization);

    Set<RoleMembershipModel> getMemberships(OrganizationModel organization);

    Set<RoleMembershipModel> getMembershipsByUsername(String username);

    Set<RoleMembershipModel> getMembershipsByIdentityId(String identityId);

    boolean removeRoleMembership(RoleMembershipModel roleMembership);

}
