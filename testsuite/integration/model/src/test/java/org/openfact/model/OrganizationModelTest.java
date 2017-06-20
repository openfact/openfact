package org.openfact.model;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openfact.models.OrganizationModel;
import org.openfact.models.OrganizationProvider;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;

@RunWith(Arquillian.class)
@UsingDataSet("empty.xml")
public class OrganizationModelTest {

    public static final String ORGANIZATION_NAME = "SISTCOOP S.A.C.";

    public OrganizationModel ORGANIZATION;

    @Inject
    public OrganizationProvider organizationProvider;

    @Deployment
    public static Archive deploy() {
        Archive[] libs = TestUtil.getLibraries();
        WebArchive archive = ShrinkWrap.create(WebArchive.class)
                .addAsResource("persistence.xml", "META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
                .addClasses(TestUtil.getBasicClasses())
                .addClasses(TestUtil.getOrganizationClasses())
                .addPackage(TestUtil.getEntitiesPackage());
        return archive.addAsLibraries(libs);
    }

    @Before
    public void before() {
        ORGANIZATION = organizationProvider.createOrganization(ORGANIZATION_NAME);
    }

    @Test
    public void test() {
        Set<String> supportedLocales = new HashSet<>();
        supportedLocales.add("es");
        supportedLocales.add("en");

        Set<String> initialSupportedLocales = ORGANIZATION.getSupportedLocales();
        ORGANIZATION.setSupportedLocales(supportedLocales);
        Set<String> currentSupportedLocales = ORGANIZATION.getSupportedLocales();

        assertThat("Result should never be null", initialSupportedLocales, is(notNullValue()));
        assertThat("Initial Size should be empty", initialSupportedLocales.size(), is(equalTo(0)));
        assertThat("Result should never be null", currentSupportedLocales, is(notNullValue()));
        assertThat("Incorrect number of supported locales", currentSupportedLocales.size(), is(equalTo(2)));
    }
}
