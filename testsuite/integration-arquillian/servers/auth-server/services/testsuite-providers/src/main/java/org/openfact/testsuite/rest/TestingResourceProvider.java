/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates
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
 */

package org.openfact.testsuite.rest;

import org.jboss.resteasy.annotations.cache.NoCache;
import org.jboss.resteasy.spi.BadRequestException;
import org.openfact.common.util.Time;
import org.openfact.component.ComponentModel;
import org.openfact.events.Event;
import org.openfact.events.EventQuery;
import org.openfact.events.EventStoreProvider;
import org.openfact.events.EventType;
import org.openfact.events.admin.AdminEvent;
import org.openfact.events.admin.AdminEventQuery;
import org.openfact.events.admin.AuthDetails;
import org.openfact.events.admin.OperationType;
import org.openfact.events.admin.ResourceType;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.OrganizationProvider;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.provider.ProviderFactory;
import org.openfact.representations.idm.AdminEventRepresentation;
import org.openfact.representations.idm.AuthDetailsRepresentation;
import org.openfact.representations.idm.EventRepresentation;
import org.openfact.services.resource.OrganizationResourceProvider;
import org.openfact.testsuite.components.TestProvider;
import org.openfact.testsuite.components.TestProviderFactory;
import org.openfact.testsuite.events.EventsListenerProvider;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:sthorger@redhat.com">Stian Thorgersen</a>
 */
public class TestingResourceProvider implements OrganizationResourceProvider {

    private OpenfactSession session;

    @Override
    public Object getResource() {
        return this;
    }

    public TestingResourceProvider(OpenfactSession session) {
        this.session = session;
    }

    @GET
    @Path("/time-offset")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, String> getTimeOffset() {
        Map<String, String> response = new HashMap<>();
        response.put("currentTime", String.valueOf(Time.currentTime()));
        response.put("offset", String.valueOf(Time.getOffset()));
        return response;
    }

    @PUT
    @Path("/time-offset")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, String> setTimeOffset(Map<String, String> time) {
        int offset = Integer.parseInt(time.get("offset"));
        Time.setOffset(offset);
        return getTimeOffset();
    }

    @POST
    @Path("/poll-event-queue")
    @Produces(MediaType.APPLICATION_JSON)
    public EventRepresentation getEvent() {
        Event event = EventsListenerProvider.poll();
        if (event != null) {
            return ModelToRepresentation.toRepresentation(event);
        } else {
            return null;
        }
    }

    @POST
    @Path("/poll-admin-event-queue")
    @Produces(MediaType.APPLICATION_JSON)
    public AdminEventRepresentation getAdminEvent() {
        AdminEvent adminEvent = EventsListenerProvider.pollAdminEvent();
        if (adminEvent != null) {
            return ModelToRepresentation.toRepresentation(adminEvent);
        } else {
            return null;
        }
    }

    @POST
    @Path("/clear-event-queue")
    @Produces(MediaType.APPLICATION_JSON)
    public Response clearEventQueue() {
        EventsListenerProvider.clear();
        return Response.ok().build();
    }

    @POST
    @Path("/clear-admin-event-queue")
    @Produces(MediaType.APPLICATION_JSON)
    public Response clearAdminEventQueue() {
        EventsListenerProvider.clearAdminEvents();
        return Response.ok().build();
    }

    @GET
    @Path("/clear-event-store")
    @Produces(MediaType.APPLICATION_JSON)
    public Response clearEventStore() {
        EventStoreProvider eventStore = session.getProvider(EventStoreProvider.class);
        eventStore.clear();
        return Response.ok().build();
    }

    @GET
    @Path("/clear-event-store-for-organization")
    @Produces(MediaType.APPLICATION_JSON)
    public Response clearEventStore(@QueryParam("organizationId") String organizationId) {
        EventStoreProvider eventStore = session.getProvider(EventStoreProvider.class);
        eventStore.clear(organizationId);
        return Response.ok().build();
    }

