package org.openfact.services.resources.admin;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.cache.NoCache;
import org.openfact.representatios.idm.catalog.CodeCatalogRepresentation;

/**
 * @author carlosthe19916@sistcoop.com
 */
public interface CodeCatalogAdminResource {

    /**
     * Get the document with the specified documentId.
     *
     * @return The document with the specified documentId
     * @summary Get the document with the specified documentId
     */
    @GET
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    CodeCatalogRepresentation getCodeCatalog();

    /**
     * Update document information.
     *
     * @param rep
     *            The representation of the document to be changed
     * @return Generic Response object
     * @summary Update document information
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    Response updateCodeCatalog(final CodeCatalogRepresentation rep);

    /**
     * Deletes document with given documentId.
     *
     * @throws AuthorizationException
     *             The user is not authorized to delete this invoice.
     */
    @DELETE
    Response deleteCodeCatalog();

}
