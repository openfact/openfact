package org.openfact.exportimport;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

public class ImportSpi implements Spi {

    @Override
    public boolean isInternal() {
        return true;
    }

    @Override
    public String getName() {
        return "import";
    }

    @Override
    public Class<? extends Provider> getProviderClass() {
        return ImportProvider.class;
    }

    @Override
    public Class<? extends ProviderFactory> getProviderFactoryClass() {
        return ImportProviderFactory.class;
    }
}
