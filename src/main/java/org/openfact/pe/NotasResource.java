package org.openfact.pe;

import org.openfact.pe.representations.idm.NotaRepresentation;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/organizations/{organizationId}/pe/documentos/notas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface NotasResource {

    @GET
    @Path("/")
    List<NotaRepresentation> getNotas(
            @PathParam("organizationId") String organizationId,
            @QueryParam("filterText") String filterText,
            @QueryParam("offset") @DefaultValue("0") int offset,
            @QueryParam("limit") @DefaultValue("10") int limit
    );

    @POST
    @Path("/")
    NotaRepresentation crearNota(
            @PathParam("organizationId") String organizacionId,
            @QueryParam("async") @DefaultValue("true") Boolean async,
            @Valid NotaRepresentation rep
    );

    @GET
    @Path("/{documentId}")
    NotaRepresentation getNota(
            @PathParam("organizationId") String organizationId,
            @PathParam("documentId") String documentId
    );

    @PUT
    @Path("/{documentId}")
    NotaRepresentation actualizarNota(
            @PathParam("organizationId") String organizacionId,
            @PathParam("documentId") String idDocumento,
            @QueryParam("async") @DefaultValue("true") Boolean async,
            @Valid NotaRepresentation rep
    );

    @DELETE
    @Path("/{documentId}")
    void eliminarNota(
            @PathParam("organizationId") String organizacionId,
            @PathParam("documentId") String idDocumento
    );

}
