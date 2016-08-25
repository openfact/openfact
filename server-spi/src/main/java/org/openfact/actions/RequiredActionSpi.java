package org.openfact.actions;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

public class RequiredActionSpi implements Spi {

    @Override
    public boolean isInternal() {
        return false;
    }

    @Override
    public String getName() {
        return "required-action";
    }

    @Override
    public Class<? extends Provider> getProviderClass() {
        return RequiredActionProvider.class;
    }

    @Override
    public Class<? extends ProviderFactory> getProviderFactoryClass() {
        return RequiredActionFactory.class;
    }

}
