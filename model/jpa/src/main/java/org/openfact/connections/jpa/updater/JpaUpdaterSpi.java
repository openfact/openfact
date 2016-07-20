package org.openfact.connections.jpa.updater;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

public class JpaUpdaterSpi implements Spi {

    @Override
    public boolean isInternal() {
        return true;
    }

    @Override
    public String getName() {
        return "connectionsJpaUpdater";
    }

    @Override
    public Class<? extends Provider> getProviderClass() {
        return JpaUpdaterProvider.class;
    }

    @Override
    public Class<? extends ProviderFactory> getProviderFactoryClass() {
        return JpaUpdaterProviderFactory.class;
    }

}
