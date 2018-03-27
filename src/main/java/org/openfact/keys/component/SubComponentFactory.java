package org.openfact.keys.component;

import org.openfact.keys.provider.ProviderConfigProperty;
import org.openfact.models.CompanyModel;

import java.util.List;
import java.util.Map;

/**
 * Useful when you want to describe config properties that are effected by the parent ComponentModel
 */
public interface SubComponentFactory<CreatedType, ProviderType> extends ComponentFactory<CreatedType, ProviderType> {

    default List<ProviderConfigProperty> getConfigProperties(CompanyModel company, ComponentModel parent) {
        return getConfigProperties();
    }

    /**
     * This is metadata about this component type.  Its really configuration information about the component type and not
     * an individual instance
     *
     * @return
     */
    default Map<String, Object> getTypeMetadata(CompanyModel company, ComponentModel parent) {
        return getTypeMetadata();
    }

}
