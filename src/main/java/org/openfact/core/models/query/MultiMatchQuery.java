package org.openfact.core.models.query;

public class MultiMatchQuery implements SimpleQuery {

    private final Object text;
    private final String[] fieldNames;

    public MultiMatchQuery(Object text, String... fieldNames) {
        this.text = text;
        this.fieldNames = fieldNames;
    }

    @Override
    public String getQueryName() {
        return "MultiMatch";
    }

    public Object getText() {
        return text;
    }

    public String[] getFieldNames() {
        return fieldNames;
    }

}
