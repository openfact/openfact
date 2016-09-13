package org.openfact.models.ubl.provider;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

public class CreditNoteSpi implements Spi {

    @Override
    public String getName() {
        return "creditNote-ubl";
    }

    @Override
    public Class<? extends Provider> getProviderClass() {
        return CreditNoteProvider.class;
    }

    @Override
    public Class<? extends ProviderFactory> getProviderFactoryClass() {
        return CreditNoteProviderFactory.class;
    }

    @Override
    public boolean isInternal() {
        // TODO Auto-generated method stub
        return false;
    }

}
