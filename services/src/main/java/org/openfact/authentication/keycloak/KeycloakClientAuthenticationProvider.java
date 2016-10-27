package org.openfact.authentication.keycloak;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;

import org.keycloak.AuthorizationContext;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.representations.AccessToken;
import org.openfact.authentication.AuthenticationProvider;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.UserModel;

public class KeycloakClientAuthenticationProvider implements AuthenticationProvider {

    protected OpenfactSession session;

    public KeycloakClientAuthenticationProvider(OpenfactSession session) {
        this.session = session;
    }

    @Override
    public void close() {
        // TODO Auto-generated method stub

    }

    @Override
    public String getOrganizationName(HttpHeaders headers, HttpServletRequest request) {
        KeycloakPrincipal kcPrincipal = (KeycloakPrincipal) request.getUserPrincipal();
        AccessToken accessToken = kcPrincipal.getKeycloakSecurityContext().getToken();
        Map<String, Object> otherClaims = accessToken.getOtherClaims();
        if (otherClaims.containsKey(OrganizationModel.NAME)) {
            return String.valueOf(otherClaims.get(OrganizationModel.NAME));
        }
        return null;
    }

    @Override
    public UserModel getUser(HttpHeaders headers, HttpServletRequest request) {
        KeycloakPrincipal kcPrincipal = (KeycloakPrincipal) request.getUserPrincipal();
        KeycloakSecurityContext kcSecurityContext = kcPrincipal.getKeycloakSecurityContext();
        AccessToken accessToken = kcSecurityContext.getToken();
        AuthorizationContext authContext = kcSecurityContext.getAuthorizationContext();

        return new UserModel() {

            @Override
            public String getUsername() {
                return accessToken.getPreferredUsername();
            }

            @Override
            public String getFirstName() {
                return accessToken.getFamilyName();
            }

            @Override
            public String getLastName() {
                return accessToken.getFamilyName();
            }

            @Override
            public String getFullName() {
                return accessToken.getName();
            }

            @Override
            public String getEmail() {
                return accessToken.getEmail();
            }

            @Override
            public Map<String, Object> getAttributes() {
                return accessToken.getOtherClaims();
            }

            @Override
            public boolean hasRole(String role) {
                return authContext.hasResourcePermission(role);
            }

        };
    }

}
