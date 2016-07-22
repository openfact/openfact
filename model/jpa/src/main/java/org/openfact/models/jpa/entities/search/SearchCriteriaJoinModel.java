package org.openfact.models.jpa.entities.search;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.search.SearchCriteriaFilterModel;
import org.openfact.models.search.SearchCriteriaFilterOperator;

/**
 * A base class that JPA storage impls can extend.
 *
 * @author carlosthe19916@openfact.com
 */
public class SearchCriteriaJoinModel {

    private String entityAlias;
    private List<SearchCriteriaJoinAliasModel> joins = new ArrayList<>();
    private List<SearchCriteriaFilterModel> filters = new ArrayList<>();

    /**
     * Constructor
     */
    public SearchCriteriaJoinModel(String entityAlias) {
        this.entityAlias = entityAlias;
    }

    /**
     * Methods
     */
    public void addJoin(String associationPath, String associationAlias, SearchCriteriaJoinType joinType) {
        SearchCriteriaJoinAliasModel join = new SearchCriteriaJoinAliasModel();
        join.setAssociationPath(associationPath);
        join.setAssociationAlias(associationAlias);
        join.setJoinType(joinType);
        joins.add(join);
    }

    public void addCondition(String name, Object value, SearchCriteriaFilterOperator operator) {
        SearchCriteriaFilterModel condition = new SearchCriteriaFilterModel();
        condition.setName(name);
        condition.setValue(value);
        condition.setOperator(operator);
        filters.add(condition);
    }

    public String getEntityAlias() {
        return entityAlias;
    }

    public void setEntityAlias(String entityAlias) {
        this.entityAlias = entityAlias;
    }

    public List<SearchCriteriaJoinAliasModel> getJoins() {
        return joins;
    }

    public void setJoins(List<SearchCriteriaJoinAliasModel> joins) {
        this.joins = joins;
    }

    public List<SearchCriteriaFilterModel> getFilters() {
        return filters;
    }

    public void setFilters(List<SearchCriteriaFilterModel> filters) {
        this.filters = filters;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((entityAlias == null) ? 0 : entityAlias.hashCode());
        result = prime * result + ((filters == null) ? 0 : filters.hashCode());
        result = prime * result + ((joins == null) ? 0 : joins.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SearchCriteriaJoinModel other = (SearchCriteriaJoinModel) obj;
        if (entityAlias == null) {
            if (other.entityAlias != null)
                return false;
        } else if (!entityAlias.equals(other.entityAlias))
            return false;
        if (filters == null) {
            if (other.filters != null)
                return false;
        } else if (!filters.equals(other.filters))
            return false;
        if (joins == null) {
            if (other.joins != null)
                return false;
        } else if (!joins.equals(other.joins))
            return false;
        return true;
    }

    /**
     * Getter setter
     */

}