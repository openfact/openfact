package org.openfact.authentication;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

public class ClientAuthenticatorSpi implements Spi {

    @Override
    public boolean isInternal() {
        return false;
    }

    @Override
    public String getName() {
        return "client-authenticator";
    }

    @Override
    public Class<? extends Provider> getProviderClass() {
        return ClientAuthenticatorProvider.class;
    }

    @Override
    public Class<? extends ProviderFactory> getProviderFactoryClass() {
        return ClientAuthenticatorProviderFactory.class;
    }

}
