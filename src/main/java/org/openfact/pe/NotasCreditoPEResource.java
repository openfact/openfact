package org.openfact.pe;

import org.openfact.pe.idm.BoletaFacturaPERepresentation;
import org.openfact.pe.idm.NotaCreditoPERepresentation;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/companies/{companyId}/pe/documentos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface NotasCreditoPEResource {

    @POST
    @Path("/notas-credito")
    NotaCreditoPERepresentation crearNotaCredito(
            @PathParam("companyId") String organizacionId,
            @Valid NotaCreditoPERepresentation rep
    );

    @PUT
    @Path("/notas-credito/{documentId}")
    void actualizarNotaCredito(
            @PathParam("companyId") String organizacionId,
            @PathParam("documentId") String idDocumento,
            @Valid NotaCreditoPERepresentation rep
    );

    @DELETE
    @Path("/notas-credito/{documentId}")
    void eliminarNotaCredito(
            @PathParam("companyId") String organizacionId,
            @PathParam("documentId") String idDocumento
    );

}
