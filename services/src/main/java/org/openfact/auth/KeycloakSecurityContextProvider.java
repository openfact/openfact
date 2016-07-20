package org.openfact.auth;

import javax.servlet.http.HttpServletRequest;

public class KeycloakSecurityContextProvider implements SecurityContextProvider {

    protected HttpServletRequest request;

    @Override
    public void close() {
        // TODO Auto-generated method stub
    }

    @Override
    public String getCurrentUser() {
        return request.getRemoteUser();
    }

    @Override
    public String getFullName() {
        org.keycloak.KeycloakSecurityContext session = (org.keycloak.KeycloakSecurityContext) request
                .getAttribute(org.keycloak.KeycloakSecurityContext.class.getName());
        if (session != null) {
            return session.getToken().getName();
        } else {
            return null;
        }
    }

    @Override
    public String getEmail() {
        org.keycloak.KeycloakSecurityContext session = (org.keycloak.KeycloakSecurityContext) request
                .getAttribute(org.keycloak.KeycloakSecurityContext.class.getName());
        if (session != null) {
            return session.getToken().getEmail();
        } else {
            return null;
        }
    }

}
