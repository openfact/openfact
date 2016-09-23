/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates
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
 */
package org.openfact.services;

import org.openfact.OAuth2Constants;
import org.openfact.common.Version;
import org.openfact.services.resources.OrganizationsResource;

import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import java.net.URI;

/**
 * @author <a href="mailto:sthorger@redhat.com">Stian Thorgersen</a>
 */
public class Urls {

    /*public static URI accountApplicationsPage(URI baseUri, String organizationId) {
        return accountBase(baseUri).path(AccountService.class, "applicationsPage").build(organizationId);
    }

    public static UriBuilder accountBase(URI baseUri) {
        return organizationBase(baseUri).path(OrganizationsResource.class, "getAccountService");
    }*/

    /*public static URI accountPage(URI baseUri, String organizationId) {
        return accountPageBuilder(baseUri).build(organizationId);
    }*/

    /*public static UriBuilder accountPageBuilder(URI baseUri) {
        return accountBase(baseUri).path(AccountService.class, "accountPage");
    }

    public static URI accountPasswordPage(URI baseUri, String organizationId) {
        return accountBase(baseUri).path(AccountService.class, "passwordPage").build(organizationId);
    }

    public static URI accountFederatedIdentityPage(URI baseUri, String organizationId) {
        return accountBase(baseUri).path(AccountService.class, "federatedIdentityPage").build(organizationId);
    }

    public static URI accountFederatedIdentityUpdate(URI baseUri, String organizationName) {
        return accountBase(baseUri).path(AccountService.class, "processFederatedIdentityUpdate").build(organizationName);
    }

    public static URI identityProviderAuthnResponse(URI baseUri, String providerId, String organizationName) {
        return organizationBase(baseUri).path(OrganizationsResource.class, "getBrokerService")
                .path(IdentityBrokerService.class, "getEndpoint")
                .build(organizationName, providerId);
    }

    public static URI identityProviderAuthnRequest(URI baseUri, String providerId, String organizationName, String accessCode) {
        UriBuilder uriBuilder = organizationBase(baseUri).path(OrganizationsResource.class, "getBrokerService")
                .path(IdentityBrokerService.class, "performLogin");

        if (accessCode != null) {
            uriBuilder.replaceQueryParam(OAuth2Constants.CODE, accessCode);
        }

        return uriBuilder.build(organizationName, providerId);
    }

    public static URI identityProviderRetrieveToken(URI baseUri, String providerId, String organizationName) {
        return organizationBase(baseUri).path(OrganizationsResource.class, "getBrokerService")
                .path(IdentityBrokerService.class, "retrieveToken")
                .build(organizationName, providerId);
    }

    public static URI identityProviderAuthnRequest(URI baseURI, String providerId, String organizationName) {
        return identityProviderAuthnRequest(baseURI, providerId, organizationName, null);
    }

    public static URI identityProviderAfterFirstBrokerLogin(URI baseUri, String organizationName, String accessCode) {
        return organizationBase(baseUri).path(OrganizationsResource.class, "getBrokerService")
                .path(IdentityBrokerService.class, "afterFirstBrokerLogin")
                .replaceQueryParam(OAuth2Constants.CODE, accessCode)
                .build(organizationName);
    }

    public static URI identityProviderAfterPostBrokerLogin(URI baseUri, String organizationName, String accessCode) {
        return organizationBase(baseUri).path(OrganizationsResource.class, "getBrokerService")
                .path(IdentityBrokerService.class, "afterPostBrokerLoginFlow")
                .replaceQueryParam(OAuth2Constants.CODE, accessCode)
                .build(organizationName);
    }

    public static URI accountTotpPage(URI baseUri, String organizationId) {
        return accountBase(baseUri).path(AccountService.class, "totpPage").build(organizationId);
    }

    public static URI accountTotpRemove(URI baseUri, String organizationId, String stateChecker) {
        return accountBase(baseUri).path(AccountService.class, "processTotpRemove")
                .queryParam("stateChecker", stateChecker)
                .build(organizationId);
    }*/

