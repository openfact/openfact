package org.openfact.services.resources.security;

import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.representations.AccessToken;
import org.openfact.models.AdminRoles;
import org.openfact.models.OrganizationModel;
import org.openfact.models.OrganizationProvider;
import org.openfact.services.ForbiddenException;
import org.openfact.services.resource.security.OrganizationAuth;
import org.openfact.services.resource.security.Resource;
import org.openfact.services.resource.security.SecurityContextProvider;
import org.openfact.services.resource.security.UserContextModel;

@Stateless
public class KeycloakSecurityContextProvider implements SecurityContextProvider {

    public static final String KEYCLOAK_ORGANIZATION_USER_ATTRIBUTE = "organization";
    public static final String KEYCLOAK_CLIENT = "openfact-restful-api";

    @Context
    private HttpServletRequest httpRequest;

    @Inject
    private OrganizationProvider provider;

    private AccessToken accessToken;
    private OrganizationModel clientOrganization;

    @PostConstruct
    private void init() {
        KeycloakPrincipal<KeycloakSecurityContext> kcPrincipal = (KeycloakPrincipal<KeycloakSecurityContext>) httpRequest.getUserPrincipal();
        accessToken = kcPrincipal.getKeycloakSecurityContext().getToken();
    }

    @Override
    public OrganizationModel getCurrentOrganization() {
        if (clientOrganization == null) {
            String organizationName = getCurrentOrganizationName();
            if (organizationName != null) {
                clientOrganization = provider.getOrganizationByName(organizationName);
            }
        }
        return clientOrganization;
    }

    @Override
    public UserContextModel getCurrentUser() {
        return new UserContextModel() {
            @Override
            public String getUsername() {
                return accessToken.getPreferredUsername();
            }

            @Override
            public boolean hasOrganizationRole(String role) {
                return hasRole(role);
            }

            @Override
            public boolean hasOneOfOrganizationRole(String... roles) {
                for (String r : roles) {
                    if (hasOrganizationRole(r)) {
                        return true;
                    }
                }
                return false;
            }

            @Override
            public boolean hasAppRole(String role) {
                return hasRole(role);
            }

            @Override
            public boolean hasOneOfAppRole(String... roles) {
                for (String r : roles) {
                    if (hasAppRole(r)) {
                        return true;
                    }
                }
                return false;
            }

            @Override
            public OrganizationAuth organizationAuth(Resource resource) {
                return new KeycloakOrganizationAuth(resource);
            }
        };
    }

    private String getCurrentOrganizationName() {
        Map<String, Object> otherClaims = accessToken.getOtherClaims();
        if (otherClaims.containsKey(KEYCLOAK_ORGANIZATION_USER_ATTRIBUTE)) {
            return String.valueOf(otherClaims.get(KEYCLOAK_ORGANIZATION_USER_ATTRIBUTE));
        } else {
            return null;
        }
    }

    private boolean hasRole(String role) {
        Set<String> organizationRoles = accessToken.getRealmAccess().getRoles();
        Set<String> applicationRoles = accessToken.getResourceAccess(KEYCLOAK_CLIENT).getRoles();
        return organizationRoles.contains(role) || applicationRoles.contains(role);
    }

    public class KeycloakOrganizationAuth implements OrganizationAuth {

        private Resource resource;

        public KeycloakOrganizationAuth(Resource resource) {
            this.resource = resource;
        }

        public KeycloakOrganizationAuth init(Resource resource) {
            this.resource = resource;
            return this;
        }

        @Override
        public void requireAny() {
            if (!getCurrentUser().hasOneOfAppRole(AdminRoles.ALL_ORGANIZATION_ROLES)) {
                throw new ForbiddenException();
            }
        }

        @Override
        public boolean hasView() {
            return getCurrentUser().hasOneOfAppRole(getViewRole(resource), getManageRole(resource));
        }

        @Override
        public boolean hasManage() {
            return getCurrentUser().hasOneOfAppRole(getManageRole(resource));
        }

        @Override
        public void requireView() {
            if (!hasView()) {
                throw new ForbiddenException();
            }
        }

        @Override
        public void requireManage() {
            if (!hasManage()) {
                throw new ForbiddenException();
            }
        }

        private String getViewRole(Resource resource) {
            switch (resource) {
                case ORGANIZATION:
                    return AdminRoles.VIEW_ORGANIZATION;
                case DOCUMENT:
                    return AdminRoles.VIEW_DOCUMENTS;
                case EVENTS:
                    return AdminRoles.VIEW_EVENTS;
                case FILES:
                    return AdminRoles.VIEW_FILES;
                case REPORTS:
                    return AdminRoles.VIEW_REPORTS;
                default:
                    throw new IllegalStateException();
            }
        }

        private String getManageRole(Resource resource) {
            switch (resource) {
                case ORGANIZATION:
                    return AdminRoles.MANAGE_ORGANIZATION;
                case DOCUMENT:
                    return AdminRoles.MANAGE_DOCUMENTS;
                case EVENTS:
                    return AdminRoles.MANAGE_EVENTS;
                case FILES:
                    return AdminRoles.MANAGE_FILES;
                case REPORTS:
                    return AdminRoles.MANAGE_REPORTS;
                default:
                    throw new IllegalStateException();
            }
        }
    }

}
