package org.openfact.models.jpa;

import org.openfact.models.DocumentModel;
import org.openfact.models.DocumentQuery;
import org.openfact.models.DocumentQuery.EntityQuery;
import org.openfact.models.OrganizationModel;
import org.openfact.models.jpa.entities.DocumentEntity;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class JpaDocumentQuery implements DocumentQuery {

    private final CriteriaBuilder cb;
    private final CriteriaQuery cq;
    private final Root<DocumentEntity> root;
    private final ArrayList<Predicate> predicates;
    private Map<String, Boolean> orderBy;

    private EntityManager em;
    private OrganizationModel organization;

    public JpaDocumentQuery(EntityManager em, OrganizationModel organization) {
        this.em = em;
        this.organization = organization;

        cb = em.getCriteriaBuilder();
        cq = cb.createQuery();
        root = cq.from(DocumentEntity.class);

        predicates = new ArrayList<>();
        orderBy = new HashMap<>();
    }

    @Override
    public DocumentQuery currencyCode(String... currencyCode) {
        if (currencyCode.length > 0) {
            List<String> currencyCodes = Arrays.stream(currencyCode)
                    .map(String::toUpperCase)
                    .collect(Collectors.toList());
            predicates.add(cb.upper(root.get(JpaDocumentProvider.DOCUMENT_CURRENCY_CODE)).in(currencyCodes));
        }
        return this;
    }

    @Override
    public DocumentQuery documentType(String... documentType) {
        return null;
    }

    @Override
    public DocumentQuery documentType(DocumentModel.DocumentType... documentType) {
        return null;
    }

    @Override
    public DocumentQuery requiredAction(String... requiredAction) {
        return null;
    }

    @Override
    public DocumentQuery requiredAction(DocumentModel.RequiredAction... requiredAction) {
        return null;
    }

    @Override
    public DocumentQuery filterText(String filterText) {
        return null;
    }

    @Override
    public DocumentQuery filterTextPattern(String filterText) {
        return null;
    }

    @Override
    public DocumentQuery enabled(boolean enabled) {
        return null;
    }

    @Override
    public DocumentQuery fromDate(LocalDateTime fromDate, boolean include) {
        return null;
    }

    @Override
    public DocumentQuery toDate(LocalDateTime toDate, boolean include) {
        return null;
    }

    @Override
    public EntityQuery entityQuery() {
        return new JpaEntityQuery();
    }

    @Override
    public CountQuery countQuery() {
        return new JpaCountQuery();
    }

    class JpaEntityQuery implements EntityQuery {

        private Map<String, Boolean> orderBy;

        public JpaEntityQuery() {
            orderBy = new HashMap<>();
        }

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

    class JpaCountQuery implements CountQuery {
        @Override
        public int getTotalCount() {
            cq.select(cb.count(root));

            if (!predicates.isEmpty()) {
                cq.where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
            }

            TypedQuery<Long> query = em.createQuery(cq);
            return query.getSingleResult().intValue();
        }
    }
}
