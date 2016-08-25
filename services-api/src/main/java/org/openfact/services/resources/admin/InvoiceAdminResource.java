package org.openfact.services.resources.admin;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.cache.NoCache;
import org.openfact.representations.idm.InvoiceLineRepresentation;
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

    @GET
    @Path("lines")
    @Produces(MediaType.APPLICATION_JSON)
    List<InvoiceLineRepresentation> getLines();

    /**
     * Send a update account email to the user
     *
     * An email contains a link the user can click to perform a set of required
     * actions. The redirectUri and clientId parameters are optional. The
     * default for the redirect is the account client.
     *
     * @param redirectUri
     *            Redirect uri
     * @param clientId
     *            Client id
     * @param actions
     *            required actions the user needs to complete
     * @return
     */
    @Path("execute-actions-email")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response executeActionsEmail(List<String> actions);

    /**
     * Deletes invoice with given invoiceId.
     *
     * @throws AuthorizationException
     *             The user is not authorized to delete this invoice.
     */
    @DELETE
    Response deleteInvoice();

    /**
     * get pdf invoice with given invoiceId.
     *
     * @throws AuthorizationException
     *             The user is not authorized to pdf this invoice.
     */
    @GET
    @Path("/pdf")
    @Produces("application/pdf")
    public Response getPdf();

}
