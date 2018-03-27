package org.openfact.keys;

import org.openfact.keys.component.ComponentModel;
import org.openfact.keys.component.ComponentValidationException;
import org.openfact.keys.provider.ConfigurationValidationHelper;
import org.openfact.keys.provider.ProviderConfigurationBuilder;
import org.openfact.models.CompanyModel;

public abstract class AbstractRsaKeyProviderFactory {

    public final static ProviderConfigurationBuilder configurationBuilder() {
        return ProviderConfigurationBuilder.create()
                .property(Attributes.PRIORITY_PROPERTY)
                .property(Attributes.ENABLED_PROPERTY)
                .property(Attributes.ACTIVE_PROPERTY);
    }

    public void validateConfiguration(CompanyModel organization, ComponentModel model) throws ComponentValidationException {
        ConfigurationValidationHelper.check(model)
                .checkLong(Attributes.PRIORITY_PROPERTY, false)
                .checkBoolean(Attributes.ENABLED_PROPERTY, false)
                .checkBoolean(Attributes.ACTIVE_PROPERTY, false);
    }
}
