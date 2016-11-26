package org.openfact.ubl;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

public class UBLCreditNoteSpi implements Spi {

    @Override
    public boolean isInternal() {
        return true;
    }

    @Override
    public String getName() {
        return "ublCreditNote";
    }

    @Override
    public Class<? extends Provider> getProviderClass() {
        return UBLCreditNoteProvider.class;
    }

    @Override
    public Class<? extends ProviderFactory> getProviderFactoryClass() {
        return UBLCreditNoteProviderFactory.class;
    }

}
