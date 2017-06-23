package org.openfact.testsuite.model;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
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
    public OrganizationProvider organizationProvider;

    @Deployment
    public static Archive deploy() {
        Archive[] libs = TestUtil.getLibraries();
        WebArchive archive = buildArchive().addClasses(TestUtil.getOrganizationClasses());
        return archive.addAsLibraries(libs);
    }

    @Test
    public void create() {
        OrganizationModel organization = organizationProvider.createOrganization(ORGANIZATION_NAME);

        // Check
        testOrganization(organization);
    }

    @Test
    public void createWithCustomId() {
        final String ORGANIZATION_ID = UUID.randomUUID().toString();
        OrganizationModel organization = organizationProvider.createOrganization(ORGANIZATION_ID, ORGANIZATION_NAME);

        // Check
        testOrganization(organization);
        assertThat(organization.getId(), equalTo(ORGANIZATION_ID));
    }

    private void testOrganization(OrganizationModel organization) {
        assertThat(organization, is(notNullValue()));
        assertThat(organization.getId(), is(notNullValue()));
        assertThat(organization.getName(), equalTo(ORGANIZATION_NAME));
        assertThat(organization.isEnabled(), equalTo(true));
    }

    @Test(expected = ModelDuplicateException.class)
    public void createDuplicate() {
        organizationProvider.createOrganization(ORGANIZATION_NAME);
        organizationProvider.createOrganization(ORGANIZATION_NAME);
    }

    @Test
    public void getOrganization() {
        OrganizationModel organization1 = organizationProvider.createOrganization(ORGANIZATION_NAME);
        OrganizationModel organization2 = organizationProvider.getOrganization(organization1.getId());

        assertThat(organization1, equalTo(organization2));
    }

    @Test
    public void getOrganizationByName() {
        OrganizationModel organization1 = organizationProvider.createOrganization(ORGANIZATION_NAME);
        OrganizationModel organization2 = organizationProvider.getOrganizationByName(organization1.getName());

        assertThat(organization1, equalTo(organization2));
    }

    @Test
    public void getUnknownOrganization() {
        OrganizationModel organization = organizationProvider.getOrganization(UUID.randomUUID().toString());

        assertThat(organization, is(nullValue()));
    }

    @Test
    public void getOrganizations() {
        organizationProvider.createOrganization("organization1");
        organizationProvider.createOrganization("organization2");

        List<OrganizationModel> organizations = organizationProvider.getOrganizations();

        assertThat(organizations, is(notNullValue()));
        assertThat(organizations.size(), equalTo(2));
    }

    @Test
    public void getOrganizationsWithLimits() {
        organizationProvider.createOrganization("organization1");
        organizationProvider.createOrganization("organization2");
        organizationProvider.createOrganization("organization3");
        organizationProvider.createOrganization("organization4");

        List<OrganizationModel> organizations = organizationProvider.getOrganizations(1, 2);

        assertThat(organizations, is(notNullValue()));
        assertThat(organizations.size(), equalTo(2));
    }

    @Test
    public void getOrganizationsCount() {
        organizationProvider.createOrganization("organization1");
        organizationProvider.createOrganization("organization2");
        organizationProvider.createOrganization("organization3");

        int organizationsCount = organizationProvider.getOrganizationsCount();

        assertThat(organizationsCount, equalTo(3));
    }

    @Test
    public void removeOrganization() {
        OrganizationModel organization = organizationProvider.createOrganization(ORGANIZATION_NAME);
        boolean result = organizationProvider.removeOrganization(organization);
        organization = organizationProvider.getOrganization(organization.getId());

        assertThat(result, equalTo(true));
        assertThat(organization, is(nullValue()));
    }

    @Test
    public void removeOrganizationById() {
        OrganizationModel organization = organizationProvider.createOrganization(ORGANIZATION_NAME);
        boolean result = organizationProvider.removeOrganization(organization.getId());
        organization = organizationProvider.getOrganization(organization.getId());

        assertThat(result, equalTo(true));
        assertThat(organization, is(nullValue()));
    }

}