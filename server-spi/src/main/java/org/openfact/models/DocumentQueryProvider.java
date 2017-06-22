package org.openfact.models;

import org.openfact.models.query.QueryResult;
import org.openfact.models.query.SortableQueryResult;
import org.openfact.models.search.SearchResultsModel;

import java.util.List;

public interface DocumentQueryProvider {

    QueryResult<Integer> countQuery(DocumentQuery query);

    SortableQueryResult<List<DocumentModel>> listQuery(DocumentQuery query);

    SortableQueryResult<SearchResultsModel<DocumentModel>> searchQuery(DocumentQuery query);

}
