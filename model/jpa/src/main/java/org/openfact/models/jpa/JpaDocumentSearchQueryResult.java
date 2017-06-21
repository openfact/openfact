package org.openfact.models.jpa;

import org.openfact.models.DocumentModel;
import org.openfact.models.DocumentQuery;
import org.openfact.models.DocumentQueryResult;
import org.openfact.models.search.SearchResultsModel;

public class JpaDocumentSearchQueryResult extends DocumentQueryResult<SearchResultsModel<DocumentModel>> {

    public JpaDocumentSearchQueryResult(DocumentQuery documentQuery) {
        super(documentQuery);
    }

    public JpaDocumentSearchQueryResult firstResult(int result) {
        return null;
    }

    public JpaDocumentSearchQueryResult maxResults(int results) {
        return null;
    }

    @Override
    public SearchResultsModel<DocumentModel> getResult() {
        return null;
    }

}
