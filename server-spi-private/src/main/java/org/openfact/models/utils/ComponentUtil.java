package org.openfact.models.utils;

import org.openfact.models.OrganizationModel;
import org.openfact.models.component.ComponentFactory;
import org.openfact.models.component.ComponentModel;
import org.openfact.models.provider.ProviderConfigProperty;
import org.openfact.representations.idm.ComponentRepresentation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.inject.Instance;


public class ComponentUtil {

    public static Map<String, ProviderConfigProperty> getComponentConfigProperties(ComponentRepresentation component) {
        return getComponentConfigProperties(component.getProviderType(), component.getProviderId());
    }

    public static Map<String, ProviderConfigProperty> getComponentConfigProperties(ComponentModel component) {
        return getComponentConfigProperties(component.getProviderType(), component.getProviderId());
    }

    public static ComponentFactory getComponentFactory(ComponentRepresentation component) {
        return getComponentFactory(component.getProviderType(), component.getProviderId());
    }

    public static ComponentFactory getComponentFactory(ComponentModel component) {
        return getComponentFactory(component.getProviderType(), component.getProviderId());
    }

    private static Map<String, ProviderConfigProperty> getComponentConfigProperties(String providerType, String providerId) {
        try {
            ComponentFactory componentFactory = getComponentFactory(providerType, providerId);
            List<ProviderConfigProperty> l = componentFactory.getConfigProperties();
            Map<String, ProviderConfigProperty> properties = new HashMap<>();
            for (ProviderConfigProperty p : l) {
                properties.put(p.getName(), p);
            }
            List<ProviderConfigProperty> common = componentFactory.getCommonProviderConfigProperties();
            for (ProviderConfigProperty p : common) {
                properties.put(p.getName(), p);
            }

            return properties;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static ComponentFactory getComponentFactory(Instance<ComponentFactory> instances, String providerType, String providerId) {
        Class<? extends Provider> provider = session.getProviderClass(providerType);
        if (provider == null) {
            throw new IllegalArgumentException("Invalid provider type '" + providerType + "'");
        }

        ProviderFactory<? extends Provider> f = session.getOpenfactSessionFactory().getProviderFactory(provider, providerId);
        if (f == null) {
            throw new IllegalArgumentException("No such provider '" + providerId + "'");
        }

        ComponentFactory cf = (ComponentFactory) f;
        return cf;
    }

    public static void notifyCreated(OrganizationModel organization, ComponentModel model) {
        ComponentFactory factory = getComponentFactory(session, model);
        factory.onCreate(session, organization, model);
//        if (factory instanceof UserStorageProviderFactory) {
//            ((OnCreateComponent) session.userStorageManager()).onCreate(session, organization, model);
//        }
    }

    public static void notifyUpdated(OrganizationModel organization, ComponentModel model) {
        ComponentFactory factory = getComponentFactory(session, model);
        factory.onUpdate(session, organization, model);
    }

}
