package org.openfact.pe;

import org.openfact.pe.representations.idm.BoletaRepresentation;
import org.openfact.pe.representations.idm.NotaCreditoRepresentation;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/organizations/{organizationId}/pe/documentos/notas-credito")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface NotasCreditoResource {

    @GET
    @Path("/")
    List<NotaCreditoRepresentation> getNotasCredito(
            @PathParam("organizationId") String organizationId,
            @QueryParam("estado") @DefaultValue("ABIERTO") String estado,
            @QueryParam("offset") @DefaultValue("0") int offset,
            @QueryParam("limit") @DefaultValue("10") int limit
    );

    @POST
    @Path("/")
    NotaCreditoRepresentation crearNotaCredito(
            @PathParam("organizationId") String organizacionId,
            @QueryParam("async") @DefaultValue("true") Boolean async,
            @Valid NotaCreditoRepresentation rep
    );

    @GET
    @Path("/{documentId}")
    NotaCreditoRepresentation getNotaCredito(
            @PathParam("organizationId") String organizationId,
            @PathParam("documentId") String idDocumento
    );

    @PUT
    @Path("/{documentId}")
    NotaCreditoRepresentation actualizarNotaCredito(
            @PathParam("organizationId") String organizacionId,
            @PathParam("documentId") String idDocumento,
            @QueryParam("async") @DefaultValue("true") Boolean async,
            @Valid NotaCreditoRepresentation rep
    );

    @DELETE
    @Path("/{documentId}")
    void eliminarNotaCredito(
            @PathParam("organizationId") String organizacionId,
            @PathParam("documentId") String idDocumento
    );

}
