package org.openfact.models;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderEventManager;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

import java.util.List;
import java.util.Set;

public interface OpenfactSessionFactory extends ProviderEventManager {

    OpenfactSession create();

    Set<Spi> getSpis();

    Spi getSpi(Class<? extends Provider> providerClass);

    <T extends Provider> ProviderFactory<T> getProviderFactory(Class<T> clazz);

    <T extends Provider> ProviderFactory<T> getProviderFactory(Class<T> clazz, String id);

    List<ProviderFactory> getProviderFactories(Class<? extends Provider> clazz);

    long getServerStartupTimestamp();

    void close();

}
