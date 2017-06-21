package org.openfact.models;

import org.openfact.models.query.QueryResult;

public abstract class DocumentCountQueryResult implements QueryResult<Integer> {

    protected DocumentQuery documentQuery;

    public DocumentCountQueryResult(DocumentQuery documentQuery) {
        this.documentQuery = documentQuery;
    }

}
