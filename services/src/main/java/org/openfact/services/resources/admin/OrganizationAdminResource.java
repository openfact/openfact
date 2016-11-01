package org.openfact.services.resources.admin;

import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.cache.NoCache;
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
import org.openfact.services.managers.OrganizationManager;
import org.openfact.services.managers.OrganizationScheduledTaskManager;

public class OrganizationAdminResource {

    protected static final Logger logger = Logger.getLogger(OrganizationAdminResource.class);

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

    public OrganizationAdminResource(OrganizationAuth auth, OrganizationModel organization,
            AdminEventBuilder adminEvent) {
        this.auth = auth;
        this.organization = organization;
        this.adminEvent = adminEvent.organization(organization);

        auth.init(OrganizationAuth.Resource.ORGANIZATION);
        auth.requireAny();
    }

    /**
     * Get the organization with the specified organization name.
     *
     * @return The organization with the specified name
     * @summary Get the organization with the specified name
     */
    @GET
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
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

    /**
     * Update organization information.
     *
     * @param rep
     *            The representation of the organization to be changed
     * @return Generic Response object
     * @summary Update organization information
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateOrganization(@Valid final OrganizationRepresentation rep) {
        auth.requireManage();

        logger.debug("updating organization: " + organization.getName());

        if (Config.getAdminOrganization().equals(organization.getName()) && (rep.getOrganization() != null
                && !rep.getOrganization().equals(Config.getAdminOrganization()))) {
            return ErrorResponse.error("Can't rename master organization", Status.BAD_REQUEST);
        }

        try {
            if (!"GENERATE".equals(rep.getPublicKey())
                    && (rep.getPrivateKey() != null && rep.getPublicKey() != null)) {
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
            return ErrorResponse.error("Failed to update organization",
                    Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Deletes organization with given name.
     *
     * @throws AuthorizationException
     *             The user is not authorized to delete this organization.
     */
    @DELETE
    public void deleteOrganization() {
        auth.requireManage();

        if (!new OrganizationManager(session).removeOrganization(organization)) {
            throw new NotFoundException("Organization doesn't exist");
        }
    }

    /**
     * Get the invoices sub resource for the current organization
     */
    @Path("invoices")
    public InvoicesAdminResource invoices() {
        InvoicesAdminResource invoices = new InvoicesAdminResource(organization, auth, adminEvent);
        ResteasyProviderFactory.getInstance().injectProperties(invoices);

        return invoices;
    }

    /**
     * Get the invoices sub resource for the current organization
     */
    @Path("credit-notes")
    public CreditNotesAdminResource creditNotes() {
        CreditNotesAdminResource creditNotes = new CreditNotesAdminResource(organization, auth, adminEvent);
        ResteasyProviderFactory.getInstance().injectProperties(creditNotes);
        return creditNotes;
    }

    /**
     * Get the invoices sub resource for the current organization
     */
    @Path("debit-notes")
    public DebitNotesAdminResource debitNotes() {
        DebitNotesAdminResource debitNotes = new DebitNotesAdminResource(organization, auth, adminEvent);
        ResteasyProviderFactory.getInstance().injectProperties(debitNotes);
        return debitNotes;
    }

    /**
     * Get the events provider configuration
     *
     * Returns JSON object with events provider configuration
     *
     * @return
     */
    @GET
    @NoCache
    @Path("events/config")
    @Produces(MediaType.APPLICATION_JSON)
    public OrganizationEventsConfigRepresentation getOrganizationEventsConfig() {
        auth.init(OrganizationAuth.Resource.EVENTS).requireView();

        OrganizationEventsConfigRepresentation config = ModelToRepresentation
                .toEventsConfigReprensetation(organization);
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

    /**
     * Update the events provider
     *
     * Change the events provider and/or its configuration
     *
     * @param rep
     */
    @PUT
    @Path("events/config")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateOrganizationEventsConfig(@Valid final OrganizationEventsConfigRepresentation rep) {
        auth.init(OrganizationAuth.Resource.EVENTS).requireManage();

        logger.debug("updating organization events config: " + organization.getName());
        new OrganizationManager(session).updateOrganizationEventsConfig(rep, organization);
    }

    /**
     * Get events
     *
     * Returns all events, or filters them based on URL query parameters listed
     * here
     *
     * @param types
     *            The types of events to return
     * @param user
     *            User id
     * @param ipAddress
     *            IP address
     * @param dateTo
     *            To date
     * @param dateFrom
     *            From date
     * @param firstResult
     *            Paging offset
     * @param maxResults
     *            Paging size
     * @return
     */
    @Path("events")
    @GET
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public List<EventRepresentation> getEvents(@QueryParam("type") List<String> types,
            @QueryParam("user") String user, @QueryParam("dateFrom") String dateFrom,
            @QueryParam("dateTo") String dateTo, @QueryParam("ipAddress") String ipAddress,
            @QueryParam("first") Integer firstResult, @QueryParam("max") Integer maxResults) {
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

    /**
     * Get admin events
     *
     * Returns all admin events, or filters events based on URL query parameters
     * listed here
     *
     * @param operationTypes
     * @param authOrganization
     * @param authUser
     *            user id
     * @param authIpAddress
     * @param resourcePath
     * @param dateTo
     * @param dateFrom
     * @param firstResult
     * @param maxResults
     * @return
     */
    @Path("admin-events")
    @GET
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public List<AdminEventRepresentation> getEvents(@QueryParam("operationTypes") List<String> operationTypes,
            @QueryParam("authOrganization") String authOrganization, @QueryParam("authUser") String authUser,
            @QueryParam("authIpAddress") String authIpAddress,
            @QueryParam("resourcePath") String resourcePath, @QueryParam("dateFrom") String dateFrom,
            @QueryParam("dateTo") String dateTo, @QueryParam("first") Integer firstResult,
            @QueryParam("max") Integer maxResults, @QueryParam("resourceTypes") List<String> resourceTypes) {
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
                throw new BadRequestException(
                        "Invalid value for 'Date(From)', expected format is yyyy-MM-dd");
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

    /**
     * Delete all events
     *
     */
    @Path("events")
    @DELETE
    public void clearEvents() {
        auth.init(OrganizationAuth.Resource.EVENTS).requireManage();

        EventStoreProvider eventStore = session.getProvider(EventStoreProvider.class);
        eventStore.clear(organization.getId());
    }

    /**
     * Delete all admin events
     *
     */
    @Path("admin-events")
    @DELETE
    public void clearAdminEvents() {
        auth.init(OrganizationAuth.Resource.EVENTS).requireManage();

        EventStoreProvider eventStore = session.getProvider(EventStoreProvider.class);
        eventStore.clearAdmin(organization.getId());
    }

    /**
     * Base path for managing components under this organization.
     *
     * @return
     */
    @Path("components")
    public ComponentResource getComponents() {
        ComponentResource resource = new ComponentResource(organization, auth, adminEvent);
        ResteasyProviderFactory.getInstance().injectProperties(resource);
        return resource;
    }

    @Path("keys")
    public KeyResource keys() {
        KeyResource resource = new KeyResource(organization, session, this.auth);
        ResteasyProviderFactory.getInstance().injectProperties(resource);
        return resource;
    }

}
