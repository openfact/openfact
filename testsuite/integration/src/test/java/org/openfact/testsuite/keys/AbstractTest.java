package org.openfact.testsuite.keys;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.runner.RunWith;
import org.openfact.component.ComponentFactory;
import org.openfact.component.ComponentModel;
import org.openfact.component.ComponentValidationException;
import org.openfact.keys.*;
import org.openfact.models.OrganizationModel;
import org.openfact.provider.*;
import org.openfact.testsuite.model.TestUtil;

@RunWith(Arquillian.class)
public abstract class AbstractTest {

    public static WebArchive buildArchive() {
        return ShrinkWrap.create(WebArchive.class)
                .addClass(AbstractTest.class)
                .addAsResource("persistence.xml", "META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
                .addClasses(TestUtil.getBasicClasses());
    }

    public static Class<?>[] getBasicClasses() {
        return new Class<?>[]{
                OrganizationModel.class,
                ComponentModel.class,

                Attributes.class,
                ProviderConfigProperty.class,
                ProviderConfigurationBuilder.class,
                ConfigurationValidationHelper.class,

                ConfiguredProvider.class,
                ProviderFactory.class,
                ComponentFactory.class,
                KeyProviderFactory.class,
                RsaKeyProviderFactory.class,
                AbstractRsaKeyProviderFactory.class,

                KeyProvider.class,
                RsaKeyProvider.class,
                AbstractRsaKeyProvider.class,

                ComponentValidationException.class
        };
    }

}
