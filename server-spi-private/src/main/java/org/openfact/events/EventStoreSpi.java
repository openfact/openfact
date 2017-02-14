package org.openfact.events;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

public class EventStoreSpi implements Spi {

    @Override
    public boolean isInternal() {
        return true;
    }

    @Override
    public String getName() {
        return "eventsStore";
    }

    @Override
    public Class<? extends Provider> getProviderClass() {
        return EventStoreProvider.class;
    }

    @Override
    public Class<? extends ProviderFactory> getProviderFactoryClass() {
        return EventStoreProviderFactory.class;
    }

}
