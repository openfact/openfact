package org.openfact.services.resources.admin;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.cache.NoCache;
import org.openfact.representations.idm.TaxTypeRepresentation;

/**
 * @author carlosthe19916@sistcoop.com
 */
public interface TaxTypeAdminResource {

    /**
     * Get the taxType with the specified taxTypeId.
     *
     * @return The taxType with the specified taxTypeId
     * @summary Get the taxType with the specified taxTypeId
     */
    @GET
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    TaxTypeRepresentation getTaxType();

    /**
     * Update taxType information.
     *
     * @param rep
     *            The representation of the taxType to be changed
     * @return Generic Response object
     * @summary Update taxType information
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    Response updateTaxType(final TaxTypeRepresentation rep);

    /**
     * Deletes taxType with given taxTypeId.
     *
     * @throws AuthorizationException
     *             The user is not authorized to delete this invoice.
     */
    @DELETE
    Response deleteTaxType();

}
