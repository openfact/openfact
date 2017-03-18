package org.openfact.testsuite.model;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openfact.Config;
import org.openfact.models.OrganizationModel;
import org.openfact.models.OrganizationProvider;
import org.openfact.representations.idm.OrganizationRepresentation;
import org.openfact.services.managers.OrganizationManager;
import org.openfact.util.JsonSerialization;
import org.wildfly.swarm.undertow.WARArchive;

import javax.inject.Inject;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@RunWith(Arquillian.class)
public abstract class AbstractModelTest {

    @Inject
    protected OrganizationManager organizationManager;

    @Inject
    protected OrganizationProvider organizationProvider;

    @Deployment
    public static WARArchive createDeployment() throws Exception {
        WARArchive appDeployment = ShrinkWrap.create(WARArchive.class);

        appDeployment.addPackage("org.openfact")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAllDependencies();
        return appDeployment;
    }

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
        for (OrganizationModel organization : organizationProvider.getOrganizations()) {
            if (!organization.getName().equals(Config.getAdminOrganization())) {
                organizationManager.removeOrganization(organization);
            }
        }
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
