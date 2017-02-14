package org.openfact.admin.client.resource;

import org.jboss.resteasy.annotations.cache.NoCache;
import org.openfact.representations.idm.AdminEventRepresentation;
import org.openfact.representations.idm.EventRepresentation;
import org.openfact.representations.idm.OrganizationEventsConfigRepresentation;
import org.openfact.representations.idm.OrganizationRepresentation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

public interface OrganizationResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public OrganizationRepresentation toRepresentation();

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    void update(OrganizationRepresentation organizationRepresentation);

    @DELETE
    void remove();

    @Path("documents")
    DocumentsResource documents();

    @Path("invoices")
    public InvoicesResource invoices();

    @Path("credit-notes")
    public CreditNotesResource creditNotes();

    @Path("debit-notes")
    public DebitNotesResource debitNotes();

    @Path("job-reports")
    public JobReportsResource jobReports();

    @Path("storage-files")
    public StorageFilesResource storageFiles();

    @DELETE
    @Path("events")
    public void clearEvents();

    @GET
    @Path("events")
    @Produces(MediaType.APPLICATION_JSON)
    public List<EventRepresentation> getEvents();

    @Path("events")
    @GET
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public List<EventRepresentation> getEvents(@QueryParam("type") List<String> types,
                                               @QueryParam("user") String user,
                                               @QueryParam("dateFrom") String dateFrom,
                                               @QueryParam("dateTo") String dateTo,
                                               @QueryParam("ipAddress") String ipAddress,
                                               @QueryParam("first") Integer firstResult,
                                               @QueryParam("max") Integer maxResults);

    @DELETE
    @Path("admin-events")
    public void clearAdminEvents();

    @GET
    @Path("admin-events")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AdminEventRepresentation> getAdminEvents();

    @GET
    @Path("admin-events")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AdminEventRepresentation> getAdminEvents(@QueryParam("operationTypes") List<String> operationTypes,
                                                         @QueryParam("authOrganization") String authOrganization,
                                                         @QueryParam("authUser") String authUser,
                                                         @QueryParam("authIpAddress") String authIpAddress,
                                                         @QueryParam("resourcePath") String resourcePath,
                                                         @QueryParam("dateFrom") String dateFrom,
                                                         @QueryParam("dateTo") String dateTo,
                                                         @QueryParam("first") Integer firstResult,
                                                         @QueryParam("max") Integer maxResults,
                                                         @QueryParam("resourceTypes") List<String> resourceTypes);

    @GET
    @Path("events/config")
    @Produces(MediaType.APPLICATION_JSON)
    public OrganizationEventsConfigRepresentation getOrganizationEventsConfig();

    @PUT
    @Path("events/config")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateOrganizationEventsConfig(OrganizationEventsConfigRepresentation rep);

    @Path("components")
    public ComponentsResource components();

    @Path("keys")
    public KeyResource keys();

}
