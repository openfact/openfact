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

    /**
     * A JAX-RS sub-resource locator that uses the
     * {@link org.openfact.services.resource.OrganizationResourceSPI} to resolve
     * sub-resources instances given an <code>unknownPath</code>.
     *
     * @param extension
     *            a path that could be to a REST extension
     * @return a JAX-RS sub-resource instance for the REST extension if found.
     *         Otherwise null is returned.
     */
    @Path("{organization}/{extension}")
    public Object resolveOrganizationExtension(@PathParam("organization") String organizationName,
            @PathParam("extension") String extension);

}
