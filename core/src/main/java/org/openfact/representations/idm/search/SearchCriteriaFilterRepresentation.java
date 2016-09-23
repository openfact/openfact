package org.openfact.representations.idm.search;

public class SearchCriteriaFilterRepresentation {

    private String name;
    private Object value;

    private SearchCriteriaFilterOperatorRepresentation operator;

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

}