    /*public static URI accountLogPage(URI baseUri, String organizationId) {
        return accountBase(baseUri).path(AccountService.class, "logPage").build(organizationId);
    }

    public static URI accountSessionsPage(URI baseUri, String organizationId) {
        return accountBase(baseUri).path(AccountService.class, "sessionsPage").build(organizationId);
    }

    public static URI accountSessionsLogoutPage(URI baseUri, String organizationId, String stateChecker) {
        return accountBase(baseUri).path(AccountService.class, "processSessionsLogout")
                .queryParam("stateChecker", stateChecker)
                .build(organizationId);
    }

    public static URI accountRevokeClientPage(URI baseUri, String organizationId) {
        return accountBase(baseUri).path(AccountService.class, "processRevokeGrant")
                .build(organizationId);
    }

    public static URI accountLogout(URI baseUri, URI redirectUri, String organizationId) {
        return organizationLogout(baseUri).queryParam("redirect_uri", redirectUri).build(organizationId);
    }

    public static URI loginActionUpdatePassword(URI baseUri, String organizationId) {
        return loginActionsBase(baseUri).path(LoginActionsService.class, "updatePassword").build(organizationId);
    }

    public static URI loginActionUpdateTotp(URI baseUri, String organizationId) {
        return loginActionsBase(baseUri).path(LoginActionsService.class, "updateTotp").build(organizationId);
    }

    public static UriBuilder requiredActionBase(URI baseUri) {
        return loginActionsBase(baseUri).path(LoginActionsService.class, "requiredAction");
    }


    public static URI loginActionUpdateProfile(URI baseUri, String organizationId) {
        return loginActionsBase(baseUri).path(LoginActionsService.class, "updateProfile").build(organizationId);
    }

    public static URI loginActionEmailVerification(URI baseUri, String organizationId) {
        return loginActionEmailVerificationBuilder(baseUri).build(organizationId);
    }

    public static UriBuilder loginActionEmailVerificationBuilder(URI baseUri) {
        return loginActionsBase(baseUri).path(LoginActionsService.class, "emailVerification");
    }

    public static URI loginResetCredentials(URI baseUri, String organizationId) {
        return loginResetCredentialsBuilder(baseUri).build(organizationId);
    }

    public static UriBuilder executeActionsBuilder(URI baseUri) {
        return loginActionsBase(baseUri).path(LoginActionsService.class, "executeActions");
    }

    public static UriBuilder loginResetCredentialsBuilder(URI baseUri) {
        return loginActionsBase(baseUri).path(LoginActionsService.RESET_CREDENTIALS_PATH);
    }

    public static URI loginUsernameReminder(URI baseUri, String organizationId) {
        return loginUsernameReminderBuilder(baseUri).build(organizationId);
    }

    public static UriBuilder loginUsernameReminderBuilder(URI baseUri) {
        return loginActionsBase(baseUri).path(LoginActionsService.class, "usernameReminder");
    }

    public static String organizationIssuer(URI baseUri, String organizationId) {
        return organizationBase(baseUri).path("{organization}").build(organizationId).toString();
    }

    public static UriBuilder organizationBase(URI baseUri) {
        return UriBuilder.fromUri(baseUri).path(OrganizationsResource.class);
    }

    public static URI organizationLoginPage(URI baseUri, String organizationId) {
        return loginActionsBase(baseUri).path(LoginActionsService.class, "authenticate").build(organizationId);
    }

    private static UriBuilder organizationLogout(URI baseUri) {
        return tokenBase(baseUri).path(OIDCLoginProtocolService.class, "logout");
    }

    public static URI organizationRegisterAction(URI baseUri, String organizationId) {
        return loginActionsBase(baseUri).path(LoginActionsService.class, "processRegister").build(organizationId);
    }

    public static URI organizationRegisterPage(URI baseUri, String organizationId) {
        return loginActionsBase(baseUri).path(LoginActionsService.class, "registerPage").build(organizationId);
    }

    public static URI organizationInstalledAppUrnCallback(URI baseUri, String organizationId) {
        return tokenBase(baseUri).path(OIDCLoginProtocolService.class, "installedAppUrnCallback").build(organizationId);
    }

    public static URI organizationOauthAction(URI baseUri, String organizationId) {
        return loginActionsBase(baseUri).path(LoginActionsService.class, "processConsent").build(organizationId);
    }

    public static URI firstBrokerLoginProcessor(URI baseUri, String organizationName) {
        return loginActionsBase(baseUri).path(LoginActionsService.class, "firstBrokerLoginGet")
                .build(organizationName);
    }

    public static String localeCookiePath(URI baseUri, String organizationName){
        return organizationBase(baseUri).path(organizationName).build().getRawPath();
    }

    public static URI themeRoot(URI baseUri) {
        return themeBase(baseUri).path(Version.RESOURCES_VERSION).build();
    }

    private static UriBuilder loginActionsBase(URI baseUri) {
        return organizationBase(baseUri).path(OrganizationsResource.class, "getLoginActionsService");
    }

    private static UriBuilder tokenBase(URI baseUri) {
        return organizationBase(baseUri).path("{organization}/protocol/" + OIDCLoginProtocol.LOGIN_PROTOCOL);
    }

    private static UriBuilder themeBase(URI baseUri) {
        return UriBuilder.fromUri(baseUri).path(ThemeResource.class);
    }*/
}
