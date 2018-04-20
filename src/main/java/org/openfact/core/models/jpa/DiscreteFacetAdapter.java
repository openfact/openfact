package org.openfact.core.models.jpa;

import org.hibernate.search.query.facet.Facet;
import org.openfact.core.models.FacetModel;

public class DiscreteFacetAdapter implements FacetModel<String> {

    private final Facet facet;

    public DiscreteFacetAdapter(Facet facet) {
        this.facet = facet;
    }

    @Override
    public String getValue() {
        return facet.getValue();
    }

    @Override
    public int getCount() {
        return facet.getCount();
    }

}
