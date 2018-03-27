package org.openfact;

import org.openfact.representations.idm.PECompanyRepresentation;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/companies/{companyId}/pe")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface PECompaniesResource {

    @GET
    @Path("/")
    PECompanyRepresentation getCompany(@PathParam("companyId") String companyId);

    @PUT
    @Path("/")
    PECompanyRepresentation updateCompany(@PathParam("companyId") String companyId, @Valid PECompanyRepresentation rep);

}
