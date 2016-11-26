package org.openfact.ubl;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

public class UBLDebitNoteSpi implements Spi {

    @Override
    public boolean isInternal() {
        return true;
    }

    @Override
    public String getName() {
        return "ublDebitNote";
    }

    @Override
    public Class<? extends Provider> getProviderClass() {
        return UBLDebitNoteProvider.class;
    }

    @Override
    public Class<? extends ProviderFactory> getProviderFactoryClass() {
        return UBLDebitNoteProviderFactory.class;
    }

}