    @GET
    @Path("/clear-event-store-older-than")
    @Produces(MediaType.APPLICATION_JSON)
    public Response clearEventStore(@QueryParam("organizationId") String organizationId, @QueryParam("olderThan") long olderThan) {
        EventStoreProvider eventStore = session.getProvider(EventStoreProvider.class);
        eventStore.clear(organizationId, olderThan);
        return Response.ok().build();
    }

    /**
     * Query events
     *
     * Returns all events, or filters them based on URL query parameters listed here
     *
     * @param organizationId The organization
     * @param types The types of events to return
     * @param user User id
     * @param dateFrom From date
     * @param dateTo To date
     * @param ipAddress IP address
     * @param firstResult Paging offset
     * @param maxResults Paging size
     * @return
     */
    @Path("query-events")
    @GET
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public List<EventRepresentation> queryEvents(
            @QueryParam("organizationId") String organizationId,
            @QueryParam("type") List<String> types,
            @QueryParam("user") String user,
            @QueryParam("dateFrom") String dateFrom,
            @QueryParam("dateTo") String dateTo,
            @QueryParam("ipAddress") String ipAddress,
            @QueryParam("first") Integer firstResult,
            @QueryParam("max") Integer maxResults) {

        EventStoreProvider eventStore = session.getProvider(EventStoreProvider.class);

        EventQuery query = eventStore.createQuery();

        if (organizationId != null) {
            query.organization(organizationId);
        }

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

        if(dateFrom != null) {
            Date from = formatDate(dateFrom, "Date(From)");
            query.fromDate(from);
        }

        if(dateTo != null) {
            Date to = formatDate(dateTo, "Date(To)");
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

    @PUT
    @Path("/on-event")
    @Consumes(MediaType.APPLICATION_JSON)
    public void onEvent(final EventRepresentation rep) {
        EventStoreProvider eventStore = session.getProvider(EventStoreProvider.class);

        eventStore.onEvent(repToModel(rep));
    }

    private Event repToModel(EventRepresentation rep) {
        Event event = new Event();
        event.setDetails(rep.getDetails());
        event.setError(rep.getError());
        event.setIpAddress(rep.getIpAddress());
        event.setOrganizationId(rep.getOrganizationId());
        event.setTime(rep.getTime());
        event.setType(EventType.valueOf(rep.getType()));
        event.setUserId(rep.getUserId());
        return event;
    }

    @GET
    @Path("/clear-admin-event-store")
    @Produces(MediaType.APPLICATION_JSON)
    public Response clearAdminEventStore() {
        EventStoreProvider eventStore = session.getProvider(EventStoreProvider.class);
        eventStore.clearAdmin();
        return Response.ok().build();
    }

    @GET
    @Path("/clear-admin-event-store-for-organization")
    @Produces(MediaType.APPLICATION_JSON)
    public Response clearAdminEventStore(@QueryParam("organizationId") String organizationId) {
        EventStoreProvider eventStore = session.getProvider(EventStoreProvider.class);
        eventStore.clearAdmin(organizationId);
        return Response.ok().build();
    }

    @GET
    @Path("/clear-admin-event-store-older-than")
    @Produces(MediaType.APPLICATION_JSON)
    public Response clearAdminEventStore(@QueryParam("organizationId") String organizationId, @QueryParam("olderThan") long olderThan) {
        EventStoreProvider eventStore = session.getProvider(EventStoreProvider.class);
        eventStore.clearAdmin(organizationId, olderThan);
        return Response.ok().build();
    }

    /**
     * Get admin events
     *
     * Returns all admin events, or filters events based on URL query parameters listed here
     *
     * @param organizationId
     * @param operationTypes
     * @param authOrganization
     * @param authUser user id
     * @param authIpAddress
     * @param resourcePath
     * @param dateFrom
     * @param dateTo
     * @param firstResult
     * @param maxResults
     * @return
     */
    @Path("query-admin-events")
    @GET
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public List<AdminEventRepresentation> getAdminEvents(
            @QueryParam("organizationId") String organizationId,
            @QueryParam("operationTypes") List<String> operationTypes,
            @QueryParam("authOrganization") String authOrganization,
            @QueryParam("authUser") String authUser,
            @QueryParam("authIpAddress") String authIpAddress,
            @QueryParam("resourcePath") String resourcePath,
            @QueryParam("dateFrom") String dateFrom,
            @QueryParam("dateTo") String dateTo,
            @QueryParam("first") Integer firstResult,
            @QueryParam("max") Integer maxResults) {

        EventStoreProvider eventStore = session.getProvider(EventStoreProvider.class);
        AdminEventQuery query = eventStore.createAdminQuery();

        if (organizationId != null) {
            query.organization(organizationId);
        };

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

        if(dateFrom != null) {
            Date from = formatDate(dateFrom, "Date(From)");
            query.fromTime(from);
        }

        if(dateTo != null) {
            Date to = formatDate(dateTo, "Date(To)");
            query.toTime(to);
        }

        if (firstResult != null || maxResults != null) {
            if (firstResult == null) {
                firstResult = 0;
            }
            if (maxResults == null) {
                maxResults = 100;
            }
            query.firstResult(firstResult);
            query.maxResults(maxResults);
        }

        return toAdminEventRep(query.getResultList());
    }

    private Date formatDate(String date, String paramName) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return df.parse(date);
        } catch (ParseException e) {
            throw new BadRequestException("Invalid value for '" + paramName + "', expected format is yyyy-MM-dd");
        }
    }

