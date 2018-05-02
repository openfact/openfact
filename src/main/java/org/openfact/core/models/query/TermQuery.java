package org.openfact.core.models.query;

public class TermQuery implements SimpleQuery {

    private final String name;
    private final Object value;

    public TermQuery(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String getQueryName() {
        return "TermQuery";
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

}
