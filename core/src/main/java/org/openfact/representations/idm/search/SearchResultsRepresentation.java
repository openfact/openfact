package org.openfact.representations.idm.search;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsRepresentation<T> {

    private List<T> items = new ArrayList<>();
    private int totalSize;

    /**
     * @return the beans
     */
    public List<T> getItems() {
        return items;
    }

    /**
     * @param beans
     *            the beans to set
     */
    public void setItems(List<T> items) {
        this.items = items;
    }

    /**
     * @return the totalSize
     */
    public int getTotalSize() {
        return totalSize;
    }

    /**
     * @param totalSize
     *            the totalSize to set
     */
    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

}
