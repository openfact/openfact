package org.openfact.pe;

import org.openfact.pe.idm.BoletaFacturaRepresentation;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/organizations/{organizationId}/pe/documentos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface BoletasFacturasResource {

    @POST
    @Path("/boletas-facturas")
    BoletaFacturaRepresentation crearBoletaFactura(
            @PathParam("organizationId") String organizacionId,
            @Valid BoletaFacturaRepresentation rep
    );

    @PUT
    @Path("/boletas-facturas/{documentId}")
    void actualizarBoletaFactura(
            @PathParam("organizationId") String organizacionId,
            @PathParam("documentId") String idDocumento,
            @Valid BoletaFacturaRepresentation rep
    );

    @DELETE
    @Path("/boletas-facturas/{documentId}")
    void eliminarBoletaFactura(
            @PathParam("organizationId") String organizacionId,
            @PathParam("documentId") String idDocumento
    );

}
