package org.openfact.file;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

public class FileSpi implements Spi {

    @Override
    public String getName() {
        return "file";
    }

    @Override
    public Class<? extends Provider> getProviderClass() {
        return FileProvider.class;
    }

    @Override
    public Class<? extends ProviderFactory> getProviderFactoryClass() {
        return FileProviderFactory.class;
    }

    @Override
    public boolean isInternal() {
        return true;
    }

}
