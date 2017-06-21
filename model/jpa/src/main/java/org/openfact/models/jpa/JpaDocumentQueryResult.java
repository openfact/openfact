package org.openfact.models.jpa;

import org.openfact.models.DocumentModel;
import org.openfact.models.DocumentQueryResult;
import org.openfact.models.DocumentQuery;

import java.util.List;

public class JpaDocumentQueryResult extends DocumentQueryResult<List<DocumentModel>> {

    public JpaDocumentQueryResult(DocumentQuery documentQuery) {
        super(documentQuery);
    }

    @Override
    public List<DocumentModel> getResult() {
        return null;
    }

    public JpaDocumentQueryResult firstResult(int result) {
        return null;
    }

    public JpaDocumentQueryResult maxResults(int results) {
        return null;
    }
}
