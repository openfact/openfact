package org.openfact.models;

import java.util.List;
import java.util.Set;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderEventManager;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

public interface RepeidSessionFactory extends ProviderEventManager {

    RepeidSession create();

    Set<Spi> getSpis();

    <T extends Provider> ProviderFactory<T> getProviderFactory(Class<T> clazz);

    <T extends Provider> ProviderFactory<T> getProviderFactory(Class<T> clazz, String id);

    List<ProviderFactory> getProviderFactories(Class<? extends Provider> clazz);

    long getServerStartupTimestamp();

    void close();

}