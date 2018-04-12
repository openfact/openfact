package org.openfact.core.security;

import java.util.Set;

public interface ISecurityContext {

    String getUsername();

    String getEmail();

    String getFullName();

    String getIdentityId();

    String getIdentityProviderAlias();

    /**
     * Returns true if the current user is an administrator.
     * @return true if admin, else false
     */
    public boolean isAdmin();

    /**
     * Returns true if the current user has permission to perform a particular
     * action for the provided organization.
     * @param permission the permission type
     * @param organizationId the org id
     * @return true if has permission, else false
     */
    public boolean hasPermission(PermissionType permission, String organizationId);

    /**
     * @param organizationId
     */
    public boolean isMemberOf(String organizationId);

    /**
     * Returns the set of organizations for which the current user is allowed
     * to perform a given action.
     * @param permission the permission type
     * @return set of permitted organizations
     */
    public Set<String> getPermittedOrganizations(PermissionType permission);

    String getRequestHeader(String headerName);

    Object getAttribute(String attributeName);
}
