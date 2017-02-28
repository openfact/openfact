package org.openfact.models.search;

/**
 * Encapsulates paging information. Useful when listing beans or searching for
 * beans. In these cases the criteria might match a large number of beans, and
 * we only want to return a certain number of them.
 */
public class PagingModel {

    private int page;
    private int pageSize;

    /**
     * Constructor.
     */
    public PagingModel() {
    }

    /**
     * @return the page
     */
    public int getPage() {
        return page;
    }

    /**
     * @param page the page to set
     */
    public void setPage(int page) {
        this.page = page;
    }

    /**
     * @return the pageSize
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize the pageSize to set
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + page;
        result = prime * result + pageSize;
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
        PagingModel other = (PagingModel) obj;
        if (page != other.page)
            return false;
        if (pageSize != other.pageSize)
            return false;
        return true;
    }

}
