package org.openfact.models.jpa;

import org.openfact.models.*;
import org.openfact.models.jpa.entities.DocumentEntity;
import org.openfact.models.search.PagingModel;
import org.openfact.models.search.SearchCriteriaFilterOperator;
import org.openfact.models.search.SearchResultsModel;
import org.openfact.models.types.DocumentRequiredAction;
import org.openfact.models.types.DocumentType;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JpaDocumentQuery implements DocumentQuery {

    private DocumentCriteria<DocumentEntity, DocumentEntity> query;
    private DocumentCriteria<DocumentEntity, Long> queryCount;

    private OrganizationModel organization;
    private EntityManager em;

    private FileProvider fileProvider;

    public JpaDocumentQuery(EntityManager em, FileProvider fileProvider, OrganizationModel organization) {
        this.em = em;
        this.fileProvider = fileProvider;
        this.organization = organization;

        this.query = new DocumentCriteria<>(organization, em, DocumentEntity.class, DocumentEntity.class);
        this.queryCount = new DocumentCriteria<>(organization, em, DocumentEntity.class, Long.class);
    }

    private DocumentModel toModel(DocumentEntity entity) {
        return new DocumentAdapter(organization, em, entity, fileProvider);
    }

    @Override
    public DocumentQuery currencyCode(String... currencyCode) {
        if (currencyCode.length > 0) {
            query.currencyCode(currencyCode);
            queryCount.currencyCode(currencyCode);
        }
        return this;
    }

    @Override
    public DocumentQuery documentType(DocumentType... documentType) {
        return documentType(Arrays.stream(documentType).map(DocumentType::toString).toArray(String[]::new));
    }

    @Override
    public DocumentQuery documentType(String... documentType) {
        if (documentType.length > 0) {
            query.documentType(documentType);
            queryCount.documentType(documentType);
        }
        return this;
    }

    @Override
    public DocumentQuery customerSendEventFailures(int numberFailures, boolean greatherThan) {
        query.customerSendEventFailures(numberFailures, greatherThan);
        queryCount.customerSendEventFailures(numberFailures, greatherThan);
        return this;
    }

    @Override
    public DocumentQuery thirdPartySendEventFailures(int numberFailures, boolean greatherThan) {
        query.thirdPartySendEventFailures(numberFailures, greatherThan);
        queryCount.thirdPartySendEventFailures(numberFailures, greatherThan);
        return this;
    }

    @Override
    public DocumentQuery enabled(boolean isEnabled) {
        query.enabled(isEnabled);
        queryCount.enabled(isEnabled);
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
    public DocumentQuery fromDate(LocalDateTime fromDate, boolean include) {
        query.fromDate(fromDate, include);
        queryCount.fromDate(fromDate, include);
        return this;
    }

    @Override
    public DocumentQuery toDate(LocalDateTime toDate, boolean include) {
        query.toDate(toDate, include);
        queryCount.toDate(toDate, include);
        return this;
    }

    @Override
    public DocumentQuery requiredAction(DocumentRequiredAction... requiredAction) {
        if (requiredAction.length > 0) {
            query.requiredAction(requiredAction);
            queryCount.requiredAction(requiredAction);
        }
        return this;
    }

    @Override
    public DocumentQuery filterText(String filterText) {
        String[] fieldNames = {
                DocumentModel.DOCUMENT_ID,
                DocumentModel.CUSTOMER_REGISTRATION_NAME,
                DocumentModel.CUSTOMER_ASSIGNED_ACCOUNT_ID,
                DocumentModel.CUSTOMER_ELECTRONIC_MAIL
        };
        query.filterText(filterText, fieldNames);
        queryCount.filterText(filterText, fieldNames);
        return this;
    }

    @Override
    public DocumentQuery filterTextReplaceAsterisk(String filterText, String... fieldName) {
        if (fieldName.length > 0) {
            query.filterTextReplaceAsterisk(filterText, fieldName);
            queryCount.filterTextReplaceAsterisk(filterText, fieldName);
        }
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
            TypedQuery<DocumentEntity> typedQuery = query.buildQuery(false);
            if (firstResult != null) {
                typedQuery.setFirstResult(firstResult);
            }
            if (maxResults != null) {
                typedQuery.setMaxResults(maxResults);
            }

            return typedQuery.getResultList().stream()
                    .map(JpaDocumentQuery.this::toModel)
                    .collect(Collectors.toList());
        }

        @Override
        public ListEntityQuery firstResult(int firstResult) {
            if (firstResult != -1) {
                this.firstResult = firstResult;
            }
            return this;
        }

        @Override
        public ListEntityQuery maxResults(int maxResults) {
            if (maxResults != -1) {
                this.maxResults = maxResults;
            }
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

            TypedQuery<DocumentEntity> typedQuery = query.buildQuery(false);

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
                totalSize = countQuery().getTotalCount();
            }

            SearchResultsModel<DocumentModel> results = new SearchResultsModel<>();
            results.setTotalSize(totalSize);
            results.setModels(resultList.stream().map(JpaDocumentQuery.this::toModel).collect(Collectors.toList()));
            return results;
        }
    }

    class JpaScrollEntityQuery implements DocumentQuery.ScrollEntityQuery {
        @Override
        public ScrollModel<DocumentModel> getScrollResult(int scrollSize) {
            TypedQuery<DocumentEntity> typedQuery = query.buildQuery(false);
            return new ScrollAdapter<>(DocumentEntity.class, typedQuery, JpaDocumentQuery.this::toModel, scrollSize);
        }

        @Override
        public ScrollModel<List<DocumentModel>> getScrollResultList(int listSize) {
            TypedQuery<DocumentEntity> typedQuery = query.buildQuery(false);
            return new ScrollPagingAdapter<>(DocumentEntity.class, typedQuery, f -> f.stream().map(JpaDocumentQuery.this::toModel).collect(Collectors.toList()), listSize);
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
