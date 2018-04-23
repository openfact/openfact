package org.openfact.pe;

import org.openfact.pe.representations.idm.FacturaRepresentation;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/organizations/{organizationId}/pe/documentos/facturas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface FacturasResource {

    @GET
    @Path("/")
    List<FacturaRepresentation> getFacturas(
            @PathParam("organizationId") String organizationId,
            @QueryParam("estado") @DefaultValue("ABIERTO") String estado,
            @QueryParam("offset") @DefaultValue("0") int offset,
            @QueryParam("limit") @DefaultValue("10") int limit
    );

    @POST
    @Path("/")
    FacturaRepresentation crearFactura(
            @PathParam("organizationId") String organizationId,
            @Valid FacturaRepresentation rep
    );

    @PUT
    @Path("/{documentId}")
    FacturaRepresentation getFactura(
            @PathParam("organizationId") String organizationId,
            @PathParam("documentId") String idDocumento
    );

    @PUT
    @Path("/{documentId}")
    void actualizarFactura(
            @PathParam("organizationId") String organizationId,
            @PathParam("documentId") String idDocumento,
            @Valid FacturaRepresentation rep
    );

    @DELETE
    @Path("/{documentId}")
    void eliminarFactura(
            @PathParam("organizationId") String organizationId,
            @PathParam("documentId") String idDocumento
    );

}
