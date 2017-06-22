package org.openfact.models;

public class ListQueryParamsModel {

    private final Integer firstResult;
    private final Integer maxResults;
    private final String[] orderByAsc;
    private final String[] orderByDesc;

    public ListQueryParamsModel(Builder builder) {
        this.firstResult = builder.firstResult;
        this.maxResults = builder.maxResults;
        this.orderByAsc = builder.orderByAsc;
        this.orderByDesc = builder.orderByDesc;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Integer getFirstResult() {
        return firstResult;
    }

    public Integer getMaxResults() {
        return maxResults;
    }

    public String[] getOrderByAsc() {
        return orderByAsc;
    }

    public String[] getOrderByDesc() {
        return orderByDesc;
    }

    public static class Builder {
        private Integer firstResult;
        private Integer maxResults;
        private String[] orderByAsc;
        private String[] orderByDesc;

        public Builder firstResult(int firstResult) {
            this.firstResult = firstResult;
            return this;
        }

        public Builder maxResults(int maxResults) {
            this.maxResults = maxResults;
            return this;
        }
        
        public Builder orderByAsc(String... orderByAsc) {
            this.orderByAsc = orderByAsc;
            return this;
        }

        public Builder orderByDesc(String... orderByDesc) {
            this.orderByDesc = orderByDesc;
            return this;
        }

        public ListQueryParamsModel build() {
            return new ListQueryParamsModel(this);
        }
    }
}

