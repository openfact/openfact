package org.openfact.authentication.keycloak;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.representations.AccessToken;
import org.openfact.authentication.ClientAuthenticatorProvider;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.UserModel;
import org.openfact.services.managers.OrganizationManager;

public class KeycloakClientAuthenticatorProvider implements ClientAuthenticatorProvider {

    protected OpenfactSession session;

    public KeycloakClientAuthenticatorProvider(OpenfactSession session) {
        this.session = session;
    }

    @Override
    public void close() {
        // TODO Auto-generated method stub

    }

    @Override
    public OrganizationModel getOrganization(HttpHeaders headers, HttpServletRequest request) {
        KeycloakPrincipal keycloakPrincipal = (KeycloakPrincipal) request.getUserPrincipal();
        AccessToken accessToken = keycloakPrincipal.getKeycloakSecurityContext().getToken();

        Map<String, Object> otherClaims = accessToken.getOtherClaims();
        if (otherClaims.containsKey(OrganizationModel.NAME)) {
            String organizationName = String.valueOf(otherClaims.get(OrganizationModel.NAME));
            
            OrganizationManager organizationManager = new OrganizationManager(session);
            return organizationManager.getOrganizationByName(organizationName);
        } 
        return null;      
    }

    @Override
    public UserModel getUser(HttpHeaders headers, HttpServletRequest request) {
        KeycloakPrincipal keycloakPrincipal = (KeycloakPrincipal) request.getUserPrincipal();
        AccessToken accessToken = keycloakPrincipal.getKeycloakSecurityContext().getToken();

        String username = accessToken.getPreferredUsername();
        String fullName = accessToken.getName();
        String email = accessToken.getEmail();

        return new UserModel() {

            @Override
            public String getUsername() {
                return username;
            }

            @Override
            public String getFullName() {
                return fullName;
            }

            @Override
            public String getEmail() {
                return email;
            }
        };
    }

}
