package org.openfact.connections.jpa.updater.liquibase.conn;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

public class LiquibaseConnectionSpi implements Spi {

    @Override
    public boolean isInternal() {
        return true;
    }

    @Override
    public String getName() {
        return "connectionsLiquibase";
    }

    @Override
    public Class<? extends Provider> getProviderClass() {
        return LiquibaseConnectionProvider.class;
    }

    @Override
    public Class<? extends ProviderFactory> getProviderFactoryClass() {
        return LiquibaseConnectionProviderFactory.class;
    }
}
