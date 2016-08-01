package org.openfact.storage;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

/**
 * Created by Alex Pariona-"alexpariona@openfact.com" on 01/08/2016.
 */
public class StorageInvoiceSpi implements Spi {
    @Override
    public boolean isInternal() {
        return true;
    }

    @Override
    public String getName() {
        return "invoice-storage";
    }

    @Override
    public Class<? extends Provider> getProviderClass() {
    return StorageInvoiceProvider.class;
    }

    @Override
    public Class<? extends ProviderFactory> getProviderFactoryClass() {
        return StorageInvoiceProviderFactory.class;
    }
}
