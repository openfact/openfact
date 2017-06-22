package org.openfact.models.jpa;

import org.openfact.models.DocumentQuery;
import org.openfact.models.OrganizationModel;
import org.openfact.models.query.QueryResult;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class JpaDocumentCountQueryResult implements QueryResult<Integer> {

    private final JpaBasicDocumentCriteria<Long> criteria;

    public JpaDocumentCountQueryResult(EntityManager em, OrganizationModel organization, DocumentQuery documentQuery) {
        this.criteria = new JpaBasicDocumentCriteria<>(em, Long.class, organization, documentQuery);
    }

    @Override
    public Integer getResult() {
        TypedQuery<Long> typedQuery = criteria.buildTypedQuery();
        return typedQuery.getSingleResult().intValue();
    }

}
