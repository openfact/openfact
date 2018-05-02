package org.openfact.core.models.query;

import java.util.ArrayList;
import java.util.List;

public class BoolQuery implements ComposedQuery {

    private final List<Query> must = new ArrayList<>();
    private final List<Query> mustNot = new ArrayList<>();
    private final List<Query> should = new ArrayList<>();
    private final List<Query> filter = new ArrayList<>();
    private String minimumShouldMatch;

    @Override
    public String getQueryName() {
        return "BoolQuery";
    }

    public BoolQuery must(Query query) {
        this.must.add(query);
        return this;
    }

    public BoolQuery mustNot(Query query) {
        this.mustNot.add(query);
        return this;
    }

    public BoolQuery should(Query query) {
        this.should.add(query);
        return this;
    }

    public BoolQuery minimumShouldMatch(String minimumShouldMatch) {
        this.minimumShouldMatch = minimumShouldMatch;
        return this;
    }

    public BoolQuery minimumShouldMatch(Integer minimumShouldMatch) {
        this.minimumShouldMatch = Integer.toString(minimumShouldMatch);
        return this;
    }

    public BoolQuery filter(Query query) {
        this.filter.add(query);
        return this;
    }

    public List<Query> getMust() {
        return must;
    }

    public List<Query> getMustNot() {
        return mustNot;
    }

    public List<Query> getShould() {
        return should;
    }

    public String getMinimumShouldMatch() {
        return minimumShouldMatch;
    }

    public List<Query> getFilter() {
        return filter;
    }

}
