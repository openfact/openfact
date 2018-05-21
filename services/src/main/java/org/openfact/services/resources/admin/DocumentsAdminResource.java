package org.openfact.services.resources.admin;

import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.IDType;
import oasis.names.specification.ubl.schema.xsd.creditnote_21.CreditNoteType;
import oasis.names.specification.ubl.schema.xsd.debitnote_21.DebitNoteType;
import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;
import org.apache.commons.io.IOUtils;
import org.jboss.logging.Logger;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.json.JSONObject;
import org.openfact.Config;
import org.openfact.common.ClientConnection;
import org.openfact.common.converts.DocumentUtils;
import org.openfact.events.admin.OperationType;
import org.openfact.events.admin.ResourceType;
import org.openfact.models.*;
import org.openfact.models.search.SearchCriteriaFilterModel;
import org.openfact.models.search.SearchCriteriaFilterOperator;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;
import org.openfact.models.types.DestinyType;
import org.openfact.models.types.DocumentRequiredAction;
import org.openfact.models.types.DocumentType;
import org.openfact.models.types.SendEventStatus;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.models.utils.RepresentationToModel;
import org.openfact.report.ExportFormat;
import org.openfact.report.ReportException;
import org.openfact.report.ReportTemplateConfiguration;
import org.openfact.report.ReportTemplateProvider;
import org.openfact.representations.idm.DocumentRepresentation;
import org.openfact.representations.idm.SendEventRepresentation;
import org.openfact.representations.idm.ThirdPartyEmailRepresentation;
import org.openfact.representations.idm.search.SearchCriteriaRepresentation;
import org.openfact.representations.idm.search.SearchResultsRepresentation;
import org.openfact.services.ErrorResponse;
import org.openfact.services.ModelErrorResponseException;
import org.openfact.services.managers.DocumentManager;
import org.openfact.services.managers.EventStoreManager;
import org.openfact.services.managers.OrganizationManager;
import org.openfact.services.resource.security.OrganizationAuth;
import org.openfact.services.resource.security.Resource;
import org.openfact.services.resource.security.SecurityContextProvider;
import org.openfact.ubl.UBLIDGenerator;
import org.openfact.ubl.UBLReaderWriter;
import org.openfact.ubl.utils.DefaultUBLUtil;
import org.openfact.ubl.utils.UBLUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Stateless
@Consumes(MediaType.APPLICATION_JSON)
public class DocumentsAdminResource {

    private static final String UPLOAD_FILE_NAME = "file";
    private static final Logger logger = Logger.getLogger(DocumentsAdminResource.class);

    @Context
    protected UriInfo uriInfo;

    @Context
    protected OpenfactSession session;

    @Context
    protected ClientConnection clientConnection;

    @Inject
    private OrganizationManager organizationManager;

    @Inject
    private DocumentManager documentManager;

    @Inject
    private EventStoreManager eventStoreManager;

    @Inject
    private SecurityContextProvider securityContext;

    @Inject
    private DocumentProvider documentProvider;

    @Inject
    private ModelToRepresentation modelToRepresentation;

    @Inject
    private RepresentationToModel representationToModel;

    @Inject
    private ReportTemplateProvider reportTemplate;

    @Inject
    private UBLUtil ublUtil;

    private OrganizationModel getOrganizationModel(String organizationName) {
        OrganizationModel organization = organizationManager.getOrganizationByName(organizationName);
        if (organization == null) {
            throw new NotFoundException("Organization " + organizationName + " not found.");
        }
        return organization;
    }

    private DocumentModel getDocument(String documentIdPk, OrganizationModel organization) {
        DocumentModel document = documentProvider.getDocumentById(documentIdPk, organization);
        if (document == null) {
            throw new NotFoundException("Document not found.");
        }
        return document;
    }

    private OrganizationAuth getAuth(OrganizationModel organization) {
        List<OrganizationModel> permittedOrganizations = securityContext.getPermittedOrganizations(session);
        if (!securityContext.getClientUser(session).hasAppRole(AdminRoles.ADMIN) && !permittedOrganizations.contains(organization)) {
            throw new ForbiddenException();
        }
        return securityContext.getClientUser(session).organizationAuth(Resource.DOCUMENT);
    }

