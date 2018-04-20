package org.openfact.core.models.query.es;

import org.apache.lucene.search.Filter;
import org.openfact.core.models.query.*;
import org.hibernate.search.query.dsl.BooleanJunction;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.hibernate.search.query.dsl.RangeMatchingContext;
import org.hibernate.search.query.dsl.RangeTerminationExcludable;
import org.jboss.logging.Logger;

import java.util.Arrays;
import java.util.function.Function;

public class LuceneQueryParser {

    private static final Logger logger = Logger.getLogger(LuceneQueryParser.class);

    public static org.apache.lucene.search.Query toLuceneQuery(Query query, Function<String, String> fieldMapper, QueryBuilder queryBuilder) {
        if (query instanceof MatchAllQuery) {
            return queryBuilder.all().createQuery();
        }
        if (query instanceof TermQuery) {
            TermQuery q = (TermQuery) query;
            return queryBuilder.keyword()
                    .onField(fieldMapper.apply(q.getName()))
                    .matching(q.getValue())
                    .createQuery();
        }
        if (query instanceof TermsQuery) {
            TermsQuery q = (TermsQuery) query;
            String matching = q.getValues().stream()
                    .map(String::valueOf)
                    .reduce((t, u) -> t + " " + u)
                    .orElse("");
            return queryBuilder.keyword()
                    .onField(fieldMapper.apply(q.getName()))
                    .matching(matching)
                    .createQuery();
        }
        if (query instanceof MultiMatchQuery) {
            MultiMatchQuery q = (MultiMatchQuery) query;
            return queryBuilder.keyword()
                    .onFields(Arrays.stream(q.getFieldNames()).map(fieldMapper).toArray(String[]::new))
                    .matching(q.getText())
                    .createQuery();
        }
        if (query instanceof RangeQuery) {
            RangeQuery q = (RangeQuery) query;
            RangeMatchingContext rangeMatchingContext = queryBuilder
                    .range()
                    .onField(fieldMapper.apply(q.getName()));

            if (q.getFrom() != null && q.getTo() != null) {
                RangeMatchingContext.FromRangeContext<Object> range = rangeMatchingContext.from(q.getFrom());
                if (!q.isIncludeFrom()) {
                    range = range.excludeLimit();
                }

                RangeTerminationExcludable to = range.to(q.getTo());
                if (!q.isIncludeTo()) {
                    to = to.excludeLimit();
                }
                return to.createQuery();
            }

            if (q.getFrom() != null) {
                RangeTerminationExcludable range = rangeMatchingContext.above(q.getFrom());
                if (!q.isIncludeFrom()) {
                    range = range.excludeLimit();
                }
                return range.createQuery();
            }

            if (q.getTo() != null) {
                RangeTerminationExcludable range = rangeMatchingContext.below(q.getTo());
                if (!q.isIncludeTo()) {
                    range = range.excludeLimit();
                }
                return range.createQuery();
            }
        }
        if (query instanceof BoolQuery) {
            BoolQuery q = (BoolQuery) query;
            BooleanJunction<BooleanJunction> boolQueryBuilder = queryBuilder.bool();

            q.getMust().forEach(must -> boolQueryBuilder.must(toLuceneQuery(must, fieldMapper, queryBuilder)));
            q.getMustNot().forEach(mustNot -> boolQueryBuilder.must(toLuceneQuery(mustNot, fieldMapper, queryBuilder)).not());

            q.getShould().forEach(should -> boolQueryBuilder.should(toLuceneQuery(should, fieldMapper, queryBuilder)));

            q.getFilter().forEach(filter -> boolQueryBuilder.filteredBy((Filter) toLuceneQuery(filter, fieldMapper, queryBuilder)));

            return boolQueryBuilder.createQuery();
        }

        logger.error("Could not found implementation of Query:" + query.getQueryName());
        return null;
    }

}
