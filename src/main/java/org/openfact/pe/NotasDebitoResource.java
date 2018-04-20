package org.openfact.pe;

import org.openfact.pe.representations.idm.NotaDebitoRepresentation;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/organizations/{organizationId}/pe/documentos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface NotasDebitoResource {

    @POST
    @Path("/notas-debito")
    NotaDebitoRepresentation crearNotaDebito(
            @PathParam("organizationId") String organizacionId,
            @Valid NotaDebitoRepresentation rep
    );

    @PUT
    @Path("/nota-debito/{documentId}")
    void actualizarNotaDebito(
            @PathParam("organizationId") String organizacionId,
            @PathParam("documentId") String idDocumento,
            @Valid NotaDebitoRepresentation rep
    );

    @DELETE
    @Path("/nota-debito/{documentId}")
    void eliminarNotaDebito(
            @PathParam("organizationId") String organizacionId,
            @PathParam("documentId") String idDocumento
    );

}
