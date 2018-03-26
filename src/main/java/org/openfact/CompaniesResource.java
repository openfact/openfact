package org.openfact;

import org.openfact.representations.idm.CompanyRepresentation;

import javax.enterprise.context.ApplicationScoped;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("companies")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface CompaniesResource {

    @POST
    @Path("/")
    CompanyRepresentation createCompany(@Valid CompanyRepresentation companyRepresentation);

    @GET
    List<CompanyRepresentation> getCompanies(@QueryParam("userId") String userId,
                                             @QueryParam("mode") @DefaultValue("owned") String mode);

}
