package org.openfact.authentication;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

public class AuthenticationSpi implements Spi {

    @Override
    public boolean isInternal() {
        return false;
    }

    @Override
    public String getName() {
        return "authentication";
    }

    @Override
    public Class<? extends Provider> getProviderClass() {
        return AuthenticationProvider.class;
    }

    @Override
    public Class<? extends ProviderFactory> getProviderFactoryClass() {
        return AuthenticationProviderFactory.class;
    }

}
