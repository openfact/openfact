package org.openfact.models;

import org.openfact.models.enums.RequiredAction;
import org.openfact.models.search.SearchCriteriaFilterModel;

import java.time.LocalDateTime;
import java.util.List;

public interface DocumentCountQuery {

    DocumentCountQuery currencyCode(String... currencyCode);

    DocumentCountQuery documentType(String... documentType);

    DocumentCountQuery filterText(String filterText, String... fieldName);

    DocumentCountQuery requiredAction(RequiredAction... requiredAction);

    DocumentCountQuery addFilter(SearchCriteriaFilterModel filter);

    DocumentCountQuery fromDate(LocalDateTime fromDate);

    DocumentCountQuery toDate(LocalDateTime toDate);

    int getTotalCount();

}
