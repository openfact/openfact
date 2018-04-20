package org.openfact.core.representations.idm;

import java.util.List;
import java.util.Map;

public class SearchResultRepresentation<T> {

    private List<T> items;
    private Integer totalResults;
    private Map<String, List<FacetRepresentation>> facets;

    public SearchResultRepresentation() {

    }

    public SearchResultRepresentation(List<T> items, Integer totalResults, Map<String, List<FacetRepresentation>> facets) {
        this.items = items;
        this.totalResults = totalResults;
        this.facets = facets;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public Map<String, List<FacetRepresentation>> getFacets() {
        return facets;
    }

    public void setFacets(Map<String, List<FacetRepresentation>> facets) {
        this.facets = facets;
    }
}
