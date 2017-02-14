package org.openfact.connections.httpclient;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

public class HttpClientSpi implements Spi {

    @Override
    public boolean isInternal() {
        return true;
    }

    @Override
    public String getName() {
        return "connectionsHttpClient";
    }

    @Override
    public Class<? extends Provider> getProviderClass() {
        return HttpClientProvider.class;
    }

    @Override
    public Class<? extends ProviderFactory> getProviderFactoryClass() {
        return HttpClientFactory.class;
    }

}
