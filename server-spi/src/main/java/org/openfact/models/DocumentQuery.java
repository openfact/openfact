package org.openfact.models;

import org.openfact.models.enums.RequiredAction;
import org.openfact.models.search.SearchCriteriaFilterModel;
import org.w3c.dom.Document;

import java.time.LocalDateTime;
import java.util.List;

public interface DocumentQuery {

    DocumentQuery currencyCode(String... currencyCode);

    DocumentQuery documentType(String... documentType);

    DocumentQuery filterText(String filterText, String... fieldName);

    DocumentQuery requiredAction(RequiredAction... requiredAction);

    DocumentQuery addFilter(SearchCriteriaFilterModel filter);

    DocumentQuery orderByAsc(String... attribute);

    DocumentQuery orderByDesc(String... attribute);

    DocumentQuery fromDate(LocalDateTime fromDate);

    DocumentQuery toDate(LocalDateTime toDate);

    DocumentQuery firstResult(int result);

    DocumentQuery maxResults(int results);

    List<DocumentModel> getResultList();

    ScrollModel<DocumentModel> getScrollResult(int scrollSize);

    ScrollModel<List<DocumentModel>> getScrollResultList(int listSize);

}
