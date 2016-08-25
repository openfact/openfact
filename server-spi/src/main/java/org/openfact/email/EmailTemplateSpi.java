package org.openfact.email;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

public class EmailTemplateSpi implements Spi {

    @Override
    public boolean isInternal() {
        return true;
    }

    @Override
    public String getName() {
        return "emailTemplate";
    }

    @Override
    public Class<? extends Provider> getProviderClass() {
        return EmailTemplateProvider.class;
    }

    @Override
    public Class<? extends ProviderFactory> getProviderFactoryClass() {
        return EmailTemplateProviderFactory.class;
    }
}
