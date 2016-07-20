package org.openfact.provider;

public interface ProviderEventManager {
    void register(ProviderEventListener listener);

    void unregister(ProviderEventListener listener);

    void publish(ProviderEvent event);
}
