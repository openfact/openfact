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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openfact.component.ComponentFactory;
import org.openfact.component.ComponentModel;
import org.openfact.component.ComponentProvider;
import org.openfact.components.utils.ComponentUtil;
import org.openfact.models.DocumentProvider;
import org.openfact.models.OrganizationModel;
import org.openfact.models.OrganizationProvider;
import org.openfact.models.jpa.JpaComponentProvider;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@RunWith(Arquillian.class)
//@UsingDataSet("empty.xml")
public class ComponentProviderTest {

    @InjectMocks
    private ComponentProvider componentProvider;

    @Mock
    private ComponentUtil componentUtil;

    @Deployment
    public static Archive deploy() {
        Archive[] libs = TestUtil.getLibraries();
        WebArchive archive = ShrinkWrap.create(WebArchive.class)
                .addAsResource("persistence.xml", "META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
                .addClasses(TestUtil.getBasicClasses())
                .addClasses(TestUtil.getOrganizationClasses())
                .addPackage(TestUtil.getEntitiesPackage())
                .addClasses(TestUtil.getComponentClasses());
        return archive.addAsLibraries(libs);
    }

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void create_success() {
        List<ComponentModel> components = componentProvider.getComponents(null);
    }

    @Stateless
    static class MockComponentUtil implements ComponentUtil {
        @Override
        public ComponentFactory getComponentFactory(String providerType, String providerId) {
            return null;
        }
    }
}
