package org.openfact.models;

import java.util.Set;

import org.openfact.provider.Provider;

public interface OpenfactSession {

    RepeidContext getContext();

    RepeidTransactionManager getTransaction();

    <T extends Provider> T getProvider(Class<T> clazz);

    <T extends Provider> T getProvider(Class<T> clazz, String id);

    <T extends Provider> Set<String> listProviderIds(Class<T> clazz);

    <T extends Provider> Set<T> getAllProviders(Class<T> clazz);

    void enlistForClose(Provider provider);

    RepeidSessionFactory getRepeidSessionFactory();

    /**
     * Returns a managed provider instance. Will start a provider transaction.
     * This transaction is managed by the RepeidSession transaction.
     *
     * @return
     * @throws IllegalStateException if transaction is not active
     */
    OrganizationProvider organizations();

    void close();

}
