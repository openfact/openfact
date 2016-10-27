package org.openfact.services.resources.admin;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.openfact.common.ClientConnection;
import org.openfact.events.admin.OperationType;
import org.openfact.models.ModelDuplicateException;
import org.openfact.models.ModelException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.search.SearchCriteriaFilterOperator;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.models.utils.RepresentationToModel;
import org.openfact.representations.idm.search.PagingRepresentation;
import org.openfact.representations.idm.search.SearchCriteriaFilterOperatorRepresentation;
import org.openfact.representations.idm.search.SearchCriteriaRepresentation;
import org.openfact.representations.idm.search.SearchResultsRepresentation;
import org.openfact.representations.idm.ubl.CreditNoteRepresentation;
import org.openfact.services.ErrorResponse;
import org.openfact.services.ServicesLogger;
import org.openfact.services.managers.CreditNoteManager;

public class CreditNotesAdminResourceImpl implements CreditNotesAdminResource {

    private static final ServicesLogger logger = ServicesLogger.LOGGER;

    protected OrganizationModel organization;
    private OrganizationAuth auth;
    private AdminEventBuilder adminEvent;

    @Context
    protected UriInfo uriInfo;

    @Context
    protected OpenfactSession session;

    @Context
    protected ClientConnection clientConnection;

    @Context
    protected HttpHeaders headers;

    public CreditNotesAdminResourceImpl(OrganizationModel organization, OrganizationAuth auth, AdminEventBuilder adminEvent) {
        this.auth = auth;
        this.organization = organization;
        this.adminEvent = adminEvent;

        auth.init(OrganizationAuth.Resource.CREDIT_NOTE);
    }

    @Override
    public CreditNoteAdminResource getCreditNoteAdmin(String creditNoteId) {
        CreditNoteModel creditNote = session.creditNotes().getCreditNoteById(organization, creditNoteId);
        if (creditNote == null) {
            throw new NotFoundException("Credit Note not found");
        }
        
        CreditNoteAdminResource creditNoteResource = new CreditNoteAdminResourceImpl(organization, auth, adminEvent, creditNote);
        ResteasyProviderFactory.getInstance().injectProperties(creditNoteResource);
        return creditNoteResource;
    }

    @Override
    public List<CreditNoteRepresentation> getCreditNotes(String filterText, Integer firstResult, Integer maxResults) {
        auth.requireView();

        firstResult = firstResult != null ? firstResult : -1;
        maxResults = maxResults != null ? maxResults : -1;

        List<CreditNoteModel> creditNotes;
        if (filterText != null) {
            creditNotes = session.creditNotes().searchForCreditNote(organization, filterText.trim(), firstResult, maxResults);                       
        } else {
            creditNotes = session.creditNotes().getCreditNotes(organization, firstResult, maxResults);
        }
        return creditNotes.stream().map(f -> ModelToRepresentation.toRepresentation(f)).collect(Collectors.toList());
    }

    @Override
    public Response createCreditNote(CreditNoteRepresentation rep) {
        auth.requireManage();                
        
        CreditNoteManager creditNoteManager =  new CreditNoteManager(session);
        
        // Double-check duplicated ID
        if (rep.getIdUbl() != null && creditNoteManager.getCreditNoteByID(organization, rep.getIdUbl()) != null) {
            return ErrorResponse.exists("Credit Note exists with same ID");
        }
        
        try {
            CreditNoteModel creditNote = creditNoteManager.addCreditNote(organization, rep);
                        
            if (session.getTransactionManager().isActive()) {
                session.getTransactionManager().commit();
            }
            
            adminEvent.operation(OperationType.CREATE).resourcePath(uriInfo, creditNote.getId()).representation(rep).success();

            URI location = uriInfo.getAbsolutePathBuilder().path(creditNote.getId()).build();
            return Response.created(location).build();
        } catch (ModelDuplicateException e) {
            if (session.getTransactionManager().isActive()) {
                session.getTransactionManager().setRollbackOnly();
            }
            return ErrorResponse.exists("Credit Note exists with same id or ID");
        } catch (ModelException me){
            if (session.getTransactionManager().isActive()) {
                session.getTransactionManager().setRollbackOnly();
            }
            return ErrorResponse.exists("Could not create credit note");
        }        
    }

    @Override
    public SearchResultsRepresentation<CreditNoteRepresentation> search(SearchCriteriaRepresentation criteria) {
        auth.requireView();
        
        SearchCriteriaModel criteriaModel = RepresentationToModel.toModel(criteria);

        String filterText = criteria.getFilterText();
        SearchResultsModel<CreditNoteModel> results = null;
        if (filterText == null) {
            results = session.creditNotes().searchForCreditNote(organization, criteriaModel);
        } else {
            results = session.creditNotes().searchForCreditNote(organization, criteriaModel, filterText);
        }
        SearchResultsRepresentation<CreditNoteRepresentation> rep = new SearchResultsRepresentation<>();
        List<CreditNoteRepresentation> items = new ArrayList<>();
        results.getModels().forEach(f -> items.add(ModelToRepresentation.toRepresentation(f)));
        rep.setItems(items);
        rep.setTotalSize(results.getTotalSize());
        return rep;
    }

}
