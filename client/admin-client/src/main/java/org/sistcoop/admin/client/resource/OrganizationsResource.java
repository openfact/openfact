package org.sistcoop.admin.client.resource;

import org.openfact.representations.idm.OrganizationRepresentation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/admin/organizations")
@Consumes(MediaType.APPLICATION_JSON)
public interface OrganizationsResource {

    @Path("/{organization}")
    OrganizationResource organization(@PathParam("organization") String organization);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    void create(OrganizationRepresentation organizationRepresentation);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<OrganizationRepresentation> findAll();

}
