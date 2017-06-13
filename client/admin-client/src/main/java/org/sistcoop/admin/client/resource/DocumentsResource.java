package org.sistcoop.admin.client.resource;

import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.openfact.representations.idm.DocumentRepresentation;
import org.openfact.representations.idm.search.SearchResultsRepresentation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Consumes(MediaType.APPLICATION_JSON)
public interface DocumentsResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    SearchResultsRepresentation<DocumentRepresentation> search(@QueryParam("query") @DefaultValue("") String query);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    SearchResultsRepresentation<DocumentRepresentation> search(@QueryParam("query") @DefaultValue("") String query,
                                                               @QueryParam("requiredActions") final List<String> requiredActions);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    SearchResultsRepresentation<DocumentRepresentation> search(@QueryParam("query") @DefaultValue("") String query,
                                                               @QueryParam("requiredActions") final List<String> requiredActions,
                                                               @QueryParam("includeDisabled") @DefaultValue("false") final Boolean includeDisabled);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    SearchResultsRepresentation<DocumentRepresentation> search(@QueryParam("query") @DefaultValue("") String query,
                                                               @QueryParam("requiredActions") final List<String> requiredActions,
                                                               @QueryParam("includeDisabled") @DefaultValue("false") final Boolean includeDisabled,
                                                               @QueryParam("first") Integer firstResult,
                                                               @QueryParam("max") Integer maxResults);

    @Path("upload")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    void uploadDocument(MultipartFormDataInput input);

    @Path("{documentId}")
    @DELETE
    Response delete(@PathParam("documentId") String documentId);

    @Path("{documentId}")
    DocumentResource get(@PathParam("documentId") String documentId);

}
