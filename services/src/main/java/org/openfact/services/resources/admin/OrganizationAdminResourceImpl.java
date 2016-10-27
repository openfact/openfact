package org.openfact.services.resources.admin;

import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.jboss.logging.Logger;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.openfact.Config;
import org.openfact.KeyPairVerifier;
import org.openfact.common.ClientConnection;
import org.openfact.common.VerificationException;
import org.openfact.common.util.PemUtils;
import org.openfact.events.Event;
import org.openfact.events.EventQuery;
import org.openfact.events.EventStoreProvider;
import org.openfact.events.EventType;
import org.openfact.events.admin.AdminEvent;
import org.openfact.events.admin.AdminEventQuery;
import org.openfact.events.admin.OperationType;
import org.openfact.events.admin.ResourceType;
import org.openfact.models.ModelDuplicateException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.models.utils.RepresentationToModel;
import org.openfact.representations.idm.AdminEventRepresentation;
import org.openfact.representations.idm.EventRepresentation;
import org.openfact.representations.idm.OrganizationEventsConfigRepresentation;
import org.openfact.representations.idm.OrganizationRepresentation;
import org.openfact.services.ErrorResponse;
import org.openfact.services.ServicesLogger;
import org.openfact.services.managers.OrganizationManager;
import org.openfact.services.managers.OrganizationScheduledTaskManager;

public class OrganizationAdminResourceImpl implements OrganizationAdminResource {

    protected static final Logger logger = Logger.getLogger(OrganizationAdminResourceImpl.class);

    protected OrganizationAuth auth;
    protected OrganizationModel organization;
    private AdminEventBuilder adminEvent;

    @Context
    protected OpenfactSession session;

    @Context
    protected UriInfo uriInfo;

    @Context
    protected ClientConnection connection;

    @Context
    protected HttpHeaders headers;

    public OrganizationAdminResourceImpl(OrganizationAuth auth, OrganizationModel organization, AdminEventBuilder adminEvent) {
        this.auth = auth;
        this.organization = organization;
        this.adminEvent = adminEvent.organization(organization);

        auth.init(OrganizationAuth.Resource.ORGANIZATION);
        auth.requireAny();
    }

    @Override
    public OrganizationRepresentation getOrganization() {
        if (auth.hasView()) {
            return ModelToRepresentation.toRepresentation(organization, true);
        } else {
            auth.requireAny();

            OrganizationRepresentation rep = new OrganizationRepresentation();
            rep.setOrganization(organization.getName());
            return rep;
        }
    }

