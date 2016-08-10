package org.openfact.models;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

/**
 * Created by Alex Pariona-"alexpariona@openfact.com" on 09/08/2016.
 */
public class CertifiedSpi  implements Spi{
    @Override
    public boolean isInternal() {
        return false;
    }

    @Override
    public String getName() {
        return "certified";
    }

    @Override
    public Class<? extends Provider> getProviderClass() {
        return CertifiedProvider.class;
    }

    @Override
    public Class<? extends ProviderFactory> getProviderFactoryClass() {
        return CertifiedProviderFactory.class;
    }
}
