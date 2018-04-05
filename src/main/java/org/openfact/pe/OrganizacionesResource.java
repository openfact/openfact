package org.openfact.pe;

import org.openfact.pe.idm.OrganizacionRepresentation;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/organizations/{organizationId}/pe")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface OrganizacionesResource {

    @GET
    @Path("/")
    OrganizacionRepresentation getCompany(
            @PathParam("organizationId") String organizationId
    );

    @PUT
    @Path("/")
    OrganizacionRepresentation updateCompany(
            @PathParam("organizationId") String organizationId,
            @Valid OrganizacionRepresentation rep
    );

}
