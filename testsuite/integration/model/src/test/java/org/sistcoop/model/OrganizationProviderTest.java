package org.sistcoop.model;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openfact.models.ModelException;
import org.openfact.models.OrganizationProvider;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.arquillian.CreateSwarm;
import org.wildfly.swarm.jaxrs.JAXRSArchive;

import javax.inject.Inject;
import java.net.URL;

@RunWith(Arquillian.class)
public class OrganizationProviderTest {

    private static final String ORGANIZATION = "sistcoop";

    @Inject
    private OrganizationProvider organizationProvider;

    @Deployment
    public static Archive createDeployment() throws Exception {
        return ShrinkWrap.create(JAXRSArchive.class)
                .addClass(OrganizationProvider.class)
                .addAllDependencies();
    }

    @CreateSwarm
    public static Swarm newContainer() throws Exception {
        ClassLoader classLoader = OrganizationProviderTest.class.getClassLoader();
        URL stageConfig = classLoader.getResource("project-defaults.yml");

        Swarm swarm = new Swarm(false)
                .withProperty("swarm.ds.name", "OpenfactDS")
                .withProperty("swarm.ds.username", "sa")
                .withProperty("swarm.ds.password", "sa")
                .withProperty("swarm.ds.connection.url", "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");

        return swarm;
    }

    @Test
    public void test_create_success() throws ModelException {
//        OrganizationModel organization = organizationProvider.createOrganization(ORGANIZATION);
//
//        assertThat("Organization has not been created", organization, is(notNullValue()));
//        assertThat("Primary key has not been assigned", organization.getId(), is(notNullValue()));
//        assertThat("Organization name has changed", organization.getName(), equalTo(ORGANIZATION));
    }

//    @Test(expected = ModelDuplicateException.class)
//    public void test_create_noDuplicatesAllowed() throws ModelException {
//        //organizationProvider.createOrganization(ORGANIZATION);
//        //organizationProvider.createOrganization(ORGANIZATION);
//        throw new ModelDuplicateException();
//    }
}
