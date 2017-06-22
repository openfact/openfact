package org.openfact.models;

import org.openfact.models.query.QueryResult;
import org.openfact.models.search.SearchResultsModel;

import java.util.List;

public interface DocumentQueryProvider {

    QueryResult<Integer> countQuery(DocumentQueryModel query);

    QueryResult<List<DocumentModel>> listQuery(DocumentQueryModel query);
    QueryResult<List<DocumentModel>> listQuery(DocumentQueryModel query, ListQueryParamsModel params);

    QueryResult<SearchResultsModel<DocumentModel>> searchQuery(DocumentQueryModel query);
    QueryResult<SearchResultsModel<DocumentModel>> searchQuery(DocumentQueryModel query, SearchQueryParamsModel params);

}
