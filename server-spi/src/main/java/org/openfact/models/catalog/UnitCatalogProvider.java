package org.openfact.models.catalog;

import org.openfact.provider.Provider;

public interface UnitCatalogProvider extends Provider {

    UnitCatalogModel addUnitCatalog(String name, String symbol, String description);

    int getUnitsCatalogCount();

}
