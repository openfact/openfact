package org.openfact.email;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;


public class EmailSenderSpi implements Spi {

    @Override
    public boolean isInternal() {
        return true;
    }

    @Override
    public String getName() {
        return "emailSender";
    }

    @Override
    public Class<? extends Provider> getProviderClass() {
        return EmailSenderProvider.class;
    }

    @Override
    public Class<? extends ProviderFactory> getProviderFactoryClass() {
        return EmailSenderProviderFactory.class;
    }
}