    private List<AdminEventRepresentation> toAdminEventRep(List<AdminEvent> events) {
        List<AdminEventRepresentation> reps = new ArrayList<>();
        for (AdminEvent event : events) {
            reps.add(ModelToRepresentation.toRepresentation(event));
        }

        return reps;
    }

    @POST
    @Path("/on-admin-event")
    @Consumes(MediaType.APPLICATION_JSON)
    public void onAdminEvent(final AdminEventRepresentation rep, @QueryParam("includeRepresentation") boolean includeRepresentation) {
        EventStoreProvider eventStore = session.getProvider(EventStoreProvider.class);
        eventStore.onEvent(repToModel(rep), includeRepresentation);
    }

    private AdminEvent repToModel(AdminEventRepresentation rep) {
        AdminEvent event = new AdminEvent();
        event.setAuthDetails(repToModel(rep.getAuthDetails()));
        event.setError(rep.getError());
        event.setOperationType(OperationType.valueOf(rep.getOperationType()));
        if (rep.getResourceType() != null) {
            event.setResourceType(ResourceType.valueOf(rep.getResourceType()));
        }
        event.setOrganizationId(rep.getOrganizationId());
        event.setRepresentation(rep.getRepresentation());
        event.setResourcePath(rep.getResourcePath());
        event.setTime(rep.getTime());
        return event;
    }

    private AuthDetails repToModel(AuthDetailsRepresentation rep) {
        AuthDetails details = new AuthDetails();
        details.setIpAddress(rep.getIpAddress());
        details.setOrganizationId(rep.getOrganizationId());
        details.setUserId(rep.getUserId());
        return details;
    }

    @Override
    public void close() {
    }

    @GET
    @Path("/test-component")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, TestProvider.DetailsRepresentation> getTestComponentDetails() {
        Map<String, TestProvider.DetailsRepresentation> reps = new HashMap<>();

        OrganizationModel organization = session.getContext().getOrganization();
        for (ComponentModel c : organization.getComponents(organization.getId(), TestProvider.class.getName())) {
            ProviderFactory<TestProvider> f = session.getOpenfactSessionFactory().getProviderFactory(TestProvider.class, c.getProviderId());
            TestProviderFactory factory = (TestProviderFactory) f;
            TestProvider p = (TestProvider) factory.create(session, c);
            reps.put(c.getName(), p.getDetails());
        }

        return reps;
    }

    @GET
    @Path("/smtp-config")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, String> getSmtpConfig() {
        return session.getContext().getOrganization().getSmtpConfig();
    }

    private OrganizationModel getOrganizationByName(String organizationName) {
        OrganizationProvider organizationProvider = session.getProvider(OrganizationProvider.class);
        return organizationProvider.getOrganizationByName(organizationName);
    }

}
