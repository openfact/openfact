package org.openfact.models;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

public class OrganizationSpi implements Spi {

    @Override
    public String getName() {
        return "organization";
    }

    @Override
    public Class<? extends Provider> getProviderClass() {
        return OrganizationProvider.class;
    }

    @Override
    public Class<? extends ProviderFactory> getProviderFactoryClass() {
        return OrganizationProviderFactory.class;
    }

    @Override
    public boolean isInternal() {
        // TODO Auto-generated method stub
        return false;
    }

}
