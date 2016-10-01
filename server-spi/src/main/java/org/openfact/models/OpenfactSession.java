package org.openfact.models;

import java.util.Set;

import org.openfact.authentication.ClientAuthenticatorProvider;
import org.openfact.models.catalog.CodeCatalogProvider;
import org.openfact.models.catalog.CountryCatalogProvider;
import org.openfact.models.catalog.CurrencyCatalogProvider;
import org.openfact.models.catalog.UnitCatalogProvider;
import org.openfact.models.ubl.provider.CreditNoteProvider;
import org.openfact.models.ubl.provider.DebitNoteProvider;
import org.openfact.models.ubl.provider.InvoiceProvider;
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
     * @throws IllegalStateException
     *             if transaction is not active
     */
    OrganizationProvider organizations();

    InvoiceProvider invoices();

    CreditNoteProvider creditNotes();

    DebitNoteProvider debitNotes();

    /**
     * Catalog
     */
    CodeCatalogProvider codesCatalog();

    CountryCatalogProvider countriesCatalog();

    CurrencyCatalogProvider currenciesCatalog();

    UnitCatalogProvider unitsCatalog();

    /**
     * Security
     */
    ClientAuthenticatorProvider authentications();

    void close();

}
