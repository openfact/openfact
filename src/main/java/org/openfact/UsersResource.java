package org.openfact;

import org.openfact.models.UserModel;
import org.openfact.models.UserProvider;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.representations.idm.UserRepresentation;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Path("users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface UsersResource {

    @POST
    @Path("/")
    void createUser();

    @GET
    @Path("/")
    List<UserRepresentation> getUsers(
            @QueryParam("userId") String userId,
            @QueryParam("username") String username
    );

    @GET
    @Path("/{userId}")
    UserRepresentation getUser(@PathParam("userId") String userId);

    @PUT
    @Path("/{userId}")
    UserRepresentation updateUser(@PathParam("userId") String userId, UserRepresentation rep);

    @DELETE
    @Path("/{userId}")
    void deleteUser(@PathParam("userId") String userId);

}
