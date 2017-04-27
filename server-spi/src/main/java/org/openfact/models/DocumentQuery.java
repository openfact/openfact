package org.openfact.models;

import org.openfact.common.converts.DateUtils;
import org.openfact.models.search.PagingModel;
import org.openfact.models.search.SearchCriteriaFilterOperator;
import org.openfact.models.search.SearchResultsModel;
import org.openfact.models.types.DocumentRequiredAction;
import org.openfact.models.types.DocumentType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public interface DocumentQuery {

    DocumentQuery currencyCode(String... currencyCode);

    DocumentQuery documentType(DocumentType... documentType);

    DocumentQuery documentType(String... documentType);

    DocumentQuery requiredAction(DocumentRequiredAction... requiredAction);

    DocumentQuery filterText(String filterText);

    DocumentQuery filterTextReplaceAsterisk(String filterText, String... fieldName);

    DocumentQuery customerSendEventFailures(int numberFailures, boolean greatherThan);

    DocumentQuery thirdPartySendEventFailures(int numberFailures, boolean greatherThan);

    DocumentQuery enabled(boolean enabled);

    /**
     * Just equals filters
     */
    DocumentQuery addFilter(String key, String value);

    DocumentQuery addFilter(Map<String, String> filters);

    DocumentQuery addFilter(String key, Object value, SearchCriteriaFilterOperator operator);

    DocumentQuery fromDate(LocalDateTime fromDate, boolean include);

    DocumentQuery toDate(LocalDateTime toDate, boolean include);

    EntityQuery entityQuery();

    CountQuery countQuery();

    interface EntityQuery {
        EntityQuery orderByAsc(String... attribute);

        EntityQuery orderByDesc(String... attribute);

        ListEntityQuery resultList();

        SearchResultEntityQuery searchResult();

        ScrollEntityQuery resultScroll();
    }

    interface ListEntityQuery {
        List<DocumentModel> getResultList();

        ListEntityQuery firstResult(int result);

        ListEntityQuery maxResults(int results);
    }

    interface ScrollEntityQuery {
        ScrollModel<DocumentModel> getScrollResult(int scrollSize);

        ScrollModel<List<DocumentModel>> getScrollResultList(int listSize);
    }

    interface SearchResultEntityQuery {
        SearchResultsModel<DocumentModel> getSearchResult();

        SearchResultsModel<DocumentModel> getSearchResult(PagingModel pagingModel);
    }

    interface CountQuery {
        int getTotalCount();
    }

    /**
     * */
    default DocumentQuery applyQuery(String query) {
        if (!query.trim().isEmpty()) {
            Map<QueryOperator, String> params = QueryOperator.mapQuery(query);
            for (Map.Entry<DocumentQuery.QueryOperator, String> map : params.entrySet()) {
                switch (map.getKey()) {
                    case FILTER_TEXT:
                        this.filterText(map.getValue());
                        break;
                    case CURRENCY_CODE:
                        this.currencyCode(map.getValue().split(","));
                        break;
                    case DOCUMENT_TYPE:
                        this.documentType(map.getValue().split(","));
                        break;
                    case AFTER:
                        LocalDate after = DateUtils.asLocalDate(map.getValue());
                        if (after != null) {
                            this.fromDate(after.atStartOfDay(), true);
                        }
                        break;
                    case BEFORE:
                        LocalDate before = DateUtils.asLocalDate(map.getValue());
                        if (before != null) {
                            this.toDate(before.plusDays(1).atStartOfDay(), true);
                        }
                        break;
                }
            }
        }
        return this;
    }

    enum QueryOperator {
        FILTER_TEXT("filtertext"),
        CURRENCY_CODE("currency_code"),
        DOCUMENT_TYPE("document_type"),
        AFTER("after"),
        BEFORE("before");

        private String name;

        QueryOperator(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public static Optional<QueryOperator> getByName(String name) {
            return Arrays.stream(QueryOperator.values())
                    .filter(f -> f.getName().equals(name))
                    .findFirst();
        }

        public static Map<QueryOperator, String> mapQuery(String query) {
            Map<QueryOperator, String> result = new HashMap<>();

            String[] userQueries = query.trim().split(" ");
            for (String userQuery : userQueries) {
                String[] operator = userQuery.split(":");
                QueryOperator.getByName(operator[0])
                        .ifPresent(queryOperator -> result.put(queryOperator, operator[1]));
            }
            return result;
        }
    }

}
