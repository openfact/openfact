package org.openfact.services.resources.admin;

import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.cache.NoCache;
import org.json.JSONObject;
import org.openfact.common.OpenfactClientConnection;
import org.openfact.events.admin.OperationType;
import org.openfact.models.*;
import org.openfact.models.search.SearchCriteriaFilterModel;
import org.openfact.models.search.SearchCriteriaFilterOperator;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;
import org.openfact.models.types.DestinyType;
import org.openfact.models.types.DocumentRequiredAction;
import org.openfact.models.types.SendEventStatus;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.models.utils.RepresentationToModel;
import org.openfact.report.ExportFormat;
import org.openfact.report.ReportException;
import org.openfact.representations.idm.DocumentRepresentation;
import org.openfact.representations.idm.SendEventRepresentation;
import org.openfact.representations.idm.ThirdPartyEmailRepresentation;
import org.openfact.representations.idm.search.SearchCriteriaRepresentation;
import org.openfact.representations.idm.search.SearchResultsRepresentation;
import org.openfact.services.ErrorResponse;
import org.openfact.services.managers.DocumentManager;
import org.openfact.services.managers.OrganizationManager;
import org.openfact.services.resource.security.OrganizationAuth;
import org.openfact.services.resource.security.SecurityContextProvider;
import org.openfact.ubl.UBLReportProvider;
import org.w3c.dom.Document;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Path("/admin/organizations/{organization}/documents")
public class DocumentsAdminResource {

    protected static final Logger logger = Logger.getLogger(DocumentsAdminResource.class);

    @Context
    protected UriInfo uriInfo;

    @Context
    protected OpenfactSession session;

    @Context
    protected OpenfactClientConnection clientConnection;

    @Context
    protected HttpHeaders headers;

    @Inject
    protected AdminEventBuilder adminEvent;

    @Inject
    private OrganizationManager organizationManager;

    @Inject
    private SecurityContextProvider securityContext;

    @Inject
    private DocumentProvider documentProvider;

    @Inject
    private DocumentManager documentManager;

    @Inject
    private DocumentQuery documentQuery;

    @Inject
    private UBLReportProvider ublReportProvider;

    @GET
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public List<DocumentRepresentation> getDocuments(
            @PathParam("organization") String organizationName,
            @QueryParam("filterText") String filterText,
            @QueryParam("documentType") String documentType,
            @QueryParam("documentId") String documentId,
            @QueryParam("first") Integer firstResult,
            @QueryParam("max") Integer maxResults) {

        OrganizationModel organization = AdminUtil.initOrganization(organizationName, organizationManager);
        OrganizationAuth auth = AdminUtil.initAuth(session, securityContext, organizationManager, organization);

        auth.requireView();

        firstResult = firstResult != null ? firstResult : -1;
        maxResults = maxResults != null ? maxResults : Constants.DEFAULT_MAX_RESULTS;

        List<DocumentModel> documentModels;
        if (filterText != null) {
            documentModels = documentProvider.searchForDocument(filterText.trim(), organization, firstResult, maxResults);
        } else if (documentId != null || documentType != null) {
            Map<String, String> attributes = new HashMap<>();
            if (documentType != null) {
                attributes.put(DocumentModel.DOCUMENT_TYPE, documentType);
            }
            if (documentId != null) {
                attributes.put(DocumentModel.DOCUMENT_ID, documentId);
            }
            documentModels = documentQuery.organization(organization)
                    .addFilter(attributes)
                    .entityQuery()
                    .resultList().firstResult(firstResult).maxResults(maxResults).getResultList();
        } else {
            documentModels = documentProvider.getDocuments(organization, firstResult, maxResults);
        }

        return documentModels.stream()
                .map(f -> ModelToRepresentation.toRepresentation(f))
                .collect(Collectors.toList());
    }

