package org.openfact.pe;

import org.openfact.pe.representations.idm.BajaRepresentation;
import org.openfact.pe.representations.idm.InvoiceRepresentation;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/organizations/{organizationId}/pe/documentos/bajas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface BajasResource {

    @GET
    @Path("/")
    List<BajaRepresentation> getBajas(
            @PathParam("organizationId") String organizationId,
            @QueryParam("filterText") String filterText,
            @QueryParam("offset") @DefaultValue("0") int offset,
            @QueryParam("limit") @DefaultValue("10") int limit
    );

    @POST
    @Path("/")
    BajaRepresentation crearBaja(
            @PathParam("organizationId") String organizationId,
            @QueryParam("async") @DefaultValue("true") Boolean async,
            @Valid BajaRepresentation rep
    );


    @GET
    @Path("/{documentId}")
    BajaRepresentation getBaja(
            @PathParam("organizationId") String organizationId,
            @PathParam("documentId") String documentId
    );

    @PUT
    @Path("/{documentId}")
    BajaRepresentation actualizarBaja(
            @PathParam("organizationId") String organizationId,
            @PathParam("documentId") String idDocumento,
            @QueryParam("async") @DefaultValue("true") Boolean async,
            @Valid BajaRepresentation rep
    );

    @DELETE
    @Path("/{documentId}")
    void eliminarBaja(
            @PathParam("organizationId") String organizationId,
            @PathParam("documentId") String idDocumento
    );

}
