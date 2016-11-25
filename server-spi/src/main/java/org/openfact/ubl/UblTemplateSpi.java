package org.openfact.ubl;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

public class UblTemplateSpi implements Spi {

    @Override
    public boolean isInternal() {
        return true;
    }

    @Override
    public String getName() {
        return "ublTemplate";
    }

    @Override
    public Class<? extends Provider> getProviderClass() {
        return UblTemplateProvider.class;
    }

    @Override
    public Class<? extends ProviderFactory> getProviderFactoryClass() {
        return UblTemplateProviderFactory.class;
    }

}
