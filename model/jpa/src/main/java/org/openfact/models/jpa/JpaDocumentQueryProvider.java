package org.openfact.models.jpa;

import org.openfact.models.*;
import org.openfact.models.query.QueryResult;
import org.openfact.models.search.SearchResultsModel;

import javax.persistence.EntityManager;
import java.util.List;

public class JpaDocumentQueryProvider implements DocumentQueryProvider {

    private EntityManager em;
    private OrganizationModel organization;

    public JpaDocumentQueryProvider(EntityManager em, OrganizationModel organization) {
        this.em = em;
        this.organization = organization;
    }

    @Override
    public QueryResult<Integer> countQuery(DocumentQueryModel query) {
        return new JpaDocumentCountQueryResult(em, organization, query);
    }

    @Override
    public QueryResult<List<DocumentModel>> listQuery(DocumentQueryModel query) {
        return new JpaDocumentListModelQueryResult(em, organization, query, null);
    }

    @Override
    public QueryResult<List<DocumentModel>> listQuery(DocumentQueryModel query, ListQueryParamsModel params) {
        return new JpaDocumentListModelQueryResult(em, organization, query, params);
    }

    @Override
    public QueryResult<SearchResultsModel<DocumentModel>> searchQuery(DocumentQueryModel query) {
        return new JpaDocumentSearchResultModelQueryResult(em, organization, query, null);
    }

    @Override
    public QueryResult<SearchResultsModel<DocumentModel>> searchQuery(DocumentQueryModel query, SearchQueryParamsModel params) {
        return new JpaDocumentSearchResultModelQueryResult(em, organization, query, params);
    }

}
