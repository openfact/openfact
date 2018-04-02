package org.openfact.security;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.representations.AccessToken;

import javax.enterprise.context.ApplicationScoped;
import javax.servlet.http.HttpServletRequest;

@ApplicationScoped
@SecurityContextType(name = SecurityContextType.IdentityProvider.KEYCLOAK)
public class KeycloakSecurityContext extends AbstractSecurityContext implements ISecurityContext {

    @Override
    public String getRequestHeader(String headerName) {
        return servletRequest.get().getHeader(headerName);
    }

    @Override
    public Object getAttribute(String attributeName) {
        return servletRequest.get().getAttribute(attributeName);
    }

    @Override
    public String getUsername() {
        HttpServletRequest request = servletRequest.get();
        KeycloakPrincipal<org.keycloak.KeycloakSecurityContext> principal = (KeycloakPrincipal<org.keycloak.KeycloakSecurityContext>) request.getUserPrincipal();
        AccessToken accessToken = principal.getKeycloakSecurityContext().getToken();
        return accessToken.getPreferredUsername();
    }

    @Override
    public String getFullName() {
        HttpServletRequest request = servletRequest.get();
        org.keycloak.KeycloakSecurityContext session = (org.keycloak.KeycloakSecurityContext) request.getAttribute(org.keycloak.KeycloakSecurityContext.class.getName());
        if (session != null) {
            return session.getToken().getName();
        } else {
            return null;
        }
    }

    @Override
    public String getEmail() {
        HttpServletRequest request = servletRequest.get();
        org.keycloak.KeycloakSecurityContext session = (org.keycloak.KeycloakSecurityContext) request.getAttribute(org.keycloak.KeycloakSecurityContext.class.getName());
        if (session != null) {
            return session.getToken().getEmail();
        } else {
            return null;
        }
    }

    @Override
    public String getIdentityId() {
        HttpServletRequest request = servletRequest.get();
        KeycloakPrincipal<org.keycloak.KeycloakSecurityContext> principal = (KeycloakPrincipal<org.keycloak.KeycloakSecurityContext>) request.getUserPrincipal();
        return principal.getName();
    }

    @Override
    public String getIdentityProviderAlias() {
        return "keycloak";
    }

}
