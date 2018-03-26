package org.openfact;

import org.openfact.models.CompanyModel;
import org.openfact.models.CompanyProvider;
import org.openfact.models.UserModel;
import org.openfact.models.UserProvider;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.representations.idm.CompanyRepresentation;
import org.openfact.representations.idm.UserRepresentation;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Transactional
@Path("companies")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CompaniesResource {

    @Inject
    private UserProvider userProvider;

    @Inject
    private CompanyProvider companyProvider;

    @POST
    @Path("/")
    public Response createCompany(@Valid CompanyRepresentation companyRepresentation) {
        CompanyRepresentation.CompanyOwnerRepresentation ownerRepresentation = companyRepresentation.getOwner();

        Optional<UserModel> ownerModel = userProvider.getUser(ownerRepresentation.getId());
        if (!ownerModel.isPresent()) {
            return ErrorResponse.error("Owner does not exist", Response.Status.BAD_REQUEST);
        }

        CompanyModel companyModel = companyProvider.addCompany(companyRepresentation.getName(), ownerModel.get());
        companyModel.setDescription(companyRepresentation.getDescription());

        return Response.ok(ModelToRepresentation.toRepresentation(companyModel, true)).build();
    }

    @GET
    public List<CompanyRepresentation> getCompanies() {
        throw new ForbiddenException();
    }

}
