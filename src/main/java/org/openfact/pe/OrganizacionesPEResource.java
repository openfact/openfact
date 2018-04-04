package org.openfact.pe;

import org.openfact.pe.idm.OrganizacionPERepresentation;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/companies/{companyId}/pe")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface OrganizacionesPEResource {

    @GET
    @Path("/")
    OrganizacionPERepresentation getCompany(@PathParam("companyId") String companyId);

    @PUT
    @Path("/")
    OrganizacionPERepresentation updateCompany(@PathParam("companyId") String companyId, @Valid OrganizacionPERepresentation rep);

}
