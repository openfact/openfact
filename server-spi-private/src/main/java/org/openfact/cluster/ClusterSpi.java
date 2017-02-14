package org.openfact.cluster;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

public class ClusterSpi implements Spi {

    @Override
    public boolean isInternal() {
        return true;
    }

    @Override
    public String getName() {
        return "cluster";
    }

    @Override
    public Class<? extends Provider> getProviderClass() {
        return ClusterProvider.class;
    }

    @Override
    public Class<? extends ProviderFactory> getProviderFactoryClass() {
        return ClusterProviderFactory.class;
    }
}
