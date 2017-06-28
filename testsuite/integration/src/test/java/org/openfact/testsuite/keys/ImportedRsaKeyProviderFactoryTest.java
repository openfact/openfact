package org.openfact.testsuite.keys;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.openfact.component.ComponentFactory;
import org.openfact.component.ComponentModel;
import org.openfact.keys.ImportedRsaKeyProvider;
import org.openfact.keys.ImportedRsaKeyProviderFactory;
import org.openfact.keys.KeyProvider;
import org.openfact.keys.qualifiers.ComponentProviderType;
import org.openfact.keys.qualifiers.RsaKeyProviderType;
import org.openfact.keys.qualifiers.RsaKeyType;
import org.openfact.models.OrganizationModel;
import org.openfact.testsuite.model.TestUtil;

import javax.inject.Inject;

public class ImportedRsaKeyProviderFactoryTest extends AbstractTest{

    @Inject
    @ComponentProviderType(providerType = KeyProvider.class)
    @RsaKeyProviderType(type = RsaKeyType.IMPORTED)
    public ComponentFactory componentFactory;

    @Deployment
    public static Archive deploy() {
        Archive[] libs = TestUtil.getLibraries();
        WebArchive archive = buildArchive()
                .addClasses(getBasicClasses())
                .addClass(ImportedRsaKeyProviderFactory.class)
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

}
