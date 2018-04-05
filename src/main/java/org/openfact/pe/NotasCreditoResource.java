package org.openfact.pe;

import org.openfact.pe.idm.NotaCreditoRepresentation;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/organizations/{organizationId}/pe/documentos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface NotasCreditoResource {

    @POST
    @Path("/notas-credito")
    NotaCreditoRepresentation crearNotaCredito(
            @PathParam("organizationId") String organizacionId,
            @Valid NotaCreditoRepresentation rep
    );

    @PUT
    @Path("/notas-credito/{documentId}")
    void actualizarNotaCredito(
            @PathParam("organizationId") String organizacionId,
            @PathParam("documentId") String idDocumento,
            @Valid NotaCreditoRepresentation rep
    );

    @DELETE
    @Path("/notas-credito/{documentId}")
    void eliminarNotaCredito(
            @PathParam("organizationId") String organizacionId,
            @PathParam("documentId") String idDocumento
    );

}
