package org.openfact.testsuite.providers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.After;
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

public class AbstractProviderTest {

    @ClassRule
    public static OpenfactRule of = new OpenfactRule();

    protected OpenfactSession session;
    
    protected OrganizationManager organizationManager;
    protected OrganizationProvider model;

    @Before
    public void before() throws Exception {
        session = of.startSession();
        model = session.organizations();
        organizationManager = new OrganizationManager(session);
    }

    @After
    public void after() throws Exception {
        of.stopSession(session, true);

        session = of.startSession();
        try {
            model = session.organizations();

            OrganizationManager om = new OrganizationManager(session);
            for (OrganizationModel organization : model.getOrganizations()) {
                if (!organization.getName().equals(Config.getAdminOrganization())) {
                    om.removeOrganization(organization);
                }
            }
        } finally {
            of.stopSession(session, true);
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
        of.stopSession(session, false);
        session = of.startSession();
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
    
}
