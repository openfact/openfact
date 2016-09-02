package org.openfact.models;

import java.util.Set;

import org.openfact.authentication.ClientAuthenticatorProvider;
import org.openfact.provider.Provider;

public interface OpenfactSession {

    OpenfactContext getContext();

    OpenfactTransactionManager getTransactionManager();

    <T extends Provider> T getProvider(Class<T> clazz);

    <T extends Provider> T getProvider(Class<T> clazz, String id);

    <T extends Provider> Set<String> listProviderIds(Class<T> clazz);

    <T extends Provider> Set<T> getAllProviders(Class<T> clazz);

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
    
    InvoiceProvider invoices();
    
    CertifiedProvider certifieds();
    
    ClientAuthenticatorProvider authentications();
    
    void close();

}
