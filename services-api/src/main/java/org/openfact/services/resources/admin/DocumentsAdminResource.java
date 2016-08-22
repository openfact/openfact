package org.openfact.services.resources.admin;

import java.util.Set;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.cache.NoCache;
import org.openfact.representations.idm.DocumentRepresentation;

/**
 * @author carlosthe19916@sistcoop.com
 */
@Consumes(MediaType.APPLICATION_JSON)
public interface DocumentsAdminResource {

    /**
     * @param documentId
     *            The documentId of the document
     */
    @Path("{documentId}")
    DocumentAdminResource getDocumentAdmin(@PathParam("documentId") final String documentId);

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    Response createDocument(@Valid final DocumentRepresentation rep);

    @GET
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    Set<DocumentRepresentation> getDocuments(@QueryParam("type") final String type);

}
