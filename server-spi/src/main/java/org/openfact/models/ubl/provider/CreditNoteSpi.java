package org.openfact.models.ubl.provider;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

public class CreditNoteSpi implements Spi {

    public String getName() {
        return "creditNote-ubl";
    }

    public Class<? extends Provider> getProviderClass() {
        return CreditNoteProvider.class;
    }

    public Class<? extends ProviderFactory> getProviderFactoryClass() {
        return CreditNoteProviderFactory.class;
    }

    public boolean isInternal() {
        // TODO Auto-generated method stub
        return false;
    }

}
