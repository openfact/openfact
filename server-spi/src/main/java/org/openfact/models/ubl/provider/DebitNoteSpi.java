package org.openfact.models.ubl.provider;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

public class DebitNoteSpi implements Spi {

    @Override
    public String getName() {
        return "debitNote";
    }

    @Override
    public Class<? extends Provider> getProviderClass() {
        return DebitNoteProvider.class;
    }

    @Override
    public Class<? extends ProviderFactory> getProviderFactoryClass() {
        return DebitNoteProviderFactory.class;
    }

    @Override
    public boolean isInternal() {
        // TODO Auto-generated method stub
        return false;
    }

}
