package org.sistcoop.model;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openfact.connections.jpa.PersistenceEntityProducer;
import org.openfact.connections.jpa.PersistenceExceptionConverter;
import org.openfact.models.ModelDuplicateException;
import org.openfact.models.ModelException;
import org.openfact.models.OrganizationModel;
import org.openfact.models.OrganizationProvider;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.JpaOrganizationProvider;
import org.openfact.models.jpa.OrganizationAdapter;
import org.openfact.models.jpa.entities.OrganizationEntity;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;

@RunWith(Arquillian.class)
@UsingDataSet("empty.xml")
public class OrganizationProviderTest {

    private static final String ORGANIZATION = "sistcoop";

    @Inject
    OrganizationProvider organizationProvider;

    @Deployment
    public static Archive deploy() {
        Archive[] libs = Maven.resolver()
                .loadPomFromFile("pom.xml")
                .resolve("org.mockito:mockito-core")
                .withTransitivity()
                .as(JavaArchive.class);

        WebArchive archive = ShrinkWrap.create(WebArchive.class, "test1.war")
                .addAsResource("persistence.xml", "META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsWebInfResource("datasource.xml")

                .addClass(PersistenceEntityProducer.class)
                .addClass(PersistenceExceptionConverter.class)
                .addClass(ModelException.class)
                .addClass(ModelDuplicateException.class)

                .addClass(OrganizationModel.class)
                .addClass(JpaModel.class)
                .addClass(OrganizationAdapter.class)
                .addClass(OrganizationProvider.class)
                .addClass(JpaOrganizationProvider.class)
                .addPackage(OrganizationEntity.class.getPackage());

        archive.addAsLibraries(libs);
        return archive;
    }

    @Test
    public void test_create_success() {
        OrganizationModel organization = organizationProvider.createOrganization(ORGANIZATION);

        assertThat("Organization has not been created", organization, is(notNullValue()));
        assertThat("Primary key has not been assigned", organization.getId(), is(notNullValue()));
        assertThat("Organization name has changed", organization.getName(), equalTo(ORGANIZATION));
        assertThat("Organization should have active state", organization.isEnabled(), equalTo(true));
    }

    @Test
    public void test_createWithPredefinedId_success() {
        final String id = UUID.randomUUID().toString();
        OrganizationModel organization = organizationProvider.createOrganization(id, ORGANIZATION);

        assertThat("Organization has not been created", organization, is(notNullValue()));
        assertThat("Primary key has not been assigned", organization.getId(), equalTo(id));
        assertThat("Organization name has changed", organization.getName(), equalTo(ORGANIZATION));
    }

    @Test(expected = ModelDuplicateException.class)
    public void test_duplicate() {
        OrganizationModel organization1 = organizationProvider.createOrganization(ORGANIZATION);
        OrganizationModel organization2 = organizationProvider.createOrganization(ORGANIZATION);
    }

    @Test
    public void test_getById() {
        OrganizationModel organization1 = organizationProvider.createOrganization(ORGANIZATION);
        OrganizationModel organization2 = organizationProvider.getOrganization(organization1.getId());

        assertThat("Both organizations have to be the same", organization1, equalTo(organization2));
    }

    @Test
    public void test_getById_notFound() {
        OrganizationModel organization = organizationProvider.getOrganization(UUID.randomUUID().toString());

        assertThat("Organization should not exists", organization, is(nullValue()));
    }

    @Test
    public void test_getByOrganizationName() {
        OrganizationModel organization1 = organizationProvider.createOrganization(ORGANIZATION);
        OrganizationModel organization2 = organizationProvider.getOrganizationByName(organization1.getName());

        assertThat("Both organizations have to be the same", organization1, equalTo(organization2));
    }

    @Test
    public void test_listOrganizations() {
        OrganizationModel organization1 = organizationProvider.createOrganization("organization1");
        OrganizationModel organization2 = organizationProvider.createOrganization("organization2");

        List<OrganizationModel> organizations = organizationProvider.getOrganizations();

        assertThat("Result should never be null", organizations, is(notNullValue()));
        assertThat("Size is not corresponding to the number of organizations", organizations.size(), equalTo(2));
    }

    @Test
    public void test_listOrganizationsWithLimit() {
        OrganizationModel organization1 = organizationProvider.createOrganization("organization1");
        OrganizationModel organization2 = organizationProvider.createOrganization("organization2");
        OrganizationModel organization3 = organizationProvider.createOrganization("organization3");
        OrganizationModel organization4 = organizationProvider.createOrganization("organization4");

        List<OrganizationModel> organizations = organizationProvider.getOrganizations(1, 2);

        assertThat("Result should never be null", organizations, is(notNullValue()));
        assertThat("Size is not corresponding to the number of selected organizations", organizations.size(), equalTo(2));
    }

    @Test
    public void test_totalNumberOfOrganizations() {
        OrganizationModel organization1 = organizationProvider.createOrganization("organization1");
        OrganizationModel organization2 = organizationProvider.createOrganization("organization2");
        OrganizationModel organization3 = organizationProvider.createOrganization("organization3");

        int organizationsCount = organizationProvider.getOrganizationsCount();

        assertThat("Size is not corresponding to the number of organizations", organizationsCount, equalTo(3));
    }

    @Test
    public void test_removeById() {
        OrganizationModel organization = organizationProvider.createOrganization("ORGANIZATION");
        boolean result = organizationProvider.removeOrganization(organization.getId());
        organization = organizationProvider.getOrganization(organization.getId());

        assertThat("Result should be true", result, equalTo(true));
        assertThat("Organization was not removed", organization, is(nullValue()));
    }

    @Test
    public void test_remove() {
        OrganizationModel organization = organizationProvider.createOrganization("ORGANIZATION");
        boolean result = organizationProvider.removeOrganization(organization);
        organization = organizationProvider.getOrganization(organization.getId());

        assertThat("Result should be true", result, equalTo(true));
        assertThat("Organization was not removed", organization, is(nullValue()));
    }

}