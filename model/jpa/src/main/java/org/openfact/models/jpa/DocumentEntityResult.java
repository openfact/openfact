package org.openfact.models.jpa;

import org.openfact.models.DocumentModel;
import org.openfact.models.DocumentQuery;
import org.openfact.models.query.QueryResult;

import java.util.List;

public class DocumentEntityResult implements QueryResult<List<DocumentModel>>{

    private DocumentQuery documentQuery;

    public DocumentEntityResult(DocumentQuery documentQuery) {
        this.documentQuery = documentQuery;
    }

    @Override
    public List<DocumentModel> getResult() {
        return null;
    }
}
