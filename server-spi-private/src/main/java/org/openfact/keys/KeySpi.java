package org.openfact.keys;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

public class KeySpi implements Spi {
    @Override
    public boolean isInternal() {
        return true;
    }

    @Override
    public String getName() {
        return "keys";
    }

    @Override
    public Class<? extends Provider> getProviderClass() {
        return KeyProvider.class;
    }

    @Override
    public Class<? extends ProviderFactory> getProviderFactoryClass() {
        return KeyProviderFactory.class;
    }
}
