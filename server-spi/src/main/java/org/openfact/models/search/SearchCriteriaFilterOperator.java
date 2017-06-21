package org.openfact.models.search;

/**
 * The operator to use for a single search criteria filter. Typically we use eq,
 * but other operators are occassionally useful as well.
 */
public enum SearchCriteriaFilterOperator {

    bool_eq, eq, neq, gt, gte, lt, lte, like, in, ni;

}
