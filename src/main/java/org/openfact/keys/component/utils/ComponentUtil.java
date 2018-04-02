package org.openfact.keys.component.utils;

import org.openfact.keys.component.ComponentFactory;
import org.openfact.keys.component.ComponentModel;
import org.openfact.keys.provider.ProviderConfigProperty;
import org.openfact.models.CompanyModel;
import org.openfact.representations.idm.ComponentRepresentation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    default void notifyCreated(CompanyModel company, ComponentModel model) {
        ComponentFactory factory = getComponentFactory(model);
        factory.onCreate(company, model);
    }

    default void notifyUpdated(CompanyModel company, ComponentModel model) {
        ComponentFactory factory = getComponentFactory(model);
        factory.onUpdate(company, model);
    }

}
