package org.openfact.models;

import org.openfact.models.search.PagingModel;

public class SearchQueryParamsModel {
    private final PagingModel paging;
    private final String[] orderByAsc;
    private final String[] orderByDesc;

    public SearchQueryParamsModel(Builder builder) {
        this.paging = builder.paging;
        this.orderByAsc = builder.orderByAsc;
        this.orderByDesc = builder.orderByDesc;
    }

    public static Builder builder() {
        return new Builder();
    }

    public PagingModel getPaging() {
        return paging;
    }

    public String[] getOrderByAsc() {
        return orderByAsc;
    }

    public String[] getOrderByDesc() {
        return orderByDesc;
    }

    public static class Builder {
        public PagingModel paging;
        private String[] orderByAsc;
        private String[] orderByDesc;

        public Builder paging(PagingModel paging) {
            this.paging = paging;
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

        public SearchQueryParamsModel build() {
            return new SearchQueryParamsModel(this);
        }
    }
}