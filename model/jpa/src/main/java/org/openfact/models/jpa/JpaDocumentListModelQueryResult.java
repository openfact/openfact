package org.openfact.models.jpa;

import org.openfact.models.DocumentModel;
import org.openfact.models.DocumentQuery;
import org.openfact.models.OrganizationModel;
import org.openfact.models.jpa.entities.DocumentEntity;
import org.openfact.models.query.Sortable;
import org.openfact.models.query.SortableQueryResult;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

public class JpaDocumentListModelQueryResult implements SortableQueryResult<List<DocumentModel>> {

    private Integer firstResult;
    private Integer maxResults;

    private final JpaBasicSortableDocumentCriteria<DocumentEntity> criteria;
    private OrganizationModel organization;
    private DocumentQuery documentQuery;
    private final EntityManager em;

    public JpaDocumentListModelQueryResult(OrganizationModel organization, DocumentQuery documentQuery, EntityManager em) {
        this.organization = organization;
        this.documentQuery = documentQuery;
        this.em = em;

        JpaBasicDocumentCriteria<DocumentEntity> basicCriteria = new JpaBasicDocumentCriteria<>(em, DocumentEntity.class, organization, documentQuery);
        this.criteria = new JpaBasicSortableDocumentCriteria<>(em, DocumentEntity.class, organization, documentQuery, basicCriteria);
    }

    public JpaDocumentListModelQueryResult firstResult(int firstResult) {
        this.firstResult = firstResult;
        return this;
    }

    public JpaDocumentListModelQueryResult maxResults(int maxResults) {
        this.maxResults = maxResults;
        return this;
    }

    @Override
    public List<DocumentModel> getResult() {
        TypedQuery<DocumentEntity> typedQuery = criteria.buildTypedQuery();

        if (firstResult != null) {
            typedQuery.setFirstResult(firstResult);
        }
        if (maxResults != null) {
            typedQuery.setMaxResults(maxResults);
        }

        return typedQuery.getResultList().stream()
                .map(f -> new DocumentAdapter(null, em, f))
                .collect(Collectors.toList());
    }

    @Override
    public Sortable orderByAsc(String... asc) {
        criteria.orderByAsc(asc);
        return this;
    }

    @Override
    public Sortable orderByDesc(String... desc) {
        criteria.orderByDesc(desc);
        return this;
    }
}
