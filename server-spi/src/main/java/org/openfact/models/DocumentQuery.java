package org.openfact.models;

import org.openfact.models.enums.DocumentType;
import org.openfact.models.enums.RequiredAction;
import org.openfact.models.search.PagingModel;
import org.openfact.models.search.SearchCriteriaFilterModel;
import org.openfact.models.search.SearchCriteriaFilterOperator;
import org.openfact.models.search.SearchResultsModel;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface DocumentQuery {

    DocumentQuery currencyCode(String... currencyCode);

    DocumentQuery documentType(DocumentType... documentType);
    DocumentQuery documentType(String... documentType);

    DocumentQuery requiredAction(RequiredAction... requiredAction);

    DocumentQuery filterText(String filterText, String... fieldName);
    DocumentQuery filterTextReplaceAsterisk(String filterText, String... fieldName);

    DocumentQuery customerSendEventFailures(int numberFailures, boolean greatherThan);
    DocumentQuery thirdPartySendEventFailures(int numberFailures, boolean greatherThan);

    DocumentQuery enabled(boolean isEnabled);

    /**
     * Just equals filters
     */
    DocumentQuery addFilter(String key, String value);
    DocumentQuery addFilter(Map<String, String> filters);
    DocumentQuery addFilter(String key, Object value, SearchCriteriaFilterOperator operator);

    DocumentQuery fromDate(LocalDateTime fromDate);
    DocumentQuery toDate(LocalDateTime toDate);

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

}
