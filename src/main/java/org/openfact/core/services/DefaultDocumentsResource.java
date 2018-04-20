package org.openfact.core.services;

import org.openfact.core.DocumentsResource;
import org.openfact.core.models.*;
import org.openfact.core.models.query.*;
import org.openfact.core.models.utils.ModelToRepresentation;
import org.openfact.core.representations.idm.DocumentQueryRepresentation;
import org.openfact.core.representations.idm.DocumentRepresentation;
import org.openfact.core.representations.idm.FacetRepresentation;
import org.openfact.core.representations.idm.SearchResultRepresentation;
import org.openfact.core.security.ISecurityContext;
import org.openfact.core.security.PermissionType;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import java.util.*;
import java.util.stream.Collectors;

@Transactional
@ApplicationScoped
public class DefaultDocumentsResource implements DocumentsResource {

    @Inject
    private ISecurityContext securityContext;

    @Inject
    private DocumentProvider documentProvider;

    @Override
    public DocumentRepresentation getDocument(String documentId) {
        DocumentModel document = documentProvider.getDocument(documentId).orElseThrow(NotFoundException::new);
        return ModelToRepresentation.toRepresentation(document);
    }

    @Override
    public Response downloadDocumentXml(String documentId) {
        return null;
    }

    @Override
    public Response downloadDocumentPdf(HttpServletRequest httpServletRequest, String documentId, String theme, String locale, String format) {
        return null;
    }

    @Override
    public Response getDocuments(String filterText, int offset, int limit) {
        return null;
    }

    @Override
    public SearchResultRepresentation<DocumentRepresentation> searchUserDocuments(DocumentQueryRepresentation query) {
        if (!securityContext.isAdmin() && !securityContext.hasPermission(PermissionType.document_view, query.getOrganizationId())) {
            throw new ForbiddenException();
        }

        // Search query
        TermsQuery typeQuery = null;
        if (query.getTypes() != null && !query.getTypes().isEmpty()) {
            typeQuery = new TermsQuery(DocumentModel.TYPE, query.getTypes());
        }

        TermsQuery currencyQuery = null;
        if (query.getCurrencies() != null && !query.getCurrencies().isEmpty()) {
            currencyQuery = new TermsQuery(DocumentModel.CURRENCY, query.getCurrencies());
        }

        RangeQuery amountQuery = null;
        if (query.getGreaterThan() != null || query.getLessThan() != null) {
            amountQuery = new RangeQuery(DocumentModel.AMOUNT);
            if (query.getGreaterThan() != null) {
                amountQuery.gte(query.getGreaterThan());
            }
            if (query.getLessThan() != null) {
                amountQuery.lte(query.getLessThan());
            }
        }

        RangeQuery issueDateQuery = null;
        if (query.getAfter() != null || query.getBefore() != null) {
            issueDateQuery = new RangeQuery(DocumentModel.ISSUE_DATE);
            if (query.getAfter() != null) {
                issueDateQuery.gte(query.getAfter());
            }
            if (query.getBefore() != null) {
                issueDateQuery.lte(query.getBefore());
            }
        }

        String orderBy = query.getOrderBy();
        if (query.getOrderBy() == null) {
            orderBy = DocumentModel.ISSUE_DATE;
        }

        Optional<String> optionalFilterText = Optional.ofNullable(query.getFilterText());
        DocumentQueryModel.Builder builder = DocumentQueryModel.builder()
                .filterText(optionalFilterText.orElse(""))
                .orderBy(orderBy, query.isAsc())
                .offset(query.getOffset() != null ? query.getOffset() : 0)
                .limit(query.getLimit() != null ? query.getLimit() : 10);

        if (typeQuery != null) {
            builder.addFilter(typeQuery);
        }
        if (currencyQuery != null) {
            builder.addFilter(currencyQuery);
        }

        if (amountQuery != null) {
            builder.addFilter(amountQuery);
        }
        if (issueDateQuery != null) {
            builder.addFilter(issueDateQuery);
        }

        SearchResultModel<DocumentModel> result = documentProvider.searchDocuments(builder.build(), query.getOrganizationId());

        // Facets
        Map<String, List<FacetRepresentation>> facets = new HashMap<>();
        for (Map.Entry<String, List<FacetModel>> entry : result.getFacets().entrySet()) {
            facets.put(entry.getKey(), entry.getValue().stream().map(ModelToRepresentation::toRepresentation).collect(Collectors.toList()));
        }


        List<DocumentRepresentation> representations = result.getItems()
                .stream()
                .map(ModelToRepresentation::toRepresentation)
                .collect(Collectors.toList());
        return new SearchResultRepresentation<>(representations, result.getTotalResults(), facets);
    }

}
