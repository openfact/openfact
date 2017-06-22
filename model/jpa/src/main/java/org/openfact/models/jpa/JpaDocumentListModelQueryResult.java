package org.openfact.models.jpa;

import org.openfact.models.DocumentModel;
import org.openfact.models.DocumentQueryModel;
import org.openfact.models.ListQueryParamsModel;
import org.openfact.models.OrganizationModel;
import org.openfact.models.jpa.entities.DocumentEntity;
import org.openfact.models.query.QueryResult;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

public class JpaDocumentListModelQueryResult implements QueryResult<List<DocumentModel>> {

    private final JpaSortableDocumentCriteria<DocumentEntity> criteria;

    private final OrganizationModel organization;
    private final ListQueryParamsModel params;
    private final EntityManager em;

    public JpaDocumentListModelQueryResult(EntityManager em, OrganizationModel organization, DocumentQueryModel query, ListQueryParamsModel params) {
        this.organization = organization;
        this.params = params;
        this.em = em;

        this.criteria = new JpaSortableDocumentCriteria<>(em, DocumentEntity.class, organization, query);
    }

    @Override
    public List<DocumentModel> getResult() {
        if (params != null) {
            criteria.orderByAsc(params.getOrderByAsc());
            criteria.orderByDesc(params.getOrderByDesc());
        }

        TypedQuery<DocumentEntity> typedQuery = criteria.buildTypedQuery();

        if (params != null) {
            if (params.getFirstResult() != null) {
                typedQuery.setFirstResult(params.getFirstResult());
            }
            if (params.getMaxResults() != null) {
                typedQuery.setMaxResults(params.getMaxResults());
            }
        }

        return typedQuery.getResultList().stream()
                .map(f -> new DocumentAdapter(organization, em, f))
                .collect(Collectors.toList());
    }

}
