package org.openfact.models.catalog;

import org.openfact.provider.Provider;

public interface CodeCatalogProvider extends Provider {

    CodeCatalogModel addCodeCatalog(String locale, String type, String code, String description);

    int getCodesCatalogCount();

}
