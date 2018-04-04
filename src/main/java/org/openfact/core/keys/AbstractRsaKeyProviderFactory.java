package org.openfact.core.keys;

import org.openfact.core.keys.component.ComponentModel;
import org.openfact.core.keys.component.ComponentValidationException;
import org.openfact.core.keys.provider.ConfigurationValidationHelper;
import org.openfact.core.keys.provider.ProviderConfigurationBuilder;
import org.openfact.core.models.OrganizationModel;

public abstract class AbstractRsaKeyProviderFactory {

    public final static ProviderConfigurationBuilder configurationBuilder() {
        return ProviderConfigurationBuilder.create()
                .property(Attributes.PRIORITY_PROPERTY)
                .property(Attributes.ENABLED_PROPERTY)
                .property(Attributes.ACTIVE_PROPERTY);
    }

    public void validateConfiguration(OrganizationModel organization, ComponentModel model) throws ComponentValidationException {
        ConfigurationValidationHelper.check(model)
                .checkLong(Attributes.PRIORITY_PROPERTY, false)
                .checkBoolean(Attributes.ENABLED_PROPERTY, false)
                .checkBoolean(Attributes.ACTIVE_PROPERTY, false);
    }
}
