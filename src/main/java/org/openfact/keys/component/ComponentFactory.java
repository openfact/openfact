package org.openfact.keys.component;

import org.openfact.keys.provider.ConfiguredProvider;
import org.openfact.keys.provider.ProviderConfigProperty;
import org.openfact.keys.provider.ProviderFactory;
import org.openfact.models.CompanyModel;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public interface ComponentFactory<CreatedType, ProviderType> extends ProviderFactory<ProviderType>, ConfiguredProvider {

    CreatedType create(CompanyModel organization, ComponentModel model);

    @Override
    default ProviderType create() {
        return null;
    }

    default void validateConfiguration(CompanyModel organization, ComponentModel model) throws ComponentValidationException {
    }

    default void onCreate(CompanyModel organization, ComponentModel model) {
    }


    default void onUpdate(CompanyModel organization, ComponentModel model) {
    }

    /**
     * These are config properties that are common across all implementation of this component type
     *
     * @return
     */
    default List<ProviderConfigProperty> getCommonProviderConfigProperties() {
        return Collections.EMPTY_LIST;
    }

    /**
     * This is metadata about this component type.  Its really configuration information about the component type and not
     * an individual instance
     *
     * @return
     */
    default Map<String, Object> getTypeMetadata() {
        return Collections.EMPTY_MAP;
    }


}
