package org.openfact.models;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

public class InvoiceSpi implements Spi {

    @Override
    public String getName() {
        return "invoice";
    }

    @Override
    public Class<? extends Provider> getProviderClass() {
        return InvoiceProvider.class;
    }

    @Override
    public Class<? extends ProviderFactory> getProviderFactoryClass() {
        return InvoiceProviderFactory.class;
    }

    @Override
    public boolean isInternal() {
        // TODO Auto-generated method stub
        return false;
    }

}
