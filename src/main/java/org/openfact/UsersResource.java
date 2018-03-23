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
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("users")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsersResource {

    @Inject
    private UserProvider userProvider;

    @Inject
    private CompaniesResource companiesResource;

    @GET
    @Path("/{userId}")
    public UserRepresentation getUser(@PathParam("userId") String userId) {
        UserModel userModel = userProvider.getUser(userId).orElseThrow(NotFoundException::new);
        return ModelToRepresentation.toRepresentation(userModel, true);
    }

    @PUT
    @Path("/{userId}")
    public UserRepresentation updateUser(@PathParam("userId") String userId, UserRepresentation rep) {
        UserModel userModel = userProvider.getUser(userId).orElseThrow(NotFoundException::new);
        return ModelToRepresentation.toRepresentation(userModel, true);
    }

    @Path("/{userId}/companies")
    public CompaniesResource userCompanies(@PathParam("userId") String userId) {
        UserModel userModel = userProvider.getUser(userId).orElseThrow(NotFoundException::new);
        CompaniesResource.setUser(userModel);
        return companiesResource;
    }

}
