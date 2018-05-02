package org.openfact.core.models.query;

public class MatchAllQuery implements SimpleQuery {

    @Override
    public String getQueryName() {
        return "MatchAll";
    }

}
