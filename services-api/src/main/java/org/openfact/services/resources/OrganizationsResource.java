package org.openfact.services.resources;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * @author carlosthe19916@sistcoop.com
 */
@Path("/organizations")
public interface OrganizationsResource {

    @Path("{organization}")
    PublicOrganizationResource getOrganizationResource(final @PathParam("organization") String name);

}
