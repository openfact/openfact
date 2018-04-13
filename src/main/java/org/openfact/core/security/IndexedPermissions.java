package org.openfact.core.security;

import org.openfact.core.models.RoleMembershipModel;
import org.openfact.core.models.RoleModel;

import java.io.Serializable;
import java.util.*;

public class IndexedPermissions implements Serializable {

    private Set<String> organizations = new HashSet<>();
    private Set<String> qualifiedPermissions = new HashSet<>();
    private Map<PermissionType, Set<String>> permissionToOrganizationsMap = new HashMap<>();

    public IndexedPermissions(Set<RoleMembershipModel> memberships) {
        index(memberships);
    }

    private void index(Set<RoleMembershipModel> memberships) {
        for (RoleMembershipModel membership : memberships) {
            RoleModel role = membership.getRole();
            for (PermissionType permission : role.getPermissions()) {
                String organizationId= membership.getOrganization().getId();
                String qualifiedPermission = createQualifiedPermissionKey(permission, organizationId);
                organizations.add(organizationId);
                qualifiedPermissions.add(qualifiedPermission);
                Set<String> orgs = permissionToOrganizationsMap.computeIfAbsent(permission, k -> new HashSet<>());
                orgs.add(organizationId);
            }
        }
    }

    /**
     * Returns true if the qualified permission exists.
     * @param permissionName the permission name
     * @param organizationId the org qualifier
     * @return true if has qualified permission
     */
    public boolean hasQualifiedPermission(PermissionType permissionName, String organizationId) {
        String key = createQualifiedPermissionKey(permissionName, organizationId);
        return qualifiedPermissions.contains(key);
    }

    public boolean isMemberOf(String organizationId) {
        return organizations.contains(organizationId);
    }

    public Set<String> getOrgQualifiers(PermissionType permissionName) {
        Set<String> orgs = permissionToOrganizationsMap.get(permissionName);
        if (orgs == null) {
            orgs = Collections.emptySet();
        }
        return Collections.unmodifiableSet(orgs);
    }

    protected String createQualifiedPermissionKey(PermissionType permissionName, String organizationId) {
        return permissionName.name() + "||" + organizationId;
    }

}
