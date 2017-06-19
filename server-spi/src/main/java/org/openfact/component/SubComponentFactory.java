package org.openfact.component;

import org.openfact.models.OrganizationModel;
import org.openfact.provider.ProviderConfigProperty;

import java.util.List;
import java.util.Map;

/**
 * Useful when you want to describe config properties that are effected by the parent ComponentModel
 */
public interface SubComponentFactory<CreatedType, ProviderType> extends ComponentFactory<CreatedType, ProviderType> {

    default List<ProviderConfigProperty> getConfigProperties(OrganizationModel organization, ComponentModel parent) {
        return getConfigProperties();
    }

    /**
     * This is metadata about this component type.  Its really configuration information about the component type and not
     * an individual instance
     *
     * @return
     */
    default Map<String, Object> getTypeMetadata(OrganizationModel organization, ComponentModel parent) {
        return getTypeMetadata();
    }

}
