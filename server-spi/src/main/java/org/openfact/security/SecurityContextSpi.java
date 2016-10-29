package org.openfact.security;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

public class SecurityContextSpi implements Spi {

    @Override
    public boolean isInternal() {
        return false;
    }

    @Override
    public String getName() {
        return "security-context";
    }

    @Override
    public Class<? extends Provider> getProviderClass() {
        return SecurityContextProvider.class;
    }

    @Override
    public Class<? extends ProviderFactory> getProviderFactoryClass() {
        return SecurityContextProviderFactory.class;
    }

}
