package org.openfact.models.jpa;

import org.openfact.models.DocumentQueryModel;
import org.openfact.models.OrganizationModel;
import org.openfact.models.query.QueryResult;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class JpaDocumentCountQueryResult implements QueryResult<Integer> {

    private final JpaDocumentCriteria<Long> criteria;

    public JpaDocumentCountQueryResult(EntityManager em, OrganizationModel organization, DocumentQueryModel query) {
        this.criteria = new JpaDocumentCriteria<>(em, Long.class, organization, query);
    }

    @Override
    public Integer getResult() {
        TypedQuery<Long> typedQuery = criteria.buildTypedQuery();
        return typedQuery.getSingleResult().intValue();
    }

}
