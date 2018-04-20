package org.openfact.core.models;

import org.openfact.core.models.query.SimpleQuery;

import java.util.HashSet;
import java.util.Set;

public class DocumentQueryModel {

    private final String filterText;
    private final Set<SimpleQuery> filters;
    private final Set<SimpleQuery> negativeFilters;

    private final String orderBy;
    private final boolean asc;

    private final Integer offset;
    private final Integer limit;

    private DocumentQueryModel(Builder builder) {
        this.filterText = builder.filterText;
        this.filters = builder.filters;
        this.negativeFilters = builder.negativeFilters;

        this.orderBy = builder.orderBy;
        this.asc = builder.asc;

        this.offset = builder.offset;
        this.limit = builder.limit;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getFilterText() {
        return filterText;
    }

    public Set<SimpleQuery> getFilters() {
        return filters;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public boolean isAsc() {
        return asc;
    }

    public Integer getOffset() {
        return offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public Set<SimpleQuery> getNegativeFilters() {
        return negativeFilters;
    }

    public static class Builder {

        private String filterText;
        private Set<SimpleQuery> filters = new HashSet<>();
        private Set<SimpleQuery> negativeFilters = new HashSet<>();

        private boolean asc;
        private String orderBy;

        private Integer offset;
        private Integer limit;

        public Builder filterText(String filterText) {
            this.filterText = filterText;
            return this;
        }

        public Builder addFilter(SimpleQuery SimpleQuery) {
            this.filters.add(SimpleQuery);
            return this;
        }

        public Builder addNegativeFilter(SimpleQuery SimpleQuery) {
            this.negativeFilters.add(SimpleQuery);
            return this;
        }

        public Builder orderBy(String field, boolean asc) {
            this.orderBy = field;
            this.asc = asc;
            return this;
        }

        public Builder offset(Integer offset) {
            this.offset = offset;
            return this;
        }

        public Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        public DocumentQueryModel build() {
            return new DocumentQueryModel(this);
        }

    }

}
