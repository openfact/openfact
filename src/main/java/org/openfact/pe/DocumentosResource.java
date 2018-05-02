package org.openfact.pe;

import org.openfact.pe.representations.idm.ResumenDocumentosObservadosRepresentation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/organizations/{organizationId}/pe/documentos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface DocumentosResource {

    @GET
    @Path("/observados")
    ResumenDocumentosObservadosRepresentation getResumenDocumentosObservados(
            @PathParam("organizationId") String organizationId
    );

}
