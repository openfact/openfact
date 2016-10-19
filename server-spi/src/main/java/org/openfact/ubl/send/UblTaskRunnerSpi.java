package org.openfact.ubl.send;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

public class UblTaskRunnerSpi implements Spi {

    @Override
    public String getName() {
        return "organization-taskRunner";
    }

    @Override
    public Class<? extends Provider> getProviderClass() {
        return UblTaskRunnerProvider.class;
    }

    @Override
    public Class<? extends ProviderFactory> getProviderFactoryClass() {
        return UblTaskRunnerProviderFactory.class;
    }

    @Override
    public boolean isInternal() {
        // TODO Auto-generated method stub
        return false;
    }

}
