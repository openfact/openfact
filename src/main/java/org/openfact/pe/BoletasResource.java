package org.openfact.pe;

import org.openfact.pe.idm.BoletaRepresentation;
import org.openfact.pe.models.EstadoComprobantePago;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/organizations/{organizationId}/pe/documentos/boletas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface BoletasResource {

    @GET
    @Path("/")
    List<BoletaRepresentation> getBoletas(
            @PathParam("organizationId") String organizationId,
            @QueryParam("estado") @DefaultValue("REGISTRADO") String estado,
            @QueryParam("offset") @DefaultValue("0") int offset,
            @QueryParam("limit") @DefaultValue("10") int limit
    );

    @POST
    @Path("/")
    BoletaRepresentation crearBoleta(
            @PathParam("organizationId") String organizationId,
            @Valid BoletaRepresentation rep
    );

    @PUT
    @Path("/{documentId}")
    void actualizarBoleta(
            @PathParam("organizationId") String organizationId,
            @PathParam("documentId") String idDocumento,
            @Valid BoletaRepresentation rep
    );

    @DELETE
    @Path("/{documentId}")
    void eliminarBoleta(
            @PathParam("organizationId") String organizationId,
            @PathParam("documentId") String idDocumento
    );

}
