package org.openfact.representations.idm.search;

import java.util.ArrayList;
import java.util.List;

public class SearchCriteriaRepresentation {

	private String filterText;
	private List<SearchCriteriaFilterRepresentation> filters = new ArrayList<>();
	private List<OrderByRepresentation> orders = new ArrayList<>();
	private PagingRepresentation paging;

	public String getFilterText() {
		return filterText;
	}

	public void setFilterText(String filterText) {
		this.filterText = filterText;
	}

	public List<SearchCriteriaFilterRepresentation> getFilters() {
		return filters;
	}

	public void setFilters(List<SearchCriteriaFilterRepresentation> filters) {
		this.filters = filters;
	}

	public List<OrderByRepresentation> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderByRepresentation> orders) {
		this.orders = orders;
	}

	public PagingRepresentation getPaging() {
		return paging;
	}

	public void setPaging(PagingRepresentation paging) {
		this.paging = paging;
	}

}
