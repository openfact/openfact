package org.openfact.models.jpa.entities.search;

/**
 * A base class that JPA storage impls can extend.
 */
public class SearchCriteriaJoinAliasModel {

    private String associationPath;
    private String associationAlias;
    private SearchCriteriaJoinType joinType;

    public SearchCriteriaJoinAliasModel() {

    }

    public String getAssociationPath() {
        return associationPath;
    }

    public void setAssociationPath(String associationPath) {
        this.associationPath = associationPath;
    }

    public String getAssociationAlias() {
        return associationAlias;
    }

    public void setAssociationAlias(String associationAlias) {
        this.associationAlias = associationAlias;
    }

    public SearchCriteriaJoinType getJoinType() {
        return joinType;
    }

    public void setJoinType(SearchCriteriaJoinType joinType) {
        this.joinType = joinType;
    }

}