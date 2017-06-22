package org.openfact.models.jpa;

import org.openfact.models.*;
import org.openfact.models.jpa.entities.DocumentEntity;
import org.openfact.models.query.QueryResult;
import org.openfact.models.search.PagingModel;
import org.openfact.models.search.SearchResultsModel;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

public class JpaDocumentSearchResultModelQueryResult implements QueryResult<SearchResultsModel<DocumentModel>> {

    private final JpaSortableDocumentCriteria<DocumentEntity> criteria;
    private final JpaDocumentCountQueryResult countCriteria;
    private final OrganizationModel organization;
    private SearchQueryParamsModel params;
    private final EntityManager em;

    public JpaDocumentSearchResultModelQueryResult(EntityManager em, OrganizationModel organization, DocumentQueryModel query, SearchQueryParamsModel params) {
        this.organization = organization;
        this.params = params;
        this.em = em;

        this.criteria = new JpaSortableDocumentCriteria<>(em, DocumentEntity.class, organization, query);
        this.countCriteria = new JpaDocumentCountQueryResult(em, organization, query);
    }

    @Override
    public SearchResultsModel<DocumentModel> getResult() {
        PagingModel paging = null;

        if (params != null) {
            criteria.orderByAsc(params.getOrderByAsc());
            criteria.orderByDesc(params.getOrderByDesc());

            paging = params.getPaging();
        }

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

}
