package org.openfact.pe;

import org.openfact.pe.representations.idm.NotaCreditoRepresentation;
import org.openfact.pe.representations.idm.NotaDebitoRepresentation;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/organizations/{organizationId}/pe/documentos/notas-debito")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface NotasDebitoResource {

    @GET
    @Path("/")
    List<NotaDebitoRepresentation> getNotasDebito(
            @PathParam("organizationId") String organizationId,
            @QueryParam("estado") @DefaultValue("ABIERTO") String estado,
            @QueryParam("offset") @DefaultValue("0") int offset,
            @QueryParam("limit") @DefaultValue("10") int limit
    );

    @POST
    @Path("/")
    NotaDebitoRepresentation crearNotaDebito(
            @PathParam("organizationId") String organizacionId,
            @QueryParam("async") @DefaultValue("true") Boolean async,
            @Valid NotaDebitoRepresentation rep
    );

    @GET
    @Path("/{documentId}")
    NotaDebitoRepresentation getNotaDebito(
            @PathParam("organizationId") String organizationId,
            @PathParam("documentId") String idDocumento
    );

    @PUT
    @Path("/{documentId}")
    NotaDebitoRepresentation actualizarNotaDebito(
            @PathParam("organizationId") String organizacionId,
            @PathParam("documentId") String idDocumento,
            @QueryParam("async") @DefaultValue("true") Boolean async,
            @Valid NotaDebitoRepresentation rep
    );

    @DELETE
    @Path("/{documentId}")
    void eliminarNotaDebito(
            @PathParam("organizationId") String organizacionId,
            @PathParam("documentId") String idDocumento
    );

}
