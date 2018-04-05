package org.openfact.pe;

import org.openfact.pe.idm.FacturaRepresentation;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/organizations/{organizationId}/pe/documentos/facturas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface FacturasResource {

    @POST
    @Path("/")
    FacturaRepresentation crearFactura(
            @PathParam("organizationId") String organizacionId,
            @Valid FacturaRepresentation rep
    );

    @PUT
    @Path("/{documentId}")
    void actualizarFactura(
            @PathParam("organizationId") String organizacionId,
            @PathParam("documentId") String idDocumento,
            @Valid FacturaRepresentation rep
    );

    @DELETE
    @Path("/{documentId}")
    void eliminarFactura(
            @PathParam("organizationId") String organizacionId,
            @PathParam("documentId") String idDocumento
    );

}
