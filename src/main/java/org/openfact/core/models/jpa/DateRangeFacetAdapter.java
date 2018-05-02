package org.openfact.core.models.jpa;

import org.hibernate.search.query.facet.Facet;
import org.hibernate.search.query.facet.RangeFacet;
import org.openfact.core.models.FacetModel;
import org.openfact.core.models.RangeModel;

import java.util.Date;

public class DateRangeFacetAdapter implements FacetModel<RangeModel<Date>> {

    private final Facet facet;

    public DateRangeFacetAdapter(Facet facet) {
        this.facet = facet;
    }

    @Override
    public RangeModel<Date> getValue() {
        RangeFacet<Date> range = (RangeFacet<Date>) facet;
        return new RangeModel<Date>() {
            @Override
            public Date getFrom() {
                return range.getMin();
            }

            @Override
            public Date getTo() {
                return range.getMax();
            }
        };
    }

    @Override
    public int getCount() {
        return facet.getCount();
    }
}
