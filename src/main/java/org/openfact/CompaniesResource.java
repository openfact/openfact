package org.openfact;

import org.openfact.representations.idm.CompanyRepresentation;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("companies")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface CompaniesResource {

    @POST
    @Path("/")
    CompanyRepresentation createCompany(@Valid CompanyRepresentation companyRepresentation);

    @GET
    @Path("/")
    List<CompanyRepresentation> getCompanies(
            @QueryParam("companyId") String companyId,
            @QueryParam("userId") String userId,
            @QueryParam("role") @DefaultValue("owner") String role);

    @GET
    @Path("/{companyId}")
    CompanyRepresentation getCompany(@PathParam("companyId") String companyId);

    @PUT
    @Path("/{companyId}")
    CompanyRepresentation updateCompany(@PathParam("companyId") String companyId, @Valid CompanyRepresentation rep);

    @DELETE
    @Path("/{companyId}")
    void deleteCompany(@PathParam("companyId") String companyId);

}