    @Override
    public Response updateOrganization(OrganizationRepresentation rep) {
        auth.requireManage();

        logger.debug("updating organization: " + organization.getName());

        if (Config.getAdminOrganization().equals(organization.getName()) && (rep.getOrganization() != null && !rep.getOrganization().equals(Config.getAdminOrganization()))) {
            return ErrorResponse.error("Can't rename master organization", Status.BAD_REQUEST);
        }

        try {
            if (!"GENERATE".equals(rep.getPublicKey()) && (rep.getPrivateKey() != null && rep.getPublicKey() != null)) {
                try {
                    KeyPairVerifier.verify(rep.getPrivateKey(), rep.getPublicKey());
                } catch (VerificationException e) {
                    return ErrorResponse.error(e.getMessage(), Status.BAD_REQUEST);
                }
            }

            if (!"GENERATE".equals(rep.getPublicKey()) && (rep.getCertificate() != null)) {
                try {
                    X509Certificate cert = PemUtils.decodeCertificate(rep.getCertificate());
                    if (cert == null) {
                        return ErrorResponse.error("Failed to decode certificate", Status.BAD_REQUEST);
                    }
                } catch (Exception e) {
                    return ErrorResponse.error("Failed to decode certificate", Status.BAD_REQUEST);
                }
            }

            RepresentationToModel.updateOrganization(rep, organization, session);

            // Refresh periodic tasks for send documents
            OrganizationScheduledTaskManager taskManager = new OrganizationScheduledTaskManager(session);
            taskManager.reschedulePeriodicTask(organization);

            adminEvent.operation(OperationType.UPDATE).representation(rep).success();
            return Response.noContent().build();
        } catch (ModelDuplicateException e) {
            return ErrorResponse.exists("Organization with same name exists");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ErrorResponse.error("Failed to update organization", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public void deleteOrganization() {
        auth.requireManage();

        if (!new OrganizationManager(session).removeOrganization(organization)) {
            throw new NotFoundException("Organization doesn't exist");
        }
    }

    @Override
    public InvoicesAdminResource invoices() {
        InvoicesAdminResource invoices = new InvoicesAdminResourceImpl(organization, auth, adminEvent);
        ResteasyProviderFactory.getInstance().injectProperties(invoices);
        
        return invoices;
    }

    @Override
    public CreditNotesAdminResource creditNotes() {
        CreditNotesAdminResource creditNotes = new CreditNotesAdminResourceImpl(organization, auth, adminEvent);
        ResteasyProviderFactory.getInstance().injectProperties(creditNotes);        
        return creditNotes;
    }

    @Override
    public DebitNotesAdminResource debitNotes() {
        DebitNotesAdminResource debitNotes = new DebitNotesAdminResourceImpl(organization, auth, adminEvent);
        ResteasyProviderFactory.getInstance().injectProperties(debitNotes);       
        return debitNotes;
    }

    @Override
    public OrganizationEventsConfigRepresentation getOrganizationEventsConfig() {
        auth.init(OrganizationAuth.Resource.EVENTS).requireView();

        OrganizationEventsConfigRepresentation config = ModelToRepresentation.toEventsConfigReprensetation(organization);
        if (config.getEnabledEventTypes() == null || config.getEnabledEventTypes().isEmpty()) {
            config.setEnabledEventTypes(new LinkedList<String>());
            for (EventType e : EventType.values()) {
                if (e.isSaveByDefault()) {
                    config.getEnabledEventTypes().add(e.name());
                }
            }
        }
        return config;
    }

    @Override
    public void updateOrganizationEventsConfig(OrganizationEventsConfigRepresentation rep) {
        auth.init(OrganizationAuth.Resource.EVENTS).requireManage();

        logger.debug("updating organization events config: " + organization.getName());
        new OrganizationManager(session).updateOrganizationEventsConfig(rep, organization);
    }

    @Override
    public List<EventRepresentation> getEvents(List<String> types, String user, String dateFrom,
            String dateTo, String ipAddress, Integer firstResult, Integer maxResults) {
        auth.init(OrganizationAuth.Resource.EVENTS).requireView();

        EventStoreProvider eventStore = session.getProvider(EventStoreProvider.class);

        EventQuery query = eventStore.createQuery().organization(organization.getId());
        if (types != null & !types.isEmpty()) {
            EventType[] t = new EventType[types.size()];
            for (int i = 0; i < t.length; i++) {
                t[i] = EventType.valueOf(types.get(i));
            }
            query.type(t);
        }

        if (user != null) {
            query.user(user);
        }

        if (dateFrom != null) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date from = null;
            try {
                from = df.parse(dateFrom);
            } catch (ParseException e) {
                throw new BadRequestException(
                        "Invalid value for 'Date(From)', expected format is yyyy-MM-dd");
            }
            query.fromDate(from);
        }

        if (dateTo != null) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date to = null;
            try {
                to = df.parse(dateTo);
            } catch (ParseException e) {
                throw new BadRequestException("Invalid value for 'Date(To)', expected format is yyyy-MM-dd");
            }
            query.toDate(to);
        }

        if (ipAddress != null) {
            query.ipAddress(ipAddress);
        }
        if (firstResult != null) {
            query.firstResult(firstResult);
        }
        if (maxResults != null) {
            query.maxResults(maxResults);
        }

        return toEventListRep(query.getResultList());
    }

    private List<EventRepresentation> toEventListRep(List<Event> events) {
        List<EventRepresentation> reps = new ArrayList<>();
        for (Event event : events) {
            reps.add(ModelToRepresentation.toRepresentation(event));
        }
        return reps;
    }

    @Override
    public List<AdminEventRepresentation> getEvents(List<String> operationTypes, String authOrganization,
            String authUser, String authIpAddress, String resourcePath, String dateFrom, String dateTo,
            Integer firstResult, Integer maxResults, List<String> resourceTypes) {
        auth.init(OrganizationAuth.Resource.EVENTS).requireView();

        EventStoreProvider eventStore = session.getProvider(EventStoreProvider.class);
        AdminEventQuery query = eventStore.createAdminQuery().organization(organization.getId());

        if (authOrganization != null) {
            query.authOrganization(authOrganization);
        }

        if (authUser != null) {
            query.authUser(authUser);
        }

        if (authIpAddress != null) {
            query.authIpAddress(authIpAddress);
        }

        if (resourcePath != null) {
            query.resourcePath(resourcePath);
        }

        if (operationTypes != null && !operationTypes.isEmpty()) {
            OperationType[] t = new OperationType[operationTypes.size()];
            for (int i = 0; i < t.length; i++) {
                t[i] = OperationType.valueOf(operationTypes.get(i));
            }
            query.operation(t);
        }

        if (resourceTypes != null && !resourceTypes.isEmpty()) {
            ResourceType[] t = new ResourceType[resourceTypes.size()];
            for (int i = 0; i < t.length; i++) {
                t[i] = ResourceType.valueOf(resourceTypes.get(i));
            }
            query.resourceType(t);
        }

        if (dateFrom != null) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date from = null;
            try {
                from = df.parse(dateFrom);
            } catch (ParseException e) {
                throw new BadRequestException("Invalid value for 'Date(From)', expected format is yyyy-MM-dd");
            }
            query.fromTime(from);
        }

        if (dateTo != null) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date to = null;
            try {
                to = df.parse(dateTo);
            } catch (ParseException e) {
                throw new BadRequestException("Invalid value for 'Date(To)', expected format is yyyy-MM-dd");
            }
            query.toTime(to);
        }

        if (firstResult != null) {
            query.firstResult(firstResult);
        }
        if (maxResults != null) {
            query.maxResults(maxResults);
        }

        return toAdminEventRep(query.getResultList());
    }

    private List<AdminEventRepresentation> toAdminEventRep(List<AdminEvent> events) {
        List<AdminEventRepresentation> reps = new ArrayList<>();
        for (AdminEvent event : events) {
            reps.add(ModelToRepresentation.toRepresentation(event));
        }

        return reps;
    }

    @Override
    public void clearEvents() {
        auth.init(OrganizationAuth.Resource.EVENTS).requireManage();

        EventStoreProvider eventStore = session.getProvider(EventStoreProvider.class);
        eventStore.clear(organization.getId());
    }

    @Override
    public void clearAdminEvents() {
        auth.init(OrganizationAuth.Resource.EVENTS).requireManage();

        EventStoreProvider eventStore = session.getProvider(EventStoreProvider.class);
        eventStore.clearAdmin(organization.getId());
    }

    @Override
    public ComponentResource getComponents() {
        ComponentResource resource = new ComponentResourceImpl(organization, auth, adminEvent);
        ResteasyProviderFactory.getInstance().injectProperties(resource);
        return resource;
    }

    @Override
    public KeyResource keys() {
        KeyResource resource =  new KeyResourceImpl(organization, session, this.auth);
        ResteasyProviderFactory.getInstance().injectProperties(resource);
        return resource;
    }

}
