package org.openfact.rest.admin;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 * 
 */
@Stateless
@Path("/admin/organizations")
public class OrganizationAdminResource {
    @PersistenceContext(unitName = "openfact-persistence-unit")
    private EntityManager em;

    @POST
    @Consumes("application/json")
    public Response create() {
        return null;
    }

    @DELETE
    @Path("/{id:[0-9][0-9]*}")
    public Response deleteById(@PathParam("id") Long id) {
        return null;
    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces("application/json")
    public Response findById(@PathParam("id") Long id) {
        return null;
    }

    @GET
    @Produces("application/json")
    public List listAll(@QueryParam("start") Integer startPosition, @QueryParam("max") Integer maxResult) {
        return null;
    }

    @PUT
    @Path("/{id:[0-9][0-9]*}")
    @Consumes("application/json")
    public Response update(@PathParam("id") Long id) {
        return null;
    }
}
