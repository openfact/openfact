package org.openfact.core.models.query;

public class RangeQuery implements SimpleQuery {

    private final String name;

    private Object from;
    private boolean includeFrom;

    private Object to;
    private boolean includeTo;

    public RangeQuery(String name) {
        this.name = name;
    }

    @Override
    public String getQueryName() {
        return "RangeQuery";
    }

    public RangeQuery gt(Object value) {
        this.from = value;
        this.includeFrom = false;
        return this;
    }

    public RangeQuery gte(Object value) {
        this.from = value;
        this.includeFrom = true;
        return this;
    }

    public RangeQuery lt(Object value) {
        this.to = value;
        this.includeTo = false;
        return this;
    }

    public RangeQuery lte(Object value) {
        this.to = value;
        this.includeTo = true;
        return this;
    }

    public String getName() {
        return name;
    }

    public Object getFrom() {
        return from;
    }

    public boolean isIncludeFrom() {
        return includeFrom;
    }

    public Object getTo() {
        return to;
    }

    public boolean isIncludeTo() {
        return includeTo;
    }

}
