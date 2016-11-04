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

package org.openfact.testsuite.model;

import org.openfact.models.OrganizationModel;

/**
 * @author <a href="mailto:mposolda@sistcoop.com">Marek Posolda</a>
 */
public class MultipleOrganizationsTest extends AbstractModelTest {

    private OrganizationModel organization1;
    private OrganizationModel organization2;

    /*@Before
    @Override
    public void before() throws Exception {
        super.before();
        organization1 = organizationManager.createOrganization("id1", "organization1");
        organization2 = organizationManager.createOrganization("id2", "organization2");

        createObjects(organization1);
        createObjects(organization2);
    }

    @Test
    public void testUsers() {
        UserModel r1user1 = session.users().getUserByUsername("user1", organization1);
        UserModel r2user1 = session.users().getUserByUsername("user1", organization2);
        Assert.assertEquals(r1user1.getUsername(), r2user1.getUsername());
        Assert.assertNotEquals(r1user1.getId(), r2user1.getId());

        // Test password
        r1user1.updateCredential(UserCredentialModel.password("pass1"));
        r2user1.updateCredential(UserCredentialModel.password("pass2"));

        Assert.assertTrue(session.users().validCredentials(session, organization1, r1user1, UserCredentialModel.password("pass1")));
        Assert.assertFalse(session.users().validCredentials(session, organization1, r1user1, UserCredentialModel.password("pass2")));
        Assert.assertFalse(session.users().validCredentials(session, organization2, r2user1, UserCredentialModel.password("pass1")));
        Assert.assertTrue(session.users().validCredentials(session, organization2, r2user1, UserCredentialModel.password("pass2")));

        // Test searching
        Assert.assertEquals(2, session.users().searchForUser("user", organization1).size());

        commit();
        organization1 = model.getOrganization("id1");
        organization2 = model.getOrganization("id2");

        session.users().removeUser(organization1, r1user1);
        UserModel user2 = session.users().getUserByUsername("user2", organization1);
        session.users().removeUser(organization1, user2);
        Assert.assertEquals(0, session.users().searchForUser("user", organization1).size());
        Assert.assertEquals(2, session.users().searchForUser("user", organization2).size());
    }

    @Test
    public void testGetById() {
        Assert.assertEquals(organization1, model.getOrganization("id1"));
        Assert.assertEquals(organization1, model.getOrganizationByName("organization1"));
        Assert.assertEquals(organization2, model.getOrganization("id2"));
        Assert.assertEquals(organization2, model.getOrganizationByName("organization2"));

        ClientModel r1app1 = organization1.getClientByClientId("app1");
        ClientModel r1app2 = organization1.getClientByClientId("app2");
        ClientModel r2app1 = organization2.getClientByClientId("app1");
        ClientModel r2app2 = organization2.getClientByClientId("app2");

        Assert.assertEquals(r1app1, organization1.getClientById(r1app1.getId()));
        Assert.assertNull(organization2.getClientById(r1app1.getId()));

        ClientModel r2cl1 = organization2.getClientByClientId("cl1");
        Assert.assertEquals(r2cl1.getId(), organization2.getClientById(r2cl1.getId()).getId());
        Assert.assertNull(organization1.getClientByClientId(r2cl1.getId()));

        RoleModel r1App1Role = r1app1.getRole("app1Role1");
        Assert.assertEquals(r1App1Role, organization1.getRoleById(r1App1Role.getId()));
        Assert.assertNull(organization2.getRoleById(r1App1Role.getId()));

        RoleModel r2Role1 = organization2.getRole("role2");
        Assert.assertNull(organization1.getRoleById(r2Role1.getId()));
        Assert.assertEquals(r2Role1, organization2.getRoleById(r2Role1.getId()));
    }

    private void createObjects(OrganizationModel organization) {
        ClientModel app1 = organization.addClient("app1");
        organization.addClient("app2");

        organizationManager.getSession().users().addUser(organization, "user1");
        organizationManager.getSession().users().addUser(organization, "user2");

        organization.addRole("role1");
        organization.addRole("role2");

        app1.addRole("app1Role1");
        app1.addScopeMapping(organization.getRole("role1"));

        organization.addClient("cl1");
    }*/

}