    private AdminEventBuilder getAdminEvent(OrganizationModel organization) {
        return new AdminEventBuilder(organization, securityContext.getClientUser(session), session, clientConnection).resource(ResourceType.DOCUMENT);
    }

    private List<InputPart> getInputs(MultipartFormDataInput multipartFormDataInput) {
        Map<String, List<InputPart>> uploadForm = multipartFormDataInput.getFormDataMap();
        return uploadForm.get(UPLOAD_FILE_NAME);
    }

    private <T> T readFile(InputPart inputPart, DocumentType documentType, Class<T> tClass) throws IOException, ModelException {
        InputStream inputStream = inputPart.getBody(InputStream.class, null);
        byte[] bytes = IOUtils.toByteArray(inputStream);

        Config.Scope documentConfig = Config.scope(documentType.toString().toLowerCase());
        String readerWriterProviderType = documentConfig.get(DefaultUBLUtil.READER_WRITER, "default");

        UBLReaderWriter<T> readerWriter = (UBLReaderWriter<T>) ublUtil.getReaderWriter(readerWriterProviderType, documentType.toString());
        if (readerWriter == null) {
            throw new ModelException("Could not find a valid " + UBLReaderWriter.class.getSimpleName() + " for type[" + documentType.toString() + "]");
        }

        T t = readerWriter.reader().read(bytes);
        if (t == null) {
            throw new ModelException("Could not read file");
        }

        return t;
    }

    @POST
    @Path("/upload")
    @Consumes("multipart/form-data")
    @Produces(MediaType.APPLICATION_JSON)
    public void uploadDocument(@PathParam("organization") final String organizationName, final MultipartFormDataInput input) throws ModelErrorResponseException {
        OrganizationModel organization = getOrganizationModel(organizationName);
        OrganizationAuth auth = getAuth(organization);

        auth.requireManage();

        List<InputPart> inputParts = getInputs(input);
        for (InputPart inputPart : inputParts) {
            try {
                InputStream inputStream = inputPart.getBody(InputStream.class, null);
                Document xml = DocumentUtils.getInputStreamToDocument(inputStream);

                Element documentElement = xml.getDocumentElement();
                String documentType = documentElement.getTagName();
                switch (documentType) {
                    case "Invoice":
                        InvoiceType invoiceType = readFile(inputPart, DocumentType.INVOICE, InvoiceType.class);
                        uploadInvoice(organization, invoiceType);
                        break;
                    case "CreditNote":
                        CreditNoteType creditNoteType = readFile(inputPart, DocumentType.CREDIT_NOTE, CreditNoteType.class);
                        uploadCreditNote(organization, creditNoteType);
                        break;
                    case "DebitNote":
                        DebitNoteType debitNoteType = readFile(inputPart, DocumentType.DEBIT_NOTE, DebitNoteType.class);
                        uploadDebitNote(organization, debitNoteType);
                        break;
                    default:
                        throw new ModelErrorResponseException("Error Reading data, Document type not recognized", Response.Status.BAD_REQUEST);
                }
            } catch (IOException e) {
                logger.error("Error reading input data", e);
                throw new ModelErrorResponseException("Error Reading data", Response.Status.BAD_REQUEST);
            } catch (ModelDuplicateException e) {
                throw new ModelErrorResponseException("Invoice exists with same documentId");
            } catch (ModelException e) {
                throw new ModelErrorResponseException("Could not create document");
            } catch (Exception e) {
                throw new ModelErrorResponseException("Error Reading data", Response.Status.BAD_REQUEST);
            }
        }
    }

    private DocumentModel uploadInvoice(OrganizationModel organization, InvoiceType invoiceType) throws ModelException {
        // Double-check duplicated documentId
        if (invoiceType.getIDValue() != null && documentManager.getDocumentByTypeAndDocumentId(DocumentType.INVOICE, invoiceType.getIDValue(), organization) != null) {
            throw new ModelDuplicateException("Invoice exists with same documentId[" + invoiceType.getIDValue() + "]");
        }

        IDType documentId = invoiceType.getID();
        if (documentId == null) {
            UBLIDGenerator<InvoiceType> ublIDGenerator = ublUtil.getIDGenerator(DocumentType.INVOICE);
            if (ublIDGenerator == null) {
                throw new ModelException("Could not find a valid " + UBLIDGenerator.class.getSimpleName() + " for type[" + DocumentType.INVOICE.toString() + "]");
            }

            String newDocumentId = ublIDGenerator.generateID(organization, invoiceType);
            documentId = new IDType(newDocumentId);
            invoiceType.setID(documentId);
        }

        DocumentModel document = documentManager.addDocument(organization, invoiceType.getIDValue(), DocumentType.INVOICE, invoiceType);
        eventStoreManager.send(organization, getAdminEvent(organization)
                .operation(OperationType.CREATE)
                .resourcePath(uriInfo, document.getId())
                //.representation(invoiceType)
                .getEvent());

        return document;
    }

