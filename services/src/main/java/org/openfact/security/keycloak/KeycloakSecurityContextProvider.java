/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.openfact.security.keycloak;

import org.keycloak.KeycloakSecurityContext;
import org.openfact.models.OpenfactSession;
import org.openfact.models.UserModel;
import org.openfact.security.AbstractSecurityContext;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import java.util.Map;
import java.util.Set;

public class KeycloakSecurityContextProvider extends AbstractSecurityContext {

    protected OpenfactSession session;

    public KeycloakSecurityContextProvider(OpenfactSession session) {
        this.session = session;
    }

    @Override
    public String getCurrentOrganizationName(HttpHeaders headers) {
        HttpServletRequest request = servletRequest.get();
        org.keycloak.KeycloakPrincipal<KeycloakSecurityContext> kcPrincipal = (org.keycloak.KeycloakPrincipal<KeycloakSecurityContext>) request.getUserPrincipal();
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
                 
                Set<String> organizationRoles = accessToken.getRealmAccess().getRoles();
                Set<String> applicationRoles = accessToken.getResourceAccess("openfact-restful-api").getRoles();
                return organizationRoles.contains(role) || applicationRoles.contains(role);
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
