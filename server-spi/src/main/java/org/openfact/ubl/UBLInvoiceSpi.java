package org.openfact.ubl;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

public class UBLInvoiceSpi implements Spi {

    @Override
    public boolean isInternal() {
        return true;
    }

    @Override
    public String getName() {
        return "ublInvoice";
    }

    @Override
    public Class<? extends Provider> getProviderClass() {
        return UBLInvoiceProvider.class;
    }

    @Override
    public Class<? extends ProviderFactory> getProviderFactoryClass() {
        return UBLInvoiceProviderFactory.class;
    }

}
