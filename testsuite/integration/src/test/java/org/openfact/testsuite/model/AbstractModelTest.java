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

}
