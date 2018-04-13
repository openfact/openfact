package org.openfact.core.security;

import org.openfact.core.models.RoleMembershipModel;
import org.openfact.core.models.RoleMembershipProvider;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.Set;

public abstract class AbstractSecurityContext implements ISecurityContext {

    public static final ThreadLocal<HttpServletRequest> servletRequest = new ThreadLocal<>();
    private static final ThreadLocal<IndexedPermissions> permissions = new ThreadLocal<>();

    @Inject
    private RoleMembershipProvider membershipProvider;

    @Override
    public boolean hasPermission(PermissionType permission, String organizationId) {
        // Admins can do everything.
        if (isAdmin())
            return true;
        return getPermissions().hasQualifiedPermission(permission, organizationId);
    }

    @Override
    public boolean isMemberOf(String organizationId) {
        if (isAdmin()) {
            return true;
        }
        return getPermissions().isMemberOf(organizationId);
    }

    @Override
    public Set<String> getPermittedOrganizations(PermissionType permission) {
        return getPermissions().getOrgQualifiers(permission);
    }

    private IndexedPermissions getPermissions() {
        IndexedPermissions rval = permissions.get();
        if (rval == null) {
            rval = loadPermissions();
            permissions.set(rval);
        }
        return rval;
    }

    private IndexedPermissions loadPermissions() {
        String identityId = getIdentityId();
        Set<RoleMembershipModel> permissions = membershipProvider.getMembershipsByIdentityId(identityId);
        return new IndexedPermissions(permissions);
    }

    protected static void clearPermissions() {
        permissions.remove();
    }

    protected static void setServletRequest(HttpServletRequest request) {
        servletRequest.set(request);
    }

    protected static void clearServletRequest() {
        servletRequest.remove();
    }

}