    @POST
    @Path("search")
    @Produces(MediaType.APPLICATION_JSON)
    public SearchResultsRepresentation<DocumentRepresentation> search(@PathParam("organization") String organizationName, final SearchCriteriaRepresentation criteria) {
        OrganizationModel organization = AdminUtil.initOrganization(organizationName, organizationManager);
        OrganizationAuth auth = AdminUtil.initAuth(session, securityContext, organizationManager, organization);

        auth.requireView();

        SearchCriteriaModel criteriaModel = RepresentationToModel.toModel(criteria);
        String filterText = criteria.getFilterText();

        // Filtertext
        if (filterText != null && !filterText.trim().isEmpty()) {
            documentQuery.filterText(filterText, DocumentModel.DOCUMENT_ID, DocumentModel.CUSTOMER_REGISTRATION_NAME, DocumentModel.CUSTOMER_ASSIGNED_ACCOUNT_ID, DocumentModel.CUSTOMER_ELECTRONIC_MAIL);
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

                    DocumentRequiredAction[] array = requiredActions
                            .stream()
                            .map(f -> DocumentRequiredAction.valueOf(f.toUpperCase()))
                            .toArray(size -> new DocumentRequiredAction[requiredActions.size()]);

                    documentQuery.requiredAction(array);
                } else if (filter.getName().equalsIgnoreCase(DocumentModel.CREATED_TIMESTAMP)) {
                    if (filter.getOperator().equals(SearchCriteriaFilterOperator.gt)) {
                        documentQuery.fromDate((LocalDateTime) filter.getValue(), false);
                    } else if (filter.getOperator().equals(SearchCriteriaFilterOperator.gte)) {
                        documentQuery.fromDate((LocalDateTime) filter.getValue(), true);
                    } else if (filter.getOperator().equals(SearchCriteriaFilterOperator.lt)) {
                        documentQuery.toDate((LocalDateTime) filter.getValue(), false);
                    } else if (filter.getOperator().equals(SearchCriteriaFilterOperator.lte)) {
                        documentQuery.toDate((LocalDateTime) filter.getValue(), true);
                    } else if (filter.getOperator().equals(SearchCriteriaFilterOperator.eq)) {
                        documentQuery.fromDate((LocalDateTime) filter.getValue(), true);
                        documentQuery.toDate((LocalDateTime) filter.getValue(), true);
                    } else {
                        throw new BadRequestException("Bad operator on criteria");
                    }
                } else {
                    documentQuery.addFilter(filter.getName(), filter.getValue(), filter.getOperator());
                }
            }
        }

        DocumentQuery.EntityQuery entityQuery = documentQuery.entityQuery();
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
        return rep;
    }


    /**
     * Get the document with the specified documentId.
     *
     * @return The document with the specified documentId
     * @summary Get the document with the specified documentId
     */
    @GET
    @Path("/{document}")
    @Produces(MediaType.APPLICATION_JSON)
    public DocumentRepresentation getDocument(@PathParam("organization") String organizationName,
                                              @PathParam("document") String documentIdPk) {
        OrganizationModel organization = AdminUtil.initOrganization(organizationName, organizationManager);
        OrganizationAuth auth = AdminUtil.initAuth(session, securityContext, organizationManager, organization);

        auth.requireView();

        DocumentModel document = AdminUtil.initDocument(documentIdPk, organization, documentProvider);
        return ModelToRepresentation.toRepresentation(document);
    }

    @GET
    @Path("/{document}/representation/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDocumentAsJson(@PathParam("organization") String organizationName,
                                      @PathParam("document") String documentIdPk) {
        OrganizationModel organization = AdminUtil.initOrganization(organizationName, organizationManager);
        OrganizationAuth auth = AdminUtil.initAuth(session, securityContext, organizationManager, organization);

        auth.requireView();

        DocumentModel document = AdminUtil.initDocument(documentIdPk, organization, documentProvider);

        JSONObject jsonObject = document.getXmlAsJSONObject();
        if (jsonObject != null) {
            return Response.ok(jsonObject.toString()).build();
        } else {
            return ErrorResponse.exists("No json attached to current document");
        }
    }

    @GET
    @Path("/{document}/representation/xml")
    @Produces("application/xml")
    public Response getDebitNoteAsXml(@PathParam("organization") String organizationName,
                                      @PathParam("document") String documentIdPk) {
        OrganizationModel organization = AdminUtil.initOrganization(organizationName, organizationManager);
        OrganizationAuth auth = AdminUtil.initAuth(session, securityContext, organizationManager, organization);

        auth.requireView();

        DocumentModel document = AdminUtil.initDocument(documentIdPk, organization, documentProvider);

        Document xml = document.getXmlAsDocument();
        if (document != null) {
            return Response.ok(xml).build();
        } else {
            return ErrorResponse.exists("No xml document attached to current document");
        }
    }

    /**
     * Get the document report with the specified documentId.
     *
     * @return The byte[] with the specified documentId
     * @throws Exception
     * @summary Get the byte[] with the specified documentId
     */
    @GET
    @Path("/{document}/report")
    public Response getPdf(
            @PathParam("organization") String organizationName,
            @PathParam("document") String documentIdPk,
            @QueryParam("theme") String theme,
            @QueryParam("format") @DefaultValue("pdf") String format) {
        OrganizationModel organization = AdminUtil.initOrganization(organizationName, organizationManager);
        OrganizationAuth auth = AdminUtil.initAuth(session, securityContext, organizationManager, organization);

        auth.requireView();

        DocumentModel document = AdminUtil.initDocument(documentIdPk, organization, documentProvider);

        ExportFormat exportFormat = ExportFormat.valueOf(format.toUpperCase());

        try {
            byte[] reportBytes = ublReportProvider.document()
                    .setOrganization(organization)
                    .setThemeName(theme)
                    .getReport(document, exportFormat);

            Response.ResponseBuilder response = Response.ok(reportBytes);
            switch (exportFormat) {
                case PDF:
                    response.type("application/pdf");
                    response.header("content-disposition", "attachment; filename=\"" + document.getDocumentId() + ".pdf\"");
                    break;
                case HTML:
                    response.type("application/html");
                    break;
            }

            return response.build();
        } catch (ReportException e) {
            return ErrorResponse.error("Error generating report", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @PUT
    @Path("/{document}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateDocument(@PathParam("organization") String organizationName,
                                   @PathParam("document") String documentIdPk,
                                   DocumentRepresentation rep) {
        OrganizationModel organization = AdminUtil.initOrganization(organizationName, organizationManager);
        OrganizationAuth auth = AdminUtil.initAuth(session, securityContext, organizationManager, organization);

        auth.requireManage();

        try {
            DocumentModel document = AdminUtil.initDocument(documentIdPk, organization, documentProvider);

            Set<String> actionsToRemove;
            if (rep.getRequiredActions() != null) {
                actionsToRemove = new HashSet<>(document.getRequiredActions());
                actionsToRemove.removeAll(rep.getRequiredActions());
            } else {
                actionsToRemove = Collections.emptySet();
            }

            updateDocumentFromRep(document, rep, actionsToRemove);
            adminEvent.operation(OperationType.UPDATE).resourcePath(uriInfo).representation(rep).success();

            return Response.noContent().build();
        } catch (ModelDuplicateException e) {
            return ErrorResponse.exists("Document exists with same documentId or id");
        } catch (ModelException me) {
            logger.warn("Could not update document!", me);
            return ErrorResponse.exists("Could not update user!");
        } catch (Exception me) { // JPA
            logger.warn("Could not update document!", me);// may be committed by JTA which can't
            return ErrorResponse.exists("Could not update document!");
        }
    }

    public static void updateDocumentFromRep(DocumentModel document, DocumentRepresentation rep, Set<String> actionsToRemove) {
        for (String action : actionsToRemove) {
            document.removeRequiredAction(action);
        }

        if (rep.getRequiredActions() != null) {
            Set<String> newActions = rep.getRequiredActions();
            newActions.removeAll(document.getRequiredActions());
            for (String action : newActions) {
                document.addRequiredAction(action);
            }
        }
    }

    /**
     * Deletes document with given documentId.
     */
    @DELETE
    @Path("/{document}")
    public Response deleteDocument(@PathParam("organization") String organizationName,
                                   @PathParam("document") String documentIdPk) {
        OrganizationModel organization = AdminUtil.initOrganization(organizationName, organizationManager);
        OrganizationAuth auth = AdminUtil.initAuth(session, securityContext, organizationManager, organization);

        auth.requireManage();

        DocumentModel document = AdminUtil.initDocument(documentIdPk, organization, documentProvider);

        boolean removed = documentManager.removeDocument(organization, document);
        if (removed) {
            adminEvent.operation(OperationType.DELETE).resourcePath(uriInfo).success();
            return Response.noContent().build();
        } else {
            return ErrorResponse.error("Document couldn't be deleted", Response.Status.BAD_REQUEST);
        }
    }

    @POST
    @Path("/{document}/send-to-customer")
    @Produces(MediaType.APPLICATION_JSON)
    public Response sendToCustomer(@PathParam("organization") String organizationName,
                                   @PathParam("document") String documentIdPk) {
        OrganizationModel organization = AdminUtil.initOrganization(organizationName, organizationManager);
        OrganizationAuth auth = AdminUtil.initAuth(session, securityContext, organizationManager, organization);

        auth.requireManage();

        DocumentModel document = AdminUtil.initDocument(documentIdPk, organization, documentProvider);

        return sendDocument(organization, document, DestinyType.CUSTOMER, null);
    }

    @POST
    @Path("/{document}/send-to-third-party")
    @Produces(MediaType.APPLICATION_JSON)
    public Response sendToThirdParty(@PathParam("organization") String organizationName,
                                     @PathParam("document") String documentIdPk) {
        OrganizationModel organization = AdminUtil.initOrganization(organizationName, organizationManager);
        OrganizationAuth auth = AdminUtil.initAuth(session, securityContext, organizationManager, organization);

        auth.requireManage();

        DocumentModel document = AdminUtil.initDocument(documentIdPk, organization, documentProvider);

        return sendDocument(organization, document, DestinyType.THIRD_PARTY, null);
    }

    @POST
    @Path("/{document}/send-to-third-party-by-email")
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public Response sendToThirdPartyByEmail(@PathParam("organization") String organizationName,
                                            @PathParam("document") String documentIdPk,
                                            ThirdPartyEmailRepresentation thirdParty) {
        OrganizationModel organization = AdminUtil.initOrganization(organizationName, organizationManager);
        OrganizationAuth auth = AdminUtil.initAuth(session, securityContext, organizationManager, organization);

        auth.requireManage();

        DocumentModel document = AdminUtil.initDocument(documentIdPk, organization, documentProvider);

        if (thirdParty == null || thirdParty.getEmail() == null) {
            throw new BadRequestException("Invalid email sended");
        }

        return sendDocument(organization, document, DestinyType.CUSTOM_EMAIL, thirdParty.getEmail());
    }

    private Response sendDocument(OrganizationModel organization, DocumentModel document, DestinyType destiny, String customEmail) {
        SendEventModel sendEvent = null;
        try {
            switch (destiny) {
                case CUSTOMER:
                    sendEvent = documentManager.sendToCustomerParty(organization, document);
                    break;
                case THIRD_PARTY:
                    sendEvent = documentManager.sendToThirdParty(organization, document);
                    break;
                case CUSTOM_EMAIL:
                    sendEvent = documentManager.sendToThirdPartyByEmail(organization, document, customEmail);
                    break;
                default:
                    throw new IllegalStateException("Invalid " + destiny + " type");
            }
        } catch (ModelInsuficientData e) {
            if (sendEvent != null) {
                sendEvent.setResult(SendEventStatus.ERROR);
                sendEvent.setDescription(e.getMessage());
            }
            return ErrorResponse.error(e.getMessage(), Response.Status.BAD_REQUEST);
        } catch (SendEventException e) {
            if (sendEvent != null) {
                sendEvent.setResult(SendEventStatus.ERROR);
                if (e.getMessage() != null) {
                    sendEvent.setDescription(e.getMessage().length() < 200 ? e.getMessage() : e.getMessage().substring(0, 197).concat("..."));
                } else {
                    sendEvent.setDescription("Internal Server Error");
                }
            }
            logger.error("Internal Server Error sending to customer", e);
            return ErrorResponse.error("Internal Server Error", Response.Status.INTERNAL_SERVER_ERROR);
        }

        return Response.ok(ModelToRepresentation.toRepresentation(sendEvent)).build();
    }

    @GET
    @Path("/{document}/send-events")
    @Produces(MediaType.APPLICATION_JSON)
    public List<SendEventRepresentation> getSendEvents(
            @PathParam("organization") String organizationName,
            @PathParam("document") String documentIdPk,
            @QueryParam("destinyType") String destinyType,
            @QueryParam("result") String result,
            @QueryParam("first") Integer firstResult,
            @QueryParam("max") Integer maxResults) {
        OrganizationModel organization = AdminUtil.initOrganization(organizationName, organizationManager);
        OrganizationAuth auth = AdminUtil.initAuth(session, securityContext, organizationManager, organization);

        auth.requireView();

        DocumentModel document = AdminUtil.initDocument(documentIdPk, organization, documentProvider);

        firstResult = firstResult != null ? firstResult : -1;
        maxResults = maxResults != null ? maxResults : Constants.DEFAULT_MAX_RESULTS;

        List<SendEventModel> sendEventModels;
        if (destinyType != null || result != null) {
            Map<String, String> attributes = new HashMap<>();
            if (destinyType != null) {
                attributes.put(DocumentModel.SEND_EVENT_DESTINY, destinyType);
            }
            if (result != null) {
                attributes.put(DocumentModel.SEND_EVENT_STATUS, result);
            }
            sendEventModels = document.searchForSendEvent(attributes, firstResult, maxResults);
        } else {
            sendEventModels = document.getSendEvents(firstResult, maxResults);
        }

        return sendEventModels.stream()
                .map(f -> ModelToRepresentation.toRepresentation(f))
                .collect(Collectors.toList());
    }

}
