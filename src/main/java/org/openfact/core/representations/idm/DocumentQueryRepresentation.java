package org.openfact.core.representations.idm;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

public class DocumentQueryRepresentation {

    @NotEmpty
    @NotNull
    private String organizationId;

    private String filterText;

    private Set<String> types;
    private Set<String> currencies;

    private Date after;
    private Date before;

    private Double lessThan;
    private Double greaterThan;

    private String orderBy;
    private boolean asc;

    private Integer offset;
    private Integer limit;

    public String getFilterText() {
        return filterText;
    }

    public void setFilterText(String filterText) {
        this.filterText = filterText;
    }

    public Set<String> getTypes() {
        return types;
    }

    public void setTypes(Set<String> types) {
        this.types = types;
    }

    public Set<String> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(Set<String> currencies) {
        this.currencies = currencies;
    }

    public Date getAfter() {
        return after;
    }

    public void setAfter(Date after) {
        this.after = after;
    }

    public Date getBefore() {
        return before;
    }

    public void setBefore(Date before) {
        this.before = before;
    }

    public Double getLessThan() {
        return lessThan;
    }

    public void setLessThan(Double lessThan) {
        this.lessThan = lessThan;
    }

    public Double getGreaterThan() {
        return greaterThan;
    }

    public void setGreaterThan(Double greaterThan) {
        this.greaterThan = greaterThan;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public boolean isAsc() {
        return asc;
    }

    public void setAsc(boolean asc) {
        this.asc = asc;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }
}