    private DocumentModel uploadCreditNote(OrganizationModel organization, CreditNoteType creditNoteType) throws ModelException {
        // Double-check duplicated documentId
        if (creditNoteType.getIDValue() != null && documentManager.getDocumentByTypeAndDocumentId(DocumentType.CREDIT_NOTE, creditNoteType.getIDValue(), organization) != null) {
            throw new ModelDuplicateException("Credit Note exists with same documentId[" + creditNoteType.getIDValue() + "]");
        }

        IDType documentId = creditNoteType.getID();
        if (documentId == null) {
            UBLIDGenerator<CreditNoteType> ublIDGenerator = ublUtil.getIDGenerator(DocumentType.CREDIT_NOTE);
            if (ublIDGenerator == null) {
                throw new ModelException("Could not find a valid " + UBLIDGenerator.class.getSimpleName() + " for type[" + DocumentType.CREDIT_NOTE.toString() + "]");
            }

            String newDocumentId = ublIDGenerator.generateID(organization, creditNoteType);
            documentId = new IDType(newDocumentId);
            creditNoteType.setID(documentId);
        }

        DocumentModel document = documentManager.addDocument(organization, creditNoteType.getIDValue(), DocumentType.CREDIT_NOTE, creditNoteType);
        eventStoreManager.send(organization, getAdminEvent(organization)
                .operation(OperationType.CREATE)
                .resourcePath(uriInfo, document.getId())
                //.representation(creditNoteType)
                .getEvent());

        return document;
    }

    private DocumentModel uploadDebitNote(OrganizationModel organization, DebitNoteType debitNoteType) throws ModelException {
        // Double-check duplicated documentId
        if (debitNoteType.getIDValue() != null && documentManager.getDocumentByTypeAndDocumentId(DocumentType.DEBIT_NOTE, debitNoteType.getIDValue(), organization) != null) {
            throw new ModelDuplicateException("Debit Note exists with same documentId[" + debitNoteType.getIDValue() + "]");
        }

        IDType documentId = debitNoteType.getID();
        if (documentId == null) {
            UBLIDGenerator<DebitNoteType> ublIDGenerator = ublUtil.getIDGenerator(DocumentType.DEBIT_NOTE);
            if (ublIDGenerator == null) {
                throw new ModelException("Could not find a valid " + UBLIDGenerator.class.getSimpleName() + " for type[" + DocumentType.DEBIT_NOTE.toString() + "]");
            }

            String newDocumentId = ublIDGenerator.generateID(organization, debitNoteType);
            documentId = new IDType(newDocumentId);
            debitNoteType.setID(documentId);
        }

        DocumentModel document = documentManager.addDocument(organization, debitNoteType.getIDValue(), DocumentType.DEBIT_NOTE, debitNoteType);
        eventStoreManager.send(organization, getAdminEvent(organization)
                .operation(OperationType.CREATE)
                .resourcePath(uriInfo, document.getId())
                //.representation(debitNoteType)
                .getEvent());

        return document;
    }

    @POST
    @Path("/upload/invoices")
    @Consumes("multipart/form-data")
    @Produces(MediaType.APPLICATION_JSON)
    public void uploadInvoice(@PathParam("organization") final String organizationName, final MultipartFormDataInput input) throws ModelErrorResponseException {
        OrganizationModel organization = getOrganizationModel(organizationName);
        OrganizationAuth auth = getAuth(organization);

        auth.requireManage();

        List<InputPart> inputParts = getInputs(input);
        for (InputPart inputPart : inputParts) {
            try {
                InvoiceType invoiceType = readFile(inputPart, DocumentType.INVOICE, InvoiceType.class);
                uploadInvoice(organization, invoiceType);
            } catch (IOException e) {
                logger.error("Error reading input data", e);
                throw new ModelErrorResponseException("Error Reading data", Response.Status.BAD_REQUEST);
            } catch (ModelDuplicateException e) {
                throw new ModelErrorResponseException("Invoice exists with same documentId");
            } catch (ModelException e) {
                throw new ModelErrorResponseException("Could not create document");
            }
        }
    }

