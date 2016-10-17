package org.openfact.representations.idm.search;

public class SearchCriteriaFilterRepresentation {

    private String name;
    private Object value;
    private SearchCriteriaFilterOperatorRepresentation operator;

    private FilterValueType type;

    public enum FilterValueType {
        LONG, DATE, DATETIME, STRING
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public SearchCriteriaFilterOperatorRepresentation getOperator() {
        return operator;
    }

    public void setOperator(SearchCriteriaFilterOperatorRepresentation operator) {
        this.operator = operator;
    }

    public FilterValueType getType() {
        return type;
    }

    public void setType(FilterValueType type) {
        this.type = type;
    }

}
