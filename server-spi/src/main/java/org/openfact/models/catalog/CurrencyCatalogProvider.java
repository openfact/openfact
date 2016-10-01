package org.openfact.models.catalog;

import org.openfact.provider.Provider;

public interface CurrencyCatalogProvider extends Provider {

    CurrencyCatalogModel addCurrencyCatalog(String entity, String currency);

    int getCurrenciesCatalogCount();

}
