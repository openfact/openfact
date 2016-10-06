package org.openfact.models.catalog;

import java.util.List;
import java.util.Map;

import org.openfact.provider.Provider;

public interface CodeCatalogProvider extends Provider {

    CodeCatalogModel addCodeCatalog(String locale, String type, String code, String description);

    CodeCatalogModel getCodeCatalogById(String id);

    boolean removeCodeCatalog(CodeCatalogModel codeCatalog);

    List<CodeCatalogModel> getCodeCatalogs(Integer firstResult, Integer maxResults);

    List<CodeCatalogModel> searchForCodeCatalog(String filterText, Integer firstResult, Integer maxResults);

    List<CodeCatalogModel> searchForCodeCatalog(Map<String, String> attributes, Integer firstResult,
            Integer maxResults);

    int getCodesCatalogCount();

}
