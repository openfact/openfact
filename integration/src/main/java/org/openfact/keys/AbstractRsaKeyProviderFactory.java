package org.openfact.keys;

import org.openfact.models.OrganizationModel;
import org.openfact.models.component.ComponentModel;
import org.openfact.models.component.ComponentValidationException;
import org.openfact.models.provider.ProviderConfigurationBuilder;
import org.openfact.provider.ConfigurationValidationHelper;

public abstract class AbstractRsaKeyProviderFactory implements RsaKeyProviderFactory {

    public final static ProviderConfigurationBuilder configurationBuilder() {
        return ProviderConfigurationBuilder.create()
                .property(Attributes.PRIORITY_PROPERTY)
                .property(Attributes.ENABLED_PROPERTY)
                .property(Attributes.ACTIVE_PROPERTY);
    }

    @Override
    public void validateConfiguration(OrganizationModel organization, ComponentModel model) throws ComponentValidationException {
        ConfigurationValidationHelper.check(model)
                .checkLong(Attributes.PRIORITY_PROPERTY, false)
                .checkBoolean(Attributes.ENABLED_PROPERTY, false)
                .checkBoolean(Attributes.ACTIVE_PROPERTY, false);
    }
}
