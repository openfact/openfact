package org.openfact.truststore;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

public class TruststoreSpi implements Spi {

    @Override
    public boolean isInternal() {
        return true;
    }

    @Override
    public String getName() {
        return "truststore";
    }

    @Override
    public Class<? extends Provider> getProviderClass() {
        return TruststoreProvider.class;
    }

    @Override
    public Class<? extends ProviderFactory> getProviderFactoryClass() {
        return TruststoreProviderFactory.class;
    }
}
