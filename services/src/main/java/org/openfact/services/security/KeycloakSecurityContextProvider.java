package org.openfact.services.security;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.representations.AccessToken;
import org.openfact.models.AdminRoles;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.OrganizationProvider;
import org.openfact.services.ForbiddenException;
import org.openfact.services.resource.security.OrganizationAuth;
import org.openfact.services.resource.security.Resource;
import org.openfact.services.resource.security.SecurityContextProvider;
import org.openfact.services.resource.security.UserContextModel;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

@Stateless
public class KeycloakSecurityContextProvider implements SecurityContextProvider {

    public static final String KEYCLOAK_ORGANIZATION_USER_ATTRIBUTE = "organization";
    public static final String KEYCLOAK_CLIENT = "openfact-restful-api";

    @Inject
    private OrganizationProvider provider;

    private AccessToken accessToken;
    private List<OrganizationModel> permitedOrganizations;

    private void init(OpenfactSession session) {
        HttpServletRequest httpServletRequest = session.getContext().getContextObject(HttpServletRequest.class);
        KeycloakPrincipal<KeycloakSecurityContext> kcPrincipal = (KeycloakPrincipal<KeycloakSecurityContext>) httpServletRequest.getUserPrincipal();

        if (kcPrincipal != null) {
            accessToken = kcPrincipal.getKeycloakSecurityContext().getToken();
        } else {
            throw new IllegalStateException("Could not instantiate KeycloakSecurityContext, check if you installed Keycloak adapter");
        }
    }

    @Override
    public List<OrganizationModel> getPermitedOrganizations(OpenfactSession session) {
        init(session);
        if (permitedOrganizations == null) {
            Collection<String> organizationsName = getPermitedOrganizationNames();
            if (!organizationsName.isEmpty()) {
                permitedOrganizations = organizationsName.stream()
                        .map(name -> provider.getOrganizationByName(name))
                        .collect(Collectors.toList());
            }
        }
        return permitedOrganizations;
    }

    @Override
    public UserContextModel getCurrentUser(OpenfactSession session) {
        init(session);
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
                return new KeycloakOrganizationAuth(session, resource);
            }
        };
    }

    private Collection<String> getPermitedOrganizationNames() {
        Map<String, Object> otherClaims = accessToken.getOtherClaims();
        if (otherClaims.containsKey(KEYCLOAK_ORGANIZATION_USER_ATTRIBUTE)) {
            Object object = otherClaims.get(KEYCLOAK_ORGANIZATION_USER_ATTRIBUTE);
            if (object instanceof Collection) {
                return (Collection<String>) object;
            } else {
                return Arrays.asList((String) object);
            }
        }
        return Collections.EMPTY_LIST;
    }

    private boolean hasRole(String role) {
        Set<String> organizationRoles = accessToken.getRealmAccess().getRoles();
        Set<String> applicationRoles = accessToken.getResourceAccess(KEYCLOAK_CLIENT).getRoles();
        return organizationRoles.contains(role) || applicationRoles.contains(role);
    }

    public class KeycloakOrganizationAuth implements OrganizationAuth {

        private OpenfactSession session;
        private Resource resource;

        public KeycloakOrganizationAuth(OpenfactSession session, Resource resource) {
            this.session = session;
            this.resource = resource;
        }

        public KeycloakOrganizationAuth init(Resource resource) {
            this.resource = resource;
            return this;
        }

        @Override
        public void requireAny() {
            if (!getCurrentUser(session).hasOneOfAppRole(AdminRoles.ALL_ORGANIZATION_ROLES)) {
                throw new ForbiddenException();
            }
        }

        @Override
        public boolean hasView() {
            return getCurrentUser(session).hasOneOfAppRole(getViewRole(resource), getManageRole(resource));
        }

        @Override
        public boolean hasManage() {
            return getCurrentUser(session).hasOneOfAppRole(getManageRole(resource));
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
