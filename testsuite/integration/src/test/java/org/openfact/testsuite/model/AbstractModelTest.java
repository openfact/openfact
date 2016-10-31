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

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.openfact.Config;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.OrganizationProvider;
import org.openfact.representations.idm.OrganizationRepresentation;
import org.openfact.services.managers.OrganizationManager;
import org.openfact.testsuite.rule.OpenfactRule;
import org.openfact.util.JsonSerialization;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

/**
 * @author <a href="mailto:mposolda@redhat.com">Marek Posolda</a>
 */
public class AbstractModelTest {

    @ClassRule
    public static OpenfactRule kc = new OpenfactRule();

    protected OpenfactSession session;

    protected OrganizationManager organizationManager;
    protected OrganizationProvider model;

    @Before
    public void before() throws Exception {
        session = kc.startSession();
        model = session.organizations();
        organizationManager = new OrganizationManager(session);
    }

    @After
    public void after() throws Exception {
        kc.stopSession(session, true);

        session = kc.startSession();
        try {
            model = session.organizations();

            OrganizationManager rm = new OrganizationManager(session);
            for (OrganizationModel organization : model.getOrganizations()) {
                if (!organization.getName().equals(Config.getAdminOrganization())) {
                    rm.removeOrganization(organization);
                }
            }
        } finally {
            kc.stopSession(session, true);
        }
    }

    protected void commit() {
        commit(false);
    }

    protected void commit(boolean rollback) {
        if (rollback) {
            session.getTransactionManager().rollback();
        } else {
            session.getTransactionManager().commit();
        }
        resetSession();
    }

    protected void resetSession() {
        if (session.getTransactionManager().isActive()) {
            session.getTransactionManager().rollback();
        }
        kc.stopSession(session, false);
        session = kc.startSession();
        model = session.organizations();
        organizationManager = new OrganizationManager(session);
    }

    public static OrganizationRepresentation loadJson(String path) throws IOException {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        int c;
        while ((c = is.read()) != -1) {
            os.write(c);
        }
        byte[] bytes = os.toByteArray();
        return JsonSerialization.readValue(bytes, OrganizationRepresentation.class);
    }


    // Helper methods for role equality

    /*public static void assertRolesEquals(Set<RoleModel> expected, Set<RoleModel> actual) {
        Assert.assertEquals(expected.size(), actual.size());
        for (RoleModel current : actual) {
            assertRolesContains(current, expected);
        }
    }

    public static void assertRolesContains(RoleModel expected, Set<RoleModel> actual) {
        for (RoleModel current : actual) {
            if (current.getId().equals(expected.getId())) {
                assertRolesEquals(current, expected);
                return;
            }
        }

        Assert.fail("Role with id=" + expected.getId() + " name=" + expected.getName() + " not in set " + actual);
    }

    public static void assertRolesEquals(RoleModel expected, RoleModel actual) {
        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getName(), actual.getName());
        Assert.assertEquals(expected.getDescription(), actual.getDescription());
        Assert.assertEquals(expected.isScopeParamRequired(), actual.isScopeParamRequired());
        Assert.assertEquals(expected.getContainer(), actual.getContainer());
        Assert.assertEquals(expected.getComposites().size(), actual.getComposites().size());
    }*/
}
