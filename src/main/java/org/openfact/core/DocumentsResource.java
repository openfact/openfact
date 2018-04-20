package org.openfact.core;

import org.openfact.core.representations.idm.DocumentQueryRepresentation;
import org.openfact.core.representations.idm.DocumentRepresentation;
import org.openfact.core.representations.idm.SearchResultRepresentation;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/documents")
@Consumes(MediaType.APPLICATION_JSON)
public interface DocumentsResource {

    @GET
    @Path("{documentId}")
    DocumentRepresentation getDocument(
            @PathParam("documentId") String documentId
    );

    @GET
    @Path("/{documentId}/download")
    @Produces("application/xml")
    Response downloadDocumentXml(
            @PathParam("documentId") String documentId
    );

    @GET
    @Path("/{documentId}/print")
    Response downloadDocumentPdf(
            @Context final HttpServletRequest httpServletRequest,
            @PathParam("documentId") String documentId,
            @QueryParam("theme") String theme,
            @QueryParam("locale") String locale,
            @QueryParam("format") @DefaultValue("pdf") String format
    );

    @GET
    @Path("/documents")
    @Produces(MediaType.APPLICATION_JSON)
    Response getDocuments(
            @QueryParam("filterText") String filterText,
            @QueryParam("offset") @DefaultValue("0") int offset,
            @QueryParam("limit") @DefaultValue("10") int limit
    );

    @POST
    @Path("/documents/search")
    @Produces(MediaType.APPLICATION_JSON)
    SearchResultRepresentation<DocumentRepresentation> searchUserDocuments(
            @Valid DocumentQueryRepresentation query
    );
}
