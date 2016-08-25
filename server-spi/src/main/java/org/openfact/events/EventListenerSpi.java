package org.openfact.events;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

public class EventListenerSpi implements Spi {

    @Override
    public boolean isInternal() {
        return false;
    }

    @Override
    public String getName() {
        return "eventsListener";
    }

    @Override
    public Class<? extends Provider> getProviderClass() {
        return EventListenerProvider.class;
    }

    @Override
    public Class<? extends ProviderFactory> getProviderFactoryClass() {
        return EventListenerProviderFactory.class;
    }

}
