package org.openfact.keys;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

public class PublicKeyStorageSpi implements Spi {

    @Override
    public boolean isInternal() {
        return true;
    }

    @Override
    public String getName() {
        return "publicKeyStorage";
    }

    @Override
    public Class<? extends Provider> getProviderClass() {
        return PublicKeyStorageProvider.class;
    }

    @Override
    public Class<? extends ProviderFactory> getProviderFactoryClass() {
        return PublicKeyStorageProviderFactory.class;
    }
}
