package org.openfact.pe;

import org.openfact.pe.idm.BoletaFacturaPERepresentation;
import org.openfact.pe.idm.NotaCreditoPERepresentation;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/companies/{companyId}/pe/documentos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface BoletasFacturasPEResource {

    @POST
    @Path("/boletas-facturas")
    BoletaFacturaPERepresentation crearBoletaFactura(
            @PathParam("companyId") String organizacionId,
            @Valid BoletaFacturaPERepresentation rep
    );

    @PUT
    @Path("/boletas-facturas/{documentId}")
    void actualizarBoletaFactura(
            @PathParam("companyId") String organizacionId,
            @PathParam("documentId") String idDocumento,
            @Valid BoletaFacturaPERepresentation rep
    );

    @DELETE
    @Path("/boletas-facturas/{documentId}")
    void eliminarBoletaFactura(
            @PathParam("companyId") String organizacionId,
            @PathParam("documentId") String idDocumento
    );

}
