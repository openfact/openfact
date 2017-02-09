package org.openfact.models.jpa;

import org.openfact.models.*;
import org.openfact.models.enums.DocumentType;
import org.openfact.models.enums.RequiredAction;
import org.openfact.models.jpa.entities.UBLDocumentEntity;
import org.openfact.models.search.PagingModel;
import org.openfact.models.search.SearchCriteriaFilterModel;
import org.openfact.models.search.SearchCriteriaFilterOperator;
import org.openfact.models.search.SearchResultsModel;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JpaDocumentQuery implements DocumentQuery {

    private DocumentCriteria<UBLDocumentEntity, UBLDocumentEntity> query;
    private DocumentCriteria<UBLDocumentEntity, Long> queryCount;

    private OpenfactSession session;
    private OrganizationModel organization;
    private EntityManager em;

    public JpaDocumentQuery(OpenfactSession session, OrganizationModel organization, EntityManager em) {
        this.session = session;
        this.organization = organization;
        this.em = em;
        this.query = new DocumentCriteria<>(session, organization, em, UBLDocumentEntity.class, UBLDocumentEntity.class);
        this.queryCount = new DocumentCriteria<>(session, organization, em, UBLDocumentEntity.class, Long.class);
    }

    @Override
    public DocumentQuery currencyCode(String... currencyCode) {
        query.currencyCode(currencyCode);
        queryCount.currencyCode(currencyCode);
        return this;
    }

    @Override
    public DocumentQuery documentType(DocumentType... documentType) {
        return documentType(Arrays.stream(documentType).map(DocumentType::toString).toArray(String[]::new));
    }

    @Override
    public DocumentQuery documentType(String... documentType) {
        query.documentType(documentType);
        queryCount.documentType(documentType);
        return this;
    }

    @Override
    public DocumentQuery filterText(String filterText, String... fieldName) {
        query.filterText(filterText, fieldName);
        queryCount.filterText(filterText, fieldName);
        return this;
    }

    @Override
    public DocumentQuery addFilter(String key, String value) {
        query.addFilter(key, value);
        queryCount.addFilter(key, value);
        return this;
    }

    @Override
    public DocumentQuery addFilter(Map<String, String> filters) {
        query.addFilter(filters);
        queryCount.addFilter(filters);
        return this;
    }

    @Override
    public DocumentQuery addFilter(String key, Object value, SearchCriteriaFilterOperator operator) {
        query.addFilter(key, value, operator);
        queryCount.addFilter(key, value, operator);
        return this;
    }

    @Override
    public DocumentQuery requiredAction(RequiredAction... requiredAction) {
        query.requiredAction(requiredAction);
        queryCount.requiredAction(requiredAction);
        return this;
    }

    @Override
    public DocumentQuery fromDate(LocalDateTime fromDate) {
        query.fromDate(fromDate);
        queryCount.fromDate(fromDate);
        return this;
    }

    @Override
    public DocumentQuery toDate(LocalDateTime toDate) {
        query.toDate(toDate);
        queryCount.toDate(toDate);
        return this;
    }

    @Override
    public EntityQuery entityQuery() {
        return new JpaEntityQuery();
    }

    @Override
    public CountQuery countQuery() {
        return new JpaCountQuery();
    }

    class JpaEntityQuery implements DocumentQuery.EntityQuery {

        private Map<String, Boolean> orderBy = new HashMap<>();

        @Override
        public EntityQuery orderByAsc(String... attribute) {
            for (int i = 0; i < attribute.length; i++) {
                this.orderBy.put(attribute[i], true);
            }
            return this;
        }

        @Override
        public EntityQuery orderByDesc(String... attribute) {
            for (int i = 0; i < attribute.length; i++) {
                this.orderBy.put(attribute[i], false);
            }
            return this;
        }

        @Override
        public ListEntityQuery resultList() {
            query.orderBy(orderBy);
            return new JpaListEntityQuery();
        }

        @Override
        public SearchResultEntityQuery searchResult() {
            query.orderBy(orderBy);
            return new JpaSearchResultEntityQuery();
        }

        @Override
        public ScrollEntityQuery resultScroll() {
            query.orderBy(orderBy);
            return new JpaScrollEntityQuery();
        }

    }

    class JpaListEntityQuery implements DocumentQuery.ListEntityQuery {
        private Integer firstResult;
        private Integer maxResults;

        @Override
        public List<DocumentModel> getResultList() {
            TypedQuery<UBLDocumentEntity> typedQuery = query.buildQuery(false);
            if (firstResult != null) {
                typedQuery.setFirstResult(firstResult);
            }
            if (maxResults != null) {
                typedQuery.setMaxResults(maxResults);
            }

            return typedQuery.getResultList().stream()
                    .map(f -> new UBLDocumentAdapter(session, organization, em, f))
                    .collect(Collectors.toList());
        }

        @Override
        public ListEntityQuery firstResult(int firstResult) {
            this.firstResult = firstResult;
            return this;
        }

        @Override
        public ListEntityQuery maxResults(int maxResults) {
            this.maxResults = maxResults;
            return this;
        }
    }

    class JpaSearchResultEntityQuery implements DocumentQuery.SearchResultEntityQuery {
        @Override
        public SearchResultsModel<DocumentModel> getSearchResult() {
            PagingModel paging = new PagingModel();
            paging.setPage(1);
            paging.setPageSize(Constants.DEFAULT_MAX_RESULTS);
            return getSearchResult(paging);
        }

        @Override
        public SearchResultsModel<DocumentModel> getSearchResult(PagingModel paging) {
            int page = paging.getPage();
            int pageSize = paging.getPageSize();
            int start = (page - 1) * pageSize;

            TypedQuery<UBLDocumentEntity> typedQuery = query.buildQuery(false);

            typedQuery.setFirstResult(start);
            typedQuery.setMaxResults(pageSize + 1);
            boolean hasMore = false;

            List<UBLDocumentEntity> resultList = typedQuery.getResultList();

            // Check if we got back more than we actually needed.
            if (resultList.size() > pageSize) {
                resultList.remove(resultList.size() - 1);
                hasMore = true;
            }

            // If there are more results than we needed, then we will need to do
            // another
            // query to determine how many rows there are in total
            int totalSize = start + resultList.size();
            if (hasMore) {
                totalSize = countQuery().getTotalCount();
            }

            SearchResultsModel<DocumentModel> results = new SearchResultsModel<>();
            results.setTotalSize(totalSize);
            results.setModels(resultList.stream().map(f -> new UBLDocumentAdapter(session, organization, em, f)).collect(Collectors.toList()));
            return results;
        }
    }

    class JpaScrollEntityQuery implements DocumentQuery.ScrollEntityQuery {
        @Override
        public ScrollModel<DocumentModel> getScrollResult(int scrollSize) {
            TypedQuery<UBLDocumentEntity> typedQuery = query.buildQuery(false);
            return new ScrollAdapter<>(UBLDocumentEntity.class, typedQuery, f -> new UBLDocumentAdapter(session, organization, em, f), scrollSize);
        }

        @Override
        public ScrollModel<List<DocumentModel>> getScrollResultList(int listSize) {
            TypedQuery<UBLDocumentEntity> typedQuery = query.buildQuery(false);
            return new ScrollPagingAdapter<>(UBLDocumentEntity.class, typedQuery, f -> f.stream().map(m -> new UBLDocumentAdapter(session, organization, em, m)).collect(Collectors.toList()), listSize);
        }
    }

    class JpaCountQuery implements DocumentQuery.CountQuery {
        @Override
        public int getTotalCount() {
            queryCount.getCriteriaQuery().select(queryCount.getCriteriaBuilder().count(queryCount.getRoot()));
            TypedQuery<Long> query = queryCount.buildQuery(true);
            return query.getSingleResult().intValue();
        }
    }

}
