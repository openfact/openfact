package org.openfact.security.keycloak;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;

import org.openfact.models.OpenfactSession;
import org.openfact.models.UserModel;
import org.openfact.security.AbstractSecurityContext;

public class KeycloakSecurityContextProvider extends AbstractSecurityContext {

    protected OpenfactSession session;

    public KeycloakSecurityContextProvider(OpenfactSession session) {
        this.session = session;
    }

    @Override
    public String getCurrentOrganizationName(HttpHeaders headers) {
        HttpServletRequest request = servletRequest.get();
        org.keycloak.KeycloakPrincipal kcPrincipal = (org.keycloak.KeycloakPrincipal) request.getUserPrincipal();
        org.keycloak.representations.AccessToken accessToken = kcPrincipal.getKeycloakSecurityContext().getToken();

        Map<String, Object> otherClaims = accessToken.getOtherClaims();
        if (otherClaims.containsKey("organization")) {
            return String.valueOf(otherClaims.get("organization"));
        } else {
            return null;
        }
    }

    @Override
    public UserModel getCurrentUser(HttpHeaders headers) {
        HttpServletRequest request = servletRequest.get();
        
        return new UserModel() {

            @Override
            public boolean hasRole(String role) {
                org.keycloak.KeycloakPrincipal kcPrincipal = (org.keycloak.KeycloakPrincipal) request.getUserPrincipal();
                org.keycloak.representations.AccessToken accessToken = kcPrincipal.getKeycloakSecurityContext().getToken();

                Set<String> realmRoles = accessToken.getRealmAccess().getRoles();
                Set<String> applicationRoles = accessToken.getResourceAccess("openfact").getRoles();
                return realmRoles.contains(role) || applicationRoles.contains(role);
            }

            @Override
            public String getUsername() {
                return request.getRemoteUser();
            }

            @Override
            public String getLastName() {
                org.keycloak.KeycloakPrincipal kcPrincipal = (org.keycloak.KeycloakPrincipal) request.getUserPrincipal();
                org.keycloak.representations.AccessToken accessToken = kcPrincipal.getKeycloakSecurityContext().getToken();
                return accessToken.getFamilyName();
            }

            @Override
            public String getFullName() {
                org.keycloak.KeycloakSecurityContext session = (org.keycloak.KeycloakSecurityContext) request.getAttribute(org.keycloak.KeycloakSecurityContext.class.getName());
                if (session != null) {
                    return session.getToken().getName();
                } else {
                    return null;
                }
            }

            @Override
            public String getFirstName() {
                org.keycloak.KeycloakPrincipal kcPrincipal = (org.keycloak.KeycloakPrincipal) request.getUserPrincipal();
                org.keycloak.representations.AccessToken accessToken = kcPrincipal.getKeycloakSecurityContext().getToken();
                return accessToken.getName();
            }

            @Override
            public String getEmail() {
                org.keycloak.KeycloakSecurityContext session = (org.keycloak.KeycloakSecurityContext) request.getAttribute(org.keycloak.KeycloakSecurityContext.class.getName());
                if (session != null) {
                    return session.getToken().getEmail();
                } else {
                    return null;
                }
            }

            @Override
            public Map<String, Object> getAttributes() {
                org.keycloak.KeycloakPrincipal kcPrincipal = (org.keycloak.KeycloakPrincipal) request.getUserPrincipal();
                org.keycloak.representations.AccessToken accessToken = kcPrincipal.getKeycloakSecurityContext().getToken();
                return accessToken.getOtherClaims();
            }
        };
    }

    @Override
    public void close() {
    }

}
