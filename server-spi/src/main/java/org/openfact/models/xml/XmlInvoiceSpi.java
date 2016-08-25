package org.openfact.models.xml;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

public class XmlInvoiceSpi implements Spi {

    @Override
    public boolean isInternal() {
        return true;
    }

    @Override
    public String getName() {
        return "invoice-xml";
    }

    @Override
    public Class<? extends Provider> getProviderClass() {
        return XmlInvoiceProvider.class;
    }

    @Override
    public Class<? extends ProviderFactory> getProviderFactoryClass() {
        return XmlInvoiceProviderFactory.class;
    }

}
