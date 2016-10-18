package org.openfact.services.resources.admin;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.cache.NoCache;
import org.openfact.representations.idm.AdminEventRepresentation;
import org.openfact.representations.idm.EventRepresentation;
import org.openfact.representations.idm.OrganizationEventsConfigRepresentation;
import org.openfact.representations.idm.OrganizationRepresentation;

/**
 * @author carlosthe19916@sistcoop.com
 */
public interface OrganizationAdminResource {

    /**
     * Get the organization with the specified organization name.
     *
     * @return The organization with the specified name
     * @summary Get the organization with the specified name
     */
    @GET
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    OrganizationRepresentation getOrganization();

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
    Response updateOrganization(@Valid final OrganizationRepresentation rep);

    /**
     * Deletes organization with given name.
     *
     * @throws AuthorizationException
     *             The user is not authorized to delete this organization.
     */
    @DELETE
    void deleteOrganization();

    /**
     * Get the invoices sub resource for the current organization
     */
    @Path("invoices")
    InvoicesAdminResource invoices();

    /**
     * Get the invoices sub resource for the current organization
     */
    @Path("credit-notes")
    CreditNotesAdminResource creditNotes();

    /**
     * Get the invoices sub resource for the current organization
     */
    @Path("debit-notes")
    DebitNotesAdminResource debitNotes();

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
    public OrganizationEventsConfigRepresentation getOrganizationEventsConfig();

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
    public void updateOrganizationEventsConfig(@Valid final OrganizationEventsConfigRepresentation rep);

    /**
     * Get events
     *
     * Returns all events, or filters them based on URL query parameters listed
     * here
     *
     * @param types
     *            The types of events to return
     * @param client
     *            App or oauth client name
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
            @QueryParam("client") String client, @QueryParam("user") String user,
            @QueryParam("dateFrom") String dateFrom, @QueryParam("dateTo") String dateTo,
            @QueryParam("ipAddress") String ipAddress, @QueryParam("first") Integer firstResult,
            @QueryParam("max") Integer maxResults);

    /**
     * Get admin events
     *
     * Returns all admin events, or filters events based on URL query parameters
     * listed here
     *
     * @param operationTypes
     * @param authRealm
     * @param authClient
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
            @QueryParam("authRealm") String authRealm, @QueryParam("authClient") String authClient,
            @QueryParam("authUser") String authUser, @QueryParam("authIpAddress") String authIpAddress,
            @QueryParam("resourcePath") String resourcePath, @QueryParam("dateFrom") String dateFrom,
            @QueryParam("dateTo") String dateTo, @QueryParam("first") Integer firstResult,
            @QueryParam("max") Integer maxResults, @QueryParam("resourceTypes") List<String> resourceTypes);

    /**
     * Delete all events
     *
     */
    @Path("events")
    @DELETE
    public void clearEvents();

    /**
     * Delete all admin events
     *
     */
    @Path("admin-events")
    @DELETE
    public void clearAdminEvents();

}
