package org.openfact.component;

import org.openfact.models.OpenfactSession;
import org.openfact.provider.ConfiguredProvider;
import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;

public interface ComponentFactory<CreatedType, ProviderType extends Provider>
        extends ProviderFactory<ProviderType>, ConfiguredProvider {

    CreatedType create(OpenfactSession session, ComponentModel model);

    @Override
    default ProviderType create(OpenfactSession session) {
        return null;
    }

    void validateConfiguration(OpenfactSession session, ComponentModel config)
            throws ComponentValidationException;

}
