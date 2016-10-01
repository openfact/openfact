package org.openfact.models.catalog;

import org.openfact.provider.Provider;

public interface CountryCatalogProvider extends Provider {

    CountryCatalogModel addCountryCatalog(String name);

    int getCountriesCatalogCount();

}
