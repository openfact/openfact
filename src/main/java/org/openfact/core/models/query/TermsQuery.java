package org.openfact.core.models.query;

import java.util.Collection;

public class TermsQuery implements SimpleQuery {

    private final String name;
    private final Collection<?> values;

    public TermsQuery(String name, Collection<?> values) {
        this.name = name;
        this.values = values;
    }

    @Override
    public String getQueryName() {
        return "TermsQuery";
    }

    public String getName() {
        return name;
    }

    public Collection<?> getValues() {
        return values;
    }
}
