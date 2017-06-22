package org.openfact.models.jpa;

import org.openfact.models.DocumentModel;
import org.openfact.models.DocumentQuery;
import org.openfact.models.DocumentQueryProvider;
import org.openfact.models.OrganizationModel;
import org.openfact.models.query.QueryResult;
import org.openfact.models.query.SortableQueryResult;
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
    public QueryResult<Integer> countQuery(DocumentQuery query) {
        return new JpaDocumentCountQueryResult(em, organization, query);
    }

    @Override
    public SortableQueryResult<List<DocumentModel>> listQuery(DocumentQuery query) {
        return new JpaDocumentListModelQueryResult(organization, query, em);
    }

    @Override
    public SortableQueryResult<SearchResultsModel<DocumentModel>> searchQuery(DocumentQuery query) {
        return new JpaDocumentSearchResultModelQueryResult(organization, query, em);
    }

}
