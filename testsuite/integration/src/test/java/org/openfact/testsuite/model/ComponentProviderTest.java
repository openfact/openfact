package org.openfact.testsuite.model;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.openfact.common.util.MultivaluedHashMap;
import org.openfact.component.ComponentFactory;
import org.openfact.component.ComponentModel;
import org.openfact.component.ComponentProvider;
import org.openfact.components.utils.ComponentUtil;
import org.openfact.models.OrganizationModel;
import org.openfact.models.OrganizationProvider;
import org.openfact.models.jpa.JpaComponentProvider;
import org.openfact.provider.ProviderConfigProperty;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ComponentProviderTest extends AbstractModelTest {

    @Inject
    public EntityManager em;

    @Inject
    public OrganizationProvider organizationProvider;

    @Mock
    public ComponentUtil componentUtil;

    @InjectMocks
    public ComponentProvider componentProvider;

    public OrganizationModel ORGANIZATION;
    public ComponentModel COMPONENT;

    @Deployment
    public static Archive deploy() {
        Archive[] libs = TestUtil.getLibraries();
        WebArchive archive = buildArchive()
                .addClasses(TestUtil.getOrganizationClasses())
                .addClasses(TestUtil.getComponentClasses());
        return archive.addAsLibraries(libs);
    }

    @Before
    public void before() {
        componentProvider = new JpaComponentProvider(em, componentUtil);
        MockitoAnnotations.initMocks(this);

        ORGANIZATION = organizationProvider.createOrganization("SISTCOOP S.A.C.");
        COMPONENT = buildComponentModel();
    }

    @Test
    public void importComponentModel() {
        ComponentFactory componentFactory = buildComponentFactory();
        when(componentUtil.getComponentFactory(COMPONENT)).thenReturn(componentFactory);

        // Create component
        ComponentModel component = componentProvider.importComponentModel(ORGANIZATION, COMPONENT);

        verify(componentUtil).getComponentFactory(COMPONENT);

        assertThat(component, is(notNullValue()));
        assertThat(component, equalTo(COMPONENT));
    }

    @Test
    public void addComponentModel() {
        ComponentFactory componentFactory = buildComponentFactory();
        when(componentUtil.getComponentFactory(COMPONENT)).thenReturn(componentFactory);

        // Create component
        ComponentModel component = componentProvider.addComponentModel(ORGANIZATION, COMPONENT);

        verify(componentUtil).getComponentFactory(COMPONENT);
        verify(componentUtil).notifyCreated(ORGANIZATION, COMPONENT);

        assertThat(component, is(notNullValue()));
        assertThat(component, equalTo(COMPONENT));
    }

    @Test
    public void updateComponent() {
        ComponentFactory componentFactory = buildComponentFactory();
        when(componentUtil.getComponentFactory(any(ComponentModel.class))).thenReturn(componentFactory);

        // Create component
        COMPONENT = componentProvider.addComponentModel(ORGANIZATION, COMPONENT);

        // Updated component
        ComponentModel updatedComponent = buildComponentModel();
        updatedComponent.setId(COMPONENT.getId());
        updatedComponent.setName("ChangedComponentName");
        updatedComponent.setProviderId("ChangedProviderId");
        updatedComponent.setProviderType("ChangedProviderType");
        updatedComponent.setParentId("ChangedParentId");
        updatedComponent.setSubType("ChangedComponentSubType");

        // Execute update
        componentProvider.updateComponent(ORGANIZATION, updatedComponent);
        updatedComponent = componentProvider.getComponent(ORGANIZATION, COMPONENT.getId());

        // Check
        assertThat(COMPONENT, equalTo(updatedComponent));

        assertThat("ChangedComponentName", equalTo(updatedComponent.getName()));
        assertThat("ChangedProviderId", equalTo(updatedComponent.getProviderId()));
        assertThat("ChangedProviderType", equalTo(updatedComponent.getProviderType()));
        assertThat("ChangedParentId", equalTo(updatedComponent.getParentId()));
        assertThat("ChangedComponentSubType", equalTo(updatedComponent.getSubType()));
    }

    @Test
    public void getComponent() {
        ComponentFactory componentFactory = buildComponentFactory();
        when(componentUtil.getComponentFactory(COMPONENT)).thenReturn(componentFactory);

        // Create component
        COMPONENT = componentProvider.addComponentModel(ORGANIZATION, COMPONENT);

        // Search component
        ComponentModel searched = componentProvider.getComponent(ORGANIZATION, COMPONENT.getId());

        assertThat(COMPONENT, equalTo(searched));
    }

    @Test
    public void getUnknownComponent() {
        ComponentModel searched = componentProvider.getComponent(ORGANIZATION, UUID.randomUUID().toString());

        assertThat(searched, is(nullValue()));
    }

    @Test
    public void getComponents() {
        ComponentFactory componentFactory = buildComponentFactory();
        Mockito.when(componentUtil.getComponentFactory(any(ComponentModel.class))).thenReturn(componentFactory);

        // Create another organization
        OrganizationModel AUX_ORGANIZATION = organizationProvider.createOrganization("AUX_ORGANIZATION");

        // Create components
        ComponentModel component1 = buildComponentModel();
        ComponentModel component2 = buildComponentModel();
        ComponentModel component3 = buildComponentModel();

        componentProvider.addComponentModel(ORGANIZATION, component1);
        componentProvider.addComponentModel(ORGANIZATION, component2);
        componentProvider.addComponentModel(AUX_ORGANIZATION, component3);

        // Search
        List<ComponentModel> components1 = componentProvider.getComponents(ORGANIZATION);
        List<ComponentModel> components2 = componentProvider.getComponents(AUX_ORGANIZATION);

        assertThat(components1, is(notNullValue()));
        assertThat(components1.size(), is(equalTo(2)));

        assertThat(components2, is(notNullValue()));
        assertThat(components2.size(), is(equalTo(1)));
        assertThat(components2.get(0), is(equalTo(component3)));
    }

    @Test
    public void getComponentsByParent() {
        ComponentFactory componentFactory = buildComponentFactory();
        Mockito.when(componentUtil.getComponentFactory(any(ComponentModel.class))).thenReturn(componentFactory);

        // Create another organization
        OrganizationModel AUX_ORGANIZATION = organizationProvider.createOrganization("AUX_ORGANIZATION");

        // Create components
        ComponentModel component1 = buildComponentModel();
        ComponentModel component2 = buildComponentModel();
        ComponentModel component3 = buildComponentModel();
        ComponentModel component4 = buildComponentModel();

        // Changing parentId
        component3.setParentId("AnotherParentId");

        componentProvider.addComponentModel(ORGANIZATION, component1);
        componentProvider.addComponentModel(ORGANIZATION, component2);
        componentProvider.addComponentModel(ORGANIZATION, component3);
        componentProvider.addComponentModel(AUX_ORGANIZATION, component4);

        // Search
        List<ComponentModel> components11 = componentProvider.getComponents(ORGANIZATION, "ParentId");
        List<ComponentModel> components12 = componentProvider.getComponents(ORGANIZATION, "AnotherParentId");
        List<ComponentModel> components21 = componentProvider.getComponents(AUX_ORGANIZATION, "ParentId");
        List<ComponentModel> components22 = componentProvider.getComponents(AUX_ORGANIZATION, "AnotherParentId");

        assertThat(components11, is(notNullValue()));
        assertThat(components12, is(notNullValue()));
        assertThat(components21, is(notNullValue()));
        assertThat(components22, is(notNullValue()));
        assertThat(components11.size(), is(equalTo(2)));
        assertThat(components12.size(), is(equalTo(1)));
        assertThat(components21.size(), is(equalTo(1)));
        assertThat(components22.size(), is(equalTo(0)));
    }

    @Test
    public void getComponentsByParentAndProviderType() {
        ComponentFactory componentFactory = buildComponentFactory();
        Mockito.when(componentUtil.getComponentFactory(any(ComponentModel.class))).thenReturn(componentFactory);

        // Create another organization
        OrganizationModel AUX_ORGANIZATION = organizationProvider.createOrganization("AUX_ORGANIZATION");

        // Create components
        ComponentModel component1 = buildComponentModel(); // ParentId
        ComponentModel component2 = buildComponentModel(); // ParentId
        ComponentModel component3 = buildComponentModel(); // AnotherParentId
        ComponentModel component4 = buildComponentModel(); // AnotherParentId, AnotherProviderType
        ComponentModel component5 = buildComponentModel(); // AnotherParentId, AnotherProviderType
        ComponentModel component6 = buildComponentModel(); // AUX_ORGANIZATION

        // Changing parentId
        component3.setParentId("AnotherParentId");
        component4.setParentId("AnotherParentId");
        component5.setParentId("AnotherParentId");

        component4.setProviderType("AnotherProviderType");
        component5.setProviderType("AnotherProviderType");

        componentProvider.addComponentModel(ORGANIZATION, component1);
        componentProvider.addComponentModel(ORGANIZATION, component2);
        componentProvider.addComponentModel(ORGANIZATION, component3);
        componentProvider.addComponentModel(ORGANIZATION, component4);
        componentProvider.addComponentModel(ORGANIZATION, component5);
        componentProvider.addComponentModel(AUX_ORGANIZATION, component6);

        // Search
        List<ComponentModel> components = componentProvider.getComponents(ORGANIZATION, "AnotherParentId", "AnotherProviderType");

        assertThat(components, is(notNullValue()));
        assertThat(components.size(), is(equalTo(2)));
    }

    @Test
    public void removeComponent() {
        ComponentFactory componentFactory = buildComponentFactory();
        when(componentUtil.getComponentFactory(COMPONENT)).thenReturn(componentFactory);

        // Create component
        COMPONENT = componentProvider.addComponentModel(ORGANIZATION, COMPONENT);

        // Remove component
        componentProvider.removeComponent(ORGANIZATION, COMPONENT);

        // Search component
        COMPONENT = componentProvider.getComponent(ORGANIZATION, COMPONENT.getId());

        assertThat("Component has not been removed", COMPONENT, is(nullValue()));
    }

    @Test
    public void removeComponentsByParentId() {
        ComponentFactory componentFactory = buildComponentFactory();
        Mockito.when(componentUtil.getComponentFactory(any(ComponentModel.class))).thenReturn(componentFactory);

        // Create another organization
        OrganizationModel AUX_ORGANIZATION = organizationProvider.createOrganization("AUX_ORGANIZATION");

        // Create components
        ComponentModel component1 = buildComponentModel();
        ComponentModel component2 = buildComponentModel();
        ComponentModel component3 = buildComponentModel();
        ComponentModel component4 = buildComponentModel();

        component2.setParentId("AnotherParentId");
        component3.setParentId("AnotherParentId");

        componentProvider.addComponentModel(ORGANIZATION, component1);
        componentProvider.addComponentModel(ORGANIZATION, component2);
        componentProvider.addComponentModel(ORGANIZATION, component3);
        componentProvider.addComponentModel(AUX_ORGANIZATION, component4);

        // Remove component
        componentProvider.removeComponents(ORGANIZATION, "AnotherParentId");

        // Search component
        List<ComponentModel> components1 = componentProvider.getComponents(ORGANIZATION);
        List<ComponentModel> components2 = componentProvider.getComponents(AUX_ORGANIZATION);

        assertThat(components1, is(notNullValue()));
        assertThat(components2, is(notNullValue()));
        assertThat(components1.size(), is(equalTo(1)));
        assertThat(components2.size(), is(equalTo(1)));
    }

    @Test
    public void removeOrganization() {
        ComponentFactory componentFactory = buildComponentFactory();
        Mockito.when(componentUtil.getComponentFactory(any(ComponentModel.class))).thenReturn(componentFactory);

        // Create another organization
        OrganizationModel AUX_ORGANIZATION = organizationProvider.createOrganization("AUX_ORGANIZATION");

        // Create components
        ComponentModel component1 = buildComponentModel();
        ComponentModel component2 = buildComponentModel();
        ComponentModel component3 = buildComponentModel();

        componentProvider.addComponentModel(ORGANIZATION, component1);
        componentProvider.addComponentModel(ORGANIZATION, component2);
        componentProvider.addComponentModel(AUX_ORGANIZATION, component3);

        // Remove organization
        boolean result = organizationProvider.removeOrganization(ORGANIZATION);
        assertThat("Result should be true", result, equalTo(true));

        // Check documents no longer exists
        List<ComponentModel> components1 = componentProvider.getComponents(ORGANIZATION);
        List<ComponentModel> components2 = componentProvider.getComponents(AUX_ORGANIZATION);

        assertThat(components1.size(), is(0));
        assertThat(components2.size(), is(1));
    }

    private ComponentModel buildComponentModel() {
        ComponentModel component = new ComponentModel();
        component.setId(UUID.randomUUID().toString());
        component.setName("ComponentName");
        component.setProviderId("ProviderId");
        component.setProviderType("ProviderType");
        component.setParentId("ParentId");
        component.setSubType("ComponentSubType");

        MultivaluedHashMap config = new MultivaluedHashMap();
        config.add("key1", "value1");
        component.setConfig(config);

        component.setNote("key1", "value1");
        component.setNote("key2", "value2");
        component.setNote("key2", "value2");

        return component;
    }

    private ComponentFactory buildComponentFactory() {
        return new ComponentFactory() {
            @Override
            public Object create(OrganizationModel organization, ComponentModel model) {
                return null;
            }

            @Override
            public String getHelpText() {
                return null;
            }

            @Override
            public List<ProviderConfigProperty> getConfigProperties() {
                return null;
            }

            @Override
            public String getId() {
                return null;
            }
        };
    }

}
