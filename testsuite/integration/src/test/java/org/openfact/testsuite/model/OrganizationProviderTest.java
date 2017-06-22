package org.openfact.testsuite.model;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Ignore;
import org.junit.Test;
import org.openfact.models.ModelDuplicateException;
import org.openfact.models.OrganizationModel;
import org.openfact.models.OrganizationProvider;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;

public class OrganizationProviderTest extends AbstractModelTest {

    public static final String ORGANIZATION_NAME = "SISTCOOP S.A.C.";

    @Inject
    OrganizationProvider organizationProvider;

    @Deployment
    public static Archive deploy() {
        Archive[] libs = TestUtil.getLibraries();
        WebArchive archive = ShrinkWrap.create(WebArchive.class)
                .addClass(AbstractModelTest.class)
                .addAsResource("persistence.xml", "META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
                .addClasses(TestUtil.getBasicClasses())
                .addClasses(TestUtil.getOrganizationClasses())
                .addPackage(TestUtil.getEntitiesPackage());
        return archive.addAsLibraries(libs);
    }



    @Test
    public void test_create_success() {
        OrganizationModel organization = organizationProvider.createOrganization(ORGANIZATION_NAME);

        // Check
        checkOrganizationConsistence(organization);
    }

    @Test
    public void test_create_custom_id_success() {
        final String id = UUID.randomUUID().toString();
        OrganizationModel organization = organizationProvider.createOrganization(id, ORGANIZATION_NAME);

        // Check
        checkOrganizationConsistence(organization);
        assertThat("Primary key has not been assigned", organization.getId(), equalTo(id));
    }

    private void checkOrganizationConsistence(OrganizationModel organization) {
        assertThat("Organization has not been created", organization, is(notNullValue()));
        assertThat("Primary key has not been assigned", organization.getId(), is(notNullValue()));
        assertThat("Incorrect Organization Name", organization.getName(), equalTo(ORGANIZATION_NAME));
        assertThat("Organization should have active state", organization.isEnabled(), equalTo(true));
    }

    @Test(expected = ModelDuplicateException.class)
    public void test_create_duplicate_fail() {
        organizationProvider.createOrganization(ORGANIZATION_NAME);
        organizationProvider.createOrganization(ORGANIZATION_NAME);
    }

    @Test
    public void test_get_by_id_success() {
        OrganizationModel organization1 = organizationProvider.createOrganization(ORGANIZATION_NAME);
        OrganizationModel organization2 = organizationProvider.getOrganization(organization1.getId());

        assertThat("Both Organizations are not equals", organization1, equalTo(organization2));
    }

    @Test
    public void test_get_by_id_fail() {
        OrganizationModel organization = organizationProvider.getOrganization(UUID.randomUUID().toString());

        assertThat("Organization should not exists", organization, is(nullValue()));
    }

    @Test
    public void test_get_organization_by_name_success() {
        OrganizationModel organization1 = organizationProvider.createOrganization(ORGANIZATION_NAME);
        OrganizationModel organization2 = organizationProvider.getOrganizationByName(organization1.getName());

        assertThat("Both organizations have to be the same", organization1, equalTo(organization2));
    }

    @Test
    public void test_list_organizations_success() {
        organizationProvider.createOrganization("organization1");
        organizationProvider.createOrganization("organization2");

        List<OrganizationModel> organizations = organizationProvider.getOrganizations();

        assertThat("Result should never be null", organizations, is(notNullValue()));
        assertThat("Size is not corresponding to the number of organizations", organizations.size(), equalTo(2));
    }

    @Test
    public void test_list_organizations_limit_success() {
        organizationProvider.createOrganization("organization1");
        organizationProvider.createOrganization("organization2");
        organizationProvider.createOrganization("organization3");
        organizationProvider.createOrganization("organization4");

        List<OrganizationModel> organizations = organizationProvider.getOrganizations(1, 2);

        assertThat("Result should never be null", organizations, is(notNullValue()));
        assertThat("Size is not corresponding to the number of selected organizations", organizations.size(), equalTo(2));
    }

    @Test
    public void test_count_success() {
        organizationProvider.createOrganization("organization1");
        organizationProvider.createOrganization("organization2");
        organizationProvider.createOrganization("organization3");

        int organizationsCount = organizationProvider.getOrganizationsCount();

        assertThat("Size is not corresponding to the number of organizations", organizationsCount, equalTo(3));
    }

    @Test
    public void test_remove_success() {
        OrganizationModel organization = organizationProvider.createOrganization(ORGANIZATION_NAME);
        boolean result = organizationProvider.removeOrganization(organization);
        organization = organizationProvider.getOrganization(organization.getId());

        assertThat("Result should be true", result, equalTo(true));
        assertThat("Organization was not removed", organization, is(nullValue()));
    }

    @Test
    public void test_remove_by_id_success() {
        OrganizationModel organization = organizationProvider.createOrganization(ORGANIZATION_NAME);
        boolean result = organizationProvider.removeOrganization(organization.getId());
        organization = organizationProvider.getOrganization(organization.getId());

        assertThat("Result should be true", result, equalTo(true));
        assertThat("Organization was not removed", organization, is(nullValue()));
    }

    @Ignore
    @Test
    public void disable_document_success() {
    }

}