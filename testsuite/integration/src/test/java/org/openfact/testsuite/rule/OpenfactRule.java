package org.openfact.testsuite.rule;

import org.openfact.Config;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.services.managers.OrganizationManager;
import org.openfact.testsuite.ApplicationServlet;

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
        KeycloakSession session = startSession();
        RealmModel realm = session.realms().getRealm("test");
        UserSessionModel userSession = session.sessions().getUserSession(realm, sessionId);
        assertNotNull(userSession);
        session.sessions().removeUserSession(realm, userSession);
        stopSession(session, true);
    }

    public ClientSessionCode verifyCode(String code) {
        KeycloakSession session = startSession();
        try {
            RealmModel realm = session.realms().getRealm("test");
            try {
                ClientSessionCode accessCode = ClientSessionCode.parse(code, session, realm);
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

        public abstract void config(OrganizationManager manager, OrganizationModel adminstrationOrganization,
                OrganizationModel appOrganization);

    }

}
