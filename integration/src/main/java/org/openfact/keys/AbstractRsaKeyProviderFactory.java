package org.openfact.keys;

import org.openfact.models.OrganizationModel;
import org.openfact.component.ComponentModel;
import org.openfact.component.ComponentValidationException;
import org.openfact.provider.ProviderConfigurationBuilder;
import org.openfact.provider.ConfigurationValidationHelper;

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
