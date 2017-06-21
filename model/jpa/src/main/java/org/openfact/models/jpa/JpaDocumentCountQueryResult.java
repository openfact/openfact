package org.openfact.models.jpa;

import org.openfact.models.DocumentCountQueryResult;
import org.openfact.models.DocumentQuery;

public class JpaDocumentCountQueryResult extends DocumentCountQueryResult{

    public JpaDocumentCountQueryResult(DocumentQuery documentQuery) {
        super(documentQuery);
    }

    @Override
    public Integer getResult() {
        return null;
    }

}
