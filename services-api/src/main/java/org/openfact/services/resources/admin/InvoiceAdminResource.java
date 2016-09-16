package org.openfact.services.resources.admin;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.cache.NoCache;
import org.openfact.representations.idm.ubl.InvoiceRepresentation;
import org.openfact.representations.idm.ubl.common.InvoiceLineRepresentation;


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
     * Deletes invoice with given invoiceId.
     *
     * @throws AuthorizationException
     *             The user is not authorized to delete this invoice.
     */
    @DELETE
    Response deleteInvoice();

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

    @GET
    @Path("required-action")
    @Produces(MediaType.APPLICATION_JSON)
    Response requiredActionGet();

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
    
    /**
     * get xml invoice with given invoiceId.
     *
     * @throws AuthorizationException
     *             The user is not authorized to xml this invoice.
     */
    @GET
    @Path("/xml")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response getXml();
    
    /**
     * get cdr invoice with given invoiceId.
     *
     * @throws AuthorizationException
     *             The user is not authorized to cdr this invoice.
     */
    @GET
    @Path("/cdr")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response getCdr();

}