    @POST
    @Path("/upload/credit-notes")
    @Consumes("multipart/form-data")
    @Produces(MediaType.APPLICATION_JSON)
    public void uploadCreditNote(@PathParam("organization") final String organizationName, final MultipartFormDataInput input) throws ModelErrorResponseException {
        OrganizationModel organization = getOrganizationModel(organizationName);
        OrganizationAuth auth = getAuth(organization);

        auth.requireManage();

        List<InputPart> inputParts = getInputs(input);
        for (InputPart inputPart : inputParts) {
            try {
                CreditNoteType creditNoteType = readFile(inputPart, DocumentType.CREDIT_NOTE, CreditNoteType.class);

                uploadCreditNote(organization, creditNoteType);
            } catch (IOException e) {
                logger.error("Error reading input data", e);
                throw new ModelErrorResponseException("Error Reading data", Response.Status.BAD_REQUEST);
            } catch (ModelDuplicateException e) {
                throw new ModelErrorResponseException("Credit Note exists with same documentId");
            } catch (ModelException e) {
                throw new ModelErrorResponseException("Could not create document");
            }
        }
    }

    @POST
    @Path("/upload/debit-notes")
    @Consumes("multipart/form-data")
    @Produces(MediaType.APPLICATION_JSON)
    public void uploadDebitNote(@PathParam("organization") final String organizationName, final MultipartFormDataInput input) throws ModelErrorResponseException {
        OrganizationModel organization = getOrganizationModel(organizationName);
        OrganizationAuth auth = getAuth(organization);

        auth.requireManage();

        List<InputPart> inputParts = getInputs(input);
        for (InputPart inputPart : inputParts) {
            try {
                DebitNoteType debitNoteType = readFile(inputPart, DocumentType.DEBIT_NOTE, DebitNoteType.class);

                uploadDebitNote(organization, debitNoteType);
            } catch (IOException e) {
                logger.error("Error reading input data", e);
                throw new ModelErrorResponseException("Error Reading data", Response.Status.BAD_REQUEST);
            } catch (ModelDuplicateException e) {
                throw new ModelErrorResponseException("Debit Note exists with same documentId");
            } catch (ModelException e) {
                throw new ModelErrorResponseException("Could not create document");
            }
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public SearchResultsRepresentation<DocumentRepresentation> getDocuments(
            @PathParam("organization") final String organizationName,
            @QueryParam("documentType") String documentType,
            @QueryParam("documentId") String documentId,
            @QueryParam("query") @DefaultValue("") String query,
            @QueryParam("requiredActions") final List<String> requiredActions,
            @QueryParam("includeDisabled") @DefaultValue("false") final Boolean includeDisabled,
            @QueryParam("first") Integer firstResult,
            @QueryParam("max") Integer maxResults) {
        OrganizationModel organization = getOrganizationModel(organizationName);
        OrganizationAuth auth = getAuth(organization);

        auth.requireView();

        List<DocumentRepresentation> documents;

        if (documentType != null && documentId != null) {
            DocumentModel document = documentProvider.getDocumentByTypeAndDocumentId(documentType, documentId, organization);
            documents = Arrays.asList(modelToRepresentation.toRepresentation(document, true));

            SearchResultsRepresentation<DocumentRepresentation> result = new SearchResultsRepresentation<>();
            result.setItems(documents);
            result.setTotalSize(1);
            return result;
        } else {
            // Process params
            DocumentRequiredAction[] documentRequiredActions = requiredActions.stream()
                    .map(requiredAction -> DocumentRequiredAction.valueOf(requiredAction.toUpperCase()))
                    .toArray(DocumentRequiredAction[]::new);
            firstResult = firstResult != null ? firstResult : -1;
            maxResults = maxResults != null ? maxResults : Constants.DEFAULT_MAX_RESULTS;

            // Jql
            DocumentQuery jql = documentProvider
                    .createQuery(organization)
                    .requiredAction(documentRequiredActions)
                    .applyQuery(query);

            if (!includeDisabled) {
                jql.enabled(true);
            }

            DocumentQuery.ListEntityQuery listEntityQuery = jql.entityQuery().resultList();
            DocumentQuery.CountQuery countQuery = jql.countQuery();

            documents = listEntityQuery
                    .firstResult(firstResult)
                    .maxResults(maxResults)
                    .getResultList().stream()
                    .map(documentModel -> modelToRepresentation.toRepresentation(documentModel, false))
                    .collect(Collectors.toList());
            int totalSize = countQuery.getTotalCount();

            SearchResultsRepresentation<DocumentRepresentation> result = new SearchResultsRepresentation<>();
            result.setItems(documents);
            result.setTotalSize(totalSize);
            return result;
        }
    }

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public SearchResultsRepresentation<DocumentRepresentation> getDocuments(
//            @PathParam("organization") final String organizationName,
//            @QueryParam("filterText") String filterText,
//            @QueryParam("documentType") String documentType,
//            @QueryParam("documentId") String documentId,
//            @QueryParam("first") Integer firstResult,
//            @QueryParam("max") Integer maxResults) {
//        OrganizationModel organization = getOrganizationModel(organizationName);
//        OrganizationAuth auth = getAuth(organization);
//
//        auth.requireView();
//
//        firstResult = firstResult != null ? firstResult : -1;
//        maxResults = maxResults != null ? maxResults : Constants.DEFAULT_MAX_RESULTS;
//
//        List<DocumentModel> documentModels;
//        if (filterText != null) {
//            documentModels = documentProvider.searchForDocument(filterText.trim(), organization, firstResult, maxResults);
//        } else if (documentId != null || documentType != null) {
//            Map<String, String> attributes = new HashMap<>();
//            if (documentType != null) {
//                attributes.put(DocumentModel.DOCUMENT_TYPE, documentType);
//            }
//            if (documentId != null) {
//                attributes.put(DocumentModel.DOCUMENT_ID, documentId);
//            }
//            documentModels = documentProvider.createQuery(organization)
//                    .addFilter(attributes)
//                    .entityQuery()
//                    .resultList().firstResult(firstResult).maxResults(maxResults).getResultList();
//        } else {
//            documentModels = documentProvider.getDocuments(organization, firstResult, maxResults);
//        }
//
//        return documentModels.stream()
//                .map(f -> modelToRepresentation.toRepresentation(f))
//                .collect(Collectors.toList());
//    }

    @POST
    @Path("search")
    @Produces(MediaType.APPLICATION_JSON)
    public SearchResultsRepresentation<DocumentRepresentation> search(@PathParam("organization") final String organizationName, final SearchCriteriaRepresentation criteria) {
        OrganizationModel organization = getOrganizationModel(organizationName);
        OrganizationAuth auth = getAuth(organization);

        auth.requireView();

        SearchCriteriaModel criteriaModel = representationToModel.toModel(criteria);
        String filterText = criteria.getFilterText();

        DocumentQuery query = documentProvider.createQuery(organization);

        // Filtertext
        if (filterText != null && !filterText.trim().isEmpty()) {
            query.filterText(filterText);
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
                    query.addFilter(filter.getName(), filter.getValue(), filter.getOperator() != null ?  filter.getOperator() : SearchCriteriaFilterOperator.eq);
                }
            }
        }

        DocumentQuery.EntityQuery entityQuery = query.entityQuery();
        if (criteriaModel.getOrders() != null && !criteriaModel.getOrders().isEmpty()) {
            criteriaModel.getOrders().forEach(c -> {
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
        results.getModels().forEach(f -> items.add(modelToRepresentation.toRepresentation(f, false)));
        rep.setItems(items);
        rep.setTotalSize(results.getTotalSize());
        return rep;
    }


    /**
     * Get the document with the specified documentId.
     *
     * @return The document with the specified documentId
     */
    @GET
    @Path("/{document}")
    @Produces(MediaType.APPLICATION_JSON)
    public DocumentRepresentation getDocument(@PathParam("organization") final String organizationName,
                                              @PathParam("document") final String documentIdPk) {
        OrganizationModel organization = getOrganizationModel(organizationName);
        OrganizationAuth auth = getAuth(organization);

        auth.requireView();

        DocumentModel document = getDocument(documentIdPk, organization);
        return modelToRepresentation.toRepresentation(document, true);
    }

    @GET
    @Path("/{document}/representation/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDocumentAsJson(@PathParam("organization") final String organizationName,
                                      @PathParam("document") final String documentIdPk) {
        OrganizationModel organization = getOrganizationModel(organizationName);
        OrganizationAuth auth = getAuth(organization);

        auth.requireView();

        DocumentModel document = getDocument(documentIdPk, organization);

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
    public Response getDebitNoteAsXml(@PathParam("organization") final String organizationName,
                                      @PathParam("document") final String documentIdPk) {
        OrganizationModel organization = getOrganizationModel(organizationName);
        OrganizationAuth auth = getAuth(organization);

        auth.requireView();

        DocumentModel document = getDocument(documentIdPk, organization);
        Document xml = document.getXmlAsDocument();
        return Response.ok(xml).build();
    }

    /**
     * Get the document report with the specified documentId.
     *
     * @return The byte[] with the specified documentId
     */
    @GET
    @Path("/{document}/report")
    public Response getPdf(
            @PathParam("organization") final String organizationName,
            @PathParam("document") final String documentIdPk,
            @QueryParam("theme") String theme,
            @QueryParam("format") @DefaultValue("pdf") String format) {
        OrganizationModel organization = getOrganizationModel(organizationName);
        OrganizationAuth auth = getAuth(organization);

        auth.requireView();

        DocumentModel document = getDocument(documentIdPk, organization);

        ExportFormat exportFormat = ExportFormat.valueOf(format.toUpperCase());
        try {
            ReportTemplateConfiguration reportConfig = new ReportTemplateConfiguration(organization).themeName(theme);
            byte[] reportBytes = reportTemplate.getReport(reportConfig, document, exportFormat);

            Response.ResponseBuilder response = Response.ok(reportBytes);
            switch (exportFormat) {
                case PDF:
                    response.type("application/pdf");
                    response.header("Content-Disposition", "attachment; filename=\"" + document.getDocumentId() + ".pdf\"");
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
    public Response updateDocument(@PathParam("organization") final String organizationName,
                                   @PathParam("document") final String documentIdPk,
                                   @Valid final DocumentRepresentation rep) throws ModelErrorResponseException {
        OrganizationModel organization = getOrganizationModel(organizationName);
        OrganizationAuth auth = getAuth(organization);

        auth.requireManage();

        try {
            DocumentModel document = getDocument(documentIdPk, organization);

            Set<String> actionsToRemove;
            if (rep.getRequiredActions() != null) {
                actionsToRemove = new HashSet<>(document.getRequiredActions());
                actionsToRemove.removeAll(rep.getRequiredActions());
            } else {
                actionsToRemove = Collections.emptySet();
            }

            updateDocumentFromRep(document, rep, actionsToRemove);
            eventStoreManager.send(organization, getAdminEvent(organization)
                    .operation(OperationType.UPDATE)
                    .resourcePath(uriInfo)
                    .representation(rep)
                    .getEvent());

            return Response.noContent().build();
        } catch (ModelDuplicateException e) {
            throw new ModelErrorResponseException("Document exists with same documentId or id", Response.Status.CONFLICT);
        } catch (ModelException me) {
            logger.warn("Could not update document!", me);
            throw new ModelErrorResponseException("Could not update document!");
        }
    }

    private static void updateDocumentFromRep(DocumentModel document, DocumentRepresentation rep, Set<String> actionsToRemove) throws ModelException {
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
    public Response deleteDocument(@PathParam("organization") final String organizationName,
                                   @PathParam("document") final String documentIdPk) throws ModelErrorResponseException {
        OrganizationModel organization = getOrganizationModel(organizationName);
        OrganizationAuth auth = getAuth(organization);

        auth.requireManage();

        DocumentModel document = getDocument(documentIdPk, organization);

        boolean removed = documentManager.removeDocument(organization, document);
        if (removed) {
            eventStoreManager.send(organization, getAdminEvent(organization)
                    .operation(OperationType.DELETE)
                    .resourcePath(uriInfo)
                    .getEvent());
            return Response.noContent().build();
        } else {
            throw new ModelErrorResponseException("Document couldn't be deleted", Response.Status.BAD_REQUEST);
        }
    }

    @POST
    @Path("/{document}/send-to-customer")
    @Produces(MediaType.APPLICATION_JSON)
    public Response sendToCustomer(@PathParam("organization") final String organizationName,
                                   @PathParam("document") final String documentIdPk) throws ModelErrorResponseException {
        OrganizationModel organization = getOrganizationModel(organizationName);
        OrganizationAuth auth = getAuth(organization);

        auth.requireManage();

        DocumentModel document = getDocument(documentIdPk, organization);

        SendEventModel sendEvent = sendDocument(organization, document, DestinyType.CUSTOMER, null);
        return Response.ok(modelToRepresentation.toRepresentation(sendEvent)).build();
    }

    @POST
    @Path("/{document}/send-to-third-party")
    @Produces(MediaType.APPLICATION_JSON)
    public Response sendToThirdParty(@PathParam("organization") final String organizationName,
                                     @PathParam("document") final String documentIdPk) throws ModelErrorResponseException {
        OrganizationModel organization = getOrganizationModel(organizationName);
        OrganizationAuth auth = getAuth(organization);

        auth.requireManage();

        DocumentModel document = getDocument(documentIdPk, organization);

        SendEventModel sendEvent = sendDocument(organization, document, DestinyType.THIRD_PARTY, null);
        return Response.ok(modelToRepresentation.toRepresentation(sendEvent)).build();
    }

    @POST
    @Path("/{document}/send-to-third-party-by-email")
    @Produces(MediaType.APPLICATION_JSON)
    public void sendToThirdPartyByEmail(@PathParam("organization") final String organizationName,
                                        @PathParam("document") final String documentIdPk,
                                        ThirdPartyEmailRepresentation thirdParty) throws ModelErrorResponseException {
        OrganizationModel organization = getOrganizationModel(organizationName);
        OrganizationAuth auth = getAuth(organization);

        auth.requireManage();

        DocumentModel document = getDocument(documentIdPk, organization);
        if (thirdParty == null || thirdParty.getEmail() == null) {
            throw new BadRequestException("Invalid email sended");
        }

        sendDocument(organization, document, DestinyType.CUSTOM_EMAIL, thirdParty.getEmail());
//        SendEventModel sendEvent = sendDocument(organization, document, DestinyType.CUSTOM_EMAIL, thirdParty.getEmail());
//        return Response.ok(modelToRepresentation.toRepresentation(sendEvent)).build();
    }

    private SendEventModel sendDocument(OrganizationModel organization, DocumentModel document, DestinyType destiny, String customEmail) throws ModelErrorResponseException {
        SendEventModel sendEvent;
        try {
            switch (destiny) {
                case CUSTOMER:
                    sendEvent = documentManager.sendToCustomerParty(organization, document);
                    break;
                case THIRD_PARTY:
                    sendEvent = documentManager.sendToThirdParty(organization, document);
                    break;
                case CUSTOM_EMAIL:
                    sendEvent = documentManager.sendToCustomEmail(organization, document, customEmail);
                    break;
                default:
                    throw new IllegalStateException("Invalid destiny[" + destiny + "] type");
            }
        } catch (ModelInsuficientData | SendEventException e) {
            sendEvent = document.addSendEvent(destiny);
            sendEvent.setResult(SendEventStatus.ERROR);
            if (e.getMessage() != null) {
                sendEvent.setDescription(e.getMessage().length() < 200 ? e.getMessage() : e.getMessage().substring(0, 197).concat("..."));
            }
            logger.error(e.getMessage(), e);
        }
        return sendEvent;
    }

    @GET
    @Path("/{document}/send-events")
    @Produces(MediaType.APPLICATION_JSON)
    public List<SendEventRepresentation> getSendEvents(
            @PathParam("organization") final String organizationName,
            @PathParam("document") final String documentIdPk,
            @QueryParam("destinyType") String destinyType,
            @QueryParam("result") String result,
            @QueryParam("first") Integer firstResult,
            @QueryParam("max") Integer maxResults) {
        OrganizationModel organization = getOrganizationModel(organizationName);
        OrganizationAuth auth = getAuth(organization);

        auth.requireView();

        DocumentModel document = getDocument(documentIdPk, organization);

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
                .map(f -> modelToRepresentation.toRepresentation(f))
                .collect(Collectors.toList());
    }

}
