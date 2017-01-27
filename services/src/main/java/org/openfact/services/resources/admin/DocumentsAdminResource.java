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

import org.jboss.resteasy.annotations.cache.NoCache;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.openfact.common.ClientConnection;
import org.openfact.events.admin.ResourceType;
import org.openfact.models.*;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.models.utils.RepresentationToModel;
import org.openfact.representations.idm.DocumentRepresentation;
import org.openfact.representations.idm.search.SearchCriteriaRepresentation;
import org.openfact.representations.idm.search.SearchResultsRepresentation;
import org.openfact.services.ServicesLogger;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author carlosthe19916@sistcoop.com
 */
@Consumes(MediaType.APPLICATION_JSON)
public class DocumentsAdminResource {

    private static final ServicesLogger logger = ServicesLogger.LOGGER;

    @Context
    protected UriInfo uriInfo;

    @Context
    protected OpenfactSession session;

    @Context
    protected ClientConnection clientConnection;

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
        DocumentModel document = session.documents().getDocumentById(documentId, organization);
        if (document == null) {
            throw new NotFoundException("Document not found");
        }

        DocumentAdminResource invoiceResource = new DocumentAdminResource(organization, auth, adminEvent, document);
        ResteasyProviderFactory.getInstance().injectProperties(invoiceResource);
        return invoiceResource;
    }

    @GET
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public List<DocumentRepresentation> getInvoices(
            @QueryParam("filterText") String filterText,
            @QueryParam("documentId") String documentId,
            @QueryParam("first") Integer firstResult,
            @QueryParam("max") Integer maxResults) {

        auth.requireView();

        firstResult = firstResult != null ? firstResult : -1;
        maxResults = maxResults != null ? maxResults : Constants.DEFAULT_MAX_RESULTS;

        List<DocumentModel> documentModels;
        if (filterText != null) {
            documentModels = session.documents().searchForDocument(filterText.trim(), organization, firstResult, maxResults);
        } else if (documentId != null) {
            Map<String, String> attributes = new HashMap<>();
            if (documentId != null) {
                attributes.put(DocumentModel.DOCUMENT_ID, documentId);
            }
            documentModels = session.documents().searchForDocument(attributes, organization, firstResult, maxResults);
        } else {
            documentModels = session.documents().getDocuments(organization, firstResult, maxResults);
        }

        return documentModels.stream()
                .map(f -> ModelToRepresentation.toRepresentation(f))
                .collect(Collectors.toList());
    }

    @POST
    @Path("search")
    @Produces(MediaType.APPLICATION_JSON)
    public SearchResultsRepresentation<DocumentRepresentation> search(final SearchCriteriaRepresentation criteria) {
        auth.requireView();

        SearchCriteriaModel criteriaModel = RepresentationToModel.toModel(criteria);

        String filterText = criteria.getFilterText();
        SearchResultsModel<DocumentModel> results = null;
        if (filterText != null) {
            results = session.documents().searchForDocument(filterText, criteriaModel, organization);
        } else {
            results = session.documents().searchForDocument(criteriaModel, organization);
        }
        SearchResultsRepresentation<DocumentRepresentation> rep = new SearchResultsRepresentation<>();
        List<DocumentRepresentation> items = new ArrayList<>();
        results.getModels().forEach(f -> items.add(ModelToRepresentation.toRepresentation(f)));
        rep.setItems(items);
        rep.setTotalSize(results.getTotalSize());
        return rep;
    }

}
