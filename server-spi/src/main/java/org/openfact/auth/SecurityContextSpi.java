package org.openfact.auth;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

public class SecurityContextSpi implements Spi {

    @Override
    public boolean isInternal() {
        return true;
    }

    @Override
    public String getName() {
        return "security";
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
