package org.openfact.models;

import org.openfact.component.ComponentModel;
import org.openfact.file.FileProvider;
import org.openfact.provider.Provider;

import java.util.Set;

public interface OpenfactSession {

    OpenfactContext getContext();

    OpenfactTransactionManager getTransactionManager();

    /**
     * Get dedicated provider instance of provider type clazz that was created
     * for this session. If one hasn't been created yet, find the factory and
     * allocate by calling ProviderFactory.create(OpenfactSession). The provider
     * to use is determined by the "provider" config entry in openfact-server
     * boot configuration. (openfact-server.json)
     *
     * @param clazz
     * @param <T>
     * @return
     */
    <T extends Provider> T getProvider(Class<T> clazz);

    /**
     * Get dedicated provider instance for a specific provider factory of id of
     * provider type clazz that was created for this session. If one hasn't been
     * created yet, find the factory and allocate by calling
     * ProviderFactory.create(OpenfactSession).
     *
     * @param clazz
     * @param id
     * @param <T>
     * @return
     */
    <T extends Provider> T getProvider(Class<T> clazz, String id);

    <T extends Provider> T getProvider(Class<T> clazz, ComponentModel componentModel);

    /**
     * Get all provider factories that manage provider instances of class.
     *
     * @param clazz
     * @param <T>
     * @return
     */
    <T extends Provider> Set<String> listProviderIds(Class<T> clazz);

    <T extends Provider> Set<T> getAllProviders(Class<T> clazz);

    Class<? extends Provider> getProviderClass(String providerClassName);

    Object getAttribute(String attribute);

    Object removeAttribute(String attribute);

    void setAttribute(String name, Object value);

    void enlistForClose(Provider provider);

    OpenfactSessionFactory getOpenfactSessionFactory();

    /**
     * Returns a managed provider instance. Will start a provider transaction.
     * This transaction is managed by the OpenfactSession transaction.
     *
     * @return
     * @throws IllegalStateException if transaction is not active
     */
    OrganizationProvider organizations();

    DocumentProvider documents();

    JobReportProvider jobReports();

    FileProvider files();

    void close();

    /**
     * Key manager
     *
     * @return
     */
    KeyManager keys();

}
