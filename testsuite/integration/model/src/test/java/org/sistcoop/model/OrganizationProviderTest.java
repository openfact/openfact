package org.sistcoop.model;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openfact.models.OrganizationModel;
import org.openfact.models.OrganizationProvider;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.JpaOrganizationProvider;
import org.openfact.models.jpa.OrganizationAdapter;
import org.openfact.models.jpa.entities.OrganizationEntity;

import javax.inject.Inject;

import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

@RunWith(Arquillian.class)
public class OrganizationProviderTest {

    private static final String ORGANIZATION = "sistcoop";

    @Inject
    OrganizationProvider organizationProvider;

    @Deployment
    public static Archive deploy() {
        return ShrinkWrap.create(WebArchive.class, "test1.war")
                .addClass(OrganizationModel.class)
                .addClass(JpaModel.class)
                .addClass(OrganizationAdapter.class)
                .addClass(OrganizationProvider.class)
                .addClass(JpaOrganizationProvider.class)
                .addPackage(OrganizationEntity.class.getPackage())

                .addAsResource("persistence.xml", "META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsWebInfResource("datasource.xml");
    }

    @Test
    public void test_create_success() {
        OrganizationModel organization = organizationProvider.createOrganization(ORGANIZATION);

        assertThat("Organization has not been created", organization, is(notNullValue()));
        assertThat("Primary key has not been assigned", organization.getId(), is(notNullValue()));
        assertThat("Organization name has changed", organization.getName(), equalTo(ORGANIZATION));
    }

    @Test
    public void test_createWithPredefinedId_success() {
        final String id = UUID.randomUUID().toString();
        OrganizationModel organization = organizationProvider.createOrganization(id, ORGANIZATION);

        assertThat("Organization has not been created", organization, is(notNullValue()));
        assertThat("Primary key has not been assigned", organization.getId(), equalTo(id));
        assertThat("Organization name has changed", organization.getName(), equalTo(ORGANIZATION));
    }

}