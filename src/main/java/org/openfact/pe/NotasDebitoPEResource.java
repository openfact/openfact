package org.openfact.pe;

import org.openfact.pe.idm.NotaDebitoPERepresentation;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/companies/{companyId}/pe/documentos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface NotasDebitoPEResource {

    @POST
    @Path("/notas-debito")
    NotaDebitoPERepresentation crearNotaDebito(
            @PathParam("companyId") String organizacionId,
            @Valid NotaDebitoPERepresentation rep
    );

    @PUT
    @Path("/nota-debito/{documentId}")
    void actualizarNotaDebito(
            @PathParam("companyId") String organizacionId,
            @PathParam("documentId") String idDocumento,
            @Valid NotaDebitoPERepresentation rep
    );

    @DELETE
    @Path("/nota-debito/{documentId}")
    void eliminarNotaDebito(
            @PathParam("companyId") String organizacionId,
            @PathParam("documentId") String idDocumento
    );

}
