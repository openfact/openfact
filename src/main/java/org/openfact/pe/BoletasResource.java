package org.openfact.pe;

import org.openfact.pe.idm.BoletaRepresentation;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/organizations/{organizationId}/pe/documentos/boletas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface BoletasResource {

    @POST
    @Path("/")
    BoletaRepresentation crearBoleta(
            @PathParam("organizationId") String organizacionId,
            @Valid BoletaRepresentation rep
    );

    @PUT
    @Path("/{documentId}")
    void actualizarBoleta(
            @PathParam("organizationId") String organizacionId,
            @PathParam("documentId") String idDocumento,
            @Valid BoletaRepresentation rep
    );

    @DELETE
    @Path("/{documentId}")
    void eliminarBoleta(
            @PathParam("organizationId") String organizacionId,
            @PathParam("documentId") String idDocumento
    );

}
