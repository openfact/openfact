package org.openfact.services;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openfact.models.OrganizationProvider;
import org.openfact.authentication.ClientAuthenticatorProvider;
import org.openfact.models.OpenfactContext;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.models.OpenfactTransactionManager;
import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;

public class DefaultOpenfactSession implements OpenfactSession {

    private final DefaultOpenfactSessionFactory factory;
    private final Map<Integer, Provider> providers = new HashMap<Integer, Provider>();
    private final List<Provider> closable = new LinkedList<Provider>();
    private final DefaultOpenfactTransactionManager transactionManager;

    private ClientAuthenticatorProvider authProvider;
    private OrganizationProvider organizationProvider;

    private OpenfactContext context;

    public DefaultOpenfactSession(DefaultOpenfactSessionFactory factory) {
        this.factory = factory;
        this.transactionManager = new DefaultOpenfactTransactionManager();
        context = new DefaultOpenfactContext(this);
    }

    @Override
    public OpenfactContext getContext() {
        return context;
    }

    /**
     * @return RepeidTransactionManager return transaction manager associate to
     *         the session.
     */
    @Override
    public OpenfactTransactionManager getTransaction() {
        return transactionManager;
    }

    /**
     * @param provider
     *            added to invoke close method of the provider on
     *            DefaultRepeidSession close.
     */
    @Override
    public void enlistForClose(Provider provider) {
        closable.add(provider);
    }

    /**
     * @param clazz
     *            return provider for the given class. If the provider don't
     *            exists then this method create it and save on local variable.
     */
    @Override
    public <T extends Provider> T getProvider(Class<T> clazz) {
        Integer hash = clazz.hashCode();
        T provider = (T) providers.get(hash);
        if (provider == null) {
            ProviderFactory<T> providerFactory = factory.getProviderFactory(clazz);
            if (providerFactory != null) {
                provider = providerFactory.create(this);
                providers.put(hash, provider);
            }
        }
        return provider;
    }

    /**
     * @param clazz
     * @param id
     *            return provider for the given class. If the provider don't
     *            exists then this method create it and save on local variable.
     */
    @Override
    public <T extends Provider> T getProvider(Class<T> clazz, String id) {
        Integer hash = clazz.hashCode() + id.hashCode();
        T provider = (T) providers.get(hash);
        if (provider == null) {
            ProviderFactory<T> providerFactory = factory.getProviderFactory(clazz, id);
            if (providerFactory != null) {
                provider = providerFactory.create(this);
                providers.put(hash, provider);
            }
        }
        return provider;
    }

    /**
     * @param clazz
     *            return all the provider's id for the given class.
     */
    @Override
    public <T extends Provider> Set<String> listProviderIds(Class<T> clazz) {
        return factory.getAllProviderIds(clazz);
    }

    /**
     * @param clazz
     *            return all the provider's class for the given class.
     */
    @Override
    public <T extends Provider> Set<T> getAllProviders(Class<T> clazz) {
        Set<T> providers = new HashSet<T>();
        for (String id : listProviderIds(clazz)) {
            providers.add(getProvider(clazz, id));
        }
        return providers;
    }

    /**
     * @return the current RepeidSessionFactory.
     */
    @Override
    public OpenfactSessionFactory getOpenfactSessionFactory() {
        return factory;
    }

    @Override
    public ClientAuthenticatorProvider authentications() {
        if (authProvider == null) {
            authProvider = getAuthProvider();
        }
        return authProvider;
    }

    private ClientAuthenticatorProvider getAuthProvider() {
        ClientAuthenticatorProvider cache = getProvider(ClientAuthenticatorProvider.class);
        if (cache != null) {
            return cache;
        } else {
            return getProvider(ClientAuthenticatorProvider.class);
        }
    }

    /**
     * @return OrganizationProvider
     */
    @Override
    public OrganizationProvider organizations() {
        if (organizationProvider == null) {
            organizationProvider = getOrganizationProvider();
        }
        return organizationProvider;
    }

    private OrganizationProvider getOrganizationProvider() {
        OrganizationProvider cache = getProvider(OrganizationProvider.class);
        if (cache != null) {
            return cache;
        } else {
            return getProvider(OrganizationProvider.class);
        }
    }

    /**
     * This method is invoked on destroy this method.
     */
    @Override
    public void close() {
        for (Provider p : providers.values()) {
            try {
                p.close();
            } catch (Exception e) {
            }
        }
        for (Provider p : closable) {
            try {
                p.close();
            } catch (Exception e) {
            }
        }
    }

}