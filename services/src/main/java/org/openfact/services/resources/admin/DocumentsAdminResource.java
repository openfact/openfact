/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.openfact.services.resources.admin;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.jboss.resteasy.annotations.cache.NoCache;
import org.openfact.events.admin.ResourceType;
import org.openfact.models.OrganizationModel;
import org.openfact.representations.idm.DocumentRepresentation;
import org.openfact.representations.idm.search.SearchCriteriaRepresentation;
import org.openfact.representations.idm.search.SearchResultsRepresentation;

/**
 * @author carlosthe19916@sistcoop.com
 */
@Consumes(MediaType.APPLICATION_JSON)
public class DocumentsAdminResource {

    @Context
    protected UriInfo uriInfo;

    @Context
    protected HttpHeaders headers;

    protected OrganizationModel organization;
    protected OrganizationAuth auth;
    protected AdminEventBuilder adminEvent;

    public DocumentsAdminResource(OrganizationModel organization, OrganizationAuth auth, AdminEventBuilder adminEvent) {
        this.auth = auth;
        this.organization = organization;
        this.adminEvent = adminEvent.resource(ResourceType.DOCUMENT);

        auth.init(OrganizationAuth.Resource.DOCUMENT);
    }

    /**
     * @param documentId The invoiceId of the document
     */
    @Path("{documentId}")
    public DocumentAdminResource getInvoiceAdmin(@PathParam("documentId") final String documentId) {
        /*DocumentModel document = session.documents().getDocumentById(documentId, organization);
        if (document == null) {
            throw new NotFoundException("Document not found");
        }

        DocumentAdminResource invoiceResource = new DocumentAdminResource(organization, auth, adminEvent, document);
        ResteasyProviderFactory.getInstance().injectProperties(invoiceResource);
        return invoiceResource;*/
        return null;
    }

    @GET
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public List<DocumentRepresentation> getDocuments(
            @QueryParam("filterText") String filterText,
            @QueryParam("documentType") String documentType,
            @QueryParam("documentId") String documentId,
            @QueryParam("first") Integer firstResult,
            @QueryParam("max") Integer maxResults) {

        /*auth.requireView();

        firstResult = firstResult != null ? firstResult : -1;
        maxResults = maxResults != null ? maxResults : Constants.DEFAULT_MAX_RESULTS;

        List<DocumentModel> documentModels;
        if (filterText != null) {
            documentModels = session.documents().searchForDocument(filterText.trim(), organization, firstResult, maxResults);
        } else if (documentId != null || documentType != null) {
            Map<String, String> attributes = new HashMap<>();
            if (documentType != null) {
                attributes.put(DocumentModel.DOCUMENT_TYPE, documentType);
            }
            if (documentId != null) {
                attributes.put(DocumentModel.DOCUMENT_ID, documentId);
            }
            documentModels = session.documents().createQuery(organization)
                    .addFilter(attributes)
                    .entityQuery()
                    .resultList().firstResult(firstResult).maxResults(maxResults).getResultList();
        } else {
            documentModels = session.documents().getDocuments(organization, firstResult, maxResults);
        }

        return documentModels.stream()
                .map(f -> ModelToRepresentation.toRepresentation(f))
                .collect(Collectors.toList());*/
        return null;
    }

    @POST
    @Path("search")
    @Produces(MediaType.APPLICATION_JSON)
    public SearchResultsRepresentation<DocumentRepresentation> search(final SearchCriteriaRepresentation criteria) {
        /*auth.requireView();

        SearchCriteriaModel criteriaModel = RepresentationToModel.toModel(criteria);
        String filterText = criteria.getFilterText();

        DocumentQuery query = session.documents().createQuery(organization);

        // Filtertext
        if (filterText != null && !filterText.trim().isEmpty()) {
            query.filterText(filterText, DocumentModel.DOCUMENT_ID, DocumentModel.CUSTOMER_REGISTRATION_NAME, DocumentModel.CUSTOMER_ASSIGNED_ACCOUNT_ID, DocumentModel.CUSTOMER_ELECTRONIC_MAIL);
        }

        // Filters
        if (criteriaModel.getFilters() != null && !criteriaModel.getFilters().isEmpty()) {
            for (SearchCriteriaFilterModel filter : criteriaModel.getFilters()) {
                if (filter.getName().equalsIgnoreCase(DocumentModel.REQUIRED_ACTIONS)) {
                    List<String> requiredActions = new ArrayList<>();
                    if (filter.getValue() instanceof String) {
                        requiredActions.add((String) filter.getValue());
                    } else if (filter.getValue() instanceof Collection) {
                        requiredActions.addAll((Collection) filter.getValue());
                    } else {
                        requiredActions.add(String.valueOf(filter.getValue()));
                    }

                    RequiredAction[] array = requiredActions
                            .stream()
                            .map(f -> RequiredAction.valueOf(f.toUpperCase()))
                            .toArray(size -> new RequiredAction[requiredActions.size()]);

                    query.requiredAction(array);
                } else if (filter.getName().equalsIgnoreCase(DocumentModel.CREATED_TIMESTAMP)) {
                    if (filter.getOperator().equals(SearchCriteriaFilterOperator.gt)) {
                        query.fromDate((LocalDateTime) filter.getValue(), false);
                    } else if (filter.getOperator().equals(SearchCriteriaFilterOperator.gte)) {
                        query.fromDate((LocalDateTime) filter.getValue(), true);
                    } else if (filter.getOperator().equals(SearchCriteriaFilterOperator.lt)) {
                        query.toDate((LocalDateTime) filter.getValue(), false);
                    } else if (filter.getOperator().equals(SearchCriteriaFilterOperator.lte)) {
                        query.toDate((LocalDateTime) filter.getValue(), true);
                    } else if (filter.getOperator().equals(SearchCriteriaFilterOperator.eq)) {
                        query.fromDate((LocalDateTime) filter.getValue(), true);
                        query.toDate((LocalDateTime) filter.getValue(), true);
                    } else {
                        throw new BadRequestException("Bad operator on criteria");
                    }
                } else {
                    query.addFilter(filter.getName(), filter.getValue(), filter.getOperator());
                }
            }
        }

        DocumentQuery.EntityQuery entityQuery = query.entityQuery();
        if (criteriaModel.getOrders() != null && !criteriaModel.getOrders().isEmpty()) {
            criteriaModel.getOrders().stream().forEach(c -> {
                if (c.isAscending()) {
                    entityQuery.orderByAsc(c.getName());
                } else {
                    entityQuery.orderByDesc(c.getName());
                }
            });
        }

        SearchResultsModel<DocumentModel> results = entityQuery.searchResult().getSearchResult(criteriaModel.getPaging());

        SearchResultsRepresentation<DocumentRepresentation> rep = new SearchResultsRepresentation<>();
        List<DocumentRepresentation> items = new ArrayList<>();
        results.getModels().forEach(f -> items.add(ModelToRepresentation.toRepresentation(f)));
        rep.setItems(items);
        rep.setTotalSize(results.getTotalSize());
        return rep;*/
        return null;
    }

}
