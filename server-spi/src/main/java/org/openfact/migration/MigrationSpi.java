package org.openfact.migration;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

public class MigrationSpi implements Spi {

    @Override
    public boolean isInternal() {
        return true;
    }

    @Override
    public String getName() {
        return "migration";
    }

    @Override
    public Class<? extends Provider> getProviderClass() {
        return MigrationProvider.class;
    }

    @Override
    public Class<? extends ProviderFactory> getProviderFactoryClass() {
        return MigrationProviderFactory.class;
    }
}
