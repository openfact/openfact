package org.openfact.models.search;

import java.util.ArrayList;
import java.util.List;

/**
 * Generic search criteria used when searching for beans.
 */
public class SearchCriteriaModel {

    private List<SearchCriteriaFilterModel> filters = new ArrayList<>();
    private List<OrderByModel> orders = new ArrayList<>();
    private PagingModel paging;

    /**
     * Constructor.
     */
    public SearchCriteriaModel() {
    }

    /**
     * Adds a single filter to the criteria.
     *
     * @param name     the filter name
     * @param value    the filter value
     * @param operator the operator type
     */
    public void addFilter(String name, Object value, SearchCriteriaFilterOperator operator) {
        SearchCriteriaFilterModel filter = new SearchCriteriaFilterModel();
        filter.setName(name);
        filter.setValue(value);
        filter.setOperator(operator);
        filters.add(filter);
    }

    /**
     * Adds a single filter to the criteria.
     *
     * @param filter the filter object
     */
    public void addFilter(SearchCriteriaFilterModel filter) {
        filters.add(filter);
    }

    public void addOrder(String name, boolean ascending) {
        OrderByModel orderBy = new OrderByModel();
        orderBy.setName(name);
        orderBy.setAscending(ascending);
        orders.add(orderBy);
    }

    public void addOrder(OrderByModel orderBy) {
        orders.add(orderBy);
    }

    /**
     * @param page the page
     */
    public void setPage(int page) {
        if (this.paging == null)
            this.paging = new PagingModel();
        getPaging().setPage(page);
    }

    /**
     * @param pageSize size of page
     */
    public void setPageSize(int pageSize) {
        if (this.paging == null)
            this.paging = new PagingModel();
        getPaging().setPageSize(pageSize);
    }

    /**
     * @return the filters
     */
    public List<SearchCriteriaFilterModel> getFilters() {
        return filters;
    }

    /**
     * @param filters the filters to set
     */
    public void setFilters(List<SearchCriteriaFilterModel> filters) {
        this.filters = filters;
    }

    /**
     * @return the paging
     */
    public PagingModel getPaging() {
        return paging;
    }

    /**
     * @param paging the paging to set
     */
    public void setPaging(PagingModel paging) {
        this.paging = paging;
    }

    /**
     * @return the orderBy
     */
    public List<OrderByModel> getOrders() {
        return orders;
    }

    /**
     * @param orderBy the orderBy to set
     */
    public void setOrders(List<OrderByModel> orders) {
        this.orders = orders;
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((filters == null) ? 0 : filters.hashCode());
        result = prime * result + ((orders == null) ? 0 : orders.hashCode());
        result = prime * result + ((paging == null) ? 0 : paging.hashCode());
        return result;
    }

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SearchCriteriaModel other = (SearchCriteriaModel) obj;
        if (filters == null) {
            if (other.filters != null)
                return false;
        } else if (!filters.equals(other.filters))
            return false;
        if (orders == null) {
            if (other.orders != null)
                return false;
        } else if (!orders.equals(other.orders))
            return false;
        if (paging == null) {
            if (other.paging != null)
                return false;
        } else if (!paging.equals(other.paging))
            return false;
        return true;
    }

}
