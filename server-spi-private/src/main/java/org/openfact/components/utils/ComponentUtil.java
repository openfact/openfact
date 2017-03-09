package org.openfact.components.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openfact.models.OrganizationModel;
import org.openfact.component.ComponentFactory;
import org.openfact.component.ComponentModel;
import org.openfact.provider.ProviderConfigProperty;
import org.openfact.representations.idm.ComponentRepresentation;

public interface ComponentUtil {

    default Map<String, ProviderConfigProperty> getComponentConfigProperties(ComponentRepresentation component) {
        return getComponentConfigProperties(component.getProviderType(), component.getProviderId());
    }

    default Map<String, ProviderConfigProperty> getComponentConfigProperties(ComponentModel component) {
        return getComponentConfigProperties(component.getProviderType(), component.getProviderId());
    }

    default ComponentFactory getComponentFactory(ComponentRepresentation component) {
        return getComponentFactory(component.getProviderType(), component.getProviderId());
    }

    default ComponentFactory getComponentFactory(ComponentModel component) {
        return getComponentFactory(component.getProviderType(), component.getProviderId());
    }

    default Map<String, ProviderConfigProperty> getComponentConfigProperties(String providerType, String providerId) {
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

    ComponentFactory getComponentFactory(String providerType, String providerId);

    default void notifyCreated(OrganizationModel organization, ComponentModel model) {
        ComponentFactory factory = getComponentFactory(model);
        factory.onCreate(organization, model);
    }

    default void notifyUpdated(OrganizationModel organization, ComponentModel model) {
        ComponentFactory factory = getComponentFactory(model);
        factory.onUpdate(organization, model);
    }

}
