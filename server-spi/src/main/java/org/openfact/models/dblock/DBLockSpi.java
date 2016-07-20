package org.openfact.models.dblock;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

public class DBLockSpi implements Spi {

    @Override
    public boolean isInternal() {
        return true;
    }

    @Override
    public String getName() {
        return "dblock";
    }

    @Override
    public Class<? extends Provider> getProviderClass() {
        return DBLockProvider.class;
    }

    @Override
    public Class<? extends ProviderFactory> getProviderFactoryClass() {
        return DBLockProviderFactory.class;
    }
}
