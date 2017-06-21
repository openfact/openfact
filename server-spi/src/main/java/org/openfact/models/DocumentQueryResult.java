package org.openfact.models;

import org.openfact.models.query.QueryResult;

public abstract class DocumentQueryResult<T> implements QueryResult<T> {

    protected DocumentQuery documentQuery;

    public DocumentQueryResult(DocumentQuery documentQuery) {
        this.documentQuery = documentQuery;
    }

}
