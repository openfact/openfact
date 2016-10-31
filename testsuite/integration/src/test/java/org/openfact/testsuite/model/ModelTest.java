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

package org.openfact.testsuite.model;

import org.openfact.models.OrganizationModel;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.representations.idm.OrganizationRepresentation;

public class ModelTest extends AbstractModelTest {

    /*@Test
    public void importExportOrganization() {
        OrganizationModel organization = organizationManager.createOrganization("original");
        organization.setRegistrationAllowed(true);
        organization.setRegistrationEmailAsUsername(true);
        organization.setResetPasswordAllowed(true);
        organization.setEditUsernameAllowed(true);
        organization.setSslRequired(SslRequired.EXTERNAL);
        organization.setVerifyEmail(true);
        organization.setAccessTokenLifespan(1000);
        organization.setPasswordPolicy(PasswordPolicy.parse(organizationManager.getSession(), "length"));
        organization.setAccessCodeLifespan(1001);
        organization.setAccessCodeLifespanUserAction(1002);
        OpenfactModelUtils.generateOrganizationKeys(organization);
        organization.addDefaultRole("default-role");

        HashMap<String, String> smtp = new HashMap<String,String>();
        smtp.put("from", "auto@openfact");
        smtp.put("hostname", "localhost");
        organization.setSmtpConfig(smtp);

        organization.setDefaultLocale("en");
        organization.setAccessCodeLifespanLogin(100);
        organization.setInternationalizationEnabled(true);
        organization.setRegistrationEmailAsUsername(true);
        organization.setSupportedLocales(new HashSet<String>(Arrays.asList("en", "cz")));
        organization.setEventsListeners(new HashSet<String>(Arrays.asList("jpa", "mongo", "foo")));
        organization.setEventsExpiration(200);
        organization.setEventsEnabled(true);

        OrganizationModel persisted = organizationManager.getOrganization(organization.getId());
        assertEquals(organization, persisted);

        OrganizationModel copy = importExport(organization, "copy");
        assertEquals(organization, copy);
    }

    public static void assertEquals(OrganizationModel expected, OrganizationModel actual) {
        Assert.assertEquals(expected.isRegistrationAllowed(), actual.isRegistrationAllowed());
        Assert.assertEquals(expected.isRegistrationEmailAsUsername(), actual.isRegistrationEmailAsUsername());
        Assert.assertEquals(expected.isResetPasswordAllowed(), actual.isResetPasswordAllowed());
        Assert.assertEquals(expected.isEditUsernameAllowed(), actual.isEditUsernameAllowed());
        Assert.assertEquals(expected.getSslRequired(), actual.getSslRequired());
        Assert.assertEquals(expected.isVerifyEmail(), actual.isVerifyEmail());
        Assert.assertEquals(expected.getAccessTokenLifespan(), actual.getAccessTokenLifespan());

        Assert.assertEquals(expected.getAccessCodeLifespan(), actual.getAccessCodeLifespan());
        Assert.assertEquals(expected.getAccessCodeLifespanUserAction(), actual.getAccessCodeLifespanUserAction());
        Assert.assertEquals(expected.getPublicKeyPem(), actual.getPublicKeyPem());
        Assert.assertEquals(expected.getPrivateKeyPem(), actual.getPrivateKeyPem());

        Assert.assertEquals(new HashSet<>(expected.getDefaultRoles()), new HashSet<>(actual.getDefaultRoles()));

        Assert.assertEquals(expected.getSmtpConfig(), actual.getSmtpConfig());

        Assert.assertEquals(expected.getDefaultLocale(), actual.getDefaultLocale());
        Assert.assertEquals(expected.getAccessCodeLifespanLogin(), actual.getAccessCodeLifespanLogin());
        Assert.assertEquals(expected.isInternationalizationEnabled(), actual.isInternationalizationEnabled());
        Assert.assertEquals(expected.isRegistrationEmailAsUsername(), actual.isRegistrationEmailAsUsername());
        Assert.assertEquals(expected.getSupportedLocales(), actual.getSupportedLocales());
        Assert.assertEquals(expected.getEventsListeners(), actual.getEventsListeners());
        Assert.assertEquals(expected.getEventsExpiration(), actual.getEventsExpiration());
        Assert.assertEquals(expected.isEventsEnabled(), actual.isEventsEnabled());
    }*/

    private OrganizationModel importExport(OrganizationModel src, String copyName) {
        OrganizationRepresentation representation = ModelToRepresentation.toRepresentation(src, true);
        representation.setOrganization(copyName);
        representation.setId(copyName);
        OrganizationModel copy = organizationManager.importOrganization(representation);
        return organizationManager.getOrganization(copy.getId());
    }

}
