package org.sistcoop.admin.client.resource;

import org.openfact.representations.idm.AdminEventRepresentation;
import org.openfact.representations.idm.EventRepresentation;
import org.openfact.representations.idm.OrganizationEventsConfigRepresentation;
import org.openfact.representations.idm.OrganizationRepresentation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public interface OrganizationResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    OrganizationRepresentation toRepresentation();

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    void update(OrganizationRepresentation organizationRepresentation);

    @DELETE
    Response remove();

    @Path("documents")
    DocumentsResource documents();

    @Path("files/{id}")
    Response getFile();

    @GET
    @Path("events")
    @Produces(MediaType.APPLICATION_JSON)
    List<EventRepresentation> getEvents();

    @Path("events")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<EventRepresentation> getEvents(@QueryParam("first") Integer firstResult,
                                        @QueryParam("max") Integer maxResults);


    @DELETE
    @Path("events")
    void clearEvents();

    @GET
    @Path("admin-events")
    @Produces(MediaType.APPLICATION_JSON)
    List<AdminEventRepresentation> getAdminEvents();

    @GET
    @Path("admin-events")
    @Produces(MediaType.APPLICATION_JSON)
    List<AdminEventRepresentation> getAdminEvents(
            @PathParam("organization") final String organizationName,
            @QueryParam("operationTypes") List<String> operationTypes,
            @QueryParam("authOrganization") String authOrganization,
            @QueryParam("authUser") String authUser,
            @QueryParam("authIpAddress") String authIpAddress,
            @QueryParam("resourcePath") String resourcePath,
            @QueryParam("dateFrom") String dateFrom,
            @QueryParam("dateTo") String dateTo,
            @QueryParam("first") Integer firstResult,
            @QueryParam("max") Integer maxResults,
            @QueryParam("resourceTypes") List<String> resourceTypes);

    @DELETE
    @Path("admin-events")
    void clearAdminEvents();

    @GET
    @Path("events/config")
    @Produces(MediaType.APPLICATION_JSON)
    OrganizationEventsConfigRepresentation getOrganizationEventsConfig();

    @PUT
    @Path("events/config")
    @Consumes(MediaType.APPLICATION_JSON)
    void updateOrganizationEventsConfig(OrganizationEventsConfigRepresentation rep);

}
