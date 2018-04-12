package org.openfact.core.security;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractSecurityContext implements ISecurityContext {

    public static final ThreadLocal<HttpServletRequest> servletRequest = new ThreadLocal<>();
    private static final ThreadLocal<IndexedPermissions> permissions = new ThreadLocal<>();

    @Override
    public boolean hasPermission(PermissionType permission, String organizationId) {
//        // Admins can do everything.
//        if (isAdmin())
//            return true;
//        return getPermissions().hasQualifiedPermission(permission, organizationId);
        return false;
    }

    /**
     * @return the user permissions for the current user
     */
//    private IndexedPermissions getPermissions() {
//        IndexedPermissions rval = permissions.get();
//        if (rval == null) {
//            rval = loadPermissions();
//            permissions.set(rval);
//        }
//        return rval;
//    }

    @Override
    public boolean isMemberOf(String organizationId) {
        return false;
    }

    @Override
    public Set<String> getPermittedOrganizations(PermissionType permission) {
        return null;
    }

    /**
     * Loads the current user's permissions into a thread local variable.
     */
//    private IndexedPermissions loadPermissions() {
//        String userId = getCurrentUser();
//        try {
//            return new IndexedPermissions(getQuery().getPermissions(userId));
//        } catch (StorageException e) {
//            logger.error(Messages.getString("AbstractSecurityContext.ErrorLoadingPermissions") + userId, e); //$NON-NLS-1$
//            return new IndexedPermissions(new HashSet<>());
//        }
//    }


    protected static void setServletRequest(HttpServletRequest request) {
        servletRequest.set(request);
    }

    protected static void clearServletRequest() {
        servletRequest.remove();
    }

}
