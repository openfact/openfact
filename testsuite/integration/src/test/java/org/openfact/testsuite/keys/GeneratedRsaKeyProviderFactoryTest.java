package org.openfact.testsuite.keys;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Ignore;
import org.junit.Test;
import org.openfact.component.ComponentFactory;
import org.openfact.component.ComponentModel;
import org.openfact.component.ComponentValidationException;
import org.openfact.keys.GeneratedRsaKeyProviderFactory;
import org.openfact.keys.ImportedRsaKeyProvider;
import org.openfact.keys.KeyProvider;
import org.openfact.keys.qualifiers.ComponentProviderType;
import org.openfact.keys.qualifiers.RsaKeyProviderType;
import org.openfact.keys.qualifiers.RsaKeyType;
import org.openfact.models.OrganizationModel;
import org.openfact.testsuite.model.TestUtil;

import javax.inject.Inject;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;

public class GeneratedRsaKeyProviderFactoryTest extends AbstractTest {

    @Inject
    @ComponentProviderType(providerType = KeyProvider.class)
    @RsaKeyProviderType(type = RsaKeyType.GENERATED)
    public ComponentFactory componentFactory;

    @Deployment
    public static Archive deploy() {
        Archive[] libs = TestUtil.getLibraries();
        WebArchive archive = buildArchive()
                .addClasses(getBasicClasses())
                .addClass(GeneratedRsaKeyProviderFactory.class)
                .addClass(ImportedRsaKeyProvider.class);
        return archive.addAsLibraries(libs);
    }

    @Test
    public void onCreate() {
        OrganizationModel organization = null;
        ComponentModel component = null;
        componentFactory.onCreate(organization, component);
    }

    @Test
    public void onUpdate() {
        OrganizationModel organization = null;
        ComponentModel component = null;
        componentFactory.onUpdate(organization, component);
    }

    @Ignore
    @Test
    public void validateConfiguration() {
        OrganizationModel organization = null;
        ComponentModel component = null;
        componentFactory.validateConfiguration(organization, component); // do nothing
    }

    @Ignore
    @Test(expected = ComponentValidationException.class)
    public void validateInvalidConfiguration() {
        OrganizationModel organization = null;
        ComponentModel component = null;
        componentFactory.validateConfiguration(organization, component);
    }

    @Ignore
    @Test
    public void create() {
        Object object = componentFactory.create();
        assertThat(object, is(nullValue()));
    }

    @Ignore
    @Test
    public void createOnOrganization() {
        OrganizationModel organization = null;
        ComponentModel component = null;
        Object o = componentFactory.create(organization, component);
        assertThat(o, is(notNullValue()));

        componentFactory.getCommonProviderConfigProperties();
        componentFactory.getTypeMetadata();
    }

}
