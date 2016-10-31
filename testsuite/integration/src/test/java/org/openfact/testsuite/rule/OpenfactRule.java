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
package org.openfact.testsuite.rule;

import org.junit.Assert;
import org.openfact.Config;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.services.managers.OrganizationManager;
import org.openfact.testsuite.ApplicationServlet;

import static org.junit.Assert.assertNotNull;

/**
 * @author <a href="mailto:sthorger@redhat.com">Stian Thorgersen</a>
 */
public class OpenfactRule extends AbstractOpenfactRule {

    private OpenfactSetup setup;

    public OpenfactRule() {
    }

    public OpenfactRule(OpenfactSetup setup) {
        this.setup = setup;
    }

    @Override
    protected void setupOpenfact() {
        importOrganization();

        if (setup != null) {
            configure(setup);
        }

        deployServlet("app", "/app", ApplicationServlet.class);
    }

    protected void importOrganization() {
        server.importOrganization(getClass().getResourceAsStream("/testorganization.json"));
    }

    public void configure(OpenfactSetup configurer) {
        OpenfactSession session = server.getSessionFactory().create();
        session.getTransactionManager().begin();

        try {
            OrganizationManager manager = new OrganizationManager(session);
            manager.setContextPath("/openfact");

            OrganizationModel adminstrationOrganization = manager.getOrganization(Config.getAdminOrganization());
            OrganizationModel appOrganization = manager.getOrganization("test");

            configurer.session = session;
            configurer.config(manager, adminstrationOrganization, appOrganization);

            session.getTransactionManager().commit();
        } finally {
            session.close();
        }
    }

    public void update(OpenfactSetup configurer) {
        update(configurer, "test");
    }


    /*public void removeUserSession(String sessionId) {
        OpenfactSession session = startSession();
        OrganizationModel organization = session.organizations().getOrganization("test");
        UserSessionModel userSession = session.sessions().getUserSession(organization, sessionId);
        assertNotNull(userSession);
        session.sessions().removeUserSession(organization, userSession);
        stopSession(session, true);
    }

    public ClientSessionCode verifyCode(String code) {
        OpenfactSession session = startSession();
        try {
            OrganizationModel organization = session.organizations().getOrganization("test");
            try {
                ClientSessionCode accessCode = ClientSessionCode.parse(code, session, organization);
                if (accessCode == null) {
                    Assert.fail("Invalid code");
                }
                return accessCode;
            } catch (Throwable t) {
                throw new AssertionError("Failed to parse code", t);
            }
        } finally {
            stopSession(session, false);
        }
    }*/

    public abstract static class OpenfactSetup {

        protected OpenfactSession session;

        public abstract void config(OrganizationManager manager, OrganizationModel adminstrationOrganization, OrganizationModel appOrganization);

    }

}
