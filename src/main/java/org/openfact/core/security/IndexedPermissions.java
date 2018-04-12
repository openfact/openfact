package org.openfact.core.security;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IndexedPermissions implements Serializable {

    private Set<String> organizations = new HashSet<>();
    private Set<String> qualifiedPermissions = new HashSet<>();
    private Map<PermissionType, Set<String>> permissionToOrgsMap = new HashMap<>();

//
//    public IndexedPermissions(Map<PermissionType, String> permissions) {
//        index(permissions);
//    }

//    private void index(Set<PermissionBean> permissions) {
//        for (PermissionBean permissionBean : permissions) {
//            PermissionType permissionName = permissionBean.getName();
//            String orgQualifier = permissionBean.getOrganizationId();
//            String qualifiedPermission = createQualifiedPermissionKey(permissionName, orgQualifier);
//            organizations.add(orgQualifier);
//            qualifiedPermissions.add(qualifiedPermission);
//            Set<String> orgs = permissionToOrgsMap.get(permissionName);
//            if (orgs == null) {
//                orgs = new HashSet<>();
//                permissionToOrgsMap.put(permissionName, orgs);
//            }
//            orgs.add(orgQualifier);
//        }
//    }


}
