package org.openfact.services.resources.admin;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.cache.NoCache;
import org.openfact.representations.idm.InvoiceRepresentation;

/**
 * @author carlosthe19916@sistcoop.com
 */
public interface InvoiceAdminResource {

    /**
     * Get the invoice with the specified invoiceId.
     *
     * @return The invoice with the specified invoiceId
     * @summary Get the invoice with the specified invoiceId
     */
    @GET
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    InvoiceRepresentation getInvoice();

    /**
     * Update invoice information.
     *
     * @param rep
     *            The representation of the invoice to be changed
     * @return Generic Response object
     * @summary Update invoice information
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    Response updateInvoice(final InvoiceRepresentation rep);

    /**
     * Deletes invoice with given invoiceId.
     *
     * @throws AuthorizationException
     *             The user is not authorized to delete this invoice.
     */
    @DELETE
    Response deleteInvoice();

}
