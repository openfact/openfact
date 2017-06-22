package org.openfact.models.jpa;

import org.openfact.models.Constants;
import org.openfact.models.DocumentModel;
import org.openfact.models.DocumentQuery;
import org.openfact.models.OrganizationModel;
import org.openfact.models.jpa.entities.DocumentEntity;
import org.openfact.models.query.Sortable;
import org.openfact.models.query.SortableQueryResult;
import org.openfact.models.search.PagingModel;
import org.openfact.models.search.SearchResultsModel;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

public class JpaDocumentSearchResultModelQueryResult implements SortableQueryResult<SearchResultsModel<DocumentModel>> {

    private PagingModel paging;

    private final JpaDocumentCountQueryResult countCriteria;
    private final JpaBasicSortableDocumentCriteria<DocumentEntity> criteria;
    private final OrganizationModel organization;
    private final EntityManager em;

    public JpaDocumentSearchResultModelQueryResult(OrganizationModel organization, DocumentQuery documentQuery, EntityManager em) {
        this.organization = organization;
        this.em = em;

        this.countCriteria = new JpaDocumentCountQueryResult(em, organization, documentQuery);

        JpaBasicDocumentCriteria<DocumentEntity> basicCriteria = new JpaBasicDocumentCriteria<>(em, DocumentEntity.class, organization, documentQuery);
        this.criteria = new JpaBasicSortableDocumentCriteria<>(em, DocumentEntity.class, organization, documentQuery, basicCriteria);
    }

    @Override
    public SearchResultsModel<DocumentModel> getResult() {
        if (paging == null) {
            paging = new PagingModel();
            paging.setPage(1);
            paging.setPageSize(Constants.DEFAULT_MAX_RESULTS);
        }

        int page = paging.getPage();
        int pageSize = paging.getPageSize();
        int start = (page - 1) * pageSize;

        TypedQuery<DocumentEntity> typedQuery = criteria.buildTypedQuery();

        typedQuery.setFirstResult(start);
        typedQuery.setMaxResults(pageSize + 1);
        boolean hasMore = false;

        List<DocumentEntity> resultList = typedQuery.getResultList();

        // Check if we got back more than we actually needed.
        if (resultList.size() > pageSize) {
            resultList.remove(resultList.size() - 1);
            hasMore = true;
        }

        // If there are more results than we needed, then we will need to do
        // another
        // createQuery to determine how many rows there are in total
        int totalSize = start + resultList.size();
        if (hasMore) {
            totalSize = countCriteria.getResult();
        }

        SearchResultsModel<DocumentModel> results = new SearchResultsModel<>();
        results.setTotalSize(totalSize);
        results.setModels(resultList.stream().map(f -> new DocumentAdapter(organization, em, f)).collect(Collectors.toList()));
        return results;
    }

    public JpaDocumentSearchResultModelQueryResult paging(PagingModel paging) {
        this.paging = paging;
        return this;
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
