package org.openfact.core;

import org.openfact.core.idm.UserRepresentation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

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
